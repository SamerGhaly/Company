package components;

import Panes.customerPane;
import Panes.profilePane;
import controller.customer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sample.Main;

public class profieFormEdit extends GridPane {
    Label nameLabel, cityLabel, addressLabel, phoneNumberLabel, debtMoneyLabel, commentLabel;
    TextField nameTextField, cityTextField, phoneTextField, debtMoneyTextField;
    TextArea commentTextArea, addressTextField;

    public profieFormEdit(BorderPane parent, Stage primaryStage, customer c) {
        super();
        getStylesheets().add
                (Main.class.getResource("style.css").toExternalForm());
        getStyleClass().add("label-profile");
//        setAlignment(Pos.CENTER);
        setHgap(40);
        setVgap(30);
        setPadding(new Insets(30, 25, 25, 0));

        nameLabel = new Label("Name: ");
        add(nameLabel, 0, 0);
        nameLabel.setTextFill(Color.web("#2185d0"));

        nameTextField = new TextField(c.getName());
        add(nameTextField, 1, 0);


        cityLabel = new Label("City: ");
        add(cityLabel, 0, 1);
        cityLabel.setTextFill(Color.web("#2185d0"));

        cityTextField = new TextField(c.getCity());
        add(cityTextField, 1, 1);

        phoneNumberLabel = new Label("Phone Number: ");
        add(phoneNumberLabel, 0, 2);
        phoneNumberLabel.setTextFill(Color.web("#2185d0"));

        phoneTextField = new TextField(c.getPhoneNumber());
        add(phoneTextField, 1, 2);

        debtMoneyLabel = new Label("Debt: ");
        add(debtMoneyLabel, 0, 3);
        debtMoneyLabel.setTextFill(Color.web("#2185d0"));

        debtMoneyTextField = new TextField(c.getDebtMoney() + "");
        add(debtMoneyTextField, 1, 3);

        addressLabel = new Label("Address: ");
        add(addressLabel, 0, 4);
        addressLabel.setTextFill(Color.web("#2185d0"));

        addressTextField = new TextArea(c.getAddress());
        add(addressTextField, 1, 4);

        commentLabel = new Label("Comment: ");
        add(commentLabel, 0, 5);
        commentLabel.setTextFill(Color.web("#2185d0"));

        commentTextArea = new TextArea(c.getComment());
        add(commentTextArea, 1, 5);


        Button submit = new Button("Submit");
        GridPane me = this;

        Text nameTakenError = new Text("name is already taken");
        nameTakenError.setFill(Color.web("#cc0000"));
        add(nameTakenError, 3, 0);
        nameTakenError.setVisible(false);

        Text nameError = new Text("name is empty");
        nameError.setFill(Color.web("#cc0000"));
        add(nameError, 3, 0);
        nameError.setVisible(false);

        Text cityError = new Text("city is empty");
        cityError.setFill(Color.web("#cc0000"));
        add(cityError, 3, 1);
        cityError.setVisible(false);


        Text phoneError = new Text("phone number is empty");
        phoneError.setFill(Color.web("#cc0000"));
        add(phoneError, 3, 2);
        phoneError.setVisible(false);

        Text addressError = new Text("address is empty");
        addressError.setFill(Color.web("#cc0000"));
        add(addressError, 3, 4);
        addressError.setVisible(false);

        Text debtError = new Text("debt is invalid ");
        debtError.setFill(Color.web("#cc0000"));
        add(debtError, 3, 3);
        debtError.setVisible(false);


        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    boolean canBeEdited = true;
                    if (!nameTextField.getText().equals(c.getName()) && customerPane.customerSet.contains(nameTextField.getText())) {
                        nameTakenError.setVisible(true);
                        canBeEdited = false;
                    } else if (nameTextField.getText().equals("")) {
                        nameTakenError.setVisible(false);
                        nameError.setVisible(true);
                        canBeEdited = false;

                    } else {
                        nameError.setVisible(false);

                    }

                    if (cityTextField.getText().equals("")) {
                        cityError.setVisible(true);
                        canBeEdited = false;

                    } else {
                        cityError.setVisible(false);

                    }
                    if (phoneTextField.getText().equals("")) {
                        phoneError.setVisible(true);
                        canBeEdited = false;

                    } else phoneError.setVisible(false);

                    if (addressTextField.getText().equals("")) {
                        addressError.setVisible(true);
                        canBeEdited = false;
                    } else addressError.setVisible(false);

                    try {
                        Double.parseDouble(debtMoneyTextField.getText());
                        debtError.setVisible(false);
                        if (canBeEdited) {
                            c.setName(nameTextField.getText());
                            c.setCity(cityTextField.getText());
                            c.setAddress(addressTextField.getText());
                            c.setComment(commentTextArea.getText());
                            c.setPhoneNumber(phoneTextField.getText());
                            c.setDebtMoney(Double.parseDouble(debtMoneyTextField.getText()));
                            ((profilePane) parent).nameLabel.setText(c.getName());
                            GridPane centrePane = new profileFormView(parent, c, primaryStage);
                            parent.setCenter(centrePane);
                            parent.setMargin(centrePane, new Insets(10, 0, 0, 100));
                        }

                    } catch (Exception e) {
                        debtError.setVisible(true);
                    }

                } catch (Exception a) {
                    System.out.println("there is a problem in Edit profile");
                    System.out.println(a.getMessage());
                }
            }
        });
        add(submit, 3, 7);

    }
}
