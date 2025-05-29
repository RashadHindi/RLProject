package org.example.rlproject;
import javafx.beans.property.*;

public class CustomerTableView {
    private IntegerProperty customerID;
    private IntegerProperty phone;
    private StringProperty email;
    private StringProperty country;
    private StringProperty city;
    private StringProperty street;
    private StringProperty firstName;
    private StringProperty middleName;
    private StringProperty lastName;
    private StringProperty gender;

    public CustomerTableView(int customerID, int phone, String email, String country, String city, String street,
                             String firstName, String middleName, String lastName, String gender) {
        this.customerID = new SimpleIntegerProperty(customerID);
        this.phone = new SimpleIntegerProperty(phone);
        this.email = new SimpleStringProperty(email);
        this.country = new SimpleStringProperty(country);
        this.city = new SimpleStringProperty(city);
        this.street = new SimpleStringProperty(street);
        this.firstName = new SimpleStringProperty(firstName);
        this.middleName = new SimpleStringProperty(middleName);
        this.lastName = new SimpleStringProperty(lastName);
        this.gender = new SimpleStringProperty(gender);
    }

    // Getters and setters for properties
    public IntegerProperty customerIDProperty() { return customerID; }
    public IntegerProperty phoneProperty() { return phone; }
    public StringProperty emailProperty() { return email; }
    public StringProperty countryProperty() { return country; }
    public StringProperty cityProperty() { return city; }
    public StringProperty streetProperty() { return street; }
    public StringProperty firstNameProperty() { return firstName; }
    public StringProperty middleNameProperty() { return middleName; }
    public StringProperty lastNameProperty() { return lastName; }
    public StringProperty genderProperty() { return gender; }

    // Getters and setters for values (not properties)
    public int getCustomerID() { return customerID.get(); }
    public void setCustomerID(int customerID) { this.customerID.set(customerID); }

    public int getPhone() { return phone.get(); }
    public void setPhone(int phone) { this.phone.set(phone); }

    public String getEmail() { return email.get(); }
    public void setEmail(String email) { this.email.set(email); }

    public String getCountry() { return country.get(); }
    public void setCountry(String country) { this.country.set(country); }

    public String getCity() { return city.get(); }
    public void setCity(String city) { this.city.set(city); }

    public String getStreet() { return street.get(); }
    public void setStreet(String street) { this.street.set(street); }

    public String getFirstName() { return firstName.get(); }
    public void setFirstName(String firstName) { this.firstName.set(firstName); }

    public String getMiddleName() { return middleName.get(); }
    public void setMiddleName(String middleName) { this.middleName.set(middleName); }

    public String getLastName() { return lastName.get(); }
    public void setLastName(String lastName) { this.lastName.set(lastName); }

    public String getGender() { return gender.get(); }
    public void setGender(String gender) { this.gender.set(gender); }
}
