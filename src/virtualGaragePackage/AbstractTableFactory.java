/**
 * File Name: AbstractTableFactory.java
 * Author: Jonathan Ross Tew
 * Last Modified: 5/4/15
 * Purpose of implementation: An abstract class for creating table data. This is
 * part of the the Abstract Factory design pattern. This class holds the enum types
 * for the three different table types, and all of the abstract methods implemented fully
 * in the concrete subclass.
 */
package virtualGaragePackage;

import java.util.ArrayList;

public abstract class AbstractTableFactory {

    // Enum types for the three types of tables:
    public enum TableType {

        MAINTENANCE, VEHICLE, USER
    };

    // The create table method makes the actual data table:
    public ArrayList createTable(TableType type, String fileName) {
        ArrayList newTable = selectType(type, fileName);
        return newTable;
    }

    // All the abstract methods that will be fully implemented in the concrete
    // subclass:
    protected abstract ArrayList createMaintenanceTable(String fileName);

    protected abstract ArrayList createVehicleTable(String fileName);

    protected abstract ArrayList createUserTable(String fileName);

    protected abstract TableData createMaintenancTableRow(String[] row);

    protected abstract TableData createVehicleTableRow(String[] row);

    protected abstract TableData createUserTableRow(String[] row);

    protected abstract ArrayList selectType(TableType type, String fileName);
}
