package org.example.rlproject;
import javafx.beans.property.*;

public class OrderDetailsTableView {
    private IntegerProperty orderDetailsID;
    private IntegerProperty orderID;
    private IntegerProperty itemID;
    private DoubleProperty price;
    private IntegerProperty quantity;
    private DoubleProperty totalPrice;

    public OrderDetailsTableView(int orderDetailsID, int orderID, int itemID, double price, int quantity, double totalPrice) {
        this.orderDetailsID = new SimpleIntegerProperty(orderDetailsID);
        this.orderID = new SimpleIntegerProperty(orderID);
        this.itemID = new SimpleIntegerProperty(itemID);
        this.price = new SimpleDoubleProperty(price);
        this.quantity = new SimpleIntegerProperty(quantity);
        this.totalPrice = new SimpleDoubleProperty(totalPrice);
    }

    // Property getters for binding
    public IntegerProperty orderDetailsIDProperty() { return orderDetailsID; }
    public IntegerProperty orderIDProperty() { return orderID; }
    public IntegerProperty itemIDProperty() { return itemID; }
    public DoubleProperty priceProperty() { return price; }
    public IntegerProperty quantityProperty() { return quantity; }
    public DoubleProperty totalPriceProperty() { return totalPrice; }

    // Setters
    public void setOrderDetailsID(int orderDetailsID) { this.orderDetailsID.set(orderDetailsID); }
    public void setOrderID(int orderID) { this.orderID.set(orderID); }
    public void setItemID(int itemID) { this.itemID.set(itemID); }
    public void setPrice(double price) { this.price.set(price); }
    public void setQuantity(int quantity) { this.quantity.set(quantity); }
    public void setTotalPrice(double totalPrice) { this.totalPrice.set(totalPrice); }

    // Getters
    public int getOrderDetailsID() { return orderDetailsID.get(); }
    public int getOrderID() { return orderID.get(); }
    public int getItemID() { return itemID.get(); }
    public double getPrice() { return price.get(); }
    public int getQuantity() { return quantity.get(); }
    public double getTotalPrice() { return totalPrice.get(); }

}
