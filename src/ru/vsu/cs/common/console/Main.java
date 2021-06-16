package ru.vsu.cs.common.console;

import ru.vsu.cs.common.Table;

public class Main {

    public static void main(String[] args) throws Exception{
        Table table = new Table();
        table.addColumn("1");
        table.addRow();
        table.addRow();
        table.addRow();
        table.setValueAt("1",0,"Value");
        table.setValueAt(1,"1", "Car");
        System.out.println(table.getValueAt("1",0));
        System.out.println(table.getValueAt(1,"1"));
    }
}
