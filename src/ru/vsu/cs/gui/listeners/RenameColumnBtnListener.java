package ru.vsu.cs.gui.listeners;

import ru.vsu.cs.common.Table;
import ru.vsu.cs.utils.ArrayUtils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RenameColumnBtnListener implements ActionListener {
    private JTable table1;
    private JTextField newNameField;
    private JTextField columnNameField;
    private Table table;
    private DefaultTableModel model;

    public RenameColumnBtnListener(JTable table1, JTextField newNameField, JTextField columnNameField, Table table) {
        this.table1 = table1;
        this.newNameField = newNameField;
        this.columnNameField = columnNameField;
        this.table = table;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        model = (DefaultTableModel) table1.getModel();
        try {
            table.renameColumn(columnNameField.getText(), newNameField.getText());
            String[][] data = ArrayUtils.getData(table);
            String[] colNames = ArrayUtils.getColNames(table);
            model = new DefaultTableModel(data, colNames);
            table1.setModel(model);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
