package org.example.rlproject;
import javafx.beans.property.*;

public class SupplierTableView {
    private IntegerProperty supplierID;
    private StringProperty firstName;
    private StringProperty lastName;
    private StringProperty email;
    private IntegerProperty phone;
    private StringProperty country;
    private StringProperty city;
    private StringProperty street;
    private StringProperty zipCode;

    // Constructor to initialize the properties
    public SupplierTableView(int supplierID, String firstName,  String lastName,
                             String email, int phone, String country, String city, String street, String zipCode) {
        this.supplierID = new SimpleIntegerProperty(supplierID);
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.email = new SimpleStringProperty(email);
        this.phone = new SimpleIntegerProperty(phone);
        this.country = new SimpleStringProperty(country);
        this.city = new SimpleStringProperty(city);
        this.street = new SimpleStringProperty(street);
        this.zipCode = new SimpleStringProperty(zipCode);
    }

    // Getters for each property
    public IntegerProperty supplierIDProperty() { return supplierID; }
    public StringProperty firstNameProperty() { return firstName; }
    public StringProperty lastNameProperty() { return lastName; }
    public StringProperty emailProperty() { return email; }
    public IntegerProperty phoneProperty() { return phone; }
    public StringProperty countryProperty() { return country; }
    public StringProperty cityProperty() { return city; }
    public StringProperty streetProperty() { return street; }
    public StringProperty zipCodeProperty() { return zipCode; }

    // Setters for each property
    public void setSupplierID(int supplierID) { this.supplierID.set(supplierID); }
    public void setFirstName(String firstName) { this.firstName.set(firstName); }
    public void setLastName(String lastName) { this.lastName.set(lastName); }
    public void setEmail(String email) { this.email.set(email); }
    public void setPhone(int phone) { this.phone.set(phone); }
    public void setCountry(String country) { this.country.set(country); }
    public void setCity(String city) { this.city.set(city); }
    public void setStreet(String street) { this.street.set(street); }
    public void setZipCode(String zipCode) { this.zipCode.set(zipCode); }
}
