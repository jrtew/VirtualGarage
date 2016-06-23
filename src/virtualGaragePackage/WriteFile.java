/**
 * File Name: WriteFile.java
 * Author: Jonathan Ross Tew
 * Last Modified: 5/4/15
 * Purpose of implementation: The WriteFile class contains methods used to write
 * data to text files in the project folder.
 */
package virtualGaragePackage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WriteFile {

    // Setting up delimiter and new line characters:
    private final String DELIMITER = "~";
    private final String NEW_LINE = "\n";

    // Writes the maintenance table data to file:
    public void writeMaintenanceFile(String fileName, ArrayList table) {
        String fullFileName = fileName + ".txt";
        FileWriter newFileWriter = null;
        TableData maintRow;
        try {
            newFileWriter = new FileWriter(fullFileName);
            for (int i = 0; i < table.size(); i++) {
                maintRow = (TableData) table.get(i);
                newFileWriter.append(maintRow.getDate());
                newFileWriter.append(DELIMITER);
                newFileWriter.append(maintRow.getMiles());
                newFileWriter.append((DELIMITER));
                newFileWriter.append(maintRow.getMaint());
                newFileWriter.append(DELIMITER);
                newFileWriter.append(maintRow.getComments());
                newFileWriter.append(DELIMITER);
                newFileWriter.append(maintRow.getCost());
                newFileWriter.append(NEW_LINE);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                newFileWriter.flush();
                newFileWriter.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    // Writes a new user to the userlist file:
    public void writeUserFile(String fileName, String[] newUser) {
        String fullFileName = fileName + ".txt";
        FileWriter newFileWriter = null;
        ReadFile newReader = new ReadFile();
        ArrayList theUserList = new ArrayList();
        theUserList = newReader.readLines(fileName);
        theUserList.add(newUser);
        String[] theUser;
        try {
            newFileWriter = new FileWriter(fullFileName);
            for (int i = 0; i < theUserList.size(); i++) {
                theUser = (String[]) theUserList.get(i);
                newFileWriter.append(String.valueOf(theUser[0]));
                newFileWriter.append(DELIMITER);
                newFileWriter.append(String.valueOf(theUser[1]));
                newFileWriter.append(NEW_LINE);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                newFileWriter.flush();
                newFileWriter.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    // Writes new vehicles to the vehiclelist file:
    public void writeVehicleFile(String fileName, String[] newVehicle) {
        String fullFileName = fileName + ".txt";
        FileWriter newFileWriter = null;
        ReadFile newReader = new ReadFile();
        ArrayList theVehicleList = new ArrayList();
        theVehicleList = newReader.readLines(fileName);
        theVehicleList.add(newVehicle);
        String[] theVehicle;
        try {
            newFileWriter = new FileWriter(fullFileName);
            for (int i = 0; i < theVehicleList.size(); i++) {
                theVehicle = (String[]) theVehicleList.get(i);
                newFileWriter.append(String.valueOf(theVehicle[0]));
                newFileWriter.append(DELIMITER);
                newFileWriter.append(String.valueOf(theVehicle[1]));
                newFileWriter.append(DELIMITER);
                newFileWriter.append(String.valueOf(theVehicle[2]));
                newFileWriter.append(DELIMITER);
                newFileWriter.append(String.valueOf(theVehicle[3]));
                newFileWriter.append(NEW_LINE);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                newFileWriter.flush();
                newFileWriter.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    // Creates a new blank file with specified name:
    public void createBlankFile(String modelName) {
        File newFile = new File(modelName + ".txt");
        try {
            newFile.createNewFile();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
