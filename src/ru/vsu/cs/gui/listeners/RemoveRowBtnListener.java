package ru.vsu.cs.gui.listeners;

import ru.vsu.cs.common.Table;
import ru.vsu.cs.utils.ArrayUtils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoveRowBtnListener implements ActionListener {
    private JTable table1;
    private DefaultTableModel model;
    private Table table;

    public RemoveRowBtnListener(JTable table1, Table table) {
        this.table1 = table1;
        this.table = table;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        model = (DefaultTableModel) table1.getModel();
        try {
            table.removeRow(table.getRowCount() - 1);
            String[][] data = ArrayUtils.getData(table);
            String[] colNames = ArrayUtils.getColNames(table);
            model = new DefaultTableModel(data, colNames);
            table1.setModel(model);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
