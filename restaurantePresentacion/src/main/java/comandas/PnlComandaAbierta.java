package comandas;

import DTOs.ComandaViejaDTO;
import enums.estadoComanda;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author daniel
 */
public class PnlComandaAbierta extends javax.swing.JPanel {

    /**
     * Creates new form PnlComandasAbiertas
     */
    public PnlComandaAbierta(ComandaViejaDTO comanda) {
        initComponents();
        
        txfFolio.setText(comanda.getFolio());
        txfTotal.setText(comanda.getTotalVenta().toString());
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        txfFecha.setText(comanda.getFechaYHora().format(formatter));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txfTotal = new javax.swing.JTextField();
        txfFolio = new javax.swing.JTextField();
        txfFecha = new javax.swing.JTextField();
        btnEditar = new javax.swing.JButton();
        btnSeleccionar = new javax.swing.JButton();
        cbEstado = new javax.swing.JComboBox<>();

        setMaximumSize(new java.awt.Dimension(775, 35));
        setMinimumSize(new java.awt.Dimension(775, 35));

        txfTotal.setEditable(false);
        txfTotal.setBackground(new java.awt.Color(217, 217, 217));
        txfTotal.setText("a");
        txfTotal.setBorder(null);
        txfTotal.setOpaque(false);

        txfFolio.setEditable(false);
        txfFolio.setBackground(new java.awt.Color(217, 217, 217));
        txfFolio.setText("a");
        txfFolio.setBorder(null);
        txfFolio.setOpaque(false);

        txfFecha.setEditable(false);
        txfFecha.setBackground(new java.awt.Color(217, 217, 217));
        txfFecha.setText("a");
        txfFecha.setBorder(null);
        txfFecha.setOpaque(false);

        btnEditar.setBackground(new java.awt.Color(238, 219, 79));
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnSeleccionar.setBackground(new java.awt.Color(128, 143, 180));
        btnSeleccionar.setForeground(new java.awt.Color(255, 255, 255));
        btnSeleccionar.setText("Seleccionar");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });

        cbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ABIERTO", "CANCELADO", "ENTREGADO" }));
        cbEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEstadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(txfFolio, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txfTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txfFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(btnSeleccionar)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfFolio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar)
                    .addComponent(btnSeleccionar)
                    .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditarActionPerformed

    private void cbEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEstadoActionPerformed
        estadoComanda estado = estadoComanda.valueOf((String) cbEstado.getSelectedItem());
        System.out.println(estado);
    }//GEN-LAST:event_cbEstadoActionPerformed

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        //
    }//GEN-LAST:event_btnSeleccionarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JComboBox<String> cbEstado;
    private javax.swing.JTextField txfFecha;
    private javax.swing.JTextField txfFolio;
    private javax.swing.JTextField txfTotal;
    // End of variables declaration//GEN-END:variables
}
