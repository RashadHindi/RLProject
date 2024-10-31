package org.example.rlproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.sql.*;

public class AdminController {
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
    private AnchorPane ViewSupplierAnchor;

    @FXML
    private TextField ZipCode;

    @FXML
    private TextField ZipCodeAdmin;

    @FXML
    private TextField ZipCodeFIeld;

    @FXML
    public void initialize() {
        hideAllAnchors();           // Hide all anchors
        HomeAnchore.setVisible(true);  // Show only the HomeAnchor by default
        updateHomeLabels();          // Populate labels with database counts
    }

    @FXML
    void AddEmployee(ActionEvent event) {

    }

    @FXML
    void AddItemButton(ActionEvent event) {

    }

    @FXML
    void AddSupplierButton(ActionEvent event) {

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

    }

    @FXML
    void SaveAdminButton(ActionEvent event) {

    }

    @FXML
    void SaveEmployeeButton(ActionEvent event) {

    }

    @FXML
    void SaveItemButton(ActionEvent event) {

    }

    @FXML
    void SaveSupplierButton(ActionEvent event) {

    }

    @FXML
    void ViewEmployeeButton(ActionEvent event) {

    }

    @FXML
    void ViewItemButton(ActionEvent event) {

    }

    @FXML
    void ViewSupplierButton(ActionEvent event) {

    }

}
