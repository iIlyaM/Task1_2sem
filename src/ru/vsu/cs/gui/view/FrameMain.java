package ru.vsu.cs.gui.view;

import ru.vsu.cs.common.Table;
import ru.vsu.cs.gui.listeners.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class FrameMain extends JFrame {
    private JButton removeRowBtn;
    private JButton addRowBtn;
    private JButton addColBtn;
    private JButton setValBtn;
    private JButton getValBtn;
    private JTable table1;
    private JTextField colNameField;
    private JTextField setValField;
    private JTextField getValField;
    private JPanel panel1;
    private JButton removeColumnButton;
    private JButton renameColBtn;
    private JTextField startColumnNameField;
    private JTextField newValField;
    private JTextField showValField;
    private JTextField newNameField;
    private JLabel coordinatesLabel;
    private Table table;


    public FrameMain() {
        this.setTitle("Task 1");
        this.setSize(880, 700);
        this.setContentPane(panel1);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        Table table = new Table();
        DefaultTableModel model = new DefaultTableModel(0, 0);
        this.table1.setModel(model);

        this.addColBtn.addActionListener(new AddColumnBtnListener(table1, colNameField, table));

        this.removeColumnButton.addActionListener(new RemoveColumnBtnListener(table1, colNameField, table));

        this.addRowBtn.addActionListener(new AddRowBtnListener(table1, table));

        this.removeRowBtn.addActionListener(new RemoveRowBtnListener(table1, table));

        this.setValBtn.addActionListener(new SetValBtnListener(setValField, newValField, table1, table));

        this.getValBtn.addActionListener(new GetValBtnListener(table1, table, getValField, showValField));

        this.renameColBtn.addActionListener(
                new RenameColumnBtnListener(table1, newNameField, startColumnNameField, table));
    }
}