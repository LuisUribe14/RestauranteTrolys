package comandas;

/**
 *
 * @author daniel
 */
public class PnlProducto extends javax.swing.JPanel {

    /**
     * Creates new form PnlProducto
     */
    public PnlProducto() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txfNombre = new javax.swing.JTextField();
        txfNombre1 = new javax.swing.JTextField();
        txfNombre2 = new javax.swing.JTextField();

        setMaximumSize(new java.awt.Dimension(518, 39));
        setMinimumSize(new java.awt.Dimension(518, 39));

        txfNombre.setEditable(false);
        txfNombre.setBackground(new java.awt.Color(217, 217, 217));
        txfNombre.setText("a");
        txfNombre.setBorder(null);
        txfNombre.setOpaque(false);

        txfNombre1.setEditable(false);
        txfNombre1.setBackground(new java.awt.Color(217, 217, 217));
        txfNombre1.setText("a");
        txfNombre1.setBorder(null);
        txfNombre1.setOpaque(false);

        txfNombre2.setEditable(false);
        txfNombre2.setBackground(new java.awt.Color(217, 217, 217));
        txfNombre2.setText("a");
        txfNombre2.setBorder(null);
        txfNombre2.setOpaque(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(txfNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(txfNombre2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfNombre2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField txfNombre;
    private javax.swing.JTextField txfNombre1;
    private javax.swing.JTextField txfNombre2;
    // End of variables declaration//GEN-END:variables
}
