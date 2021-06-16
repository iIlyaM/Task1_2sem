package ru.vsu.cs.common;

import java.util.LinkedList;

public class Table {

    private Columns columns;
    private LinkedList<Row> rows;

    public Table() {
        columns = new Columns();
        rows = new LinkedList<>();
    }


    public int getColumnCount() {
        return columns.getSize();
    }

    public int getRowCount() {
        return rows.size();
    }

    public String getColumn(int index) {
        return columns.getColumn(index);
    }

    public void setValueAt(String colName, int rowIndex, String value) {
        rows.get(rowIndex).getCell(columns.colNames.indexOf(colName)).setData(value);
    }

    public void setValueAt(int rowIndex, String colName, String value) {
        rows.get(rowIndex).getCell(columns.colNames.indexOf(colName)).setData(value);
    }

    public String getValueAt(int rowIndex, String colName) {
        return rows.get(rowIndex).getCell(columns.colNames.indexOf(colName)).getData();
    }

    public String getValueAt(String colName, int rowIndex) {
        return rows.get(rowIndex).getCell(columns.colNames.indexOf(colName)).getData();
    }

    public void renameColumn(String colName, String newName) throws Exception {
        if (!columns.search(colName) || columns.search(newName)) {
            throw new Exception();
        }
        int columnInd = columns.getIndexColumn(colName);

        columns.colNames.set(columnInd, newName);
    }

    public void removeRow(int index) throws Exception {
        if (index < 0 || index > rows.size()) {
            throw new Exception();
        }

        rows.remove(index);
    }

    public void addRow() {
        Row newRow = new Row();
        for (int i = 0; i < columns.colNames.size(); i++) {
            newRow.addCell();
        }
        rows.add(newRow);
    }

    public void addColumn(String val) throws Exception {
        if (columns.search(val)) {
            throw new Exception();
        }
        columns.addColumn(val);
        for (int i = 0; i < rows.size(); i++) {
            rows.get(i).addCell();
        }
    }

    public void removeColumn(String colName) throws Exception {
        if (!columns.search(colName)) {
            throw new Exception();
        }

        int colIndex = columns.colNames.indexOf(colName);

        for (int i = 0; i < rows.size(); i++) {
            rows.get(i).removeCell(colIndex);
        }
        columns.colNames.remove(colIndex);
    }

    class Columns {
        private LinkedList<String> colNames;

        Columns() {
            colNames = new LinkedList<>();
        }

        public void addColumn(String colName) throws Exception {
            if (columns.search(colName)) {
                throw new Exception();
            }
            colNames.add(colName);
        }

        public void removeColumn(String colName) throws Exception {
            if (columns.search(colName)) {
                throw new Exception();
            }
            colNames.remove(colName);
        }


        public boolean search(String value) {
            for (int i = 0; i < colNames.size(); i++) {
                if (colNames.get(i).equals(value)) {
                    return true;
                }
            }
            return false;
        }

        public int getSize() {
            return colNames.size();
        }

        public int getIndexColumn(String columnName) {
            for (int i = 0; i < colNames.size(); i++) {
                if (colNames.get(i).equals(columnName)) {
                    return i;
                }
            }
            return -1;
        }

        public String getColumn(int index) {
            return colNames.get(index);
        }
    }

    class Row {
        LinkedList<Cell> cells;

        Row() {
            cells = new LinkedList<>();
        }

        public Cell getCell(int index) {
            return cells.get(index);
        }

        public void addCell() {
            Cell newCell = new Cell();
            cells.add(newCell);
        }

        public void removeCell(int index) {
            cells.remove(index);
        }
    }

    class Cell {
        private String data;

        Cell(String data) {
            this.data = data;
        }

        Cell() {

        }

        public void setData(String data) {
            this.data = data;
        }

        public String getData() {
            return data;
        }
    }
}
