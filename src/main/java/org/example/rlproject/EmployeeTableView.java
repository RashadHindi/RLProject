package org.example.rlproject;
import javafx.beans.property.*;

public class EmployeeTableView {


    private IntegerProperty employeeID;
    private StringProperty firstName;
    private StringProperty middleName;
    private StringProperty lastName;
    private StringProperty gender;
    private StringProperty email;
    private IntegerProperty phone;
    private StringProperty country;
    private StringProperty city;
    private StringProperty street;
    private StringProperty zipCode;
    private StringProperty birthDate;
    private DoubleProperty salary;

    public EmployeeTableView(int employeeID, String firstName, String middleName, String lastName, String gender,
                             String email, int phone, String country, String city, String street,
                             String zipCode, String birthDate, double salary) { // Adjust salary to double
        this.employeeID = new SimpleIntegerProperty(employeeID);
        this.firstName = new SimpleStringProperty(firstName);
        this.middleName = new SimpleStringProperty(middleName);
        this.lastName = new SimpleStringProperty(lastName);
        this.gender = new SimpleStringProperty(gender);
        this.email = new SimpleStringProperty(email);
        this.phone = new SimpleIntegerProperty(phone); // This is fine
        this.country = new SimpleStringProperty(country);
        this.city = new SimpleStringProperty(city);
        this.street = new SimpleStringProperty(street);
        this.zipCode = new SimpleStringProperty(zipCode);
        this.birthDate = new SimpleStringProperty(birthDate);
        this.salary = new SimpleDoubleProperty(salary); // Initialize as SimpleDoubleProperty
    }

    // Getters and setters
    public IntegerProperty employeeIDProperty() { return employeeID; }
    public StringProperty firstNameProperty() { return firstName; }
    public StringProperty middleNameProperty() { return middleName; }
    public StringProperty lastNameProperty() { return lastName; }
    public StringProperty genderProperty() { return gender; }
    public StringProperty emailProperty() { return email; }
    public IntegerProperty phoneProperty() { return phone; }
    public StringProperty countryProperty() { return country; }
    public StringProperty cityProperty() { return city; }
    public StringProperty streetProperty() { return street; }
    public StringProperty zipCodeProperty() { return zipCode; }
    public StringProperty birthDateProperty() { return birthDate; }
    public DoubleProperty salaryProperty() { return salary; }


    /*
    private IntegerProperty employeeID;
    private StringProperty firstName;
    private StringProperty middleName;
    private StringProperty lastName;
    private StringProperty gender;
    private StringProperty email;
    private IntegerProperty phone;
    private StringProperty country;
    private StringProperty city;
    private StringProperty street;
    private StringProperty zipCode;
    private StringProperty birthDate;
    private IntegerProperty salary;

    public EmployeeTableView(int employeeID, String firstName, String middleName, String lastName, String gender,
                             String email, int phone, String country, String city, String street,
                             String zipCode, String birthDate, int salary) {
        this.employeeID = new SimpleIntegerProperty(employeeID);
        this.firstName = new SimpleStringProperty(firstName);
        this.middleName = new SimpleStringProperty(middleName);
        this.lastName = new SimpleStringProperty(lastName);
        this.gender = new SimpleStringProperty(gender);
        this.email = new SimpleStringProperty(email);
        this.phone = new SimpleIntegerProperty(phone);
        this.country = new SimpleStringProperty(country);
        this.city = new SimpleStringProperty(city);
        this.street = new SimpleStringProperty(street);
        this.zipCode = new SimpleStringProperty(zipCode);
        this.birthDate = new SimpleStringProperty(birthDate);
        this.salary = new SimpleIntegerProperty(salary);
    }

    // Getters and setters
    public IntegerProperty employeeIDProperty() { return employeeID; }
    public StringProperty firstNameProperty() { return firstName; }
    public StringProperty middleNameProperty() { return middleName; }
    public StringProperty lastNameProperty() { return lastName; }
    public StringProperty genderProperty() { return gender; }
    public StringProperty emailProperty() { return email; }
    public IntegerProperty phoneProperty() { return phone; }
    public StringProperty countryProperty() { return country; }
    public StringProperty cityProperty() { return city; }
    public StringProperty streetProperty() { return street; }
    public StringProperty zipCodeProperty() { return zipCode; }
    public StringProperty birthDateProperty() { return birthDate; }
    public IntegerProperty salaryProperty() { return salary; }*/
//    private final IntegerProperty id;
//    private final StringProperty firstName;
//    private final StringProperty secondName;
//    private final StringProperty lastName;
//    private final StringProperty gender;
//    private final IntegerProperty salary;
//    private final StringProperty birthDate;
//    private final StringProperty hireDate;
//    private final StringProperty email;
//    private final StringProperty phone;
//    private final StringProperty country;
//    private final StringProperty city;
//    private final StringProperty street;
//    private final StringProperty zipCode;
//
//    public EmployeeTableView(int id, String firstName, String secondName, String lastName, String gender,
//                             int salary, String birthDate, String hireDate, String email, String phone,
//                             String country, String city, String street, String zipCode) {
//        this.id = new SimpleIntegerProperty(id);
//        this.firstName = new SimpleStringProperty(firstName);
//        this.secondName = new SimpleStringProperty(secondName);
//        this.lastName = new SimpleStringProperty(lastName);
//        this.gender = new SimpleStringProperty(gender);
//        this.salary = new SimpleIntegerProperty(salary);
//        this.birthDate = new SimpleStringProperty(birthDate);
//        this.hireDate = new SimpleStringProperty(hireDate);
//        this.email = new SimpleStringProperty(email);
//        this.phone = new SimpleStringProperty(phone);
//        this.country = new SimpleStringProperty(country);
//        this.city = new SimpleStringProperty(city);
//        this.street = new SimpleStringProperty(street);
//        this.zipCode = new SimpleStringProperty(zipCode);
//    }
//
//    public int getId() { return id.get(); }
//    public IntegerProperty idProperty() { return id; }
//
//    public String getFirstName() { return firstName.get(); }
//    public StringProperty firstNameProperty() { return firstName; }
//
//    public String getSecondName() { return secondName.get(); }
//    public StringProperty secondNameProperty() { return secondName; }
//
//    public String getLastName() { return lastName.get(); }
//    public StringProperty lastNameProperty() { return lastName; }
//
//    public String getGender() { return gender.get(); }
//    public StringProperty genderProperty() { return gender; }
//
//    public int getSalary() { return salary.get(); }
//    public IntegerProperty salaryProperty() { return salary; }
//
//    public String getBirthDate() { return birthDate.get(); }
//    public StringProperty birthDateProperty() { return birthDate; }
//
//    public String getHireDate() { return hireDate.get(); }
//    public StringProperty hireDateProperty() { return hireDate; }
//
//    public String getEmail() { return email.get(); }
//    public StringProperty emailProperty() { return email; }
//
//    public String getPhone() { return phone.get(); }
//    public StringProperty phoneProperty() { return phone; }
//
//    public String getCountry() { return country.get(); }
//    public StringProperty countryProperty() { return country; }
//
//    public String getCity() { return city.get(); }
//    public StringProperty cityProperty() { return city; }
//
//    public String getStreet() { return street.get(); }
//    public StringProperty streetProperty() { return street; }
//
//    public String getZipCode() { return zipCode.get(); }
//    public StringProperty zipCodeProperty() { return zipCode; }
}
