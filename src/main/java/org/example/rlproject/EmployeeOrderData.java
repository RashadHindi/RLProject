package org.example.rlproject;
import javafx.beans.property.*;

public class EmployeeOrderData {
    private StringProperty employeeName;
    private IntegerProperty orderCount;

    public EmployeeOrderData(String employeeName, int orderCount) {
        this.employeeName = new SimpleStringProperty(employeeName);
        this.orderCount = new SimpleIntegerProperty(orderCount);
    }

    // Property getters for chart binding
    public StringProperty employeeNameProperty() { return employeeName; }
    public IntegerProperty orderCountProperty() { return orderCount; }

    // Regular getters
    public String getEmployeeName() { return employeeName.get(); }
    public int getOrderCount() { return orderCount.get(); }

    // Setters
    public void setEmployeeName(String employeeName) { this.employeeName.set(employeeName); }
    public void setOrderCount(int orderCount) { this.orderCount.set(orderCount); }
}
