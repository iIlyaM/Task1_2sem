package ru.vsu.cs.gui.listeners;

import ru.vsu.cs.common.Table;
import ru.vsu.cs.utils.ArrayUtils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GetValBtnListener implements ActionListener {
    private JTable table1;
    private Table table;
    private JTextField getValField;
    private JTextField showValField;
    private DefaultTableModel model;

    public GetValBtnListener(JTable table1, Table table, JTextField getValField, JTextField showValField) {
        this.table1 = table1;
        this.table = table;
        this.getValField = getValField;
        this.showValField = showValField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        model = (DefaultTableModel) table1.getModel();
        String[] val = ArrayUtils.getStringsArray(getValField.getText());
        int row = Integer.parseInt(val[1]);
        showValField.setText(table.getValueAt(val[0], row));
        table1.setModel(model);
    }
}
