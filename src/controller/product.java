package controller;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class product {
    SimpleDoubleProperty productionPrice;
    SimpleDoubleProperty clientPrice;
    SimpleStringProperty name;

    @Override
    public String toString() {
        return "product{" +
                "price=" + productionPrice +
                ", name=" + name +
                ", quantity=" + quantity +
                '}';
    }

    SimpleIntegerProperty quantity;

    public product(double productionPrice, String name, int quantity, double clientPrice) {
        this.productionPrice = new SimpleDoubleProperty(productionPrice);
        this.name = new SimpleStringProperty(name);
        this.quantity = new SimpleIntegerProperty(quantity);
        this.clientPrice = new SimpleDoubleProperty(clientPrice);
    }

    public double getClientPrice() {
        return clientPrice.get();
    }


    public void setClientPrice(double clientPrice) {
        this.clientPrice.set(clientPrice);
    }

    public Double getProductionPrice() {
        return productionPrice.get();
    }

    public void setProductionPrice(Double productionPrice) {
        this.productionPrice.set(productionPrice);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public int getQuantity() {
        return quantity.get();
    }

    public void setQuantity(int quantity) {
        this.quantity.set(quantity);
    }
}
