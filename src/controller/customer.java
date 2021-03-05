package controller;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class customer {
    SimpleStringProperty name;
    SimpleStringProperty city;
    SimpleStringProperty address;
    SimpleStringProperty phoneNumber;
    SimpleDoubleProperty debtMoney;
    SimpleStringProperty comment;

    public customer(String name, String city, String address, String phoneNumber, double debtMoney, String comment) {
        this.name = new SimpleStringProperty(name);
        this.city = new SimpleStringProperty(city);
        this.address = new SimpleStringProperty(address);
        this.phoneNumber = new SimpleStringProperty(phoneNumber);
        this.debtMoney = new SimpleDoubleProperty(debtMoney);
        this.comment = new SimpleStringProperty(comment);

    }

    public double getDebtMoney() {
        return debtMoney.get();
    }


    public void setDebtMoney(double debtMoney) {
        this.debtMoney.set(debtMoney);
    }

    public String getComment() {
        return comment.get();
    }


    public void setComment(String comment) {
        this.comment.set(comment);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getCity() {
        return city.get();
    }


    public void setCity(String city) {
        this.city.set(city);
    }

    public String getAddress() {
        return address.get();
    }


    public void setAddress(String address) {
        this.address.set(address);
    }

    public String getPhoneNumber() {
        return phoneNumber.get();
    }


    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber.set(phoneNumber);
    }
}
