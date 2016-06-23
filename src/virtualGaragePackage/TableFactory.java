/**
 * File Name: TableFactory.java
 * Author: Jonathan Ross Tew
 * Last Modified: 5/4/15
 * Purpose of implementation: This is the concrete subclass of the AbstractTableFactory.
 * It extends that abstract class and overrides all the abstract methods and defines them.
 * This is part of the abstract factory design pattern. It allows me to create data tables
 * quickly and easily.
 */
package virtualGaragePackage;

import java.util.ArrayList;

public class TableFactory extends AbstractTableFactory {

    // Holds the data:
    ArrayList newTable = new ArrayList();

    // Figure out which type of table to make:
    protected ArrayList selectType(TableType type, String fileName) {
        if (type == TableType.MAINTENANCE) {
            return createMaintenanceTable(fileName);
        } else if (type == TableType.VEHICLE) {
            return createVehicleTable(fileName);
        } else {
            return createUserTable(fileName);
        }
    }

    // Creates data table specific to Maintenance table data:
    @Override
    protected ArrayList createMaintenanceTable(String fileName) {
        if (!newTable.isEmpty()) {
            newTable.clear();
        }
        ReadFile newRF = new ReadFile();
        ArrayList tempList = new ArrayList();
        tempList = newRF.readLines(fileName);
        for (int i = 0; i < tempList.size(); i++) {
            String[] row = (String[]) tempList.get(i);
            newTable.add(createMaintenancTableRow(row));
        }

        return newTable;
    }

    // Creates vehicle tables:
    @Override
    protected ArrayList createVehicleTable(String fileName) {
        if (!newTable.isEmpty()) {
            newTable.clear();
        }
        ReadFile newRF = new ReadFile();
        ArrayList tempList = new ArrayList();
        tempList = newRF.readLines(fileName);
        for (int i = 0; i < tempList.size(); i++) {
            String[] row = (String[]) tempList.get(i);
            newTable.add(createVehicleTableRow(row));
        }

        return newTable;
    }

    // Creates user tables:
    @Override
    protected ArrayList createUserTable(String fileName) {
        if (!newTable.isEmpty()) {
            newTable.clear();
        }
        ReadFile newRF = new ReadFile();
        ArrayList tempList = new ArrayList();
        tempList = newRF.readLines(fileName);
        for (int i = 0; i < tempList.size(); i++) {
            String[] row = (String[]) tempList.get(i);
            newTable.add(createUserTableRow(row));
        }

        return newTable;
    }

    // Method makes a single row for maintenance tables:
    @Override
    protected TableData createMaintenancTableRow(String[] row) {
        TableData maintRow = new MaintenanceData(row[0], row[1], row[2],
                row[3], row[4]);

        return maintRow;
    }

    // Method makes a single row for vehicle tables:
    @Override
    protected TableData createVehicleTableRow(String[] row) {
        TableData vehicleRow = new VehicleData(row[0], row[1], row[2],
                row[3]);

        return vehicleRow;
    }

    // Method makes a single row for user tables:
    @Override
    protected TableData createUserTableRow(String[] row) {
        TableData userRow = new UserData(row[0], row[1]);

        return userRow;
    }

}
