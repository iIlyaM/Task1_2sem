package ru.vsu.cs.gui.listeners;

import ru.vsu.cs.common.Table;
import ru.vsu.cs.utils.ArrayUtils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoveColumnBtnListener implements ActionListener {
    private JTable table1;
    private JTextField colNameField;
    private DefaultTableModel model;
    private Table table;

    public RemoveColumnBtnListener(JTable table1, JTextField colNameField, Table table) {
        this.table1 = table1;
        this.colNameField = colNameField;
        this.table = table;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        model = (DefaultTableModel) table1.getModel();
        String columnName = colNameField.getText();
        try {
            table.removeColumn(columnName);
            String[][] data = ArrayUtils.getData(table);
            String[] colNames = ArrayUtils.getColNames(table);
            model = new DefaultTableModel(data, colNames);
            table1.setModel(model);
        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }
}
