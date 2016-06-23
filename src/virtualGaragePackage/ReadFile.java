/**
 * File Name: ReadFile.java
 * Author: Jonathan Ross Tew
 * Last Modified: 5/4/15
 * Purpose of implementation: The ReadFile class implements the java Iterable
 * class. This class takes use of the iterable design pattern as such. This class
 * has methods for reading in data from text files.
 */
package virtualGaragePackage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class ReadFile implements Iterable<ArrayList> {

    // Required variables:
    BufferedReader bufRead = null;
    ArrayList readLinesList = new ArrayList();
    ArrayList anArrayList = new ArrayList();
    String[] users = null;
    String[] vehicles = null;

    // Read in lines from a text file, returns an arraylist of data:
    public ArrayList readLines(String fileName) {
        if (!readLinesList.isEmpty()) {
            readLinesList.clear();
        }
        try {
            bufRead = new BufferedReader(new FileReader(fileName + ".txt"));
            String line = bufRead.readLine();

            while (line != null) {
                String[] rows = line.split("~");
                readLinesList.add(rows);
                line = bufRead.readLine();
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return readLinesList;
    }

    // Convert ArrayList to a String[]:
    public String[] convertToArray(ArrayList theAL) {
        String[] theList = (String[]) theAL.toArray(new String[theAL.size()]);
        return theList;
    }

    // Method for returning a list of users:
    public String[] getUsers(String fileName) {
        if (!anArrayList.isEmpty()) {
            anArrayList.clear();
        }
        int count = 0;
        anArrayList = readLines(fileName);
        String[] tempList = null;
        users = new String[anArrayList.size()];
        for (Object currentObj : getTheArrayList()) {
            tempList = (String[]) currentObj;
            users[count] = tempList[0];
            count++;
        }
        return users;
    }

    // Method for checking the username/password combination for login:
    public boolean checkUserPass(String fileName, String user, String password) {
        boolean correctLogin = false;
        String[] tempList = null;
        if (!anArrayList.isEmpty()) {
            anArrayList.clear();
        }
        anArrayList = readLines(fileName);
        for (Object currentObj : getTheArrayList()) {
            tempList = (String[]) currentObj;
            if (tempList[0].equals(user)) {
                if (tempList[1].equals(password)) {
                    correctLogin = true;
                }
            }
        }

        return correctLogin;
    }

    // Returns a list of vehicles associated with the specified user:
    public String[] getVehics(String fileName, String user) {
        if (!anArrayList.isEmpty()) {
            anArrayList.clear();
        }
        anArrayList = readLines(fileName);
        String[] tempList = null;
        ArrayList forConvertList = new ArrayList();
        for (Object currentObj : getTheArrayList()) {
            tempList = (String[]) currentObj;
            if (tempList[3].equals(user)) {
                forConvertList.add(tempList[1]);
            }

        }
        vehicles = convertToArray(forConvertList);

        return vehicles;
    }

    // Gets the vehicle info for a certain vehicle:
    public String[] getMakeModelYear(String fileName, String vehicle) {
        String[] makeModelYear = null;
        if (!anArrayList.isEmpty()) {
            anArrayList.clear();
        }
        anArrayList = readLines(fileName);
        String[] tempList = null;
        for (Object currentObj : getTheArrayList()) {
            tempList = (String[]) currentObj;
            if (tempList[1].equals(vehicle)) {
                makeModelYear = tempList;
            }
        }

        return makeModelYear;
    }

    // For use with the iterator pattern:
    public ArrayList getTheArrayList() {
        return anArrayList;
    }

    // For use with the iterator pattern:
    @Override
    public Iterator<ArrayList> iterator() {
        return anArrayList.listIterator();
    }
}
