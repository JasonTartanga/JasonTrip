package vista;

import recursos.LookVentana.PanelCustom;
import clases.Usuario;
import excepciones.ErrExtra;
import excepciones.ErrInsert;
import excepciones.ErrSelect;
import java.awt.Color;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import modelo.DAO;

/**
 * Esta pantalla permite al usuario registrarse en la base de datos.
 *
 * @author xDoble_Jx
 */
public class Registrarse extends PanelCustom {

    private DAO dao;
    private LocalDate fechaFinal;

    /**
     * Genera la pantalla
     */
    public Registrarse() {
        initComponents();
        setAlpha(1);

    }

    /**
     * Le pasamos los parametros de la ventana padre.
     *
     * @param dao es la interfaz de la logica del negocio.
     */
    public void pasarParametros(DAO dao) {
        this.dao = dao;
    }

    /**
     * Comprueba si los datos son validos o si no lo son. Si lo son registra al
     * usuario en la aplicacion. Si no notifica al usuario de que fallos a
     * tenido.
     */
    public void comprobarDatos() {
        String mensaje = "";

        if (txtRUsuario.getText().equalsIgnoreCase("Nombre")) {
            mensaje += "Por favor introduce un nombre\n";
            spUsuario.setForeground(new Color(204, 0, 0));

        } else if (txtRUsuario.getText().length() > 25) {
            mensaje += "El nombre no puede tener mas de 25 caracteres\n";
            spUsuario.setForeground(new Color(204, 0, 0));

        } else {
            spUsuario.setForeground(new Color(48, 170, 63));
        }

        if (txtApellidos.getText().equalsIgnoreCase("Apellidos")) {
            mensaje += "Por favor introduce tus apellidos\n";
            spApellido.setForeground(new Color(204, 0, 0));

        } else if (txtApellidos.getText().length() > 50) {
            mensaje += "Los apellidos no pueden tener mas de 50 caracteres\n";
            spApellido.setForeground(new Color(204, 0, 0));

        } else {
            spApellido.setForeground(new Color(48, 170, 63));
        }

        if (txtRContraseña.getText().equalsIgnoreCase("Contraseña")) {
            mensaje += "Por favor introduce una contraseña\n";
            spContrasenia.setForeground(new Color(204, 0, 0));

        } else if (txtRContraseña.getText().length() > 25) {
            mensaje += "La contraseña no puede tener mas de 25 caracteres\n";
            spContrasenia.setForeground(new Color(204, 0, 0));

        } else {
            spContrasenia.setForeground(new Color(48, 170, 63));
        }

        if (txtDni.getText().equalsIgnoreCase("DNI")) {
            mensaje += "Por favor introduce un dni\n";
            spDeni.setForeground(new Color(204, 0, 0));

        } else if (!comprobarDNI()) {
            mensaje += "Ese dni no es valido\n";
            spDeni.setForeground(new Color(204, 0, 0));

        } else {
            spDeni.setForeground(new Color(48, 170, 63));
        }

        if (txtFecha_nac.getText().equalsIgnoreCase("Nacimiento")) {
            mensaje += "Por favor introduce tu fecha de nacimiento\n";
            spFecha_nac.setForeground(new Color(204, 0, 0));

        } else if (!comprobarFecha()) {
            mensaje += "Introduce una fecha valida\n";
            spFecha_nac.setForeground(new Color(204, 0, 0));

        } else {
            spFecha_nac.setForeground(new Color(48, 170, 63));
        }

        if (mensaje == "") {
            registrarUsuario();
        } else {
            JOptionPane.showMessageDialog(this, mensaje);
        }
    }

    /**
     * Registra al usuario en la base de datos.
     */
    public void registrarUsuario() {
        try {
            Usuario usu = new Usuario();

            usu.setId_usuario(dao.generarIdUsuario());
            usu.setContrasenia(txtRContraseña.getText());
            usu.setNombre(txtRUsuario.getText());
            usu.setApellido(txtApellidos.getText());
            usu.setDni(txtDni.getText());
            usu.setCorreo(txtGmail.getText());
            usu.setFecha_nac(fechaFinal);

            dao.registrarUsuario(usu);

            JOptionPane.showMessageDialog(this, "Usuario registrado correctamente");
            limpiar();
        } catch (ErrExtra ex) {
            ex.mostrarError();
        } catch (ErrSelect ex) {
            ex.mostrarError();
        } catch (ErrInsert ex) {
            ex.mostrarError();
        }
    }

    /**
     * Comprueba si el dni es valido, y muestra visualmente en la pantalla.
     *
     * @return si es valido.
     */
    public boolean comprobarDNI() {
        String dni = txtDni.getText();

        if (recursos.Utilidades.validarDni(dni)) {
            spDeni.setForeground(new Color(48, 170, 63));
            return true;

        } else {
            spDeni.setForeground(new Color(204, 0, 0));
            return false;
        }
    }

    /**
     * Comprueba si la fecha de nacimiento es valido, y muestra visualmente en
     * la pantalla.
     *
     * @return si es valido.
     */
    public boolean comprobarFecha() {
        DateTimeFormatter formateadorFinal = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fecha = recursos.Utilidades.validarFecha(txtFecha_nac.getText());

        if (fecha != null) {
            String dia = String.format("%02d", fecha.getDayOfMonth());
            String mes = String.format("%02d", fecha.getMonthValue());

            fechaFinal = LocalDate.parse((fecha.getYear() + "-" + mes + "-" + dia), formateadorFinal);
            spFecha_nac.setForeground(new Color(48, 170, 63));
            return true;

        } else {
            spFecha_nac.setForeground(new Color(204, 0, 0));
            return false;
        }

    }

    /**
     * Comprueba si el gmail es valido, y muestra visualmente en la pantalla.
     *
     * @return si es valido.
     */
    public boolean comprobarGmail() {
        String gmail = txtGmail.getText();

        if (recursos.Utilidades.validarGmail(gmail)) {
            spGmail.setForeground(new Color(48, 170, 63));
            return true;

        } else {
            spGmail.setForeground(new Color(204, 0, 0));
            return false;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        button1 = new recursos.LookVentana.Button();
        txtRUsuario = new javax.swing.JTextField();
        spUsuario = new javax.swing.JSeparator();
        txtApellidos = new javax.swing.JTextField();
        spApellido = new javax.swing.JSeparator();
        txtDni = new javax.swing.JTextField();
        spDeni = new javax.swing.JSeparator();
        txtRContraseña = new javax.swing.JPasswordField();
        spContrasenia = new javax.swing.JSeparator();
        txtFecha_nac = new javax.swing.JTextField();
        spFecha_nac = new javax.swing.JSeparator();
        txtGmail = new javax.swing.JTextField();
        spGmail = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(58, 58, 58));

        lblTitulo.setFont(new java.awt.Font("sansserif", 1, 20)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(242, 242, 242));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("SIGN UP");

        button1.setBackground(new java.awt.Color(86, 142, 255));
        button1.setForeground(new java.awt.Color(255, 255, 255));
        button1.setText("Sign Up");
        button1.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        txtRUsuario.setBackground(getBackground());
        txtRUsuario.setForeground(new java.awt.Color(227, 227, 227));
        txtRUsuario.setText("Nombre");
        txtRUsuario.setBorder(null);
        txtRUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtRUsuarioFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtRUsuarioFocusLost(evt);
            }
        });

        spUsuario.setBackground(getBackground());
        spUsuario.setForeground(lblTitulo.getForeground());

        txtApellidos.setBackground(getBackground());
        txtApellidos.setForeground(new java.awt.Color(227, 227, 227));
        txtApellidos.setText("Apellidos");
        txtApellidos.setBorder(null);
        txtApellidos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtApellidosFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtApellidosFocusLost(evt);
            }
        });

        spApellido.setBackground(getBackground());
        spApellido.setForeground(lblTitulo.getForeground());

        txtDni.setBackground(getBackground());
        txtDni.setForeground(new java.awt.Color(227, 227, 227));
        txtDni.setText("DNI");
        txtDni.setBorder(null);
        txtDni.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDniFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDniFocusLost(evt);
            }
        });

        spDeni.setBackground(getBackground());
        spDeni.setForeground(lblTitulo.getForeground());

        txtRContraseña.setBackground(getBackground());
        txtRContraseña.setForeground(new java.awt.Color(227, 227, 227));
        txtRContraseña.setText("Contraseña");
        txtRContraseña.setBorder(null);
        txtRContraseña.setEchoChar((char) 0);
        txtRContraseña.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtRContraseñaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtRContraseñaFocusLost(evt);
            }
        });

        spContrasenia.setBackground(getBackground());
        spContrasenia.setForeground(lblTitulo.getForeground());

        txtFecha_nac.setBackground(getBackground());
        txtFecha_nac.setForeground(new java.awt.Color(227, 227, 227));
        txtFecha_nac.setText("Nacimiento");
        txtFecha_nac.setBorder(null);
        txtFecha_nac.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtFecha_nacFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFecha_nacFocusLost(evt);
            }
        });

        spFecha_nac.setBackground(getBackground());
        spFecha_nac.setForeground(lblTitulo.getForeground());

        txtGmail.setBackground(getBackground());
        txtGmail.setForeground(new java.awt.Color(227, 227, 227));
        txtGmail.setText("Gmail");
        txtGmail.setBorder(null);
        txtGmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtGmailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtGmailFocusLost(evt);
            }
        });

        spGmail.setBackground(getBackground());
        spGmail.setForeground(lblTitulo.getForeground());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(spUsuario)
                    .addComponent(txtRContraseña)
                    .addComponent(txtApellidos)
                    .addComponent(txtRUsuario)
                    .addComponent(button1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                    .addComponent(txtGmail, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spApellido, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(spDeni, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDni, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFecha_nac)
                            .addComponent(spFecha_nac)))
                    .addComponent(spGmail)
                    .addComponent(spContrasenia, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lblTitulo)
                .addGap(18, 18, 18)
                .addComponent(txtRUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(spUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(spApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(txtRContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(spContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFecha_nac, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(spDeni, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spFecha_nac, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addComponent(txtGmail, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(spGmail, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Si el usuario selecciona el campo del nombre le notificas al usuario de
     * manera visual.
     *
     * @param evt
     */
    private void txtRUsuarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRUsuarioFocusGained
        spUsuario.setForeground(new Color(0, 153, 255));

        if (txtRUsuario.getText().equalsIgnoreCase("Nombre")) {
            txtRUsuario.setText("");
        }
    }//GEN-LAST:event_txtRUsuarioFocusGained

    /**
     * Si el usuario deja de seleccionar el campo del nombre se le notifica de
     * manera visual.
     *
     * @param evt
     */
    private void txtRUsuarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRUsuarioFocusLost
        spUsuario.setForeground(lblTitulo.getForeground());

        if (txtRUsuario.getText().equalsIgnoreCase("")) {
            txtRUsuario.setText("Nombre");
        }
    }//GEN-LAST:event_txtRUsuarioFocusLost

    /**
     * Si el usuario selecciona el campo de los apellidos le notificas al
     * usuario de manera visual.
     *
     * @param evt
     */
    private void txtApellidosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtApellidosFocusGained
        spApellido.setForeground(new Color(0, 153, 255));

        if (txtApellidos.getText().equalsIgnoreCase("Apellidos")) {
            txtApellidos.setText("");
        }
    }//GEN-LAST:event_txtApellidosFocusGained

    /**
     * Si el usuario deja de seleccionar el campo de los apellidos se le
     * notifica de manera visual.
     *
     * @param evt
     */
    private void txtApellidosFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtApellidosFocusLost
        spApellido.setForeground(lblTitulo.getForeground());

        if (txtApellidos.getText().equalsIgnoreCase("")) {
            txtApellidos.setText("Apellidos");
        }
    }//GEN-LAST:event_txtApellidosFocusLost

    /**
     * Si el usuario selecciona el campo de la contraseña le notificas al
     * usuario de manera visual.
     *
     * @param evt
     */
    private void txtRContraseñaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRContraseñaFocusGained
        spContrasenia.setForeground(new Color(0, 153, 255));

        if (txtRContraseña.getText().equalsIgnoreCase("Contraseña")) {
            txtRContraseña.setText("");
            txtRContraseña.setEchoChar('*');
        }
    }//GEN-LAST:event_txtRContraseñaFocusGained

    /**
     * Si el usuario deja de seleccionar el campo de la contraseña se le
     * notifica de manera visual.
     *
     * @param evt
     */
    private void txtRContraseñaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRContraseñaFocusLost
        spContrasenia.setForeground(lblTitulo.getForeground());

        if (txtRContraseña.getText().equalsIgnoreCase("")) {
            txtRContraseña.setText("Usuario");
            txtRContraseña.setEchoChar((char) 0);
        }
    }//GEN-LAST:event_txtRContraseñaFocusLost

    /**
     * Si el usuario selecciona el campo del dni le notificas al usuario de
     * manera visual.
     *
     * @param evt
     */
    private void txtDniFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDniFocusGained
        spDeni.setForeground(new Color(0, 153, 255));

        if (txtDni.getText().equalsIgnoreCase("DNI")) {
            txtDni.setText("");
        }
    }//GEN-LAST:event_txtDniFocusGained

    /**
     * Si el usuario deja de seleccionar el campo del dni se le notifica de
     * manera visual.
     *
     * @param evt
     */
    private void txtDniFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDniFocusLost
        spDeni.setForeground(lblTitulo.getForeground());

        if (txtDni.getText().equalsIgnoreCase("")) {
            txtDni.setText("DNI");
        }
        comprobarDNI();
    }//GEN-LAST:event_txtDniFocusLost

    /**
     * Si el usuario selecciona el campo de la fecha de nacimiento le notificas
     * al usuario de manera visual.
     *
     * @param evt
     */
    private void txtFecha_nacFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFecha_nacFocusGained
        spFecha_nac.setForeground(new Color(0, 153, 255));

        if (txtFecha_nac.getText().equalsIgnoreCase("Nacimiento")) {
            txtFecha_nac.setText("");
        }
    }//GEN-LAST:event_txtFecha_nacFocusGained

    /**
     * Si el usuario deja de seleccionar el campo de la fecha de nacimiento se
     * le notifica de manera visual.
     *
     * @param evt
     */
    private void txtFecha_nacFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFecha_nacFocusLost
        spFecha_nac.setForeground(lblTitulo.getForeground());

        if (txtFecha_nac.getText().equalsIgnoreCase("")) {
            txtFecha_nac.setText("Nacimiento");
        }
        comprobarFecha();
    }//GEN-LAST:event_txtFecha_nacFocusLost

    /**
     * Si el usuario selecciona el campo del gmail le notificas al usuario de
     * manera visual.
     *
     * @param evt
     */
    private void txtGmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtGmailFocusGained
        spGmail.setForeground(new Color(0, 153, 255));

        if (txtGmail.getText().equalsIgnoreCase("Gmail")) {
            txtGmail.setText("");
        }
    }//GEN-LAST:event_txtGmailFocusGained

    /**
     * Si el usuario deja de seleccionar el campo del gmail se le notifica de
     * manera visual.
     *
     * @param evt
     */
    private void txtGmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtGmailFocusLost
        spGmail.setForeground(lblTitulo.getForeground());

        if (txtGmail.getText().equalsIgnoreCase("")) {
            txtGmail.setText("Gmail");
        }
        comprobarGmail();
    }//GEN-LAST:event_txtGmailFocusLost

    /**
     * Llama al metodo de comprobar datos.
     *
     * @param evt
     */
    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        comprobarDatos();
    }//GEN-LAST:event_button1ActionPerformed

    /**
     * Vacia todos los campos y los separadores los pone de color blanco.
     */
    private void limpiar() {
        txtRUsuario.setText("Nombre");
        spUsuario.setForeground(lblTitulo.getForeground());
        txtApellidos.setText("Apellidos");
        spApellido.setForeground(lblTitulo.getForeground());
        txtRContraseña.setText("Contraseña");
        spContrasenia.setForeground(lblTitulo.getForeground());
        txtDni.setText("DNI");
        spDeni.setForeground(lblTitulo.getForeground());
        txtFecha_nac.setText("Nacimiento");
        spFecha_nac.setForeground(lblTitulo.getForeground());
        txtGmail.setText("Gmail");
        spGmail.setForeground(lblTitulo.getForeground());
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private recursos.LookVentana.Button button1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JSeparator spApellido;
    private javax.swing.JSeparator spContrasenia;
    private javax.swing.JSeparator spDeni;
    private javax.swing.JSeparator spFecha_nac;
    private javax.swing.JSeparator spGmail;
    private javax.swing.JSeparator spUsuario;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtFecha_nac;
    private javax.swing.JTextField txtGmail;
    private javax.swing.JPasswordField txtRContraseña;
    private javax.swing.JTextField txtRUsuario;
    // End of variables declaration//GEN-END:variables
}
