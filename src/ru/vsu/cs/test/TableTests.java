package ru.vsu.cs.test;

import org.junit.Test;
import ru.vsu.cs.common.Table;

import static org.junit.Assert.*;

public class TableTests {

    @Test
    public void addColumn() throws Exception {
        Table testTable = new Table();
        testTable.addColumn("1");
        testTable.addColumn("2");
        testTable.addColumn("3");
        assertEquals(3, testTable.getColumnCount());
    }

    @Test
    public void removeColumn() throws Exception {
        Table testTable1 = new Table();
        testTable1.addColumn("1");
        testTable1.addColumn("2");
        testTable1.addColumn("3");
        assertEquals(3, testTable1.getColumnCount());
        testTable1.removeColumn("2");
        assertEquals(2, testTable1.getColumnCount());
        ;
    }

    @Test
    public void addRow() throws Exception {
        Table testTable2 = new Table();
        testTable2.addColumn("1");
        testTable2.addRow();
        testTable2.addRow();
        testTable2.addRow();
        assertEquals(1, testTable2.getColumnCount());
        assertEquals(3, testTable2.getRowCount());
    }

    @Test
    public void removeRow() throws Exception {
        Table testTable3 = new Table();
        testTable3.addColumn("1");
        testTable3.addColumn("2");
        testTable3.addColumn("3");
        testTable3.addRow();
        testTable3.addRow();
        testTable3.addRow();
        testTable3.addRow();
        assertEquals(4, testTable3.getRowCount());
        testTable3.removeRow(2);
        testTable3.removeRow(0);
        assertEquals(2, testTable3.getRowCount());
    }

    @Test
    public void testVal() throws Exception {
        Table testTable4 = new Table();
        testTable4.addColumn("1");
        testTable4.addColumn("2");
        testTable4.addColumn("3");
        testTable4.addRow();
        testTable4.addRow();
        testTable4.addRow();
        testTable4.addRow();
        testTable4.setValueAt("1", 2, "Ready");
        testTable4.setValueAt(1, "2", "Go");
        assertEquals("Go", testTable4.getValueAt(1, "2"));
        assertEquals("Ready", testTable4.getValueAt("1", 2));
    }
}
