package org.example.rlproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class AdminController {

    @FXML
    private Button SearchEmployee;

    @FXML
    private Button ViewAllEmployee;

    @FXML
    private TextField EmployeeSearchBar;

    @FXML
    private TextField EmployeeIDSearch;

    @FXML
    private TextField EmployeeFirstNameSearch;

    @FXML
    private TextField EmployeeMiddleNameSearch;

    @FXML
    private TextField EmployeeLastNameSearch;

    @FXML
    private TextField EmployeeBirthDateSearch;

    @FXML
    private TextField EmployeeEmailSearch;

    @FXML
    private TextField EmployeePhoneSearch;

    @FXML
    private TextField EmployeeSalarySearch;

    @FXML
    private TextField EmployeeCountrySearch;

    @FXML
    private TextField EmployeeCitySearch;

    @FXML
    private TextField EmployeeStreetSearch;

    @FXML
    private TextField EmployeeZipCodeSearch;

    @FXML
    private TextField EmployeeGenderSearch;


    @FXML
    private Button AddAdmin;

    @FXML
    private Button ClearEmployeeSearch;

    @FXML
    private Button DeleteEmployeeSearch;

    @FXML
    private Button UpdateEmployeeSearch;

    @FXML
    private Button ClearAdminFields;

    @FXML
    private AnchorPane AddAdminAnchor;

    @FXML
    private Button AddEmployee;

    @FXML
    private AnchorPane AddEmployeeAnchor;

    @FXML
    private Button AddItem;

    @FXML
    private AnchorPane AddItemAnchor;

    @FXML
    private Button AddSupplier;

    @FXML
    private AnchorPane AddSupplierAnchor;

    @FXML
    private TextField AdminIDField;

    @FXML
    private Label AdminUserName;

    @FXML
    private DatePicker Birthdate;

    @FXML
    private DatePicker BirthdateAdmin;

    @FXML
    private TextField City;

    @FXML
    private TextField CityAdmin;

    @FXML
    private TextField SupplierFirstNameField;

    @FXML
    private TextField SupplierLastNameField;

    @FXML
    private TextField CityField;

    @FXML
    private TextField Country;

    @FXML
    private TextField CountryAdmin;

    @FXML
    private TextField CountryField;

    @FXML
    private TextField EmailAdminField;

    @FXML
    private TextField IDSupplierField;

    @FXML
    private TextField PhoneSupplierField;


    @FXML
    private TextField EmailField;

    @FXML
    private TextField EmployeeIDField;

    @FXML
    private RadioButton Female;

    @FXML
    private RadioButton FemaleAdmin;

    @FXML
    private TextField FirstNameAdminField;

    @FXML
    private TextField FirstNameField;

    @FXML
    private Button Home;

    @FXML
    private Button Home1;

    @FXML
    private AnchorPane HomeAnchore;

    @FXML
    private TextField ItemIDField;

    @FXML
    private TextField ItemNameFIeld;

    @FXML
    private TextField LastNameAdminField;

    @FXML
    private TextField LastNameField;

    @FXML
    private Button Logout;

    @FXML
    private RadioButton Male;

    @FXML
    private RadioButton MaleAdmin;

    @FXML
    private TextField MiddleNameAdminField;

    @FXML
    private TextField MiddleNameField;

    @FXML
    private TextField ModelField;

    @FXML
    private Label NumberOfCustomer;

    @FXML
    private Label NumberOfEmployees;

    @FXML
    private Label NumberOfItems;

    @FXML
    private Label NumberOfOrders;

    @FXML
    private Label NumberOfSuppliers;

    @FXML
    private TextField PhoneAdminField;

    @FXML
    private TextField PhoneField;

    @FXML
    private TextField PriceField;

    @FXML
    private TextField QuantityField;

    @FXML
    private TextField Salary;

    @FXML
    private TextField SalaryAdmin;

    @FXML
    private Button SaveEmployee;

    @FXML
    private Button SaveEmployee1;

    @FXML
    private Button SaveItem;

    @FXML
    private Button SaveSupplier;

    @FXML
    private TextField Street;

    @FXML
    private TextField StreetAdmin;

    @FXML
    private TextField StreetField;

    @FXML
    private TextField SupplierIDField;

    @FXML
    private TextField SupplierNameField;

    @FXML
    private TextField UserIDAdminField;

    @FXML
    private TextField UserIDField;

    @FXML
    private TextField EmailSupplierField;

    @FXML
    private Button ViewEmployee;

    @FXML
    private AnchorPane ViewEmployeeAnchor;

    @FXML
    private Button ViewItem;

    @FXML
    private AnchorPane ViewItemAnchor;

    @FXML
    private Button ViewSupplier;

    @FXML
    private Button SaveAdmin;

    @FXML
    private AnchorPane ViewSupplierAnchor;

    @FXML
    private TextField ZipCode;

    @FXML
    private TextField ZipCodeAdmin;

    @FXML
    private TextField ZipCodeFIeld;

    @FXML
    public void initialize() {
        hideAllAnchors();
        //*********************************************//
        HomeAnchore.setVisible(true);
        //*****************************************//
        updateHomeLabels();
        //****************************************//
        EmployeeSearchList.getItems().addAll(
                "EmployeeID",
                "FirstName",
                "MiddleName",
                "LastName",
                "Gender",
                "Email",
                "Phone",
                "Country",
                "City",
                "Street",
                "ZipCode",
                "BirthDate",
                "Salary"
        );
        //*******************************************************************//
        SupplierSearchCombo.getItems().addAll(
                "SupplierID",
                "FirstName",
                "LastName",
                "Email",
                "Phone",
                "Country",
                "City",
                "Street",
                "ZipCode"
        );
        //****************************************************************************************//
        SearchItemCombo.getItems().addAll(
                "ItemID",
                "Item Name",
                "Price",
                "Model"
        );


        //**************************************************************************************************************//
        /*
        ViewEmployeeIDColumn.setCellValueFactory(cellData -> cellData.getValue().employeeIDProperty().asObject());
        ViewEmployeeFNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        ViewEmployeeMNameColumn.setCellValueFactory(cellData -> cellData.getValue().middleNameProperty());
        ViewEmployeeLNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
        ViewEmployeeGenderColumn.setCellValueFactory(cellData -> cellData.getValue().genderProperty());
        ViewEmployeeEmailColumn.setCellValueFactory(cellData -> cellData.getValue().emailProperty());
        ViewPEmployeePhoneColumn.setCellValueFactory(cellData -> cellData.getValue().phoneProperty().asObject());
        ViewEmployeeCountryColumn.setCellValueFactory(cellData -> cellData.getValue().countryProperty());
        ViewEmployeeCityColumn.setCellValueFactory(cellData -> cellData.getValue().cityProperty());
        ViewEmployeeStreetColumn.setCellValueFactory(cellData -> cellData.getValue().streetProperty());
        ViewEmployeeZipCodeColumn.setCellValueFactory(cellData -> cellData.getValue().zipCodeProperty());
        ViewEmployeeBirthDateColumn.setCellValueFactory(cellData -> cellData.getValue().birthDateProperty());
        ViewEmployeeSalaryColumn.setCellValueFactory(cellData -> cellData.getValue().salaryProperty().asObject());*/
        ViewEmployeeIDColumn.setCellValueFactory(cellData -> cellData.getValue().employeeIDProperty().asObject());
        ViewEmployeeFNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        ViewEmployeeMNameColumn.setCellValueFactory(cellData -> cellData.getValue().middleNameProperty());
        ViewEmployeeLNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
        ViewEmployeeGenderColumn.setCellValueFactory(cellData -> cellData.getValue().genderProperty());
        ViewEmployeeEmailColumn.setCellValueFactory(cellData -> cellData.getValue().emailProperty());
        ViewPEmployeePhoneColumn.setCellValueFactory(cellData -> cellData.getValue().phoneProperty().asObject());
        ViewEmployeeCountryColumn.setCellValueFactory(cellData -> cellData.getValue().countryProperty());
        ViewEmployeeCityColumn.setCellValueFactory(cellData -> cellData.getValue().cityProperty());
        ViewEmployeeStreetColumn.setCellValueFactory(cellData -> cellData.getValue().streetProperty());
        ViewEmployeeZipCodeColumn.setCellValueFactory(cellData -> cellData.getValue().zipCodeProperty());
        ViewEmployeeBirthDateColumn.setCellValueFactory(cellData -> cellData.getValue().birthDateProperty());
        ViewEmployeeSalaryColumn.setCellValueFactory(cellData -> cellData.getValue().salaryProperty().asObject());
        //************************************************************************************************************//
        SupplierIDColumn.setCellValueFactory(cellData -> cellData.getValue().supplierIDProperty().asObject());
        SupplierFirstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        SupplierLastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
        SupplierEmailColumn.setCellValueFactory(cellData -> cellData.getValue().emailProperty());
        SupplierPhoneColumn.setCellValueFactory(cellData -> cellData.getValue().phoneProperty().asObject());
        SupplierCountryColumn.setCellValueFactory(cellData -> cellData.getValue().countryProperty());
        SupplierCityColumn.setCellValueFactory(cellData -> cellData.getValue().cityProperty());
        SupplierStreetColumn.setCellValueFactory(cellData -> cellData.getValue().streetProperty());
        SupplierZipCodeColumn.setCellValueFactory(cellData -> cellData.getValue().zipCodeProperty());
        //**************************************************************************************************************//
        ItemIDColumn.setCellValueFactory(cellData -> cellData.getValue().itemIDProperty().asObject());
        ItemNameColumn.setCellValueFactory(cellData -> cellData.getValue().itemNameProperty());
        ItemModelColumn.setCellValueFactory(cellData -> cellData.getValue().itemModelProperty());
        ItemStockQuantityColumn.setCellValueFactory(cellData -> cellData.getValue().stockQuantityProperty().asObject());
        ItemPriceColumn.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asObject());
        ItemSupplierIDColumn.setCellValueFactory(cellData -> cellData.getValue().supplierIDProperty().asObject());
        //***********************************************************************************************************//
        EmployeeTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) { // Check if a row is selected
                populateFields(newValue);
            }
        });

        //******************************************************************************************************//
        SupplierTableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) { // Check if a row is selected
                populateSupplierFields(newValue); // Populate the fields with the selected supplier's data
            }
        });

        //***********************************************************************************************************//
        ItemTableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) { // Check if a row is selected
                populateItemFields(newValue); // Populate the fields with the selected item's data
            }
        });



    }

//********************************************************************************//
    @FXML
    void AddAdminButton(ActionEvent event) {
        hideAllAnchors();
        AddAdminAnchor.setVisible(true);
    }
//***********************************************************************************//
    @FXML
    void DeleteEmployeeSearchButton(ActionEvent event) {
        String employeeIDStr = EmployeeIDSearch.getText();  // Retrieve the employee ID from the search field
        System.out.println("Employee ID to delete: " + employeeIDStr); // Debug statement

        // Check if the employee ID field is empty
        if (employeeIDStr == null || employeeIDStr.isEmpty()) {
            System.out.println("Error: Employee ID is required to delete.");
            showAlert("Error", "Employee ID is required to delete.");
            return;
        }

        // Convert employee ID to an integer
        int employeeID;
        try {
            employeeID = Integer.parseInt(employeeIDStr);
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid Employee ID format.");
            showAlert("Error", "Invalid Employee ID format.");
            return;
        }

        Connection connection = null;
        try {
            // Establish a database connection
            connection = DatabaseConnectionManager.getConnection();
            System.out.println("Database connection established."); // Debug statement

            // Start a transaction
            connection.setAutoCommit(false);
            System.out.println("Transaction started."); // Debug statement

            // Step 1: Delete related orders from the "Order" table
            String deleteOrdersQuery = "DELETE FROM \"Order\" WHERE employee_id = ?";
            try (PreparedStatement deleteOrdersStmt = connection.prepareStatement(deleteOrdersQuery)) {
                deleteOrdersStmt.setInt(1, employeeID); // Use setInt to pass the integer value
                int ordersDeleted = deleteOrdersStmt.executeUpdate();
                System.out.println("Orders deleted: " + ordersDeleted); // Debug statement
            } catch (SQLException e) {
                System.out.println("Error deleting orders: " + e.getMessage()); // Debug statement
            }

            // Step 2: Delete the employee from the "Employee" table
            String deleteEmployeeQuery = "DELETE FROM Employee WHERE employee_id = ?";
            try (PreparedStatement deleteEmployeeStmt = connection.prepareStatement(deleteEmployeeQuery)) {
                deleteEmployeeStmt.setInt(1, employeeID); // Use setInt to pass the integer value
                int rowsAffected = deleteEmployeeStmt.executeUpdate();
                System.out.println("Employee rows deleted: " + rowsAffected); // Debug statement

                if (rowsAffected > 0) {
                    showAlert("Success", "Employee deleted successfully.");
                } else {
                    System.out.println("Employee not found or could not be deleted."); // Debug statement
                    showAlert("Error", "Employee not found or could not be deleted.");
                }
            } catch (SQLException e) {
                System.out.println("Error deleting employee: " + e.getMessage()); // Debug statement
            }

            // Commit the transaction if all deletions are successful
            connection.commit();
            System.out.println("Transaction committed."); // Debug statement

            // Clear the search fields
            ClearEmployeeSearchButton();

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage()); // Debug statement
            showAlert("Database Error", "An error occurred while deleting the employee.");

            try {
                if (connection != null) {
                    connection.rollback();  // Rollback in case of error
                    System.out.println("Transaction rolled back."); // Debug statement
                }
            } catch (SQLException rollbackEx) {
                System.out.println("Error during rollback: " + rollbackEx.getMessage()); // Debug statement
            }

        } finally {
            if (connection != null) {
                try {
                    connection.setAutoCommit(true);
                    connection.close();
                    System.out.println("Database connection closed."); // Debug statement
                } catch (SQLException closeEx) {
                    System.out.println("Error closing connection: " + closeEx.getMessage()); // Debug statement
                }
            }
        }

    }

    @FXML
    void UpdateEmployeeSearchButton(ActionEvent event) {
        String employeeIDStr = EmployeeIDSearch.getText(); // Get the employee ID from the search field
        String firstName = EmployeeFirstNameSearch.getText();
        String middleName = EmployeeMiddleNameSearch.getText();
        String lastName = EmployeeLastNameSearch.getText();
        String gender = EmployeeGenderSearch.getText();  // Gender input as string
        String email = EmployeeEmailSearch.getText();
        String phoneStr = EmployeePhoneSearch.getText();
        String country = EmployeeCountrySearch.getText();
        String city = EmployeeCitySearch.getText();
        String street = EmployeeStreetSearch.getText();
        String zipCode = EmployeeZipCodeSearch.getText();
        String birthDateStr = EmployeeBirthDateSearch.getText(); // Birthdate as string
        String salaryStr = EmployeeSalarySearch.getText();

        // Check if the EmployeeIDSearch is not empty and is a valid number
        if (employeeIDStr == null || employeeIDStr.isEmpty()) {
            System.out.println("Error: Employee ID is required to update.");
            showAlert("Error", "Employee ID is required to update.");
            return;
        }

        // Validate if employee_id is a number (to ensure it's a valid primary key)
        int employeeID;
        try {
            employeeID = Integer.parseInt(employeeIDStr);
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid Employee ID format.");
            showAlert("Error", "Invalid Employee ID format.");
            return;
        }

        // Validate phone and salary fields
        int phone = 0;
        double salary = 0;
        try {
            if (!phoneStr.isEmpty()) {
                phone = Integer.parseInt(phoneStr);
            }
            if (!salaryStr.isEmpty()) {
                salary = Double.parseDouble(salaryStr);
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid phone or salary format.");
            showAlert("Error", "Invalid phone or salary format.");
            return;
        }

        // Convert birthDate to java.sql.Date
        Date birthDate = null;
        try {
            if (birthDateStr != null && !birthDateStr.isEmpty()) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // Adjust date format to match input format
                java.util.Date parsedDate = sdf.parse(birthDateStr);
                birthDate = new Date(parsedDate.getTime());
            }
        } catch (Exception e) {
            System.out.println("Error: Invalid birth date format.");
            showAlert("Error", "Invalid birth date format.");
            return;
        }

        Connection connection = null;
        try {
            connection = DatabaseConnectionManager.getConnection(); // Get the database connection
            System.out.println("Database connection established."); // Debug statement

            // Prepare the SQL query to update the employee details
            // Cast gender to match gender_type in the database
            String updateQuery = "UPDATE Employee SET first_name = ?, middle_name = ?, last_name = ?, gender = CAST(? AS gender_type), " +
                    "email = ?, phone = ?, country = ?, city = ?, street = ?, zip_code = ?, birth_date = ?, " +
                    "salary = ? WHERE employee_id = ?";

            // Start the transaction
            connection.setAutoCommit(false);
            System.out.println("Transaction started."); // Debug statement

            try (PreparedStatement stmt = connection.prepareStatement(updateQuery)) {
                // Set the parameters for the query
                stmt.setString(1, firstName);
                stmt.setString(2, middleName);
                stmt.setString(3, lastName);
                stmt.setString(4, gender);  // Set gender as string and cast in SQL
                stmt.setString(5, email);
                stmt.setInt(6, phone); // Set phone as integer
                stmt.setString(7, country);
                stmt.setString(8, city);
                stmt.setString(9, street);
                stmt.setString(10, zipCode);
                stmt.setDate(11, birthDate);  // Set birth_date as java.sql.Date
                stmt.setDouble(12, salary); // Set salary as double
                stmt.setInt(13, employeeID); // Set employee ID as integer

                // Execute the update query
                int rowsAffected = stmt.executeUpdate();
                System.out.println("Rows updated: " + rowsAffected); // Debug statement

                if (rowsAffected > 0) {
                    System.out.println("Employee updated successfully.");
                    showAlert("Success", "Employee details updated successfully.");
                } else {
                    System.out.println("Error: Employee not found.");
                    showAlert("Error", "Employee not found.");
                }

                // Commit the transaction if successful
                connection.commit();
                System.out.println("Transaction committed."); // Debug statement

            } catch (SQLException e) {
                System.out.println("Error updating employee: " + e.getMessage()); // Debug statement
                connection.rollback();  // Rollback the transaction if an error occurs
                System.out.println("Transaction rolled back."); // Debug statement
                showAlert("Error", "An error occurred while updating the employee.");
            }

        } catch (SQLException e) {
            System.out.println("Database connection error: " + e.getMessage()); // Debug statement
            showAlert("Database Error", "An error occurred while connecting to the database.");
        } finally {
            try {
                if (connection != null) {
                    connection.setAutoCommit(true); // Restore auto-commit
                    connection.close(); // Close the database connection
                    System.out.println("Database connection closed."); // Debug statement
                }
            } catch (SQLException e) {
                System.out.println("Error closing database connection: " + e.getMessage()); // Debug statement
            }
        }
    }

    @FXML
    private ComboBox<String> EmployeeSearchList;

    @FXML
    private TableView<EmployeeTableView> EmployeeTable;

    @FXML
    private TableColumn<EmployeeTableView, String> ViewEmployeeFNameColumn;

    @FXML
    private TableColumn<EmployeeTableView, Integer> ViewEmployeeIDColumn;

    @FXML
    private TableColumn<EmployeeTableView, String> ViewEmployeeMNameColumn;

    @FXML
    private TableColumn<EmployeeTableView, String> ViewEmployeeLNameColumn;

    @FXML
    private TableColumn<EmployeeTableView, String> ViewEmployeeGenderColumn;

    @FXML
    private TableColumn<EmployeeTableView, String> ViewEmployeeEmailColumn;

    @FXML
    private TableColumn<EmployeeTableView, Integer> ViewPEmployeePhoneColumn;

    @FXML
    private TableColumn<EmployeeTableView, String> ViewEmployeeCountryColumn;

    @FXML
    private TableColumn<EmployeeTableView, String> ViewEmployeeCityColumn;

    @FXML
    private TableColumn<EmployeeTableView, String> ViewEmployeeStreetColumn;

    @FXML
    private TableColumn<EmployeeTableView, String> ViewEmployeeZipCodeColumn;

    @FXML
    private TableColumn<EmployeeTableView, String> ViewEmployeeBirthDateColumn;

    @FXML
    private TableColumn<EmployeeTableView, Double> ViewEmployeeSalaryColumn;


//***************************************************************************************************************//
    @FXML
    void SearchEmployeeButton(ActionEvent event) {
        EmployeeTable.getItems().clear();

        // Get the selected criteria and search input
        String searchCriteria = EmployeeSearchList.getValue();
        String searchField = EmployeeSearchBar.getText().trim();

        if (searchCriteria == null || searchField.isEmpty()) {
            System.out.println("Search criteria not selected or search field is empty.");
            return;
        }

        ObservableList<EmployeeTableView> searchResults = FXCollections.observableArrayList();

        // Build the SQL query based on the selected criteria
        String query = buildSearchQuery(searchCriteria, searchField);
        System.out.println("Executing query: " + query);

        try (Connection conn = DatabaseConnectionManager.getConnection();
             PreparedStatement statement = conn.prepareStatement(query)) {

            // Print the search field for debugging
            System.out.println("Searching for: " + searchField); // Added for debugging

            // Set the parameter based on search criteria
            if ("EmployeeID".equals(searchCriteria)) {
                statement.setInt(1, Integer.parseInt(searchField));
            } else if ("Phone".equals(searchCriteria)) {
                statement.setInt(1, Integer.parseInt(searchField));
            } else if ("Salary".equals(searchCriteria)) {
                statement.setDouble(1, Double.parseDouble(searchField)); // Salary as double
            } else if ("BirthDate".equals(searchCriteria)) {
                // Validate the date format and convert to java.sql.Date
                java.sql.Date sqlDate = validateAndConvertDate(searchField);
                if (sqlDate == null) {
                    System.out.println("Invalid date format. Please use YYYY-MM-DD.");
                    return; // Early exit if the date is invalid
                }
                statement.setDate(1, sqlDate); // Set the valid date
                System.out.println("Searching for birth date: " + sqlDate); // Add for debugging
            } else {
                statement.setString(1, "%" + searchField + "%"); // Use '%' for ILIKE to enable substring search
            }

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                EmployeeTableView employee = new EmployeeTableView(
                        resultSet.getInt("employee_id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("middle_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("gender"),
                        resultSet.getString("email"),
                        resultSet.getInt("phone"),
                        resultSet.getString("country"),
                        resultSet.getString("city"),
                        resultSet.getString("street"),
                        resultSet.getString("zip_code"),
                        resultSet.getDate("birth_date").toString(),
                        resultSet.getDouble("salary")
                );
                searchResults.add(employee);
            }

            if (searchResults.isEmpty()) {
                System.out.println("No results found for the search criteria.");
            } else {
                EmployeeTable.setItems(searchResults);
            }

        } catch (SQLException e) {
            System.out.println("An error occurred while searching for employees: " + e.getMessage());
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Invalid input for Employee ID, Phone, or Salary: " + e.getMessage());
        }


    }

    private Date validateAndConvertDate(String dateString) {
        String regex = "\\d{4}-\\d{2}-\\d{2}"; // Regex for YYYY-MM-DD format
        if (!dateString.matches(regex)) {
            return null; // Invalid format
        }

        // Try to parse the date
        try {
            java.util.Date utilDate = new java.text.SimpleDateFormat("yyyy-MM-dd").parse(dateString);
            return new java.sql.Date(utilDate.getTime());
        } catch (java.text.ParseException e) {
            System.out.println("Date parsing error: " + e.getMessage());
            return null; // Parsing failed
        }
    }

    private void printExistingBirthDates() {
        try (Connection conn = DatabaseConnectionManager.getConnection();
             PreparedStatement statement = conn.prepareStatement("SELECT birth_date FROM Employee")) {

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                System.out.println("Birth Date: " + resultSet.getDate("birth_date"));
            }
        } catch (SQLException e) {
            System.out.println("An error occurred while retrieving employees: " + e.getMessage());
        }
    }

    private String buildSearchQuery(String searchCriteria, String searchField) {
        String query = "SELECT employee_id, first_name, middle_name, last_name, gender, email, phone, " +
                "country, city, street, zip_code, birth_date, salary FROM Employee WHERE ";

        switch (searchCriteria) {
            case "EmployeeID":
                query += "employee_id = ?"; // Placeholder for ID
                break;
            case "FirstName":
                query += "first_name ILIKE ?"; // Case-insensitive search
                break;
            case "MiddleName":
                query += "middle_name ILIKE ?";
                break;
            case "LastName":
                query += "last_name ILIKE ?";
                break;
            case "Gender":
                query += "gender::text ILIKE ?"; // Explicitly cast to text
                break;
            case "Email":
                query += "email ILIKE ?";
                break;
            case "Phone":
                query += "phone = ?"; // Use '=' instead of 'ILIKE'
                break;
            case "Country":
                query += "country ILIKE ?";
                break;
            case "City":
                query += "city ILIKE ?";
                break;
            case "Street":
                query += "street ILIKE ?";
                break;
            case "ZipCode":
                query += "zip_code ILIKE ?";
                break;
            case "BirthDate":
                query += "DATE(birth_date) = ?"; // Ensure you are comparing as DATE
                break;
            case "Salary":
                query += "salary = ?";
                break;
            default:
                throw new IllegalArgumentException("Invalid search criteria");
        }

        return query;

    }


    private void populateFields(EmployeeTableView employee) {
        EmployeeIDSearch.setText(String.valueOf(employee.employeeIDProperty().get()));
        EmployeeFirstNameSearch.setText(employee.firstNameProperty().get());
        EmployeeMiddleNameSearch.setText(employee.middleNameProperty().get());
        EmployeeLastNameSearch.setText(employee.lastNameProperty().get());
        EmployeeGenderSearch.setText(employee.genderProperty().get());
        EmployeeEmailSearch.setText(employee.emailProperty().get());
        EmployeePhoneSearch.setText(String.valueOf(employee.phoneProperty().get()));
        EmployeeCountrySearch.setText(employee.countryProperty().get());
        EmployeeCitySearch.setText(employee.cityProperty().get());
        EmployeeStreetSearch.setText(employee.streetProperty().get());
        EmployeeZipCodeSearch.setText(employee.zipCodeProperty().get());
        EmployeeBirthDateSearch.setText(employee.birthDateProperty().get());
        EmployeeSalarySearch.setText(String.valueOf(employee.salaryProperty().get()));
    }


    @FXML
    void ViewAllEmployeeButton(ActionEvent event) {
        ObservableList<EmployeeTableView> employeeList = FXCollections.observableArrayList();

        try (Connection conn = DatabaseConnectionManager.getConnection()) {
            String query = "SELECT employee_id, first_name, middle_name, last_name, gender, email, phone, " +
                    "country, city, street, zip_code, birth_date, salary FROM Employee";
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            // Populate employeeList with EmployeeTableView objects
            while (resultSet.next()) {
                EmployeeTableView employee = new EmployeeTableView(
                        resultSet.getInt("employee_id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("middle_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("gender"),
                        resultSet.getString("email"),
                        resultSet.getInt("phone"),
                        resultSet.getString("country"),
                        resultSet.getString("city"),
                        resultSet.getString("street"),
                        resultSet.getString("zip_code"),
                        resultSet.getString("birth_date"),
                        resultSet.getInt("salary")
                );
                employeeList.add(employee);
            }

            // Set items in the EmployeeTable
            EmployeeTable.setItems(employeeList);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void ClearEmployeeSearchButton() {
        EmployeeIDSearch.clear();
        EmployeeFirstNameSearch.clear();
        EmployeeMiddleNameSearch.clear();
        EmployeeLastNameSearch.clear();
        EmployeeGenderSearch.clear();
        EmployeeEmailSearch.clear();
        EmployeePhoneSearch.clear();
        EmployeeCountrySearch.clear();
        EmployeeCitySearch.clear();
        EmployeeStreetSearch.clear();
        EmployeeZipCodeSearch.clear();
        EmployeeBirthDateSearch.clear();
        EmployeeSalarySearch.clear();
    }

//*******************************************************************************************************************//


    @FXML
    void AddEmployee(ActionEvent event) {
        hideAllAnchors();
        AddEmployeeAnchor.setVisible(true);

    }

    @FXML
    void AddItemButton(ActionEvent event) {

        hideAllAnchors();
        AddItemAnchor.setVisible(true);

    }

    @FXML
    void AddSupplierButton(ActionEvent event) {
        hideAllAnchors();
        AddSupplierAnchor.setVisible(true);

    }

    public void setAdminUsername(String username) {
        AdminUserName.setText(username); // Update the label with the username
    }

    @FXML
    void HomeButton(ActionEvent event) {
        hideAllAnchors();
        HomeAnchore.setVisible(true);
        updateHomeLabels();
    }

    private void hideAllAnchors() {
        AddAdminAnchor.setVisible(false);
        AddEmployeeAnchor.setVisible(false);
        AddItemAnchor.setVisible(false);
        AddSupplierAnchor.setVisible(false);
        HomeAnchore.setVisible(false);
        ViewEmployeeAnchor.setVisible(false);
        ViewItemAnchor.setVisible(false);
        ViewSupplierAnchor.setVisible(false);
    }

    private void updateHomeLabels() {
        //System.out.println("Updating Home Labels...");
        try (Connection conn = DatabaseConnectionManager.getConnection();
             Statement stmt = conn.createStatement()) {

            ResultSet rsOrders = stmt.executeQuery("SELECT COUNT(Order_id) FROM \"Order\"");
            if (rsOrders.next()) {
                int orderCount = rsOrders.getInt(1);
                //System.out.println("Order count: " + orderCount);
            NumberOfOrders.setText(String.valueOf(orderCount));
        }

            ResultSet rsSuppliers = stmt.executeQuery("SELECT COUNT(supplier_id) FROM Supplier");
            if (rsSuppliers.next()) {
                int supplierCount = rsSuppliers.getInt(1);
               // System.out.println("Supplier count: " + supplierCount); // Debug
                NumberOfSuppliers.setText(String.valueOf(supplierCount));
            }

            // Fetch and update Customer count
            ResultSet rsCustomers = stmt.executeQuery("SELECT COUNT(Customer_id) FROM Customer");
            if (rsCustomers.next()) {
                int customerCount = rsCustomers.getInt(1);
                //System.out.println("Customer count: " + customerCount); // Debug
                NumberOfCustomer.setText(String.valueOf(customerCount));
            }

            ResultSet rsEmployees = stmt.executeQuery("SELECT COUNT(Employee_id) FROM Employee");
            if (rsEmployees.next()) {
                int employeeCount = rsEmployees.getInt(1);
                //System.out.println("Employee count: " + employeeCount); // Debug
                NumberOfEmployees.setText(String.valueOf(employeeCount));
            }

            ResultSet rsItems = stmt.executeQuery("SELECT COUNT(Item_id) FROM Item");
            if (rsItems.next()) {
                int itemCount = rsItems.getInt(1);
                //System.out.println("Item count: " + itemCount); // Debug
                NumberOfItems.setText(String.valueOf(itemCount));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void LogoutButton(ActionEvent event) {
        try {
            // Load the Welcome.fxml file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/rlproject/Welcome.fxml"));
            Parent welcomeRoot = loader.load();

            // Get the current stage (window)
            Stage stage = (Stage) Logout.getScene().getWindow();

            // Set the scene to Welcome.fxml
            stage.setScene(new Scene(welcomeRoot));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Error", "Unable to load the welcome page.");
        }

    }

    @FXML
    void SaveAdminButton(ActionEvent event) {
        String firstName = FirstNameAdminField.getText().trim();
        String middleName = MiddleNameAdminField.getText().trim();
        String lastName = LastNameAdminField.getText().trim();
        String email = EmailAdminField.getText().trim();
        String country = CountryAdmin.getText().trim();
        String city = CityAdmin.getText().trim();
        String street = StreetAdmin.getText().trim();
        LocalDate birthdate = BirthdateAdmin.getValue();
        String gender = MaleAdmin.isSelected() ? "Male" : "Female";

        // Parse integer fields and validate
        int userID, adminID, phone, zipCode;
        double salary;
        try {
            userID = Integer.parseInt(UserIDAdminField.getText().trim());
            adminID = Integer.parseInt(AdminIDField.getText().trim());
            phone = Integer.parseInt(PhoneAdminField.getText().trim());
            zipCode = Integer.parseInt(ZipCodeAdmin.getText().trim());
            salary = Double.parseDouble(SalaryAdmin.getText().trim());
        } catch (NumberFormatException e) {
            showAlert("Error", "User ID, Admin ID, Phone, Zip Code, and Salary must be numeric.");
            return;
        }

        // Check if any required fields are empty
        if (firstName.isEmpty() || middleName.isEmpty() || lastName.isEmpty() || email.isEmpty() ||
                birthdate == null || country.isEmpty() || city.isEmpty() || street.isEmpty()) {
            showAlert("Error", "Please fill in all fields before saving the admin.");
            return;
        }

        try (Connection conn = DatabaseConnectionManager.getConnection()) {

            PreparedStatement checkAdminIDStmt = conn.prepareStatement(
                    "SELECT COUNT(*) FROM Employee WHERE employee_id = ?");
            checkAdminIDStmt.setInt(1, adminID);
            ResultSet rsAdminID = checkAdminIDStmt.executeQuery();
            if (rsAdminID.next() && rsAdminID.getInt(1) > 0) {
                showAlert("Error", "Admin ID already exists. Please enter a unique Admin ID.");
                return;
            }

            // Check if User ID is unique
            PreparedStatement checkUserIDStmt = conn.prepareStatement(
                    "SELECT COUNT(*) FROM Employee WHERE user_id = ?");
            checkUserIDStmt.setInt(1, userID);
            ResultSet rsUserID = checkUserIDStmt.executeQuery();
            if (rsUserID.next() && rsUserID.getInt(1) > 0) {
                showAlert("Error", "User ID already exists. Please enter a unique User ID.");
                return;
            }

            // Insert admin data into the database
            PreparedStatement saveAdminStmt = conn.prepareStatement(
                    "INSERT INTO Employee (employee_id, first_name, middle_name, last_name, gender, salary, birth_date, " +
                            "email, phone, country, city, street, zip_code, user_id) VALUES (?, ?, ?, ?, ?::gender_type, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            saveAdminStmt.setInt(1, adminID);
            saveAdminStmt.setString(2, firstName);
            saveAdminStmt.setString(3, middleName);
            saveAdminStmt.setString(4, lastName);
            saveAdminStmt.setString(5, gender);
            saveAdminStmt.setDouble(6, salary);
            saveAdminStmt.setDate(7, Date.valueOf(birthdate));
            saveAdminStmt.setString(8, email);
            saveAdminStmt.setInt(9, phone);
            saveAdminStmt.setString(10, country);
            saveAdminStmt.setString(11, city);
            saveAdminStmt.setString(12, street);
            saveAdminStmt.setInt(13, zipCode);
            saveAdminStmt.setInt(14, userID);

            int rowsAffected = saveAdminStmt.executeUpdate();

            if (rowsAffected > 0) {
                showAlert("Success", "Admin information saved successfully.");
                clearAdminFields();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            showAlert("Database Error", "An error occurred while saving admin information.");
        }


    }

    @FXML
    void SaveEmployeeButton(ActionEvent event) {

        String firstName = FirstNameField.getText().trim();
        String middleName = MiddleNameField.getText().trim();
        String lastName = LastNameField.getText().trim();
        String email = EmailField.getText().trim();
        String country = Country.getText().trim();
        String city = City.getText().trim();
        String street = Street.getText().trim();
        LocalDate birthdate = Birthdate.getValue();
        String gender = Male.isSelected() ? "Male" : "Female";

        int userID, employeeID, phone, zipCode;
        double salary;
        try {
            System.out.println("Parsing integer fields...");
            userID = Integer.parseInt(UserIDField.getText().trim());
            employeeID = Integer.parseInt(EmployeeIDField.getText().trim());
            phone = Integer.parseInt(PhoneField.getText().trim());
            zipCode = Integer.parseInt(ZipCode.getText().trim());
            salary = Double.parseDouble(Salary.getText().trim());
            System.out.println("Parsed fields successfully.");
        } catch (NumberFormatException e) {
            System.out.println("Number format exception occurred.");
            showAlert("Error", "User ID, Employee ID, Phone, Zip Code, and Salary must be numeric.");
            return;
        }

        if (firstName.isEmpty() || middleName.isEmpty() || lastName.isEmpty() || email.isEmpty() ||
                birthdate == null || country.isEmpty() || city.isEmpty() || street.isEmpty()) {
            System.out.println("One or more fields are empty.");
            showAlert("Error", "Please fill in all fields before saving the employee.");
            return;
        }

        try (Connection conn = DatabaseConnectionManager.getConnection()) {
            System.out.println("Database connection established.");

            // Check if Employee ID is unique
            System.out.println("Checking if Employee ID is unique...");
            PreparedStatement checkEmployeeIDStmt = conn.prepareStatement(
                    "SELECT COUNT(*) FROM Employee WHERE employee_id = ?");
            checkEmployeeIDStmt.setInt(1, employeeID);
            ResultSet rsEmployeeID = checkEmployeeIDStmt.executeQuery();
            if (rsEmployeeID.next() && rsEmployeeID.getInt(1) > 0) {
                System.out.println("Employee ID already exists.");
                showAlert("Error", "Employee ID already exists. Please enter a unique Employee ID.");
                return;
            }

            // Check if User ID is unique
            System.out.println("Checking if User ID is unique...");
            PreparedStatement checkUserIDStmt = conn.prepareStatement(
                    "SELECT COUNT(*) FROM Employee WHERE user_id = ?");
            checkUserIDStmt.setInt(1, userID);
            ResultSet rsUserID = checkUserIDStmt.executeQuery();
            if (rsUserID.next() && rsUserID.getInt(1) > 0) {
                System.out.println("User ID already exists.");
                showAlert("Error", "User ID already exists. Please enter a unique User ID.");
                return;
            }

             gender = Male.isSelected() ? "Male" : "Female";

            System.out.println("Inserting employee data into the database...");
            PreparedStatement saveEmployeeStmt = conn.prepareStatement(
                    "INSERT INTO Employee (employee_id, first_name, middle_name, last_name, gender, salary, birth_date, " +
                            "email, phone, country, city, street, zip_code, user_id) VALUES (?, ?, ?, ?, ?::gender_type, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            saveEmployeeStmt.setInt(1, employeeID);
            saveEmployeeStmt.setString(2, firstName);
            saveEmployeeStmt.setString(3, middleName);
            saveEmployeeStmt.setString(4, lastName);
            saveEmployeeStmt.setString(5, gender); // Ensure this is "Male" or "Female"
            saveEmployeeStmt.setDouble(6, salary);
            saveEmployeeStmt.setDate(7, Date.valueOf(birthdate));
            saveEmployeeStmt.setString(8, email);
            saveEmployeeStmt.setInt(9, phone);
            saveEmployeeStmt.setString(10, country);
            saveEmployeeStmt.setString(11, city);
            saveEmployeeStmt.setString(12, street);
            saveEmployeeStmt.setInt(13, zipCode);
            saveEmployeeStmt.setInt(14, userID);

            int rowsAffected = saveEmployeeStmt.executeUpdate();
            System.out.println("Rows affected: " + rowsAffected);

            if (rowsAffected > 0) {
                System.out.println("Employee information saved successfully.");
                showAlert("Success", "Employee information saved successfully.");
                clearEmployeeFields();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQLException: " + e.getMessage());
            showAlert("Database Error", "An error occurred while saving employee information.");
        }
    }
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }



    @FXML
    void SaveItemButton(ActionEvent event) {
        String itemIdText = ItemIDField.getText();
        String itemName = ItemNameFIeld.getText();
        String model = ModelField.getText();
        String quantityText = QuantityField.getText();
        String priceText = PriceField.getText();
        String supplierIdText = SupplierIDField.getText();

        if (itemIdText.isEmpty() || itemName.isEmpty() || model.isEmpty() ||
                quantityText.isEmpty() || priceText.isEmpty() || supplierIdText.isEmpty()) {
            showAlert("Error", "All fields must be filled.");
            return;
        }

        int itemId;
        int stockQuantity;
        int supplierId;
        double price;

        try {
            itemId = Integer.parseInt(itemIdText);
            stockQuantity = Integer.parseInt(quantityText);
            supplierId = Integer.parseInt(supplierIdText);
            price = Double.parseDouble(priceText);
        } catch (NumberFormatException e) {
            // Show error message for invalid number formats
            showAlert("Error", "Please enter valid numeric values for Item ID, Quantity, Price, and Supplier ID.");
            return;
        }

        if (checkItemExists(itemId)) {
            // Show an alert that the item_id already exists
            showAlert("Item ID already exists!");
            return;
        }
        Connection connection = null;
        PreparedStatement itemStatement = null;
        PreparedStatement supplierItemStatement = null;

        try {
            connection = DatabaseConnectionManager.getConnection();

            // Insert into item table
            String insertItemSQL = "INSERT INTO item (item_id, item_name, price, model, stock_quantity) VALUES (?, ?, ?, ?, ?)";
            itemStatement = connection.prepareStatement(insertItemSQL);
            itemStatement.setInt(1, itemId);
            itemStatement.setString(2, itemName);
            itemStatement.setBigDecimal(3, BigDecimal.valueOf(price));
            itemStatement.setString(4, model);
            itemStatement.setInt(5, stockQuantity);
            itemStatement.executeUpdate();

            // Insert into supplier_and_item table
            String insertSupplierItemSQL = "INSERT INTO supplier_and_item (item_id, supplier_id) VALUES (?, ?)";
            supplierItemStatement = connection.prepareStatement(insertSupplierItemSQL);
            supplierItemStatement.setInt(1, itemId);
            supplierItemStatement.setInt(2, supplierId);
            supplierItemStatement.executeUpdate();

            showAlert("Success", "Item saved successfully.");
            clearFields();

        } catch (SQLException e) {
            showAlert("Error", "An error occurred while saving the item: " + e.getMessage());
        } finally {
            // Close resources
            try {
                if (supplierItemStatement != null) supplierItemStatement.close();
                if (itemStatement != null) itemStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace(); // Log error closing resources
            }
        }

    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    void SaveSupplierButton(ActionEvent event) {
        String supplierName = SupplierFirstNameField.getText().trim();
        String supplierLastName = SupplierLastNameField.getText().trim();
        String country = CountryField.getText().trim();
        String city = CityField.getText().trim();
        String street = StreetField.getText().trim();
        String email = EmailSupplierField.getText().trim();
        String zipCode = ZipCodeFIeld.getText().trim();

        int supplierID, phone;
        try {
            String supplierIDInput = IDSupplierField.getText().trim();
            String phoneInput = PhoneSupplierField.getText().trim();

            System.out.println("Supplier ID Input: " + supplierIDInput);
            System.out.println("Phone Input: " + phoneInput);

            if (!supplierIDInput.matches("\\d+") || !phoneInput.matches("\\d+")) {
                showAlert("Error", "Supplier ID and Phone must be numeric.");
                return;
            }

            supplierID = Integer.parseInt(supplierIDInput);
            phone = Integer.parseInt(phoneInput);
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException: " + e.getMessage());
            showAlert("Error", "Supplier ID and Phone must be numeric.");
            return;
        }

        // Check if any required fields are empty
        if (supplierName.isEmpty() || country.isEmpty() || city.isEmpty() || street.isEmpty() || email.isEmpty() || zipCode.isEmpty()) {
            showAlert("Error", "Please fill in all fields before saving the supplier.");
            return;
        }

        try (Connection conn = DatabaseConnectionManager.getConnection()) {
            // Check if Supplier ID is unique
            PreparedStatement checkSupplierIDStmt = conn.prepareStatement(
                    "SELECT COUNT(*) FROM Supplier WHERE supplier_id = ?");
            checkSupplierIDStmt.setInt(1, supplierID);
            ResultSet rsSupplierID = checkSupplierIDStmt.executeQuery();

            if (rsSupplierID.next() && rsSupplierID.getInt(1) > 0) {
                showAlert("Error", "Supplier ID already exists. Please enter a unique Supplier ID.");
                return;
            }

            // Insert supplier data into the database
            PreparedStatement saveSupplierStmt = conn.prepareStatement(
                    "INSERT INTO Supplier (supplier_id, first_name,last_name, phone, email, country, city, street, zip_code) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");

            saveSupplierStmt.setInt(1, supplierID);
            saveSupplierStmt.setString(2, supplierName);
            saveSupplierStmt.setString(3, supplierLastName);
            saveSupplierStmt.setInt(4, phone);
            saveSupplierStmt.setString(5, email);
            saveSupplierStmt.setString(6, country);
            saveSupplierStmt.setString(7, city);
            saveSupplierStmt.setString(8, street);
            saveSupplierStmt.setString(9, zipCode); // zipCode is a string

            // Execute the update and check for success
            int rowsAffected = saveSupplierStmt.executeUpdate();
            if (rowsAffected > 0) {
                showAlert("Success", "Supplier information saved successfully.");
                clearSupplierFields(); // Call method to clear supplier fields after saving
            }
        } catch (SQLException e) {
            e.printStackTrace();
            showAlert("Database Error", "An error occurred while saving supplier information.");
        }

    }
    private boolean checkItemExists(int itemId) {
        String query = "SELECT COUNT(*) FROM item WHERE item_id = ?";
        try (Connection connection = DatabaseConnectionManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, itemId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @FXML
    void ViewEmployeeButton(ActionEvent event) {
        hideAllAnchors();
        ViewEmployeeAnchor.setVisible(true);

    }

    @FXML
    void ViewItemButton(ActionEvent event) {

        hideAllAnchors();
        ViewItemAnchor.setVisible(true);
    }

    @FXML
    void ViewSupplierButton(ActionEvent event) {

        hideAllAnchors();
        ViewSupplierAnchor.setVisible(true);
    }

    public void clearAdminFieldsButton(ActionEvent actionEvent) {
        UserIDField.clear();
        EmployeeIDField.clear();
        FirstNameField.clear();
        MiddleNameField.clear();
        LastNameField.clear();
        EmailField.clear();
        PhoneField.clear();
        Salary.clear();
        Country.clear();
        City.clear();
        Street.clear();
        ZipCode.clear();
        Birthdate.setValue(null);
        Male.setSelected(false);
        Female.setSelected(false);

    }
    private void clearEmployeeFields() {
        UserIDField.clear();
        EmployeeIDField.clear();
        FirstNameField.clear();
        MiddleNameField.clear();
        LastNameField.clear();
        EmailField.clear();
        Male.setSelected(false);
        Female.setSelected(false);
        PhoneField.clear();
        Birthdate.setValue(null);
        Salary.clear();
        CountryField.clear();
        CityField.clear();
        StreetField.clear();
        ZipCode.clear();
    }

    private void clearAdminFields() {
        UserIDAdminField.clear();
        AdminIDField.clear();
        FirstNameAdminField.clear();
        MiddleNameAdminField.clear();
        LastNameAdminField.clear();
        EmailAdminField.clear();
        MaleAdmin.setSelected(false);
        FemaleAdmin.setSelected(false);
        PhoneAdminField.clear();
        BirthdateAdmin.setValue(null);
        SalaryAdmin.clear();
        CountryAdmin.clear();
        CityAdmin.clear();
        StreetAdmin.clear();
        ZipCodeAdmin.clear();
    }

    private void clearSupplierFields() {
        IDSupplierField.clear();
        SupplierLastNameField.clear();
        SupplierFirstNameField.clear();
        EmailSupplierField.clear();
        PhoneSupplierField.clear();
        CountryField.clear();
        CityField.clear();
        StreetField.clear();
        ZipCodeFIeld.clear();
    }

    private void clearFields() {
        ItemIDField.clear();
        ItemNameFIeld.clear();
        ModelField.clear();
        QuantityField.clear();
        PriceField.clear();
        SupplierIDField.clear();
    }

    //********************************************************************************************************//

    @FXML
    private ComboBox<String> SupplierSearchCombo;

    @FXML
    private TextField SupplierSearchField;

    @FXML
    private Button SupplierSearch;

    @FXML
    private Button ViewAllSupplier;

    @FXML
    private TableView<SupplierTableView> SupplierTableView;

    @FXML
    private TableColumn<SupplierTableView, Integer> SupplierIDColumn;

    @FXML
    private TableColumn<SupplierTableView, String> SupplierFirstNameColumn;


    @FXML
    private TableColumn<SupplierTableView, String> SupplierLastNameColumn;


    @FXML
    private TableColumn<SupplierTableView, String> SupplierEmailColumn;

    @FXML
    private TableColumn<SupplierTableView, Integer> SupplierPhoneColumn;

    @FXML
    private TableColumn<SupplierTableView, String> SupplierCountryColumn;

    @FXML
    private TableColumn<SupplierTableView, String> SupplierCityColumn;

    @FXML
    private TableColumn<SupplierTableView, String> SupplierStreetColumn;

    @FXML
    private TableColumn<SupplierTableView, String> SupplierZipCodeColumn;


    @FXML
    private TextField SupplierIDSearch;

    @FXML
    private TextField SupplierFirstNameSearch;

    @FXML
    private TextField SupplierMiddleNameSearch;

    @FXML
    private TextField SupplierLastNameSearch;

    @FXML
    private TextField SupplierEmailSearch;

    @FXML
    private TextField SupplierPhoneSearch;

    @FXML
    private TextField SupplierGenderSearch;

    @FXML
    private TextField SupplierAdressSearch;

    @FXML
    private TextField SupplierCitySearch;

    @FXML
    private TextField SupplierStreetSearch;

    @FXML
    private TextField SupplierZipCodeSearch;

    @FXML
    private Button ClearSupplier;

    @FXML
    private Button DeleteSupplier;

    @FXML
    private Button UpdateSupplier;

    @FXML
    void SupplierSearchButton(ActionEvent event) {
        // Clear any previous items in the table
        SupplierTableView.getItems().clear();

        // Get the selected criteria and search input
        String searchCriteria = SupplierSearchCombo.getValue();
        String searchField = SupplierSearchField.getText().trim();

        if (searchCriteria == null || searchField.isEmpty()) {
            System.out.println("Search criteria not selected or search field is empty.");
            return;
        }

        ObservableList<SupplierTableView> searchResults = FXCollections.observableArrayList();

        // Build the SQL query based on the selected criteria
        String query = buildSupplierSearchQuery(searchCriteria, searchField);
        System.out.println("Executing query: " + query);

        try (Connection conn = DatabaseConnectionManager.getConnection();
             PreparedStatement statement = conn.prepareStatement(query)) {

            // Print the search field for debugging
            System.out.println("Searching for: " + searchField); // Added for debugging

            // Set the parameter based on search criteria
            if ("SupplierID".equals(searchCriteria) || "Phone".equals(searchCriteria)) {
                // For numeric values like SupplierID or Phone
                System.out.println("Setting parameter for numeric field: " + searchField);
                statement.setInt(1, Integer.parseInt(searchField));
            } else {
                // For string fields, use LIKE with wildcards
                System.out.println("Setting parameter for string field: " + searchField);
                statement.setString(1, "%" + searchField + "%");
            }

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                SupplierTableView supplier = new SupplierTableView(
                        resultSet.getInt("supplier_id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("email"),
                        resultSet.getInt("phone"),
                        resultSet.getString("country"),
                        resultSet.getString("city"),
                        resultSet.getString("street"),
                        resultSet.getString("zip_code")
                );
                searchResults.add(supplier);
                System.out.println("Supplier found: " + supplier); // Debugging: Print supplier details
            }

            if (searchResults.isEmpty()) {
                System.out.println("No results found for the search criteria.");
            } else {
                SupplierTableView.setItems(searchResults);
                System.out.println("Displaying search results in table.");
            }

        } catch (SQLException e) {
            System.out.println("An error occurred while searching for suppliers: " + e.getMessage());
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Invalid input for Supplier ID or Phone: " + e.getMessage());
        }
    }

    private String buildSupplierSearchQuery(String searchCriteria, String searchField) {
        String query = "SELECT supplier_id, first_name, last_name, email, phone, " +
                "country, city, street, zip_code FROM Supplier WHERE ";

        switch (searchCriteria) {
            case "SupplierID":
                query += "supplier_id = ?"; // Placeholder for SupplierID
                break;
            case "FirstName":
                query += "first_name ILIKE ?"; // Case-insensitive search
                break;
            case "LastName":
                query += "last_name ILIKE ?";
                break;
            case "Email":
                query += "email ILIKE ?";
                break;
            case "Phone":
                query += "phone = ?"; // Use '=' instead of 'ILIKE'
                break;
            case "Country":
                query += "country ILIKE ?";
                break;
            case "City":
                query += "city ILIKE ?";
                break;
            case "Street":
                query += "street ILIKE ?";
                break;
            case "ZipCode":
                query += "zip_code ILIKE ?";
                break;
            default:
                throw new IllegalArgumentException("Invalid search criteria");
        }

        return query;
    }

    @FXML
    void ClearSupplierButton(ActionEvent event) {
        SupplierIDSearch.clear();
        SupplierFirstNameSearch.clear();
        SupplierLastNameSearch.clear();
        SupplierEmailSearch.clear();
        SupplierPhoneSearch.clear();
        SupplierCitySearch.clear();
        SupplierAdressSearch.clear();
        SupplierStreetSearch.clear();
        SupplierZipCodeSearch.clear();


    }
    void ClearSupplierSearchButton()
    {
        SupplierIDSearch.clear();
        SupplierFirstNameSearch.clear();
        SupplierLastNameSearch.clear();
        SupplierEmailSearch.clear();
        SupplierPhoneSearch.clear();
        SupplierCitySearch.clear();
        SupplierAdressSearch.clear();
        SupplierStreetSearch.clear();
        SupplierZipCodeSearch.clear();


    }

    @FXML
    void DeleteSupplierButton(ActionEvent event) {
        String supplierIDText = SupplierIDSearch.getText().trim();

        // Check if the SupplierIDSearch field is empty
        if (supplierIDText.isEmpty()) {
            System.out.println("Supplier ID field is empty. Cannot delete.");
            // Optionally, show an alert to the user
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Delete Supplier");
            alert.setHeaderText(null);
            alert.setContentText("Please enter a Supplier ID to delete.");
            alert.showAndWait();
            return;
        }

        try {
            int supplierID = Integer.parseInt(supplierIDText); // Convert the ID to an integer

            // SQL query to delete supplier with the specified ID
            String query = "DELETE FROM Supplier WHERE supplier_id = ?";

            try (Connection conn = DatabaseConnectionManager.getConnection();
                 PreparedStatement statement = conn.prepareStatement(query)) {

                // Set the supplier ID parameter in the query
                statement.setInt(1, supplierID);

                int rowsAffected = statement.executeUpdate(); // Execute the delete operation

                if (rowsAffected > 0) {
                    System.out.println("Supplier with ID " + supplierID + " deleted successfully.");
                    // Optionally, show a confirmation alert
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Delete Supplier");
                    alert.setHeaderText(null);
                    alert.setContentText("Supplier deleted successfully.");
                    alert.showAndWait();

                    // Clear the fields after deletion
                    ClearSupplierSearchButton();
                } else {
                    System.out.println("No supplier found with ID " + supplierID);
                    // Optionally, show an alert that the supplier was not found
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Delete Supplier");
                    alert.setHeaderText(null);
                    alert.setContentText("No supplier found with the provided ID.");
                    alert.showAndWait();
                }

            } catch (SQLException e) {
                System.out.println("An error occurred while deleting the supplier: " + e.getMessage());
                e.printStackTrace();
            }

        } catch (NumberFormatException e) {
            System.out.println("Invalid Supplier ID format.");
            // Optionally, show an alert to the user for invalid ID format
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Delete Supplier");
            alert.setHeaderText(null);
            alert.setContentText("Please enter a valid numeric Supplier ID.");
            alert.showAndWait();
        }


    }

    @FXML
    void UpdateSupplierButton(ActionEvent event) {
        String supplierIDStr = SupplierIDSearch.getText(); // Get the supplier ID from the search field
        String firstName = SupplierFirstNameSearch.getText();
        String lastName = SupplierLastNameSearch.getText();
        String email = SupplierEmailSearch.getText();
        String phoneStr = SupplierPhoneSearch.getText();
        String city = SupplierCitySearch.getText();
        String country = SupplierAdressSearch.getText(); // Use SupplierAdressSearch for country input
        String street = SupplierStreetSearch.getText();
        String zipCode = SupplierZipCodeSearch.getText();

        // Check if SupplierIDSearch is not empty and is a valid number
        if (supplierIDStr == null || supplierIDStr.isEmpty()) {
            System.out.println("Error: Supplier ID is required to update.");
            showAlert("Error", "Supplier ID is required to update.");
            return;
        }

        // Validate if supplier_id is a number (to ensure it's a valid primary key)
        int supplierID;
        try {
            supplierID = Integer.parseInt(supplierIDStr);
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid Supplier ID format.");
            showAlert("Error", "Invalid Supplier ID format.");
            return;
        }

        // Validate phone field
        int phone = 0;
        try {
            if (!phoneStr.isEmpty()) {
                phone = Integer.parseInt(phoneStr);
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid phone format.");
            showAlert("Error", "Invalid phone format.");
            return;
        }

        Connection connection = null;
        try {
            connection = DatabaseConnectionManager.getConnection(); // Get the database connection
            System.out.println("Database connection established."); // Debug statement

            // Prepare the SQL query to update the supplier details
            String updateQuery = "UPDATE Supplier SET first_name = ?, last_name = ?, email = ?, phone = ?, " +
                    "city = ?, country = ?, street = ?, zip_code = ? WHERE supplier_id = ?";

            // Start the transaction
            connection.setAutoCommit(false);
            System.out.println("Transaction started."); // Debug statement

            try (PreparedStatement stmt = connection.prepareStatement(updateQuery)) {
                // Set the parameters for the query
                stmt.setString(1, firstName);
                stmt.setString(2, lastName);
                stmt.setString(3, email);
                stmt.setInt(4, phone); // Set phone as integer
                stmt.setString(5, city);
                stmt.setString(6, country); // Corrected to set country
                stmt.setString(7, street);
                stmt.setString(8, zipCode);
                stmt.setInt(9, supplierID); // Set supplier ID as integer

                // Execute the update query
                int rowsAffected = stmt.executeUpdate();
                System.out.println("Rows updated: " + rowsAffected); // Debug statement

                if (rowsAffected > 0) {
                    System.out.println("Supplier updated successfully.");
                    showAlert("Success", "Supplier details updated successfully.");
                } else {
                    System.out.println("Error: Supplier not found.");
                    showAlert("Error", "Supplier not found.");
                }

                // Commit the transaction if successful
                connection.commit();
                System.out.println("Transaction committed."); // Debug statement

            } catch (SQLException e) {
                System.out.println("Error updating supplier: " + e.getMessage()); // Debug statement
                connection.rollback();  // Rollback the transaction if an error occurs
                System.out.println("Transaction rolled back."); // Debug statement
                showAlert("Error", "An error occurred while updating the supplier.");
            }

        } catch (SQLException e) {
            System.out.println("Database connection error: " + e.getMessage()); // Debug statement
            showAlert("Database Error", "An error occurred while connecting to the database.");
        } finally {
            try {
                if (connection != null) {
                    connection.setAutoCommit(true); // Restore auto-commit
                    connection.close(); // Close the database connection
                    System.out.println("Database connection closed."); // Debug statement
                }
            } catch (SQLException e) {
                System.out.println("Error closing database connection: " + e.getMessage()); // Debug statement
            }
        }


    }

    @FXML
    void ViewAllSupplierButton(ActionEvent event) {
        ObservableList<SupplierTableView> supplierList = FXCollections.observableArrayList();

        try (Connection conn = DatabaseConnectionManager.getConnection()) {
            // Define the SQL query for the Supplier table
            String query = "SELECT supplier_id, first_name, last_name, email, phone, " +
                    "country, city, street, zip_code FROM Supplier";

            // Prepare and execute the query
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            // Populate supplierList with SupplierTableView objects
            while (resultSet.next()) {
                SupplierTableView supplier = new SupplierTableView(
                        resultSet.getInt("supplier_id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("email"),
                        resultSet.getInt("phone"),
                        resultSet.getString("country"),
                        resultSet.getString("city"),
                        resultSet.getString("street"),
                        resultSet.getString("zip_code")
                );
                supplierList.add(supplier);
            }

            // Set items in the SupplierTable (assuming SupplierTable is your TableView)
            SupplierTableView.setItems(supplierList);

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    private void populateSupplierFields(SupplierTableView supplier) {
        SupplierIDSearch.setText(String.valueOf(supplier.supplierIDProperty().get()));
        SupplierFirstNameSearch.setText(supplier.firstNameProperty().get());
        SupplierLastNameSearch.setText(supplier.lastNameProperty().get());
        SupplierEmailSearch.setText(supplier.emailProperty().get());
        SupplierPhoneSearch.setText(String.valueOf(supplier.phoneProperty().get()));
        SupplierCitySearch.setText(supplier.cityProperty().get());
        SupplierAdressSearch.setText(supplier.cityProperty().get());
        SupplierStreetSearch.setText(supplier.streetProperty().get());
        SupplierZipCodeSearch.setText(supplier.zipCodeProperty().get());
    }

//*********************************************************************************************************//

    @FXML
    private ComboBox<String> SearchItemCombo;

    @FXML
    private TextField SearchItemField;

    @FXML
    private TextField ItemIDSearch;

    @FXML
    private TextField ItemNameSearch;

    @FXML
    private TextField ItemModelName;

    @FXML
    private TextField ItemPriceSearch;

    @FXML
    private TextField ItemSupplierIDSearch;

    @FXML
    private TextField ItemStockQuentity;

    @FXML
    private Button ItemClear;

    @FXML
    private Button ItemDelete;

    @FXML
    private Button ItemUpdate;

    @FXML
    private Button SearchItem;

    @FXML
    private Button ItemViewAll;

    @FXML
    private TableView<ItemTableView> ItemTableView;

    @FXML
    private TableColumn<ItemTableView, Integer> ItemIDColumn;

    @FXML
    private TableColumn<ItemTableView, String> ItemNameColumn;


    @FXML
    private TableColumn<ItemTableView, String> ItemModelColumn;


    @FXML
    private TableColumn<ItemTableView, Integer> ItemStockQuantityColumn;

    @FXML
    private TableColumn<ItemTableView, Double> ItemPriceColumn;

    @FXML
    private TableColumn<ItemTableView, Integer> ItemSupplierIDColumn;


    @FXML
    void SearchItemButton(ActionEvent event) {
        // Clear any previous items in the table
        ItemTableView.getItems().clear();

        // Get the selected criteria and search input
        String searchCriteria = SearchItemCombo.getValue();
        String searchField = SearchItemField.getText().trim();

        if (searchCriteria == null || searchField.isEmpty()) {
            System.out.println("Search criteria not selected or search field is empty.");
            return;
        }

        ObservableList<ItemTableView> searchResults = FXCollections.observableArrayList();

        // Build the SQL query based on the selected criteria
        String query = buildItemSearchQuery(searchCriteria, searchField);
        System.out.println("Executing query: " + query);

        try (Connection conn = DatabaseConnectionManager.getConnection();
             PreparedStatement statement = conn.prepareStatement(query)) {

            // Set the parameter based on search criteria
            if ("ItemID".equals(searchCriteria)) {
                // For numeric values like ItemID
                statement.setInt(1, Integer.parseInt(searchField));
            } else if ("Price".equals(searchCriteria)) {
                // For numeric values like Price
                statement.setDouble(1, Double.parseDouble(searchField));
            } else {
                // For string fields, use LIKE with wildcards
                statement.setString(1, "%" + searchField + "%");
            }

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int itemID = resultSet.getInt("item_id");
                String itemName = resultSet.getString("item_name");
                String itemModel = resultSet.getString("model");
                int stockQuantity = resultSet.getInt("stock_quantity");
                double price = resultSet.getDouble("price");

                // Retrieve the SupplierID from the supplier_and_item table
                int supplierID = getSupplierIDForItem(itemID, conn);

                // Create an ItemTableView object and add it to the search results
                ItemTableView item = new ItemTableView(itemID, itemName, itemModel, stockQuantity, price, supplierID);
                searchResults.add(item);
                System.out.println("Item found: " + item); // Debugging: Print item details
            }

            if (searchResults.isEmpty()) {
                System.out.println("No results found for the search criteria.");
            } else {
                ItemTableView.setItems(searchResults);
                System.out.println("Displaying search results in table.");
            }

        } catch (SQLException e) {
            System.out.println("An error occurred while searching for items: " + e.getMessage());
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Invalid input for ItemID or Price: " + e.getMessage());
        }
    }

    private String buildItemSearchQuery(String searchCriteria, String searchField) {
        String baseQuery = "SELECT item_id, item_name, model, stock_quantity, price FROM Item WHERE ";
        switch (searchCriteria) {
            case "ItemID":
                return baseQuery + "item_id = ?";
            case "Item Name":
                return baseQuery + "item_name LIKE ?";
            case "Model":
                return baseQuery + "model LIKE ?";
            case "Price":
                return baseQuery + "price = ?";
            default:
                return null;
        }
    }
    private int getSupplierIDForItem(int itemID, Connection conn) throws SQLException {
        String query = "SELECT supplier_id FROM supplier_and_item WHERE item_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, itemID);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("supplier_id");
            }
        }
        return -1; // Return -1 or a default value if no supplier found
    }


    @FXML
    void ItemViewAllButton(ActionEvent event) {
        ObservableList<ItemTableView> itemList = FXCollections.observableArrayList();

        try (Connection conn = DatabaseConnectionManager.getConnection()) {
            String query = "SELECT item_id, item_name, model, stock_quantity, price FROM Item";

            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int itemID = resultSet.getInt("item_id");
                String itemName = resultSet.getString("item_name");
                String itemModel = resultSet.getString("model");
                int stockQuantity = resultSet.getInt("stock_quantity");
                double price = resultSet.getDouble("price");

                int supplierID = getSupplierIDForItem(itemID, conn);

                ItemTableView item = new ItemTableView(itemID, itemName, itemModel, stockQuantity, price, supplierID);
                itemList.add(item);
            }

            ItemTableView.setItems(itemList);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void ItemUpdateButton(ActionEvent event) {
        String itemIDStr = ItemIDSearch.getText();
        String itemName = ItemNameSearch.getText();
        String itemModel = ItemModelName.getText();
        String itemPriceStr = ItemPriceSearch.getText();
        String stockQuantityStr = ItemStockQuentity.getText();
        String supplierIDStr = ItemSupplierIDSearch.getText();

        // Validate that ItemIDSearch is not empty and is a valid number
        if (itemIDStr == null || itemIDStr.isEmpty()) {
            System.out.println("Error: Item ID is required to update.");
            showAlert("Error", "Item ID is required to update.");
            return;
        }

        // Convert Item ID to an integer
        int itemID;
        try {
            itemID = Integer.parseInt(itemIDStr);
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid Item ID format.");
            showAlert("Error", "Invalid Item ID format.");
            return;
        }

        // Validate and parse numeric fields for price and stock quantity
        double itemPrice = 0.0;
        int stockQuantity = 0;
        try {
            if (!itemPriceStr.isEmpty()) {
                itemPrice = Double.parseDouble(itemPriceStr);
            }
            if (!stockQuantityStr.isEmpty()) {
                stockQuantity = Integer.parseInt(stockQuantityStr);
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid price or stock quantity format.");
            showAlert("Error", "Please enter a valid numeric format for price and stock quantity.");
            return;
        }

        // Validate and parse supplier ID if provided
        Integer supplierID = null;
        try {
            if (!supplierIDStr.isEmpty()) {
                supplierID = Integer.parseInt(supplierIDStr);
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid Supplier ID format.");
            showAlert("Error", "Invalid Supplier ID format.");
            return;
        }

        Connection connection = null;
        try {
            connection = DatabaseConnectionManager.getConnection(); // Get the database connection
            System.out.println("Database connection established.");

            // Update the Item table with basic item details
            String updateItemQuery = "UPDATE Item SET item_name = ?, model = ?, price = ?, stock_quantity = ? WHERE item_id = ?";

            // Start the transaction
            connection.setAutoCommit(false);
            System.out.println("Transaction started.");

            try (PreparedStatement stmt = connection.prepareStatement(updateItemQuery)) {
                // Set the parameters for the item update query
                stmt.setString(1, itemName);
                stmt.setString(2, itemModel);
                stmt.setDouble(3, itemPrice);
                stmt.setInt(4, stockQuantity);
                stmt.setInt(5, itemID);

                // Execute the update query for the Item table
                int rowsAffected = stmt.executeUpdate();
                System.out.println("Item rows updated: " + rowsAffected);

                if (rowsAffected == 0) {
                    System.out.println("Error: Item not found.");
                    showAlert("Error", "Item not found.");
                    connection.rollback();  // Rollback if item does not exist
                    return;
                }

                if (supplierID != null) {
                    // Check if the supplier_and_item relation already exists
                    String checkRelationQuery = "SELECT COUNT(*) FROM supplier_and_item WHERE item_id = ?";
                    try (PreparedStatement checkStmt = connection.prepareStatement(checkRelationQuery)) {
                        checkStmt.setInt(1, itemID);
                        ResultSet rs = checkStmt.executeQuery();
                        rs.next();
                        int relationCount = rs.getInt(1);

                        if (relationCount > 0) {
                            // Update the existing supplier_and_item relation
                            String updateSupplierItemQuery = "UPDATE supplier_and_item SET supplier_id = ? WHERE item_id = ?";
                            try (PreparedStatement updateRelationStmt = connection.prepareStatement(updateSupplierItemQuery)) {
                                updateRelationStmt.setInt(1, supplierID);
                                updateRelationStmt.setInt(2, itemID);
                                updateRelationStmt.executeUpdate();
                                System.out.println("Supplier-Item relation updated.");
                            }
                        } else {
                            String insertSupplierItemQuery = "INSERT INTO supplier_and_item (item_id, supplier_id) VALUES (?, ?)";
                            try (PreparedStatement insertRelationStmt = connection.prepareStatement(insertSupplierItemQuery)) {
                                insertRelationStmt.setInt(1, itemID);
                                insertRelationStmt.setInt(2, supplierID);
                                insertRelationStmt.executeUpdate();
                                System.out.println("Supplier-Item relation inserted.");
                            }
                        }
                    }
                }

                // Commit the transaction if all operations are successful
                connection.commit();
                System.out.println("Transaction committed.");
                showAlert("Success", "Item details updated successfully.");

            } catch (SQLException e) {
                System.out.println("Error updating item: " + e.getMessage());
                connection.rollback(); // Rollback the transaction if an error occurs
                System.out.println("Transaction rolled back.");
                showAlert("Error", "An error occurred while updating the item.");
            }

        } catch (SQLException e) {
            System.out.println("Database connection error: " + e.getMessage());
            showAlert("Database Error", "An error occurred while connecting to the database.");
        } finally {
            try {
                if (connection != null) {
                    connection.setAutoCommit(true); // Restore auto-commit
                    connection.close(); // Close the database connection
                    System.out.println("Database connection closed.");
                }
            } catch (SQLException e) {
                System.out.println("Error closing database connection: " + e.getMessage());
            }
        }

    }

    @FXML
    void ItemClearButton(ActionEvent event) {
        ItemIDSearch.clear();
        ItemNameSearch.clear();
        ItemModelName.clear();
        ItemPriceSearch.clear();
        ItemStockQuentity.clear();
        ItemSupplierIDSearch.clear();

    }

    @FXML
    void ItemDeleteButton(ActionEvent event) {
        String itemIDText = ItemIDSearch.getText().trim();

        if (itemIDText.isEmpty()) {
            System.out.println("Item ID field is empty. Cannot delete.");
            // Optionally, show an alert to the user
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Delete Item");
            alert.setHeaderText(null);
            alert.setContentText("Please enter an Item ID to delete.");
            alert.showAndWait();
            return;
        }

        try {
            int itemID = Integer.parseInt(itemIDText); // Convert the ID to an integer

            // SQL query to delete the item with the specified ID
            String query = "DELETE FROM Item WHERE item_id = ?";

            try (Connection conn = DatabaseConnectionManager.getConnection();
                 PreparedStatement statement = conn.prepareStatement(query)) {

                // Set the item ID parameter in the query
                statement.setInt(1, itemID);

                int rowsAffected = statement.executeUpdate(); // Execute the delete operation

                if (rowsAffected > 0) {
                    System.out.println("Item with ID " + itemID + " deleted successfully.");
                    // Optionally, show a confirmation alert
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Delete Item");
                    alert.setHeaderText(null);
                    alert.setContentText("Item deleted successfully.");
                    alert.showAndWait();

                    // Clear the fields after deletion
                    ItemClearButton(new ActionEvent());
                } else {
                    System.out.println("No item found with ID " + itemID);
                    // Optionally, show an alert that the item was not found
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Delete Item");
                    alert.setHeaderText(null);
                    alert.setContentText("No item found with the provided ID.");
                    alert.showAndWait();
                }

            } catch (SQLException e) {
                System.out.println("An error occurred while deleting the item: " + e.getMessage());
                e.printStackTrace();
            }

        } catch (NumberFormatException e) {
            System.out.println("Invalid Item ID format.");
            // Optionally, show an alert to the user for invalid ID format
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Delete Item");
            alert.setHeaderText(null);
            alert.setContentText("Please enter a valid numeric Item ID.");
            alert.showAndWait();
        }


    }

    private void populateItemFields(ItemTableView item) {
        ItemIDSearch.setText(String.valueOf(item.itemIDProperty().get()));
        ItemNameSearch.setText(item.itemNameProperty().get());
        ItemModelName.setText(item.itemModelProperty().get());
        ItemPriceSearch.setText(String.valueOf(item.priceProperty().get()));
        ItemStockQuentity.setText(String.valueOf(item.stockQuantityProperty().get()));
        ItemSupplierIDSearch.setText(String.valueOf(item.supplierIDProperty().get()));
    }













    }
