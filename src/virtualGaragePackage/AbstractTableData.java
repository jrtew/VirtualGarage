/**
 * File Name: AbstractTableData.java
 * Author: Jonathan Ross Tew
 * Last Modified: 5/4/15
 * Purpose of implementation: This abstract class implements the interface TableData
 * and defines all the variables and the three different constructors that will be used
 * for the three concrete sub-classes. All of the getter/setters are defined/overriden here
 * as well.
 */
package virtualGaragePackage;

public abstract class AbstractTableData implements TableData {

    // Variables:
    private String date;
    private String miles;
    private String maint;
    private String comments;
    private String cost;
    private String make;
    private String model;
    private String year;
    private String user;
    private String password;

    // Constructor for concrete subclass MaintenanceData:
    public AbstractTableData(String date, String miles, String maint, String comments, String cost) {
        this.date = date;
        this.miles = miles;
        this.maint = maint;
        this.comments = comments;
        this.cost = cost;
    }

    // Constructor for concrete subclass VehicleData:
    public AbstractTableData(String make, String model, String year, String user) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.user = user;
    }

    // Constructor for concrete subclass UserData:
    public AbstractTableData(String user, String password) {
        this.user = user;
        this.password = password;
    }

    @Override
    public String getDate() {
        return date;
    }

    @Override
    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String getMiles() {
        return miles;
    }

    @Override
    public void setMiles(String miles) {
        this.miles = miles;
    }

    @Override
    public String getMaint() {
        return maint;
    }

    @Override
    public void setMaint(String maint) {
        this.maint = maint;
    }

    @Override
    public String getComments() {
        return comments;
    }

    @Override
    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String getCost() {
        return cost;
    }

    @Override
    public void setCost(String cost) {
        this.cost = cost;
    }

    @Override
    public String getMake() {
        return make;
    }

    @Override
    public void setMake(String make) {
        this.make = make;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String getYear() {
        return year;
    }

    @Override
    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String getUser() {
        return user;
    }

    @Override
    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

}
