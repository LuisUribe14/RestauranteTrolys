package Pantallas.moduloProductos;

import BOs.ProductoBO;
import DTOs.ProductoViejoDTO;
import enums.estadoProducto;
import exception.NegocioException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author daniel
 */
public class PnlProductosRegistrados extends javax.swing.JPanel {

    private ProductoViejoDTO producto;
    
    /**
     * Creates new form PnlProductosRegistrados
     */
    public PnlProductosRegistrados(ProductoViejoDTO producto) {
        this.producto = producto;
        initComponents();
        
        txfNombre.setText(producto.getNombre());
        txfTipo.setText(producto.getTipo().toString());
        txfPrecio.setText(producto.getPrecio().toString());
        txfEstado.setText(producto.getEstado().toString());
        
        if (producto.getEstado() == estadoProducto.DISPONIBLE) {
            cbEstado.setSelectedIndex(0);
        } else {
            cbEstado.setSelectedIndex(1);
        }
        
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
        txfTipo = new javax.swing.JTextField();
        txfEstado = new javax.swing.JTextField();
        txfPrecio = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        cbEstado = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(217, 217, 217));
        setMaximumSize(new java.awt.Dimension(856, 29));
        setMinimumSize(new java.awt.Dimension(856, 29));

        txfNombre.setEditable(false);
        txfNombre.setBackground(new java.awt.Color(217, 217, 217));
        txfNombre.setText("a");
        txfNombre.setBorder(null);
        txfNombre.setOpaque(false);

        txfTipo.setEditable(false);
        txfTipo.setBackground(new java.awt.Color(217, 217, 217));
        txfTipo.setText("a");
        txfTipo.setBorder(null);
        txfTipo.setOpaque(false);

        txfEstado.setEditable(false);
        txfEstado.setBackground(new java.awt.Color(217, 217, 217));
        txfEstado.setText("a");
        txfEstado.setBorder(null);
        txfEstado.setOpaque(false);

        txfPrecio.setEditable(false);
        txfPrecio.setBackground(new java.awt.Color(217, 217, 217));
        txfPrecio.setText("a");
        txfPrecio.setBorder(null);
        txfPrecio.setOpaque(false);

        jButton1.setBackground(new java.awt.Color(128, 143, 180));
        jButton1.setText("Ingredientes");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        cbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DISPONIBLE", "NO_DISPONIBLE" }));
        cbEstado.setSelectedIndex(-1);
        cbEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEstadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(txfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txfTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(txfPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txfEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        frame.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cbEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEstadoActionPerformed
        actualizarEstado();
    }//GEN-LAST:event_cbEstadoActionPerformed

    private void actualizarEstado() {
        try {
            estadoProducto estado = estadoProducto.valueOf((String) cbEstado.getSelectedItem());
            producto.setEstado(estado);
            ProductoBO.getInstancia().actualizarEstado(producto);
        } catch(NegocioException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }
            
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbEstado;
    private javax.swing.JButton jButton1;
    private javax.swing.JTextField txfEstado;
    private javax.swing.JTextField txfNombre;
    private javax.swing.JTextField txfPrecio;
    private javax.swing.JTextField txfTipo;
    // End of variables declaration//GEN-END:variables
}
