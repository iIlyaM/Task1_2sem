package ru.vsu.cs.gui.listeners;

import ru.vsu.cs.common.Table;
import ru.vsu.cs.utils.ArrayUtils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddRowBtnListener implements ActionListener {
    private JTable table1;
    private Table table;
    private DefaultTableModel model;

    public AddRowBtnListener(JTable table1, Table table) {
        this.table1 = table1;
        this.table = table;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        model = (DefaultTableModel) table1.getModel();
        table.addRow();
        String[][] data = ArrayUtils.getData(table);
        String[] names = ArrayUtils.getColNames(table);
        model = new DefaultTableModel(data,names);
        table1.setModel(model);
    }
}
