package ru.vsu.cs.utils;

import ru.vsu.cs.common.Table;

public class ArrayUtils {

    public static String[][] getData(Table table) {
        String[][] newArr = new String[table.getRowCount()][table.getColumnCount()];
        for (int i = 0; i < newArr.length; i++) {
            for (int j = 0; j < newArr[i].length; j++) {
                newArr[i][j] = table.getValueAt(i, table.getColumn(j));
            }
        }
        return newArr;
    }

    public static String[] getColNames(Table table) {
        String[] names = new String[table.getColumnCount()];
        for (int i = 0; i < names.length; i++) {
           names[i] = table.getColumn(i);
        }
        return names;
    }

    public static String[] getStringsArray(String str) {
        String[] strings = str.split("\\s*(\\s|;|,|!|\\.)\\s*");
        return strings;
    }
}
