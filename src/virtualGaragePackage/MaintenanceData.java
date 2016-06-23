/**
 * File Name: MaintenanceData.java
 * Author: Jonathan Ross Tew
 * Last Modified: 5/4/15
 * Purpose of implementation: Concrete subclass of the abstract AbstractTableData
 * class. This just forwards the constructor.
 */
package virtualGaragePackage;

public class MaintenanceData extends AbstractTableData {

    // Constructor, forwards to super:
    public MaintenanceData(String date, String miles, String maint, String comments, String cost) {
        super(date, miles, maint, comments, cost);
    }

}
