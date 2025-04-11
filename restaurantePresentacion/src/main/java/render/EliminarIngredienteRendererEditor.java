<<<<<<< Updated upstream
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package render;

/**
 *
 * @author chris
 */
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableCellEditor;
import javax.swing.AbstractCellEditor;
import javax.swing.JOptionPane;

import BOs.ingredienteBO;
import DTOs.IngredienteViejoDTO;
import enums.unidadMedida;
import exception.PersistenciaException;

public class EliminarIngredienteRendererEditor extends AbstractCellEditor implements TableCellRenderer, TableCellEditor {

    private JButton botonEliminar;
    private String nombre;
    private unidadMedida unidad;
    private ingredienteBO bo;

    public EliminarIngredienteRendererEditor() {
        botonEliminar = new JButton("Eliminar");
        bo = ingredienteBO.getInstancia();

        botonEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Confirmar eliminación
                int respuesta = JOptionPane.showConfirmDialog(null, "¿Deseas eliminar este ingrediente?", "Confirmar", JOptionPane.YES_NO_OPTION);
                if (respuesta == JOptionPane.YES_OPTION) {
                    try {
                        IngredienteViejoDTO dto = new IngredienteViejoDTO(nombre, unidad);
                        bo.eliminarIngredientePorNombreYUnidad(dto.getNombre(), dto.getUnidadMedida());
                        JOptionPane.showMessageDialog(null, "Ingrediente eliminado correctamente");
                        fireEditingStopped(); // Notifica a la tabla que se detenga la edición
                    } catch (PersistenciaException ex) {
                        JOptionPane.showMessageDialog(null, "Error al eliminar ingrediente: " + ex.getMessage());
                    }
                } else {
                    fireEditingCanceled();
                }
            }
        });
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        return botonEliminar;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int row, int column) {
        nombre = (String) table.getValueAt(row, 0); // Asumiendo que el nombre está en la columna 0
        unidad = (unidadMedida) table.getValueAt(row, 1);
        return botonEliminar;
    }

    @Override
    public Object getCellEditorValue() {
        return null;
    }
}
=======
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package render;

/**
 *
 * @author chris
 */
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableCellEditor;
import javax.swing.AbstractCellEditor;
import javax.swing.JOptionPane;

import BOs.ingredienteBO;
import DTOs.IngredienteViejoDTO;
import enums.unidadMedida;
import exception.PersistenciaException;

public class EliminarIngredienteRendererEditor extends AbstractCellEditor implements TableCellRenderer, TableCellEditor {

    private JButton botonEliminar;
    private String nombre;
    private unidadMedida unidad;
    private ingredienteBO bo;

    public EliminarIngredienteRendererEditor() {
        botonEliminar = new JButton("Eliminar");
        bo = ingredienteBO.getInstancia();

        botonEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Confirmar eliminación
                int respuesta = JOptionPane.showConfirmDialog(null, "¿Deseas eliminar este ingrediente?", "Confirmar", JOptionPane.YES_NO_OPTION);
                if (respuesta == JOptionPane.YES_OPTION) {
                    try {
                        IngredienteViejoDTO dto = new IngredienteViejoDTO(nombre, unidad);
                        bo.eliminarIngredientePorNombreYUnidad(dto.getNombre(), dto.getUnidadMedida());
                        JOptionPane.showMessageDialog(null, "Ingrediente eliminado correctamente");
                        fireEditingStopped(); // Notifica a la tabla que se detenga la edición
                    } catch (PersistenciaException ex) {
                        JOptionPane.showMessageDialog(null, "Error al eliminar ingrediente: " + ex.getMessage());
                    }
                } else {
                    fireEditingCanceled();
                }
            }
        });
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        return botonEliminar;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int row, int column) {
        nombre = (String) table.getValueAt(row, 0); // Asumiendo que el nombre está en la columna 0
        unidad = (unidadMedida) table.getValueAt(row, 1);
        return botonEliminar;
    }

    @Override
    public Object getCellEditorValue() {
        return null;
    }
}
>>>>>>> Stashed changes
