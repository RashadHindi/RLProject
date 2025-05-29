package org.example.rlproject;

public class Employee {
    private int employeeID;
    private String firstName;
    private String middleName;
    private String lastName;
    private String gender;
    private String email;
    private int phone;
    private String country;
    private String city;
    private String street;
    private String zipCode;
    private String birthDate;
    private double salary;

    // Constructor
    public Employee(int employeeID, String firstName, String middleName, String lastName,
                    String gender, String email, int phone, String country,
                    String city, String street, String zipCode, String birthDate, double salary) {
        this.employeeID = employeeID;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.country = country;
        this.city = city;
        this.street = street;
        this.zipCode = zipCode;
        this.birthDate = birthDate;
        this.salary = salary;
    }

    // Getters
    public int getEmployeeID() {
        return employeeID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public int getPhone() {
        return phone;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public double getSalary() {
        return salary;
    }
}
