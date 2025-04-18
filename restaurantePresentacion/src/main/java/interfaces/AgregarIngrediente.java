/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaces;

import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import java.util.List;
import entidades.Ingrediente;
import BOs.ingredienteBO;
import DTOs.IngredienteViejoDTO;
import DTOs.ingredienteDTO;
import render.EliminarIngredienteRendererEditor;
import control.ControlFlujoPantallas;
import enums.unidadMedida;
import exception.PersistenciaException;

/**
 *
 * @author chris
 */
public class AgregarIngrediente extends javax.swing.JFrame {

    /**
     * Creates new form AgregarIngrediente
     */
    DefaultTableModel mt = new DefaultTableModel();

    public AgregarIngrediente() {
        initComponents();

        // Crear el modelo con las columnas correctas
        modeloTabla = new DefaultTableModel(
                new Object[]{"Nombre", "Unidad de Medida", "Stock", "Eliminar"}, 0
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 3; // solo la columna "Eliminar"
            }
        };

        // Asignar el modelo a la tabla
        jTable1.setModel(modeloTabla);
        jTable1.getColumn("Eliminar").setCellRenderer(new EliminarIngredienteRendererEditor());
        jTable1.getColumn("Eliminar").setCellEditor(new EliminarIngredienteRendererEditor());

        // Cargar los ingredientes en la tabla
        cargarIngredientes();
        // Filtro en tiempo real
        Buscador.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            public void insertUpdate(javax.swing.event.DocumentEvent e) {
                filtrar();
            }

            public void removeUpdate(javax.swing.event.DocumentEvent e) {
                filtrar();
            }

            public void changedUpdate(javax.swing.event.DocumentEvent e) {
                filtrar();
            }

            private void filtrar() {
                String texto = Buscador.getText().trim();
                String filtroSeleccionado = Filtro.getSelectedItem().toString();

                String nombre = null, unidad = null;
                if (filtroSeleccionado.equalsIgnoreCase("Nombre")) {
                    nombre = texto;
                } else if (filtroSeleccionado.equalsIgnoreCase("Unidad")) {
                    unidad = texto;
                }

                try {
                    List<ingredienteDTO> listaFiltrada = bo.filtrarIngredientesDTO(nombre, unidad);
                    modeloTabla.setRowCount(0); // limpia la tabla

                    for (ingredienteDTO ing : listaFiltrada) {
                        modeloTabla.addRow(new Object[]{
                            ing.getNombre(),
                            ing.getUnidadMedida(),
                            ing.getStock()
                        });
                    }

                } catch (PersistenciaException ex) {
                    JOptionPane.showMessageDialog(null, "Error al filtrar ingredientes: " + ex.getMessage());
                }
            }
        });

    }
    DefaultTableModel modeloTabla;
    ingredienteBO bo = ingredienteBO.getInstancia();

    private void cargarIngredientes() {
        modeloTabla.setRowCount(0); // Limpia la tabla
        try {
            List<ingredienteDTO> lista = bo.obtenerTodosDTO(); // Devuelve todos los ingredientes
            if (lista != null) {
                for (ingredienteDTO ing : lista) {
                    modeloTabla.addRow(new Object[]{
                        ing.getNombre(),
                        ing.getUnidadMedida(),
                        ing.getStock(),
                        "Eliminar"
                    });
                }
            }
        } catch (PersistenciaException ex) {
            JOptionPane.showMessageDialog(this, "Error al cargar ingredientes: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
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

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnRegistrarIngrediente = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Filtro = new javax.swing.JComboBox<>();
        Buscador = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        Regresar = new javax.swing.JButton();
        Aumentar = new javax.swing.JTextField();
        btnAumentar = new javax.swing.JButton();

        jButton1.setText("Buscar Ingredientes");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(204, 204, 255));

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Ingredienes registrados");

        btnRegistrarIngrediente.setBackground(new java.awt.Color(0, 0, 0));
        btnRegistrarIngrediente.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrarIngrediente.setText("Registrar Ingrediente");
        btnRegistrarIngrediente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarIngredienteActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
        }

        Filtro.setBackground(new java.awt.Color(0, 0, 0));
        Filtro.setForeground(new java.awt.Color(255, 255, 255));
        Filtro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nombre", "Unidad" }));
        Filtro.setToolTipText("Seleccione");

        Buscador.setToolTipText("");

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Limpiar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Serif", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Ingredientes");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        Regresar.setBackground(new java.awt.Color(0, 0, 0));
        Regresar.setForeground(new java.awt.Color(255, 255, 255));
        Regresar.setText("Regresar");
        Regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegresarActionPerformed(evt);
            }
        });

        Aumentar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AumentarActionPerformed(evt);
            }
        });

        btnAumentar.setBackground(new java.awt.Color(0, 0, 0));
        btnAumentar.setForeground(new java.awt.Color(255, 255, 255));
        btnAumentar.setText("Aumentar");
        btnAumentar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAumentarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(jButton2)
                .addGap(99, 99, 99)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Buscador, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(84, 84, 84)
                .addComponent(Filtro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(69, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(131, 131, 131))
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(Regresar)
                .addGap(128, 128, 128)
                .addComponent(btnRegistrarIngrediente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAumentar)
                        .addGap(91, 91, 91))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(Aumentar, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(79, 79, 79))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Filtro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(Buscador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnRegistrarIngrediente)
                            .addComponent(Aumentar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addComponent(btnAumentar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Regresar)
                        .addGap(106, 106, 106))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarIngredienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarIngredienteActionPerformed
        // TODO add your handling code here:
        ControlFlujoPantallas.getInstancia().abrirAgregarIngredientes();
        this.dispose();
    }//GEN-LAST:event_btnRegistrarIngredienteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Buscador.setText("");
        Filtro.setSelectedIndex(0); // Pone el filtro en "Nombre"
        cargarIngredientes(); // Recarga todos los ingredientes
    }//GEN-LAST:event_jButton2ActionPerformed

    private void RegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegresarActionPerformed
        ControlFlujoPantallas.getInstancia().abrirPantallaAdministrador();
        this.dispose();
    }//GEN-LAST:event_RegresarActionPerformed

    private void AumentarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AumentarActionPerformed
 
    }//GEN-LAST:event_AumentarActionPerformed

    private void btnAumentarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAumentarActionPerformed
        int fila = jTable1.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Selecciona un ingrediente primero.");
            return;
        }

        String nombre = jTable1.getValueAt(fila, 0).toString();
        String unidadStr = jTable1.getValueAt(fila, 1).toString();

        try {
            // Convertir el String a unidadMedida (enum)
            unidadMedida unidad = unidadMedida.valueOf(unidadStr);

            int cantidad = Integer.parseInt(Aumentar.getText());

            // Crear el DTO con los valores obtenidos de la tabla
            IngredienteViejoDTO dto = new IngredienteViejoDTO(nombre, unidad);

            // Llamar al método BO con el DTO y la cantidad
            bo.aumentarStock(dto, cantidad); // Usa el método con DTO

            JOptionPane.showMessageDialog(null, "Stock actualizado exitosamente.");
            cargarIngredientes(); // Refresca la tabla
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ingresa un número válido.");
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Unidad de medida inválida.");
        } catch (PersistenciaException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar stock: " + e.getMessage());
        }
    }//GEN-LAST:event_btnAumentarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Aumentar;
    private javax.swing.JTextField Buscador;
    private javax.swing.JComboBox<String> Filtro;
    private javax.swing.JButton Regresar;
    private javax.swing.JButton btnAumentar;
    private javax.swing.JButton btnRegistrarIngrediente;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
