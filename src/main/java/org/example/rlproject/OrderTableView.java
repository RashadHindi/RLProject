package org.example.rlproject;
import javafx.beans.property.*;
import java.time.LocalDate;

public class OrderTableView {
    private IntegerProperty orderID;
    private IntegerProperty customerID;
    private IntegerProperty employeeID;
    private StringProperty createdDate;
    private DoubleProperty totalPrice;

    public OrderTableView(int orderID, int customerID, int employeeID, String createdDate, double totalPrice) {
        this.orderID = new SimpleIntegerProperty(orderID);
        this.customerID = new SimpleIntegerProperty(customerID);
        this.employeeID = new SimpleIntegerProperty(employeeID);
        this.createdDate = new SimpleStringProperty(createdDate);
        this.totalPrice = new SimpleDoubleProperty(totalPrice);
    }

    // Property getters
    public IntegerProperty orderIDProperty() { return orderID; }
    public IntegerProperty customerIDProperty() { return customerID; }
    public IntegerProperty employeeIDProperty() { return employeeID; }
    public StringProperty createdDateProperty() { return createdDate; }
    public DoubleProperty totalPriceProperty() { return totalPrice; }

    // Setters
    public void setOrderID(int orderID) { this.orderID.set(orderID); }
    public void setCustomerID(int customerID) { this.customerID.set(customerID); }
    public void setEmployeeID(int employeeID) { this.employeeID.set(employeeID); }
    public void setCreatedDate(String createdDate) { this.createdDate.set(createdDate); }
    public void setTotalPrice(double totalPrice) { this.totalPrice.set(totalPrice); }

    // Getters
    public int getOrderID() { return orderID.get(); }
    public int getCustomerID() { return customerID.get(); }
    public int getEmployeeID() { return employeeID.get(); }
    public String getCreatedDate() { return createdDate.get(); }
    public double getTotalPrice() { return totalPrice.get(); }

}
