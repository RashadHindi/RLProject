package org.example.rlproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.swing.JRViewer;


import javax.swing.*;
import java.io.*;
import java.sql.*;


public class EmployeeController {

    @FXML
    private Button AddCustomer;

    @FXML
    private AnchorPane AddCustomerAnchore;

    @FXML
    private AnchorPane OrderDetailsAnchor;

    @FXML
    private Button CreateOrder;

    @FXML
    private AnchorPane CreateOrderAnchor;

    @FXML
    private Label EmployeeUserName;

    @FXML
    private Button Home;

    @FXML
    private AnchorPane HomeAnchor;

    @FXML
    private AnchorPane ReportsAnchor;

    @FXML
    private Button ShowOrders;

    @FXML
    private Label TotalCustomer;

    @FXML
    private Label TotalItems;

    @FXML
    private Label TotalOrders;

    @FXML
    private Button ViewCustomer;

    @FXML
    private AnchorPane ViewCustomerAnchor;

    @FXML
    private AnchorPane ViewItemAnchor;

    @FXML
    private AnchorPane ViewOrderAnchor;



    @FXML
    public void initialize() {
        hideAllAnchors();
        HomeAnchor.setVisible(true);
        updateHomeLabels();
        //**********************************************************************************//

        CustomerSearchCombo.getItems().addAll(
                "CustomerID",
                "FirstName",
                "MiddleName",
                "LastName",
                "Gender",
                "Email",
                "Phone",
                "Country",
                "City",
                "Street"
        );
        //**********************************************************************************//
        SearchItemCombo.getItems().addAll(
                "ItemID",
                "Item Name",
                "Price",
                "Model"
        );
        //**********************************************************************************//
        OrderComboBox.getItems().addAll(
          "OrderID","CustomerID","EmployeeID"
        );
        //*********************************************************************************//
        CustomerIDColumn.setCellValueFactory(cellData -> cellData.getValue().customerIDProperty().asObject());
        CustomerFNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        CustomerMNameColumn.setCellValueFactory(cellData -> cellData.getValue().middleNameProperty());
        CustomerLNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
        CustomerGenderColumn.setCellValueFactory(cellData -> cellData.getValue().genderProperty());
        CustomerEmailColumn.setCellValueFactory(cellData -> cellData.getValue().emailProperty());
        CustomerPhoneColumn.setCellValueFactory(cellData -> cellData.getValue().phoneProperty().asObject());
        CustomerCountryColumn.setCellValueFactory(cellData -> cellData.getValue().countryProperty());
        CustomerCityColumn.setCellValueFactory(cellData -> cellData.getValue().cityProperty());
        CustomerStreetColumn.setCellValueFactory(cellData -> cellData.getValue().streetProperty());
        //************************************************************************************//
        ItemIDColumn.setCellValueFactory(cellData -> cellData.getValue().itemIDProperty().asObject());
        ItemNameColumn.setCellValueFactory(cellData -> cellData.getValue().itemNameProperty());
        ItemModelColumn.setCellValueFactory(cellData -> cellData.getValue().itemModelProperty());
        ItemStockQuantityColumn.setCellValueFactory(cellData -> cellData.getValue().stockQuantityProperty().asObject());
        ItemPriceColumn.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asObject());
        //*************************************************************************************//
        OrderIDColumn.setCellValueFactory(cellData -> cellData.getValue().orderIDProperty().asObject());
        OrderCustomerIDColumn.setCellValueFactory(cellData -> cellData.getValue().customerIDProperty().asObject());
        OrderEmployeeIDColumn.setCellValueFactory(cellData -> cellData.getValue().employeeIDProperty().asObject());
        OrderTotalPriceColumn.setCellValueFactory(cellData -> cellData.getValue().totalPriceProperty().asObject());
        OrderCreatedDateColumn.setCellValueFactory(cellData -> cellData.getValue().createdDateProperty());
        //***************************************************************************************//
        OrderDetailsIDColumn.setCellValueFactory(cellData -> cellData.getValue().orderDetailsIDProperty().asObject());
        OrderDetailsOrderIDColumn.setCellValueFactory(cellData -> cellData.getValue().orderIDProperty().asObject());
        OrderDetailsItemIDColumn.setCellValueFactory(cellData -> cellData.getValue().itemIDProperty().asObject());
        OrderDetailsPriceColumn.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asObject());
        OrderDetailsQuantitycolumn.setCellValueFactory(cellData -> cellData.getValue().quantityProperty().asObject());
        OrderDetailsTotalPriceColumn.setCellValueFactory(cellData -> cellData.getValue().totalPriceProperty().asObject());
        //*********************************************************************************************//
        CustomerTableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) { // Check if a row is selected
                populateFields(newValue);
            }
        });
        //****************************************************************************************//
        ItemTableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) { // Check if a row is selected
                populateItemFields(newValue); // Populate the fields with the selected item's data
            }
        });

        OrderTableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) { // Check if a row is selected
                populateOrderFields(newValue); // Populate the fields with the selected order's data
            }
        });
    }



    @FXML
    void AddCustomerButton(ActionEvent event) {
        hideAllAnchors();
        AddCustomerAnchore.setVisible(true);
    }

    @FXML
    void CreateOrderButton(ActionEvent event) {
        hideAllAnchors();
        CreateOrderAnchor.setVisible(true);
    }

    @FXML
    void HomeButton(ActionEvent event) {
        hideAllAnchors();
        HomeAnchor.setVisible(true);
        updateHomeLabels();

    }
    private void updateHomeLabels() {
        try (Connection conn = DatabaseConnectionManager.getConnection();
             Statement stmt = conn.createStatement()) {

            // Fetch and update Customer count
            ResultSet rsCustomers = stmt.executeQuery("SELECT COUNT(customer_id) FROM Customer");
            if (rsCustomers.next()) {
                int customerCount = rsCustomers.getInt(1);
                TotalCustomer.setText(String.valueOf(customerCount));
            }

            // Fetch and update Order count
            ResultSet rsOrders = stmt.executeQuery("SELECT COUNT(order_id) FROM \"Order\"");
            if (rsOrders.next()) {
                int orderCount = rsOrders.getInt(1);
                TotalOrders.setText(String.valueOf(orderCount));
            }

            // Fetch and update Item count
            ResultSet rsItems = stmt.executeQuery("SELECT COUNT(item_id) FROM Item");
            if (rsItems.next()) {
                int itemCount = rsItems.getInt(1);
                TotalItems.setText(String.valueOf(itemCount));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




    @FXML
    void ShowOrdersButton(ActionEvent event) {
        hideAllAnchors();
        ViewOrderAnchor.setVisible(true);

    }

    @FXML
    void ViewCustomerButton(ActionEvent event) {
        hideAllAnchors();
        ViewCustomerAnchor.setVisible(true);

    }

    private void hideAllAnchors() {
        AddCustomerAnchore.setVisible(false);
        CreateOrderAnchor.setVisible(false);
        HomeAnchor.setVisible(false);
        ViewCustomerAnchor.setVisible(false);
        ViewItemAnchor.setVisible(false);
        ViewOrderAnchor.setVisible(false);
        OrderDetailsAnchor.setVisible(false);
        ReportsAnchor.setVisible(false);
    }

    public void setEmployeeUsername(String userName) {
        EmployeeUserName.setText(userName);
    }


    //*************************************************************************************//
    @FXML
    private TextField CustomerIDField;

    @FXML
    private TextField CustomerFnameField;

    @FXML
    private TextField CustomerMNameField;

    @FXML
    private TextField CustomerLNameField;

    @FXML
    private TextField CustomerEmailField;

    @FXML
    private TextField CustomerPhoneField;

    @FXML
    private TextField CustomerCountryField;

    @FXML
    private TextField CustomerCityField;

    @FXML
    private TextField CustomerStreetField;

    @FXML
    private RadioButton CustomerMale;

    @FXML
    private RadioButton CustomerFeMale;

    @FXML
    void SaveCustomerButton(ActionEvent event){
        String firstName = CustomerFnameField.getText().trim();
        String middleName = CustomerMNameField.getText().trim();
        String lastName = CustomerLNameField.getText().trim();
        String email = CustomerEmailField.getText().trim();
        String country = CustomerCountryField.getText().trim();
        String city = CustomerCityField.getText().trim();
        String street = CustomerStreetField.getText().trim();
        String gender = CustomerMale.isSelected() ? "Male" : "Female";

       // Print field values to debug
        System.out.println("Customer Info - FirstName: " + firstName + ", MiddleName: " + middleName + ", LastName: " + lastName);
        System.out.println("Email: " + email + ", Country: " + country + ", City: " + city + ", Street: " + street);
        System.out.println("Gender: " + gender);

        int customerID, phone;
        try {
            customerID = Integer.parseInt(CustomerIDField.getText().trim());
            phone = Integer.parseInt(CustomerPhoneField.getText().trim());
            // Print parsed customer ID and phone to debug
            System.out.println("Parsed Customer ID: " + customerID);
            System.out.println("Parsed Phone: " + phone);
        } catch (NumberFormatException e) {
            showAlert("Error", "Customer ID and Phone must be numeric.");
            System.out.println("NumberFormatException: Customer ID or Phone is not numeric.");
            return;
        }

// Check if any required fields are empty
        if (firstName.isEmpty() || middleName.isEmpty() || lastName.isEmpty() || email.isEmpty() ||
                country.isEmpty() || city.isEmpty() || street.isEmpty()) {
            showAlert("Error", "Please fill in all fields before saving the customer.");
            System.out.println("Error: One or more required fields are empty.");
            return;
        }

        try (Connection conn = DatabaseConnectionManager.getConnection()) {
            System.out.println("Database connection established.");

            // Check if Customer ID is unique
            PreparedStatement checkCustomerIDStmt = conn.prepareStatement(
                    "SELECT COUNT(*) FROM Customer WHERE customer_id = ?");
            checkCustomerIDStmt.setInt(1, customerID);
            ResultSet rsCustomerID = checkCustomerIDStmt.executeQuery();

            if (rsCustomerID.next()) {
                int customerCount = rsCustomerID.getInt(1);
                System.out.println("Customer ID check - Count: " + customerCount);
                if (customerCount > 0) {
                    showAlert("Error", "Customer ID already exists. Please enter a unique Customer ID.");
                    return;
                }
            }

            // Insert customer data into the database
            PreparedStatement saveCustomerStmt = conn.prepareStatement(
                    "INSERT INTO Customer (customer_id, phone, email, country, city, street, firstname, middlename, lastname, gender) " +
                            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?::gender_enum)");

            saveCustomerStmt.setInt(1, customerID);
            saveCustomerStmt.setInt(2, phone);
            saveCustomerStmt.setString(3, email);
            saveCustomerStmt.setString(4, country);
            saveCustomerStmt.setString(5, city);
            saveCustomerStmt.setString(6, street);
            saveCustomerStmt.setString(7, firstName);
            saveCustomerStmt.setString(8, middleName);
            saveCustomerStmt.setString(9, lastName);
            saveCustomerStmt.setString(10, gender);

            System.out.println("Executing insert statement...");
            int rowsAffected = saveCustomerStmt.executeUpdate();
            System.out.println("Rows affected: " + rowsAffected);

            if (rowsAffected > 0) {
                showAlert("Success", "Customer information saved successfully.");
                System.out.println("Customer information saved successfully.");
                clearCustomerFields();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            showAlert("Database Error", "An error occurred while saving customer information.");
            System.out.println("SQLException: " + e.getMessage());
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @FXML
    private TextField OrderCustomerID;

    @FXML
    private TextField OrderEmployeeID;

    @FXML
    private Button OrderDetails;

    private int currentOrderId = -1; // Store order_id after Order creation

    @FXML
    void OrderDetailsButton(ActionEvent event) {
        String customerIDText = OrderCustomerID.getText().trim();
        String employeeIDText = OrderEmployeeID.getText().trim();

        // Validate the input: check if IDs are numeric
        int customerID, employeeID;
        try {
            customerID = Integer.parseInt(customerIDText);
            employeeID = Integer.parseInt(employeeIDText);
        } catch (NumberFormatException e) {
            showAlert("Error", "Customer ID and Employee ID must be numeric.");
            return;
        }

        // Check if customer and employee exist in the database
        try (Connection conn = DatabaseConnectionManager.getConnection()) {
            // Check if customer exists
            PreparedStatement checkCustomerStmt = conn.prepareStatement(
                    "SELECT COUNT(*) FROM Customer WHERE customer_id = ?");
            checkCustomerStmt.setInt(1, customerID);
            ResultSet rsCustomer = checkCustomerStmt.executeQuery();
            boolean customerExists = rsCustomer.next() && rsCustomer.getInt(1) > 0;

            // Check if employee exists
            PreparedStatement checkEmployeeStmt = conn.prepareStatement(
                    "SELECT COUNT(*) FROM Employee WHERE employee_id = ?");
            checkEmployeeStmt.setInt(1, employeeID);
            ResultSet rsEmployee = checkEmployeeStmt.executeQuery();
            boolean employeeExists = rsEmployee.next() && rsEmployee.getInt(1) > 0;

            // Insert new order if customer and employee exist
            if (customerExists && employeeExists) {
                PreparedStatement insertOrderStmt = conn.prepareStatement(
                        "INSERT INTO \"Order\" (customer_id, employee_id) VALUES (?, ?)",
                        Statement.RETURN_GENERATED_KEYS);
                insertOrderStmt.setInt(1, customerID);
                insertOrderStmt.setInt(2, employeeID);

                int rowsInserted = insertOrderStmt.executeUpdate();
                if (rowsInserted > 0) {
                    // Get the generated order_id
                    ResultSet generatedKeys = insertOrderStmt.getGeneratedKeys();
                    if (generatedKeys.next()) {
                        currentOrderId = generatedKeys.getInt(1); // Store the new order_id
                    }

                    showAlert("Success", "Order created successfully.");
                    hideAllAnchors();
                    ViewItemAnchor.setVisible(true);
                } else {
                    showAlert("Error", "Failed to create the order.");
                }
            } else {
                showAlert("Error", "Customer or Employee ID not found in the database.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            showAlert("Database Error", "An error occurred while creating the order in the database.");
        }

        // Clear input fields after processing
        OrderCustomerID.clear();
        OrderEmployeeID.clear();
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @FXML
    private Button LogOut;

    @FXML
    void LogOutButton(ActionEvent event) {
        try {
            // Load the Welcome.fxml file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/rlproject/Welcome.fxml"));
            Parent welcomeRoot = loader.load();

            // Get the current stage (window)
            Stage stage = (Stage) LogOut.getScene().getWindow();

            // Set the scene to Welcome.fxml
            stage.setScene(new Scene(welcomeRoot));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Error", "Unable to load the welcome page.");
        }
    }

        private void clearCustomerFields() {
        CustomerIDField.clear();
        CustomerFnameField.clear();
        CustomerMNameField.clear();
        CustomerLNameField.clear();
        CustomerEmailField.clear();
        CustomerPhoneField.clear();
        CustomerCountryField.clear();
        CustomerCityField.clear();
        CustomerStreetField.clear();
        CustomerMale.setSelected(false);
        CustomerFeMale.setSelected(false);
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    //**************************************************************************************************************//

    @FXML
    private ComboBox<String> CustomerSearchCombo;

    @FXML
    private TextField CustomerSearchField;

    @FXML
    private TableView<CustomerTableView> CustomerTableView;

    @FXML
    private Button CustomerSearch;

    @FXML
    private Button CustomerViewAll;

    @FXML
    private TableColumn<CustomerTableView, Integer> CustomerIDColumn;

    @FXML
    private TableColumn<CustomerTableView, String> CustomerFNameColumn;


    @FXML
    private TableColumn<CustomerTableView, String> CustomerMNameColumn;

    @FXML
    private TableColumn<CustomerTableView, String> CustomerGenderColumn;

    @FXML
    private TableColumn<CustomerTableView, String> CustomerEmailColumn;


    @FXML
    private TableColumn<CustomerTableView, String> CustomerLNameColumn;

    @FXML
    private TableColumn<CustomerTableView, Integer> CustomerPhoneColumn;

    @FXML
    private TableColumn<CustomerTableView, String> CustomerCountryColumn;

    @FXML
    private TableColumn<CustomerTableView, String> CustomerCityColumn;

    @FXML
    private TableColumn<CustomerTableView, String> CustomerStreetColumn;

    @FXML
    private TextField CustomerIDSearch;

    @FXML
    private TextField CustomerFNameSearch;

    @FXML
    private TextField CustomerMNameSearch;

    @FXML
    private TextField CustomerLNameSearch;

    @FXML
    private TextField CustomerEmailSearch;

    @FXML
    private TextField CustomerPhoneSearch;

    @FXML
    private TextField CustomerCountrySearch;

    @FXML
    private TextField CustomerCitySearch;

    @FXML
    private TextField CustomerStreetSearch;

    @FXML
    private TextField CustomerGenderSearch;

    @FXML
    void CustomerSearchButton(ActionEvent event) {
        CustomerTableView.getItems().clear();

        // Get the selected search criteria and search text from the fields
        String searchCriteria = CustomerSearchCombo.getValue();
        String searchField = CustomerSearchField.getText().trim();

        if (searchCriteria == null || searchField.isEmpty()) {
            System.out.println("Please select a valid search criteria and provide a search term.");
            return;
        }

        ObservableList<CustomerTableView> searchResults = FXCollections.observableArrayList();

        // Build the SQL query based on the search criteria and the search term
        String query = buildCustomerSearchQuery(searchCriteria, searchField);

        try (Connection conn = DatabaseConnectionManager.getConnection();
             PreparedStatement statement = conn.prepareStatement(query)) {

            // Set the query parameter for the search field
            if (searchCriteria.equals("CustomerID") || searchCriteria.equals("Phone")) {
                // For numeric fields like CustomerID or Phone, we use setInt
                statement.setInt(1, Integer.parseInt(searchField));
            } else {
                // For string fields (e.g., first name, last name, etc.), we use ILIKE with wildcards
                statement.setString(1, "%" + searchField + "%");
            }

            // Execute the query and process the results
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                // Create a CustomerTableView object with data from the result set
                CustomerTableView customer = new CustomerTableView(
                        resultSet.getInt("customer_id"),
                        resultSet.getInt("phone"),
                        resultSet.getString("email"),
                        resultSet.getString("country"),
                        resultSet.getString("city"),
                        resultSet.getString("street"),
                        resultSet.getString("firstname"),
                        resultSet.getString("middlename"),
                        resultSet.getString("lastname"),
                        resultSet.getString("gender")
                );

                // Add the customer object to the list of search results
                searchResults.add(customer);
            }

            // Debugging: Print out the results to see if anything was retrieved
            if (searchResults.isEmpty()) {
                System.out.println("No results found for the search criteria.");
            } else {
                System.out.println("Found " + searchResults.size() + " results.");
            }

            // If search results are found, display them in the table
            if (searchResults.isEmpty()) {
                System.out.println("No results found.");
            } else {
                CustomerTableView.setItems(searchResults);
                System.out.println("Displaying search results in table.");
            }

        } catch (SQLException e) {
            System.out.println("An error occurred while searching for customers: " + e.getMessage());
            e.printStackTrace();
        } catch (NumberFormatException e) {
            // Handle invalid input (e.g., non-numeric input for numeric fields like CustomerID or Phone)
            System.out.println("Invalid input for Customer ID or Phone: " + e.getMessage());
        }

    }

    private String buildCustomerSearchQuery(String searchCriteria, String searchField) {
        String query = "SELECT customer_id, phone, email, country, city, street, firstname, middlename, lastname, gender " +
                "FROM customer WHERE ";

        // Based on the search criteria, modify the WHERE clause
        switch (searchCriteria) {
            case "CustomerID":
                query += "customer_id = ?"; // Search by Customer ID
                break;
            case "FirstName":
                query += "firstname ILIKE ?"; // Case-insensitive search for first name
                break;
            case "MiddleName":
                query += "middlename ILIKE ?"; // Case-insensitive search for middle name
                break;
            case "LastName":
                query += "lastname ILIKE ?"; // Case-insensitive search for last name
                break;
            case "Gender":
                query += "gender::text ILIKE ?"; // Case-insensitive search for gender
                break;
            case "Email":
                query += "email ILIKE ?"; // Case-insensitive search for email
                break;
            case "Phone":
                query += "phone = ?"; // Search by phone number
                break;
            case "Country":
                query += "country ILIKE ?"; // Case-insensitive search for country
                break;
            case "City":
                query += "city ILIKE ?"; // Case-insensitive search for city
                break;
            case "Street":
                query += "street ILIKE ?"; // Case-insensitive search for street
                break;
            default:
                throw new IllegalArgumentException("Invalid search criteria");
        }

        // Return the built query string
        return query;

    }

    @FXML
    void CustomerViewAllButton(ActionEvent event){
        // Clear any previous search results in the table
        CustomerTableView.getItems().clear();

        // Create an observable list to store all customer data
        ObservableList<CustomerTableView> allCustomers = FXCollections.observableArrayList();

        // SQL query to retrieve all customers from the database
        String query = "SELECT * FROM customer";

        try (Connection conn = DatabaseConnectionManager.getConnection();
             PreparedStatement statement = conn.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            // Iterate through the result set and create CustomerTableView objects
            while (resultSet.next()) {
                CustomerTableView customer = new CustomerTableView(
                        resultSet.getInt("customer_id"),
                        resultSet.getInt("phone"),
                        resultSet.getString("email"),
                        resultSet.getString("country"),
                        resultSet.getString("city"),
                        resultSet.getString("street"),
                        resultSet.getString("firstname"),
                        resultSet.getString("middlename"),
                        resultSet.getString("lastname"),
                        resultSet.getString("gender")
                );

                // Add the customer object to the list of all customers
                allCustomers.add(customer);
            }

            // Populate the TableView with the list of customers
            if (allCustomers.isEmpty()) {
                System.out.println("No customers found.");
            } else {
                CustomerTableView.setItems(allCustomers);
                System.out.println("Displaying all customers in table.");
            }

        } catch (SQLException e) {
            // Handle potential errors with the database
            System.out.println("An error occurred while retrieving all customers: " + e.getMessage());
            e.printStackTrace();
        }


    }
    private void populateFields(CustomerTableView customer) {
        // Set text in the respective search fields with the selected customer's data
        CustomerIDSearch.setText(String.valueOf(customer.customerIDProperty().get()));
        CustomerFNameSearch.setText(customer.firstNameProperty().get());
        CustomerMNameSearch.setText(customer.middleNameProperty().get());
        CustomerLNameSearch.setText(customer.lastNameProperty().get());
        CustomerEmailSearch.setText(customer.emailProperty().get());
        CustomerPhoneSearch.setText(String.valueOf(customer.phoneProperty().get()));
        CustomerCountrySearch.setText(customer.countryProperty().get());
        CustomerCitySearch.setText(customer.cityProperty().get());
        CustomerStreetSearch.setText(customer.streetProperty().get());
        CustomerGenderSearch.setText(customer.genderProperty().get());
    }

    @FXML
    private Button CustomerUpdate;

    @FXML
    private Button CustomerDelete;

    @FXML
    private Button CustomerClear;

    @FXML
    private void CustomerClearButton(ActionEvent event) {
        CustomerIDSearch.clear();
        CustomerFNameSearch.clear();
        CustomerMNameSearch.clear();
        CustomerLNameSearch.clear();
        CustomerEmailSearch.clear();
        CustomerPhoneSearch.clear();
        CustomerCountrySearch.clear();
        CustomerCitySearch.clear();
        CustomerStreetSearch.clear();
        CustomerGenderSearch.clear();
    }

    @FXML
    private void CustomerDeleteButton(ActionEvent event) {
        String customerIDText = CustomerIDSearch.getText().trim();

        // Check if the CustomerIDSearch field is empty
        if (customerIDText.isEmpty()) {
            System.out.println("Customer ID field is empty. Cannot delete.");
            // Optionally, show an alert to the user
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Delete Customer");
            alert.setHeaderText(null);
            alert.setContentText("Please enter a Customer ID to delete.");
            alert.showAndWait();
            return;
        }

        try {
            int customerID = Integer.parseInt(customerIDText); // Convert the ID to an integer

            // Step 1: Delete orders associated with this customer
            String deleteOrdersQuery = "DELETE FROM \"Order\" WHERE customer_id = ?";  // Escaping "Order" table name

            try (Connection conn = DatabaseConnectionManager.getConnection();
                 PreparedStatement deleteOrdersStmt = conn.prepareStatement(deleteOrdersQuery)) {

                // Set the customer ID parameter in the query for deleting orders
                deleteOrdersStmt.setInt(1, customerID);

                int ordersDeleted = deleteOrdersStmt.executeUpdate(); // Execute the delete operation for orders

                if (ordersDeleted > 0) {
                    System.out.println("Orders associated with Customer ID " + customerID + " deleted successfully.");
                }

            } catch (SQLException e) {
                System.out.println("An error occurred while deleting orders: " + e.getMessage());
                e.printStackTrace();
                return; // Stop the delete process if there's an error deleting orders
            }

            // Step 2: Delete the customer
            String deleteCustomerQuery = "DELETE FROM Customer WHERE customer_id = ?";

            try (Connection conn = DatabaseConnectionManager.getConnection();
                 PreparedStatement deleteCustomerStmt = conn.prepareStatement(deleteCustomerQuery)) {

                // Set the customer ID parameter in the query for deleting the customer
                deleteCustomerStmt.setInt(1, customerID);

                int rowsAffected = deleteCustomerStmt.executeUpdate(); // Execute the delete operation for the customer

                if (rowsAffected > 0) {
                    System.out.println("Customer with ID " + customerID + " deleted successfully.");
                    // Optionally, show a confirmation alert
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Delete Customer");
                    alert.setHeaderText(null);
                    alert.setContentText("Customer deleted successfully.");
                    alert.showAndWait();

                    // Clear the fields after deletion
                    ClearCustomerSearchButton();
                } else {
                    System.out.println("No customer found with ID " + customerID);
                    // Optionally, show an alert that the customer was not found
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Delete Customer");
                    alert.setHeaderText(null);
                    alert.setContentText("No customer found with the provided ID.");
                    alert.showAndWait();
                }

            } catch (SQLException e) {
                System.out.println("An error occurred while deleting the customer: " + e.getMessage());
                e.printStackTrace();
            }

        } catch (NumberFormatException e) {
            System.out.println("Invalid Customer ID format.");
            // Optionally, show an alert to the user for invalid ID format
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Delete Customer");
            alert.setHeaderText(null);
            alert.setContentText("Please enter a valid numeric Customer ID.");
            alert.showAndWait();
        }
    }

    private void ClearCustomerSearchButton() {
        CustomerIDSearch.clear();
        CustomerFNameSearch.clear();
        CustomerMNameSearch.clear();
        CustomerLNameSearch.clear();
        CustomerEmailSearch.clear();
        CustomerPhoneSearch.clear();
        CustomerCountrySearch.clear();
        CustomerCitySearch.clear();
        CustomerStreetSearch.clear();
        CustomerGenderSearch.clear();
    }

    @FXML
    private void CustomerUpdateButton(ActionEvent event) {
        String customerIDStr = CustomerIDSearch.getText(); // Get the customer ID from the search field
        String firstName = CustomerFNameSearch.getText();
        String middleName = CustomerMNameSearch.getText();
        String lastName = CustomerLNameSearch.getText();
        String email = CustomerEmailSearch.getText();
        String phoneStr = CustomerPhoneSearch.getText();
        String city = CustomerCitySearch.getText();
        String country = CustomerCountrySearch.getText(); // Use CustomerCountrySearch for country input
        String street = CustomerStreetSearch.getText();
        String gender = CustomerGenderSearch.getText(); // Get gender from the gender field

// Check if CustomerIDSearch is not empty and is a valid number
        if (customerIDStr == null || customerIDStr.isEmpty()) {
            System.out.println("Error: Customer ID is required to update.");
            showAlert("Error", "Customer ID is required to update.");
            return;
        }

// Validate if customer_id is a number (to ensure it's a valid primary key)
        int customerID;
        try {
            customerID = Integer.parseInt(customerIDStr);
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid Customer ID format.");
            showAlert("Error", "Invalid Customer ID format.");
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

            // Prepare the SQL query to update the customer details with gender cast to gender_enum
            String updateQuery = "UPDATE Customer SET firstname = ?, middlename = ?, lastname = ?, email = ?, " +
                    "phone = ?, gender = CAST(? AS gender_enum), country = ?, city = ?, street = ? WHERE customer_id = ?";

            // Start the transaction
            connection.setAutoCommit(false);
            System.out.println("Transaction started."); // Debug statement

            try (PreparedStatement stmt = connection.prepareStatement(updateQuery)) {
                // Set the parameters for the query
                stmt.setString(1, firstName);
                stmt.setString(2, middleName);
                stmt.setString(3, lastName);
                stmt.setString(4, email);
                stmt.setInt(5, phone); // Set phone as integer
                stmt.setString(6, gender); // Set gender and cast in SQL query
                stmt.setString(7, country);
                stmt.setString(8, city);
                stmt.setString(9, street);
                stmt.setInt(10, customerID); // Set customer ID as integer

                // Execute the update query
                int rowsAffected = stmt.executeUpdate();
                System.out.println("Rows updated: " + rowsAffected); // Debug statement

                if (rowsAffected > 0) {
                    System.out.println("Customer updated successfully.");
                    showAlert("Success", "Customer details updated successfully.");
                } else {
                    System.out.println("Error: Customer not found.");
                    showAlert("Error", "Customer not found.");
                }

                // Commit the transaction if successful
                connection.commit();
                System.out.println("Transaction committed."); // Debug statement

            } catch (SQLException e) {
                System.out.println("Error updating customer: " + e.getMessage()); // Debug statement
                connection.rollback();  // Rollback the transaction if an error occurs
                System.out.println("Transaction rolled back."); // Debug statement
                showAlert("Error", "An error occurred while updating the customer.");
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

    //*****************************************************************************************************************//

    @FXML
    private ComboBox<String> SearchItemCombo;

    @FXML
    private TextField SearchItemField;

    @FXML
    private TextField ItemIDSearch;

    @FXML
    private TextField ItemNameSearch;

    @FXML
    private TextField ItemModelSearch;

    @FXML
    private TextField ItemPriceSearch;

//    @FXML
//    private TextField ItemSupplierIDSearch;

    @FXML
    private TextField ItemQuantityOrder;

    @FXML
    private Button SubmetOrder;

    @FXML
    private Button AddCart;

    @FXML
    private Button ClearOrderDetails;

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
    private void populateItemFields(ItemTableView item) {
        ItemIDSearch.setText(String.valueOf(item.itemIDProperty().get()));
        ItemNameSearch.setText(item.itemNameProperty().get());
        ItemPriceSearch.setText(String.valueOf(item.priceProperty().get()));
        ItemModelSearch.setText(String.valueOf(item.itemModelProperty().get()));
    }

    @FXML
    void AddCartButton(ActionEvent event) {

        // Check if an order has been created
        if (currentOrderId == -1) {
            showAlert("Error", "No active order. Please create an order first.");
            return;
        }

        // Get the item details from the text fields
        String itemIDText = ItemIDSearch.getText().trim();
        String priceText = ItemPriceSearch.getText().trim();
        String quantityText = ItemQuantityOrder.getText().trim();

        // Validate item details
        int itemID, quantity;
        double price;
        try {
            itemID = Integer.parseInt(itemIDText);
            price = Double.parseDouble(priceText);
            quantity = Integer.parseInt(quantityText);
        } catch (NumberFormatException e) {
            showAlert("Error", "Item ID, Price, and Quantity must be numeric.");
            return;
        }

        // Insert into Order_details using currentOrderId
        try (Connection conn = DatabaseConnectionManager.getConnection()) {
            PreparedStatement insertOrderDetailsStmt = conn.prepareStatement(
                    "INSERT INTO Order_details (order_id, item_id, price, quantity) VALUES (?, ?, ?, ?)");
            insertOrderDetailsStmt.setInt(1, currentOrderId);
            insertOrderDetailsStmt.setInt(2, itemID);
            insertOrderDetailsStmt.setDouble(3, price);
            insertOrderDetailsStmt.setInt(4, quantity);

            int rowsInserted = insertOrderDetailsStmt.executeUpdate();
            if (rowsInserted > 0) {
                showAlert("Success", "Item added to order successfully.");
            } else {
                showAlert("Error", "Failed to add item to order.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            showAlert("Database Error", "An error occurred while adding item to order in the database.");
        }
        ItemQuantityOrder.clear();
    }

    @FXML
    void ClearOrderDetailsButton(ActionEvent event) {
        ItemIDSearch.clear();
        ItemNameSearch.clear();
        ItemModelSearch.clear();
        ItemQuantityOrder.clear();
        ItemPriceSearch.clear();
    }

    @FXML
    void SubmetOrderButton(ActionEvent event) {
        showAlert("Order Submitted", "Your order has been submitted. Thank you for purchasing!");

        // Hide the ViewItemAnchor
        ViewItemAnchor.setVisible(false);

        // Display the CreateOrderAnchor
        CreateOrderAnchor.setVisible(true);

        // Reset any other states as needed (e.g., clearing form fields or resetting variables)
        currentOrderId = -1;

    }

    //**********************************************************************************************************//

    @FXML
    private ComboBox<String> OrderComboBox;

    @FXML
    private TextField OrderSearchField;

    @FXML
    private Button OrderSearch;

    @FXML
    private Button OrderViewAll;

    @FXML
    private TableView<OrderTableView> OrderTableView;

    @FXML
    private TableColumn<OrderTableView, Integer> OrderIDColumn;

    @FXML
    private TableColumn<OrderTableView, Integer> OrderCustomerIDColumn;


    @FXML
    private TableColumn<OrderTableView, Integer> OrderEmployeeIDColumn;

    @FXML
    private TableColumn<OrderTableView, Double> OrderTotalPriceColumn;

    @FXML
    private TableColumn<OrderTableView, String> OrderCreatedDateColumn;

    @FXML
    private TextField OrderIDSearch;

    @FXML
    private TextField OrderCustomerIDSearch;

    @FXML
    private TextField OrderTotalPriceSearch;

    @FXML
    private TextField OrderEmployeeIDSeach;

    @FXML
    void OrderSearchButton(ActionEvent event) {
        OrderTableView.getItems().clear();

        // Get the selected criteria and search input
        String searchCriteria = OrderComboBox.getValue();
        String searchField = OrderSearchField.getText().trim();

        if (searchCriteria == null || searchField.isEmpty()) {
            System.out.println("Search criteria not selected or search field is empty.");
            return;
        }

        ObservableList<OrderTableView> searchResults = FXCollections.observableArrayList();

        // Build the SQL query based on the selected criteria
        String query = buildOrderSearchQuery(searchCriteria);
        System.out.println("Executing query: " + query);

        try (Connection conn = DatabaseConnectionManager.getConnection();
             PreparedStatement statement = conn.prepareStatement(query)) {

            // Set the parameter based on search criteria
            if ("OrderID".equals(searchCriteria) || "CustomerID".equals(searchCriteria) || "EmployeeID".equals(searchCriteria)) {
                // For numeric values like OrderID, CustomerID, and EmployeeID
                statement.setInt(1, Integer.parseInt(searchField));
            } else {
                System.out.println("Invalid search criteria.");
                return;
            }

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int orderID = resultSet.getInt("order_id");
                int customerID = resultSet.getInt("customer_id");
                int employeeID = resultSet.getInt("employee_id");
                String createdDate = resultSet.getString("created_date");
                double totalPrice = resultSet.getDouble("total_price");

                // Create an OrderTableView object and add it to the search results
                OrderTableView order = new OrderTableView(orderID, customerID, employeeID, createdDate, totalPrice);
                searchResults.add(order);
                System.out.println("Order found: " + order); // Debugging: Print order details
            }

            if (searchResults.isEmpty()) {
                System.out.println("No results found for the search criteria.");
            } else {
                OrderTableView.setItems(searchResults);
                System.out.println("Displaying search results in table.");
            }

        } catch (SQLException e) {
            System.out.println("An error occurred while searching for orders: " + e.getMessage());
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Invalid input for numeric fields: " + e.getMessage());
        }
    }

    private String buildOrderSearchQuery(String searchCriteria) {
        // Use backticks to escape "Orders" table name as it contains the reserved word "Order"
        String baseQuery = "SELECT order_id, customer_id, employee_id, created_date, total_price FROM \"Order\"  WHERE ";
        switch (searchCriteria) {
            case "OrderID":
                return baseQuery + "order_id = ?";
            case "CustomerID":
                return baseQuery + "customer_id = ?";
            case "EmployeeID":
                return baseQuery + "employee_id = ?";
            default:
                return null;
        }
    }

    @FXML
    void OrderViewAll(ActionEvent event){
        // Clear any previous results in the table
        OrderTableView.getItems().clear();

        // Create an observable list to store all order data
        ObservableList<OrderTableView> allOrders = FXCollections.observableArrayList();

        // SQL query to retrieve all orders from the database
        String query = "SELECT order_id, customer_id, employee_id, created_date, total_price FROM \"Order\"";

        try (Connection conn = DatabaseConnectionManager.getConnection();
             PreparedStatement statement = conn.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            // Iterate through the result set and create OrderTableView objects
            while (resultSet.next()) {
                OrderTableView order = new OrderTableView(
                        resultSet.getInt("order_id"),
                        resultSet.getInt("customer_id"),
                        resultSet.getInt("employee_id"),
                        resultSet.getString("created_date"),
                        resultSet.getDouble("total_price")
                );

                // Add the order object to the list of all orders
                allOrders.add(order);
            }

            // Populate the TableView with the list of orders
            if (allOrders.isEmpty()) {
                System.out.println("No orders found.");
            } else {
                OrderTableView.setItems(allOrders);
                System.out.println("Displaying all orders in table.");
            }

        } catch (SQLException e) {
            // Handle potential errors with the database
            System.out.println("An error occurred while retrieving all orders: " + e.getMessage());
            e.printStackTrace();
        }


    }

    private void populateOrderFields(OrderTableView order) {
        OrderIDSearch.setText(String.valueOf(order.getOrderID()));
        OrderCustomerIDSearch.setText(String.valueOf(order.getCustomerID()));
        OrderEmployeeIDSeach.setText(String.valueOf(order.getEmployeeID()));
        OrderTotalPriceSearch.setText(String.format("%.2f", order.getTotalPrice()));
    }

    @FXML
    void DeleteOrderButton(ActionEvent event){
        String orderIDText = OrderIDSearch.getText().trim();

        // Check if the OrderID field is not empty
        if (orderIDText.isEmpty()) {
            System.out.println("Order ID is required for deletion.");
            return;
        }

        try {
            int orderID = Integer.parseInt(orderIDText);

            // SQL query to delete the order based on the order ID
            String query = "DELETE FROM \"Order\" WHERE order_id = ?";

            // Establish database connection
            try (Connection conn = DatabaseConnectionManager.getConnection();
                 PreparedStatement statement = conn.prepareStatement(query)) {

                // Set the order ID in the prepared statement
                statement.setInt(1, orderID);

                // Execute the delete statement and check if any rows were affected
                int rowsAffected = statement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Order with ID " + orderID + " has been deleted successfully.");

                    // Optionally clear the field and refresh the table
                    OrderIDSearch.clear();
                    OrderViewAll(null);  // Refresh the table view
                } else {
                    System.out.println("Order with ID " + orderID + " does not exist.");
                }

            } catch (SQLException e) {
                System.out.println("An error occurred while deleting the order: " + e.getMessage());
                e.printStackTrace();
            }

        } catch (NumberFormatException e) {
            System.out.println("Invalid Order ID format. Please enter a numeric value.");
        }

    }

    @FXML
    void OrderDetailsGoToButton(ActionEvent event){
        hideAllAnchors();

        // Show only the OrderDetailsAnchor
        OrderDetailsAnchor.setVisible(true);
    }

    @FXML
    void ClearORderFieldsButton(ActionEvent event) {
        // Clear the text fields
        OrderIDSearch.clear();
        OrderCustomerIDSearch.clear();
        OrderTotalPriceSearch.clear();
        OrderEmployeeIDSeach.clear();

        System.out.println("Order fields have been cleared.");
    }

    @FXML
    private Button OrderDetailsGoTo;

    @FXML
    private Button DeleteOrder;

    @FXML
    private Button ClearOrderFields;

    //*********************************************************************************************************//

    @FXML
    private TextField EnterOrderID;

    @FXML
    private  Button ShowOrderDetails;

    @FXML
    private TableView<OrderDetailsTableView> OrderDetailsTableView;

    @FXML
    private TableColumn<OrderDetailsTableView, Integer> OrderDetailsIDColumn;

    @FXML
    private TableColumn<OrderDetailsTableView, Integer> OrderDetailsOrderIDColumn;

    @FXML
    private TableColumn<OrderDetailsTableView, Integer> OrderDetailsItemIDColumn;

    @FXML
    private TableColumn<OrderDetailsTableView, Double> OrderDetailsPriceColumn;

    @FXML
    private TableColumn<OrderDetailsTableView, Double> OrderDetailsTotalPriceColumn;

    @FXML
    private TableColumn<OrderDetailsTableView, Integer> OrderDetailsQuantitycolumn;


    @FXML
    void ShowOrderDetailsButton(ActionEvent event){
        String orderIDText = OrderIDSearch.getText().trim();
        EnterOrderID.setText(orderIDText);


        if (orderIDText.isEmpty()) {
            showAlert("Input Error", "Please enter an Order ID to search.");
            return;
        }

        int orderID;
        try {
            orderID = Integer.parseInt(orderIDText);
        } catch (NumberFormatException e) {
            showAlert("Invalid Input", "Invalid Order ID format. Please enter a numeric value.");
            return;
        }

        // Clear existing items from the table view
        OrderDetailsTableView.getItems().clear();

        // Retrieve the order details from the database
        String query = "SELECT order_details_id, order_id, item_id, price, quantity, total_price FROM order_details WHERE order_id = ?";

        try (Connection connection = DatabaseConnectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, orderID);
            ResultSet resultSet = preparedStatement.executeQuery();

            // Check if any order details were found
            boolean hasResults = false;
            while (resultSet.next()) {
                hasResults = true;

                // Retrieve each field and create an OrderDetailsTableView object
                int orderDetailsID = resultSet.getInt("order_details_id");
                int retrievedOrderID = resultSet.getInt("order_id");
                int itemID = resultSet.getInt("item_id");
                double price = resultSet.getDouble("price");
                int quantity = resultSet.getInt("quantity");
                double totalPrice = resultSet.getDouble("total_price");

                // Add the data to the table view
                OrderDetailsTableView orderDetails = new OrderDetailsTableView(orderDetailsID, retrievedOrderID, itemID, price, quantity, totalPrice);
                OrderDetailsTableView.getItems().add(orderDetails);
            }

            if (!hasResults) {
                showAlert("No Results", "No order details found for Order ID " + orderID);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            showAlert("Database Error", "Error fetching order details: " + e.getMessage());
        }
    }

    @FXML
    private CategoryAxis CustomerNameXAxsis;

    @FXML
    private NumberAxis OrderNumberYAxis;

    //****************************************************************************//
    @FXML
    private Button Reports;

    @FXML
    private Button ItemSales;

    @FXML
    private Button EmployeeAchievements;

    @FXML
    void ReportsButton(ActionEvent event){
        hideAllAnchors();

        ReportsAnchor.setVisible(true);

    }

    @FXML
    void EmployeeAchievementsButton(ActionEvent event){
        try {
            // Get a database connection using DatabaseConnectionManager
            Connection con = DatabaseConnectionManager.getConnection();

            // Load the .jrxml file as an InputStream
            InputStream inp = getClass().getResourceAsStream("Cherry.jrxml");

            // Compile the JasperDesign into a JasperReport
            JasperDesign jd = JRXmlLoader.load(inp);
            JasperReport jr = JasperCompileManager.compileReport(jd);

            // Fill the report with data from the database
            JasperPrint jp = JasperFillManager.fillReport(jr, null, con);

            // Define the output PDF file path
            OutputStream os = new FileOutputStream(new File("rep.pdf"));


            // Export the report to a PDF file
            //JasperExportManager.exportReportToPdfStream(jp, os);

            // Display a confirmation dialog
            JOptionPane.showMessageDialog(null, "SalesCount Report Generated Successfully", "Report", JOptionPane.INFORMATION_MESSAGE);
            JFrame frame = new JFrame("report");
             // Set the size of the frame (Width: 800, Height: 600)
            frame.getContentPane().add(new JRViewer(jp));
            frame.pack();
            frame.setVisible(true);
            frame.setSize(1100, 800);
            // Close all resources
            os.close();
            inp.close();
            DatabaseConnectionManager.closeConnection();

        } catch (JRException | SQLException | IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error generating report: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }


    }

        @FXML
        void ItemSalesButton(ActionEvent event){
            try {
                // Get a database connection using DatabaseConnectionManager
                Connection con = DatabaseConnectionManager.getConnection();

                // Load the .jrxml file as an InputStream
                InputStream inp = getClass().getResourceAsStream("iteminfo.jrxml");

                // Compile the JasperDesign into a JasperReport
                JasperDesign jd = JRXmlLoader.load(inp);
                JasperReport jr = JasperCompileManager.compileReport(jd);

                // Fill the report with data from the database
                JasperPrint jp = JasperFillManager.fillReport(jr, null, con);

                // Define the output PDF file path
                OutputStream os = new FileOutputStream(new File("rep.pdf"));


                // Export the report to a PDF file
                //JasperExportManager.exportReportToPdfStream(jp, os);

                // Display a confirmation dialog
                JOptionPane.showMessageDialog(null, "SalesCount Report Generated Successfully", "Report", JOptionPane.INFORMATION_MESSAGE);
                JFrame frame = new JFrame("report");
                // Set the size of the frame (Width: 800, Height: 600)
                frame.getContentPane().add(new JRViewer(jp));
                frame.pack();
                frame.setVisible(true);
                frame.setSize(1100, 800);
                // Close all resources
                os.close();
                inp.close();
                DatabaseConnectionManager.closeConnection();

            } catch (JRException | SQLException | IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error generating report: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }


        }





//        @FXML
//        void ItemReportButton(ActionEvent event)throws SQLException, IOException, JRException {
//            Connection con=DatabaseConnectionManager.getConnection();
//            InputStream inp=new FileInputStream(new File("Cherry_1.jrxml"));
//            JasperDesign jd= JRXmlLoader.load(inp);
//            JasperReport jr= JasperCompileManager.compileReport(jd);
//            JasperPrint jp= JasperFillManager.fillReport(jr, null, con);
//            OutputStream os=new FileOutputStream(new File("rep.pdf"));
//            JasperExportManager.exportReportToPdfStream(jp, os);
//            JOptionPane.showMessageDialog(null,"SalesCount Report Generated Succsessfully ","Report",JOptionPane.INFORMATION_MESSAGE);
//            os.close();
//            con.close();
//            inp.close();
//
//
//        }


















}

