package recursos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import modelo.DAOImplementacionBD;

/**
 * Es una clase auxiliar con diferentes metodos estaticos que pueden ser de
 * utilidad a la hora de hacer la aplicacion.
 *
 * @author xDoble_Jx
 */
public class Utilidades {

    /**
     * Genera un numero aleatorio entre dos valores.
     *
     * @param min el numero minimo.
     * @param max el numero maximo.
     * @return el numero generado aleatoriamente.
     */
    public static int numeros_aleatorios(int min, int max) {
        return new Random().nextInt((max - min) + 1) + min;
    }

    /**
     * Mediante varios filtros comprueba si el dni podria existir en la vida
     * real.
     *
     * @param dni el dni a comprobar.
     * @return si podria existir o no.
     */
    public static boolean validarDni(String dni) {
        String caracteres = "TRWAGMYFPDXBNJZSQVHLCKE";

        boolean correcto = true;
        try {

            if (dni.length() != 9) {
                System.out.println("longitud diferente a 9");
                return false;
            }

            int numDni = Integer.parseInt(dni.substring(0, 8));
            int charDni = numDni % 23;

            if (dni.charAt(8) != caracteres.charAt(charDni)) {
                return false;
            }

        } catch (NumberFormatException e) {

            return false;
        }

        return true;
    }

    /**
     * Comprueba si un string tiene el formato adecuado para se una fecha, y si
     * lo es lo convierte en un localdate.
     *
     * @param fec la fecha que queremos comprobar.
     * @return si es valido devuelve la fecha si no devuelve null.
     */
    public static LocalDate validarFecha(String fec) {
        DateTimeFormatter formateadorG = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter formateadorB = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        char s = fec.charAt(2);

        try {
            if (s == '-') {
                return LocalDate.parse(fec, formateadorG);

            } else if (s == '/') {
                return LocalDate.parse(fec, formateadorB);
            } else {
                return null;
            }
        } catch (DateTimeParseException e) {
            return null;
        }

    }

    /**
     * Compueba mediante un patron si el correo que se le pasa podria existir en
     * la vida real o si no.
     *
     * @param email el gmail que queremos comprobar.
     * @return si podria existir o si no.
     */
    public static boolean validarGmail(String email) {
        // Expresión regular para validar una dirección de correo electrónico de Gmail
        String regex = "^[A-Za-z0-9+_.-]+@gmail\\.com$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }

    /**
     * Convierte los datos recuperados de una imagen de la base de datos y la
     * convierte en un archivo File, para poder usarlo facilmente en la
     * aplicacion Java.
     *
     * @param rs es el resultado de una select de la base de datos.
     * @param outputFilePath es el nombre que queremos que tenga el File
     * @param tabla saber el nombre del atributo de la bda, para saber si
     * sacamos imagenes o fotos de perfil.
     * @return la imagen de la bda convertido en un archivo File.
     */
    public static File recuperarImagenBDA(ResultSet rs, String outputFilePath, String tabla) {
        try {
            if (rs.getBinaryStream(tabla) != null) {
                try (OutputStream outputStream = new FileOutputStream(outputFilePath)) {
                    byte[] buffer = new byte[1024];
                    InputStream inputStream = rs.getBinaryStream(tabla);
                    int bytesRead;
                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                    }
                    System.out.println("El archivo se ha recuperado correctamente.");
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, ex);
                }
                return new File(outputFilePath);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
