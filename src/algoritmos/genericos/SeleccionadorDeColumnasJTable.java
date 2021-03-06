/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmos.genericos;

import java.util.HashMap;
import java.util.Map;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Roy
 */
public class SeleccionadorDeColumnasJTable {
    private final Map<Integer, TableColumn> hiddenColumns = new HashMap<>();
    private JTable table;

    /**
     * Constructor. Call {@link #install(javax.swing.JTable) install} to actually
     * install it on a JTable.
     */
    public SeleccionadorDeColumnasJTable() {
    }

    /**
     * Installs this selector on a given table.
     * @param table the table to install this selector on
     */
    public void install(JTable table) {
        this.table = table;
        table.getTableHeader().setComponentPopupMenu(createHeaderMenu());
    }

    private JPopupMenu createHeaderMenu() {
        final JPopupMenu headerMenu = new JPopupMenu();
        final TableModel model = table.getModel();
        for (int i = 0; i < model.getColumnCount(); ++i)
            headerMenu.add(createMenuItem(i));
        return headerMenu;
    }

    private JCheckBoxMenuItem createMenuItem(final int modelIndex) {
        final TableModel model = table.getModel();
        final String columnName = model.getColumnName(modelIndex);
        JCheckBoxMenuItem menuItem = new JCheckBoxMenuItem(columnName);
        menuItem.setSelected(true);
        menuItem.addActionListener(action -> {
            setColumnVisible(modelIndex, menuItem.isSelected());
        });
        return menuItem;
    }

    private void setColumnVisible(int modelIndex, boolean visible) {
        if (visible)
            showColumn(modelIndex);
        else
            hideColumn(modelIndex);
    }

    private void showColumn(int modelIndex) {
        TableColumn column = hiddenColumns.remove(modelIndex);
        TableColumnModel columnModel = table.getColumnModel();
        columnModel.addColumn(column);
        final int addedViewIndex = columnModel.getColumnCount() - 1;
        if (modelIndex < columnModel.getColumnCount())
            columnModel.moveColumn(addedViewIndex, modelIndex);
    }
    
    private void hideColumn(int modelIndex) {
        int vIndex = table.convertColumnIndexToView(modelIndex);
        TableColumnModel columnModel = table.getColumnModel();
        TableColumn column = columnModel.getColumn(vIndex);
        columnModel.removeColumn(column);
        hiddenColumns.put(modelIndex, column);
        workaroundForSwingIndexOutOfBoundsBug(column);
    }

    private void workaroundForSwingIndexOutOfBoundsBug(TableColumn column) {
        JTableHeader tableHeader = table.getTableHeader();
        if (tableHeader.getDraggedColumn() == column) {
            tableHeader.setDraggedColumn(null);
        }
    }
}
