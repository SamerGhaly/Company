package controller;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableSet;
import javafx.scene.control.DatePicker;

import java.time.LocalDate;
import java.util.Date;

import static java.time.LocalDate.of;


public class Bill {
    ObservableList<ProductPriceQuantity> products;
    LocalDate date;
    SimpleDoubleProperty MoneyPaid;

    public Bill() {
        this.products = FXCollections.observableArrayList();
        MoneyPaid =new SimpleDoubleProperty( 0);

    }
    public void addProduct(String name,Double price,int quantity){
        products.add(new ProductPriceQuantity(name,price,quantity));
    }
    public ObservableList<ProductPriceQuantity> getProducts() {
        return products;
    }

    public void setProducts(ObservableList<ProductPriceQuantity> products) {
        this.products = products;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setDate(String date) {
        Integer day=Integer.parseInt(date.substring(0,2));
        Integer month=Integer.parseInt(date.substring(3,5));
        Integer year=Integer.parseInt(date.substring(6,10));
        this.date=of(year,month,day);
    }

    public double getMoneyPaid() {
        return MoneyPaid.get();
    }

    public SimpleDoubleProperty moneyPaidProperty() {
        return MoneyPaid;
    }

    public void setMoneyPaid(double moneyPaid) {
        this.MoneyPaid.set(moneyPaid);
    }

}
