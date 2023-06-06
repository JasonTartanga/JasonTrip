package recursos.LookVentana;

/**
 * Esta clase genera una ventana personalizada para poder ver los mensajes de
 * las excepciones.
 *
 * @author Jason
 */
public class VentanaError extends javax.swing.JDialog {

    /**
     * Genera una ventana personalizada para poder ver mensajes de error
     *
     * @param mensaje Es el mensaje que se va a mostrar
     */
    public VentanaError(String mensaje) {

        // super(parent, modal);
        this.setModal(true);

        setUndecorated(true);
        initComponents();
        setLocationRelativeTo(null);
        txt.setText(mensaje);
        this.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        button2 = new recursos.LookVentana.Button();
        lbl = new javax.swing.JLabel();
        txt = new javax.swing.JLabel();
        bntOk = new recursos.LookVentana.Button();
        btnCancelar = new recursos.LookVentana.Button();

        button2.setText("button1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(187, 187, 187));
        setModal(true);
        setResizable(false);

        lbl.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        lbl.setForeground(new java.awt.Color(80, 80, 80));
        lbl.setText("Error en la base de datos");

        txt.setBackground(getBackground());
        txt.setForeground(new java.awt.Color(133, 133, 133));
        txt.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        txt.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        bntOk.setBackground(new java.awt.Color(48, 170, 63));
        bntOk.setForeground(new java.awt.Color(255, 255, 255));
        bntOk.setText("Ok");
        bntOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrar(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(232, 232, 232));
        btnCancelar.setForeground(new java.awt.Color(0, 0, 0));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrar(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bntOk, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(lbl)
                                .addGap(0, 283, Short.MAX_VALUE)))))
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(lbl)
                .addGap(18, 18, 18)
                .addComponent(txt, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bntOk, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Es el metodo para cerrar la ventana
     *
     * @param evt
     */
    private void cerrar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrar
        this.dispose();
    }//GEN-LAST:event_cerrar

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private recursos.LookVentana.Button bntOk;
    private recursos.LookVentana.Button btnCancelar;
    private recursos.LookVentana.Button button2;
    private javax.swing.JLabel lbl;
    private javax.swing.JLabel txt;
    // End of variables declaration//GEN-END:variables
}
