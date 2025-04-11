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
import javax.swing.JTable;

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

        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); // Deshabilita el cambio de tamaño automático de columnas
        jTable1.getTableHeader().setResizingAllowed(false); // Deshabilitar el redimensionamiento de columnas


// Establece el tamaño fijo de las columnas
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(150);  // Ancho para la columna "Nombre"
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(150);  // Ancho para la columna "Unidad de Medida"
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(100);  // Ancho para la columna "Stock"
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(150);  // Ancho para la columna "Eliminar"

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
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jPanel1 = new javax.swing.JPanel();
        btnRegistrarIngrediente = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Filtro = new javax.swing.JComboBox<>();
        Buscador = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        btnRegresar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        Aumentar = new javax.swing.JTextField();
        btnActualizar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        Descontar = new javax.swing.JTextField();
        btnDescontar = new javax.swing.JButton();

        jButton1.setText("Buscar Ingredientes");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

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

        Filtro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nombre", "Unidad" }));
        Filtro.setToolTipText("Seleccione");

        Buscador.setToolTipText("");

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
                .addGap(25, 25, 25)
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

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        jLabel3.setText("Agregar Stock");

        Aumentar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AumentarActionPerformed(evt);
            }
        });

        btnActualizar.setText("Aumentar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        jLabel4.setText("Descontar Stock");

        Descontar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DescontarActionPerformed(evt);
            }
        });

        btnDescontar.setText("Descontar");
        btnDescontar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDescontarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(159, 159, 159)
                                .addComponent(Buscador, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(Filtro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(jButton2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(297, 297, 297)
                                .addComponent(btnRegistrarIngrediente))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(btnRegresar)))
                        .addGap(0, 209, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnActualizar)
                    .addComponent(jLabel3)
                    .addComponent(Aumentar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(259, 259, 259)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel4)
                        .addComponent(Descontar, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(btnDescontar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 553, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Buscador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2)
                    .addComponent(Filtro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(btnRegistrarIngrediente)
                .addGap(70, 70, 70)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Aumentar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Descontar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnActualizar)
                    .addComponent(btnDescontar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                .addComponent(btnRegresar)
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
//        ControlFlujoPantallas.getInstancia().abrirBuscarIngrediente();
//        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Buscador.setText("");
        Filtro.setSelectedIndex(0); // Pone el filtro en "Nombre"
        cargarIngredientes(); // Recarga todos los ingredientes
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        ControlFlujoPantallas.getInstancia().abrirPantallaAdministrador();
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void AumentarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AumentarActionPerformed


    }//GEN-LAST:event_AumentarActionPerformed

    private void DescontarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DescontarActionPerformed
    }//GEN-LAST:event_DescontarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
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
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnDescontarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDescontarActionPerformed
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

            int cantidad = Integer.parseInt(Descontar.getText());

            // Crear el DTO con los valores obtenidos de la tabla
            IngredienteViejoDTO dto = new IngredienteViejoDTO(nombre, unidad);

            // Llamar al método BO con el DTO y la cantidad
            bo.descontarStock(dto, cantidad); // Usa el método con DTO

            JOptionPane.showMessageDialog(null, "Stock descontado exitosamente.");
            cargarIngredientes(); // Refresca la tabla
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ingresa un número válido.");
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Unidad de medida inválida.");
        } catch (PersistenciaException e) {
            JOptionPane.showMessageDialog(null, "Error al descontar stock: " + e.getMessage());
        }
    }//GEN-LAST:event_btnDescontarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Aumentar;
    private javax.swing.JTextField Buscador;
    private javax.swing.JTextField Descontar;
    private javax.swing.JComboBox<String> Filtro;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnDescontar;
    private javax.swing.JButton btnRegistrarIngrediente;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
