/**
 * File Name: TableData.java
 * Author: Jonathan Ross Tew
 * Last Modified: 5/4/15
 * Purpose of implementation: This interface is used to set up a TableFactory 
 * under the abstract factory pattern. It sets up all the getter/setters needed
 * for the different classes.
 */
package virtualGaragePackage;

public interface TableData {

    public String getDate();

    public void setDate(String date);

    public String getMiles();

    public void setMiles(String miles);

    public String getMaint();

    public void setMaint(String maint);

    public String getComments();

    public void setComments(String comments);

    public String getCost();

    public void setCost(String cost);

    public String getMake();

    public void setMake(String make);

    public String getModel();

    public void setModel(String model);

    public String getYear();

    public void setYear(String year);

    public String getUser();

    public void setUser(String user);

    public String getPassword();

    public void setPassword(String password);

}
