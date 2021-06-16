package ru.vsu.cs.gui.listeners;

import ru.vsu.cs.common.Table;
import ru.vsu.cs.utils.ArrayUtils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SetValBtnListener implements ActionListener {
    private JTable table1;
    private JTextField setValField;
    private JTextField newValField;
    private Table table;
    private DefaultTableModel model;

    public SetValBtnListener(JTextField setValField, JTextField newValField, JTable table1, Table table) {
        this.table1 = table1;
        this.setValField = setValField;
        this.newValField = newValField;
        this.table = table;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        model = (DefaultTableModel) table1.getModel();
        String[] val = ArrayUtils.getStringsArray(setValField.getText());
        int row = Integer.parseInt(val[1]);
        table.setValueAt(val[0], row, newValField.getText());
        String[][] data = ArrayUtils.getData(table);
        String[] colNames = ArrayUtils.getColNames(table);
        model = new DefaultTableModel(data, colNames);
        table1.setModel(model);
    }
}
