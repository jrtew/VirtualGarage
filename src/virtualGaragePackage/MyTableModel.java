/**
 * File Name: MyTableModel.java
 * Author: Jonathan Ross Tew
 * Last Modified: 5/4/15
 * Purpose of implementation: The MyTableModel class extends the AbstractTableModel
 * class, a built in java class. This takes advantage of the MVC design pattern.
 * This class allows me to built a custom table model to use in the jTable.
 */
package virtualGaragePackage;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class MyTableModel extends AbstractTableModel {

    // The data structure for storing the table data:
    private ArrayList dataTableList = new ArrayList();

    // Column names:
    private String[] columns = {"Date", "Mileage", "Maintenance", "Comments", "Cost"};

    @Override
    public int getRowCount() {
        return dataTableList.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public String getColumnName(int col) {
        return columns[col];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        // Allows the cells to be editable:
        return true;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        // For getting the specific data at a certain cell:
        TableData maintRow = (TableData) dataTableList.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return maintRow.getDate();
            case 1:
                return maintRow.getMiles();
            case 2:
                return maintRow.getMaint();
            case 3:
                return maintRow.getComments();
            case 4:
                return maintRow.getCost();
            default:
                return null;
        }
    }
    
    public void setValueAt(Object newValue, int rowIndex, int columnIndex) {
        // This method is how the cells are updated when edited in the jTable:
        TableData maintRow = (TableData) dataTableList.get(rowIndex);
        String original;
        switch (columnIndex) {
            case 0:
                original = maintRow.getDate();
                if (newValue.toString().equals("")) {
                    maintRow.setDate(original);
                } else {
                    maintRow.setDate(newValue.toString());
                }
                break;
            case 1:
                original = maintRow.getMiles();
                if (newValue.toString().equals("")) {
                    maintRow.setMiles(original);
                } else {
                    maintRow.setMiles(newValue.toString());
                }
                break;
            case 2:
                original = maintRow.getMaint();
                if (newValue.toString().equals("")) {
                    maintRow.setMaint(original);
                } else {
                    maintRow.setMaint(newValue.toString());
                }
                break;
            case 3:
                original = maintRow.getComments();
                if (newValue.toString().equals("")) {
                    maintRow.setComments(original);
                } else {
                    maintRow.setComments(newValue.toString());
                }
                break;
            case 4:
                original = maintRow.getCost();
                if (newValue.toString().equals("")) {
                    maintRow.setCost(original);
                } else {
                    maintRow.setCost(newValue.toString());
                }
                break;
            default:
        }
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    // Adds a row of data:
    public void addRow(TableData row) {
        dataTableList.add(row);
        this.fireTableDataChanged();
    }

    // Gets the table data info:
    public ArrayList getTableData() {
        return dataTableList;
    }

    // Clears the table data:
    public void clearList() {
        dataTableList.clear();
    }

    // Checks the table data ArrayList to see if empty:
    public boolean checkListEmpty() {
        return dataTableList.isEmpty();
    }

    // Adds new information to the data table:
    public void newDataNewTable(ArrayList al) {
        if (!checkListEmpty()) {
            clearList();
        }
        dataTableList.addAll(al);
    }

    // Empty constructorL
    public MyTableModel() {
    }

    // Constructor that takes an ArrayList as the argument:
    public MyTableModel(ArrayList newAL) {
        dataTableList.addAll(newAL);
    }
}
