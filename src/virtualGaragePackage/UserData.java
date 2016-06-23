/**
 * File Name: UserData.java
 * Author: Jonathan Ross Tew
 * Last Modified: 5/4/15
 * Purpose of implementation: Concrete subclass of the abstract AbstractTableData
 * class. This just forwards the constructor.
 */
package virtualGaragePackage;

public class UserData extends AbstractTableData {

    // Constructor, forwards to super:
    public UserData(String user, String password) {
        super(user, password);
    }

}
