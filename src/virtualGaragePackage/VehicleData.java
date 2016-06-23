/**
 * File Name: VehicleData.java
 * Author: Jonathan Ross Tew
 * Last Modified: 5/4/15
 * Purpose of implementation: Concrete subclass of the abstract AbstractTableData
 * class. This just forwards the constructor.
 */
package virtualGaragePackage;

public class VehicleData extends AbstractTableData {

    // Constructor, forwards to super:
    public VehicleData(String make, String model, String year, String user) {
        super(make, model, year, user);
    }

}
