package vista;

import clases.Usuario;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import modelo.DAO;

/**
 * Esta ventana es el inicio donde mediante paneles y animaciones se mostraran
 * el resto de ventanas.
 *
 * @author xDoble_Jx
 */
public class VInicio extends javax.swing.JDialog {

    private VMain vMain;
    private DAO dao;
    private Usuario usu;

    private int posX, posY;

    /**
     * Genera la venta inicio.
     *
     * @param vMain es la ventana padre.
     * @param modal es si la ventana es modal.
     * @param dao es la interfaz de la logica de negocio.
     * @param usu es el usuario que controla la aplicacion.
     */
    public VInicio(VMain vMain, boolean modal, DAO dao, Usuario usu) {
        super(vMain, modal);
        this.vMain = vMain;
        this.dao = dao;
        this.usu = usu;

        initComponents();

        setBackground(new Color(0, 0, 0, 0));

        barraTareas.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                posX = e.getX();
                posY = e.getY();
            }
        });

        barraTareas.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                int dx = e.getX() - posX;
                int dy = e.getY() - posY;
                setLocation(getLocation().x + dx, getLocation().y + dy);
            }
        });

        lblUsuario.setText(usu.getNombre());
        if (usu.getIcono() != null) {
            imgIcono.setIcon(new javax.swing.ImageIcon(usu.getIcono().getAbsolutePath()));
        } else {
            imgIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/default.png")));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondo = new recursos.LookVentana.RoundPanel();
        barraTareas = new recursos.LookVentana.RoundPanel();
        btnSalir = new javax.swing.JButton();
        menuLateral = new recursos.LookVentana.RoundPanel();
        imgLogo = new javax.swing.JLabel();
        imgLetras = new javax.swing.JLabel();
        menuUsuario = new recursos.LookVentana.RoundPanel();
        imgIcono = new recursos.LookVentana.ImageAvatar();
        imgUsuarioTxt = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        btnInicio = new recursos.LookVentana.ButtonMenu();
        btnLista = new recursos.LookVentana.ButtonMenu();
        btnDia = new recursos.LookVentana.ButtonMenu();
        btnCerrar = new recursos.LookVentana.ButtonMenu();
        btnCuenta = new recursos.LookVentana.ButtonMenu();
        panelSlide = new recursos.LookVentana.PanelSlide();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        fondo.setBackground(new java.awt.Color(21, 21, 21));

        barraTareas.setBackground(new java.awt.Color(49, 51, 53));

        btnSalir.setBackground(barraTareas.getBackground());
        btnSalir.setForeground(barraTareas.getBackground());
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pantalla/btnSalir.png"))); // NOI18N
        btnSalir.setBorder(null);
        btnSalir.setFocusPainted(false);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout barraTareasLayout = new javax.swing.GroupLayout(barraTareas);
        barraTareas.setLayout(barraTareasLayout);
        barraTareasLayout.setHorizontalGroup(
            barraTareasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, barraTareasLayout.createSequentialGroup()
                .addContainerGap(1378, Short.MAX_VALUE)
                .addComponent(btnSalir)
                .addContainerGap())
        );
        barraTareasLayout.setVerticalGroup(
            barraTareasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, barraTareasLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalir)
                .addGap(6, 6, 6))
        );

        menuLateral.setBackground(new java.awt.Color(49, 51, 53));

        imgLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pantalla/logo.png"))); // NOI18N

        imgLetras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pantalla/letras logo.png"))); // NOI18N

        menuUsuario.setBackground(new java.awt.Color(59, 61, 63));

        imgIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/iconoJason.png"))); // NOI18N

        imgUsuarioTxt.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        imgUsuarioTxt.setForeground(new java.awt.Color(227, 227, 227));
        imgUsuarioTxt.setText("USUARIO");

        lblUsuario.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        lblUsuario.setForeground(new java.awt.Color(227, 227, 227));

        javax.swing.GroupLayout menuUsuarioLayout = new javax.swing.GroupLayout(menuUsuario);
        menuUsuario.setLayout(menuUsuarioLayout);
        menuUsuarioLayout.setHorizontalGroup(
            menuUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuUsuarioLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(imgIcono, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(menuUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imgUsuarioTxt)
                    .addComponent(lblUsuario))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        menuUsuarioLayout.setVerticalGroup(
            menuUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuUsuarioLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(menuUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imgIcono, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(menuUsuarioLayout.createSequentialGroup()
                        .addComponent(imgUsuarioTxt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblUsuario)))
                .addGap(16, 16, 16))
        );

        btnInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pantalla/btnInicio.png"))); // NOI18N
        btnInicio.setText("Inicio");
        btnInicio.setFocusPainted(false);
        btnInicio.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        btnInicio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicioActionPerformed(evt);
            }
        });

        btnLista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pantalla/btnLista.png"))); // NOI18N
        btnLista.setText("Lista");
        btnLista.setFocusPainted(false);
        btnLista.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        btnLista.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListaActionPerformed(evt);
            }
        });

        btnDia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pantalla/btnDia.png"))); // NOI18N
        btnDia.setText("Dias");
        btnDia.setFocusPainted(false);
        btnDia.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        btnDia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDiaActionPerformed(evt);
            }
        });

        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pantalla/btnCerrar.png"))); // NOI18N
        btnCerrar.setText("Cerrar Sesion");
        btnCerrar.setFocusPainted(false);
        btnCerrar.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        btnCerrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        btnCuenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pantalla/btnUsuario.png"))); // NOI18N
        btnCuenta.setText("Cuenta");
        btnCuenta.setFocusPainted(false);
        btnCuenta.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        btnCuenta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCuentaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuLateralLayout = new javax.swing.GroupLayout(menuLateral);
        menuLateral.setLayout(menuLateralLayout);
        menuLateralLayout.setHorizontalGroup(
            menuLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLateralLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(menuLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(menuUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCerrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(menuLateralLayout.createSequentialGroup()
                        .addComponent(imgLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(imgLetras, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnDia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCuenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        menuLateralLayout.setVerticalGroup(
            menuLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLateralLayout.createSequentialGroup()
                .addGroup(menuLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menuLateralLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(imgLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuLateralLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(imgLetras)
                        .addGap(33, 33, 33)))
                .addComponent(menuUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(btnInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btnLista, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btnDia, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btnCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 120, Short.MAX_VALUE)
                .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout panelSlideLayout = new javax.swing.GroupLayout(panelSlide);
        panelSlide.setLayout(panelSlideLayout);
        panelSlideLayout.setHorizontalGroup(
            panelSlideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 992, Short.MAX_VALUE)
        );
        panelSlideLayout.setVerticalGroup(
            panelSlideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout fondoLayout = new javax.swing.GroupLayout(fondo);
        fondo.setLayout(fondoLayout);
        fondoLayout.setHorizontalGroup(
            fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(barraTareas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(fondoLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(menuLateral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(panelSlide, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        fondoLayout.setVerticalGroup(
            fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoLayout.createSequentialGroup()
                .addComponent(barraTareas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(menuLateral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelSlide, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
        vMain.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnInicioActionPerformed

    private void btnListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnListaActionPerformed

    private void btnDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDiaActionPerformed

    private void btnCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCuentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCuentaActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        this.dispose();
        vMain.setOpacity(1);
    }//GEN-LAST:event_btnCerrarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private recursos.LookVentana.RoundPanel barraTareas;
    private recursos.LookVentana.ButtonMenu btnCerrar;
    private recursos.LookVentana.ButtonMenu btnCuenta;
    private recursos.LookVentana.ButtonMenu btnDia;
    private recursos.LookVentana.ButtonMenu btnInicio;
    private recursos.LookVentana.ButtonMenu btnLista;
    private javax.swing.JButton btnSalir;
    private recursos.LookVentana.RoundPanel fondo;
    private recursos.LookVentana.ImageAvatar imgIcono;
    private javax.swing.JLabel imgLetras;
    private javax.swing.JLabel imgLogo;
    private javax.swing.JLabel imgUsuarioTxt;
    private javax.swing.JLabel lblUsuario;
    private recursos.LookVentana.RoundPanel menuLateral;
    private recursos.LookVentana.RoundPanel menuUsuario;
    private recursos.LookVentana.PanelSlide panelSlide;
    // End of variables declaration//GEN-END:variables
}
