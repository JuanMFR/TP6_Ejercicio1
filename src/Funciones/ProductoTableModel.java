/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funciones;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author JuanmaPC, nahuelguerra
 */
public class ProductoTableModel extends AbstractTableModel{
    private final String[] columnNames = {"Nombre", "Categoría", "Precio"};
    private final List<Producto> productos;

    public ProductoTableModel() {
        this.productos = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return productos.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
            case 1:
                return String.class;
            case 2:
                return Double.class;
            default:
                return Object.class;
        }
    }
     @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Producto producto = productos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return producto.getNombre();
            case 1:
                return producto.getCategoria();
            case 2:
                return producto.getPrecio();
            default:
                return null;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
        fireTableRowsInserted(productos.size() - 1, productos.size() - 1);
    }

    public void eliminarProducto(int rowIndex) {
        if (rowIndex >= 0 && rowIndex < productos.size()) {
            productos.remove(rowIndex);
            fireTableRowsDeleted(rowIndex, rowIndex);
        }
    }

    public void limpiarTabla() {
        int size = productos.size();
        if (size > 0) {
            productos.clear();
            fireTableRowsDeleted(0, size - 1);
        }
    }
}
