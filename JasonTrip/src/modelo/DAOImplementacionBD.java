package modelo;

import clases.Actividad;
import clases.Lista;
import clases.Usuario;
import excepciones.ErrExtra;
import excepciones.ErrInsert;
import excepciones.ErrSelect;
import excepciones.ErrUpdate;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase gestiona los metodos de la interfaz de negocio DAO
 *
 * @author xDoble_Jx
 */
public class DAOImplementacionBD implements DAO {

    private Connection con = null;
    private PreparedStatement stmt;

    //************** INSERTS***************/
    final private String REGISTRAR_USUARIO = "INSERT INTO usuario VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    final private String INSERTAR_LISTA = "INSERT INTO lista VALUES (?, ?, ?, ?)";

    //************** UPDATES***************/
    final private String EDITAR_TITULO_LISTA = "UPDATE lista SET titulo = ? WHERE id_lista = ?";
    //************** DELETES***************/
    //************** SELECTS***************/
    final private String INICIAR_SESION = "SELECT * FROM usuario WHERE nombre = ? and contrasenia = ?";

    final private String GENERAR_ID_USUARIO = "SELECT id_usuario FROM usuario ORDER BY id_usuario DESC LIMIT 1";
    final private String GENERAR_ID_LISTA = "SELECT id_lista FROM lista ORDER BY id_lista DESC LIMIT 1";

    final private String LISTAR_LISTAS_USUARIO = "SELECT * FROM lista WHERE usuario = ?";
    final private String LISTAR_ACTIVIDAD_X_LISTA = "SELECT * FROM actividad WHERE id_actividad in (SELECT id_actividad FROM contenido WHERE id_lista = ?)";

    /**
     * Este metodo abre una conexion con la base de datos.
     */
    public void abrirConexion() throws ErrExtra {

        try {
            Properties configBDA = new Properties();
            String rutaProyecto = System.getProperty("user.dir");
            FileInputStream fis = new FileInputStream(rutaProyecto + "\\src\\modelo\\configBDA.properties");
            configBDA.load(fis);

            final String URL = configBDA.getProperty("url");
            final String USER = configBDA.getProperty("user");
            final String PASSWORD = configBDA.getProperty("password");

            con = DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new ErrExtra("fichero");

        } catch (IOException e) {
            e.printStackTrace();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new ErrExtra("conexion");
        }

    }

    /**
     * Este metodo cierra la conexion con la base de datos.
     */
    public void cerrarConexion() {
        try {
            if (con != null) {
                con.close();
            }
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Este metodo genera un prepared statement en base a un usuario, con la
     * intencion de reutilizar codigo y mejorar la legibilidad del codigo.
     *
     * @param usu el usuario que queremos introducir en la bda.
     * @return el prepared statement con todos los set string hechos.
     */
    public PreparedStatement prepararUsuario(Usuario usu) {
        try {
            stmt.setString(1, usu.getId_usuario());
            stmt.setString(2, usu.getContrasenia());
            stmt.setString(3, usu.getNombre());
            stmt.setString(4, usu.getApellido());
            stmt.setString(5, usu.getDni());
            stmt.setString(6, usu.getCorreo());
            stmt.setDate(7, Date.valueOf(usu.getFecha_nac()));

            if (usu.getIcono() != null) {
                try (InputStream inputStream = new FileInputStream(usu.getIcono())) {
                    stmt.setBinaryStream(8, inputStream, (int) usu.getIcono().length());
                } catch (IOException ex) {
                    Logger.getLogger(DAOImplementacionBD.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                stmt.setBinaryStream(8, null);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return stmt;
    }

    /**
     * Recupera todos los datos de un usuario de la base de datos.
     *
     * @param rs el result set donde estan todos los datos.
     * @return el usuario con todos sus datos.
     */
    public Usuario getUsuario(ResultSet rs) {
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Usuario usu = new Usuario();

        try {
            usu.setId_usuario(rs.getString("id_usuario"));
            usu.setContrasenia(rs.getString("contrasenia"));
            usu.setNombre(rs.getString("nombre"));
            usu.setApellido(rs.getString("apellidos"));
            usu.setDni(rs.getString("dni"));
            usu.setCorreo(rs.getString("correo"));
            usu.setFecha_nac(LocalDate.parse(rs.getString("fecha_nac"), formateador));

            //usu.setIcono(Utilidades.recuperarImagenBDA(rs, "icono" + usu.getNombre() + ".png", "icono"));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return usu;
    }

    @Override
    public void registrarUsuario(Usuario usu) throws ErrExtra, ErrInsert {
        this.abrirConexion();

        try {
            stmt = con.prepareStatement(REGISTRAR_USUARIO);
            stmt = this.prepararUsuario(usu);

            System.out.println(stmt);
            stmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new ErrInsert("usuario");
        }
        this.cerrarConexion();
    }

    @Override
    public void insertarLista(Lista list) throws ErrExtra, ErrInsert {
        this.abrirConexion();

        try {
            stmt = con.prepareStatement(INSERTAR_LISTA);
            stmt.setString(1, list.getId_lista());
            stmt.setString(2, list.getTitulo());
            stmt.setString(3, list.getDescripcion());
            stmt.setString(4, list.getUsuario());
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ErrInsert("lista");
        }
        this.cerrarConexion();
    }

    @Override
    public Usuario iniciarSesion(String usuario, String contrasenia) throws ErrExtra, ErrSelect {
        Usuario usu = null;
        this.abrirConexion();

        try {
            stmt = con.prepareStatement(INICIAR_SESION);
            stmt.setString(1, usuario);
            stmt.setString(2, contrasenia);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                usu = this.getUsuario(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new ErrSelect("usuario");
        }

        this.cerrarConexion();
        return usu;
    }

    @Override
    public String generarIdUsuario() throws ErrExtra, ErrSelect {
        String id = "";
        this.abrirConexion();

        try {
            stmt = con.prepareStatement(GENERAR_ID_USUARIO);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                id = "U-" + String.format("%03d", Integer.parseInt(rs.getString("id_usuario").substring(2, 5)) + 1);
            } else {
                id = "U-001";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ErrSelect("usuario");
        }
        this.cerrarConexion();
        return id;
    }

    @Override
    public String generarIdLista() throws ErrExtra, ErrSelect {
        String id = "";
        this.abrirConexion();

        try {
            stmt = con.prepareStatement(GENERAR_ID_LISTA);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                id = "L-" + String.format("%03d", Integer.parseInt(rs.getString("id_lista").substring(2, 5)) + 1);
            } else {
                id = "L-001";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ErrSelect("lista");
        }
        this.cerrarConexion();
        return id;
    }

    @Override
    public List<Lista> listarListasUsuario(String id_usuario) throws ErrExtra, ErrSelect {
        List<Lista> listas = new ArrayList<>();
        this.abrirConexion();

        try {
            stmt = con.prepareStatement(LISTAR_LISTAS_USUARIO);
            stmt.setString(1, id_usuario);

            System.out.println(stmt);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Lista list = new Lista();
                list.setId_lista(rs.getString("id_lista"));
                list.setTitulo(rs.getString("titulo"));
                list.setDescripcion(rs.getString("descripcion"));
                list.setUsuario(rs.getString("usuario"));
                list.setActividades(this.listarActividadesXLista(list.getId_lista()));
                listas.add(list);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ErrSelect("lista");
        }

        this.cerrarConexion();
        return listas;
    }

    public List<Actividad> listarActividadesXLista(String id_lista) throws ErrExtra, ErrSelect {
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        List<Actividad> actividades = new ArrayList<>();
        this.abrirConexion();

        try {
            stmt = con.prepareStatement(LISTAR_ACTIVIDAD_X_LISTA);
            stmt.setString(1, id_lista);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Actividad act = new Actividad();
                act.setId_actividad(rs.getString("id_actividad"));
                act.setTitulo(rs.getString("titulo"));
                act.setDescripcion(rs.getString("descripcion"));
                act.setUbicacion(rs.getString("ubicacion"));
                //Fotos
                act.setDia(LocalDate.parse(rs.getString("dia"), formateador));
                act.setTabulacion(rs.getInt("tabulacion"));
                actividades.add(act);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new ErrSelect("actividad");
        }
        this.cerrarConexion();
        return actividades;
    }

    @Override
    public void editarTituloLista(String id_lista, String titulo) throws ErrExtra, ErrUpdate {
        this.abrirConexion();

        try {
            stmt = con.prepareStatement(EDITAR_TITULO_LISTA);
            stmt.setString(1, titulo);
            stmt.setString(2, id_lista);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ErrUpdate("lista");
        }
        this.cerrarConexion();
    }

}
