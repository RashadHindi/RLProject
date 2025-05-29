package org.example.rlproject;
import javafx.beans.property.*;

public class ItemTableView {
    private IntegerProperty itemID;
    private StringProperty itemName;
    private StringProperty itemModel;
    private IntegerProperty stockQuantity;
    private DoubleProperty price;
    private IntegerProperty supplierID;

    public ItemTableView(int itemID, String itemName, String itemModel, int stockQuantity, double price, int supplierID) {
        this.itemID = new SimpleIntegerProperty(itemID);
        this.itemName = new SimpleStringProperty(itemName);
        this.itemModel = new SimpleStringProperty(itemModel);
        this.stockQuantity = new SimpleIntegerProperty(stockQuantity);
        this.price = new SimpleDoubleProperty(price);
        this.supplierID = new SimpleIntegerProperty(supplierID);
    }

    public IntegerProperty itemIDProperty() { return itemID; }
    public StringProperty itemNameProperty() { return itemName; }
    public StringProperty itemModelProperty() { return itemModel; }
    public IntegerProperty stockQuantityProperty() { return stockQuantity; }
    public DoubleProperty priceProperty() { return price; }
    public IntegerProperty supplierIDProperty() { return supplierID; }

    public void setItemID(int itemID) { this.itemID.set(itemID); }
    public void setItemName(String itemName) { this.itemName.set(itemName); }
    public void setItemModel(String itemModel) { this.itemModel.set(itemModel); }
    public void setStockQuantity(int stockQuantity) { this.stockQuantity.set(stockQuantity); }
    public void setPrice(double price) { this.price.set(price); }
    public void setSupplierID(int supplierID) { this.supplierID.set(supplierID); }

    public int getItemID() { return itemID.get(); }
    public String getItemName() { return itemName.get(); }
    public String getItemModel() { return itemModel.get(); }
    public int getStockQuantity() { return stockQuantity.get(); }
    public double getPrice() { return price.get(); }
    public int getSupplierID() { return supplierID.get(); }
}
