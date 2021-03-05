package controller;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class ProductPriceQuantity {
    SimpleStringProperty productName;
    SimpleDoubleProperty productPrice;
    SimpleIntegerProperty productQuantity;

    public ProductPriceQuantity(String productName, Double productPrice, int productQuantity) {
        this.productName = new SimpleStringProperty(productName);
        this.productPrice = new SimpleDoubleProperty(productPrice);
        this.productQuantity = new SimpleIntegerProperty(productQuantity);
    }

    public String getProductName() {
        return productName.get();
    }

    public SimpleStringProperty productNameProperty() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName.set(productName);
    }

    public double getProductPrice() {
        return productPrice.get();
    }

    public SimpleDoubleProperty productPriceProperty() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice.set(productPrice);
    }

    public int getProductQuantity() {
        return productQuantity.get();
    }

    public SimpleIntegerProperty productQuantityProperty() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity.set(productQuantity);
    }
}
