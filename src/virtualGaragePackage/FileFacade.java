/**
 * File Name: FileFacade.java
 * Author: Jonathan Ross Tew
 * Last Modified: 5/4/15
 * Purpose of implementation: This class implements the Facade design pattern by
 * creating a class that simplifies the read/write proccesses for use elsewhere in
 * the program. This allows just one constructor to be used, and then all the methods
 * to be called off of it in the GUI class.
 */
package virtualGaragePackage;

import java.util.ArrayList;

public class FileFacade {

    // Constructors for two classes being combined here:
    ReadFile newFileReader = new ReadFile();
    WriteFile newFileWriter = new WriteFile();

    // All of the different methods that are consolidated here:
    public ArrayList readIn(String fileName) {
        return newFileReader.readLines(fileName);
    }

    public String[] getUserList(String fileName) {
        return newFileReader.getUsers(fileName);
    }

    public String[] getUserVehicleList(String fileName, String user) {
        return newFileReader.getVehics(fileName, user);
    }

    public String[] returnMakeModelYear(String fileName, String vehicle) {
        return newFileReader.getMakeModelYear(fileName, vehicle);
    }

    public boolean checkLogin(String fileName, String user, String password) {
        return newFileReader.checkUserPass(fileName, user, password);
    }

    public void writeMaintenanceLog(String fileName, ArrayList table) {
        newFileWriter.writeMaintenanceFile(fileName, table);
    }

    public void writeNewUsers(String fileName, String[] newUser) {
        newFileWriter.writeUserFile(fileName, newUser);
    }

    public void writeNewVehicle(String fileName, String[] newVehicle) {
        newFileWriter.writeVehicleFile(fileName, newVehicle);
    }

    public void writeBlankFile(String modelName) {
        newFileWriter.createBlankFile(modelName);
    }

}
