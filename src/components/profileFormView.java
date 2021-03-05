package components;

import controller.customer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import sample.Main;

public class profileFormView extends GridPane {
    Label nameLabel, cityLabel, addressLabel, phoneNumberLabel, debtMoneyLabel, commentLabel;
    Label name, city, phone, debtMoney;
    Label comment,address;

    public profileFormView(BorderPane parent, customer c, Stage primaryStage) {
        super();

        getStylesheets().add
                (Main.class.getResource("style.css").toExternalForm());
        getStyleClass().add("label-profile");
//        setAlignment(Pos.CENTER);
        setHgap(40);
        setVgap(30);
        setPadding(new Insets(30, 25, 25, 0));

        nameLabel=new Label("Name: ");
        add(nameLabel,0,0);
        nameLabel.setTextFill(Color.web("#2185d0"));
        name =new Label(c.getName());
        add(name,1,0);


        cityLabel=new Label("City: ");
        add(cityLabel,0,1);
        cityLabel.setTextFill(Color.web("#2185d0"));

        city =new Label(c.getCity());
        add(city,1,1);

        phoneNumberLabel=new Label("Phone Number: ");
        add(phoneNumberLabel,0,2);
        phoneNumberLabel.setTextFill(Color.web("#2185d0"));

        phone =new Label(c.getPhoneNumber());
        add(phone,1,2);

        debtMoneyLabel=new Label("Debt: ");
        add(debtMoneyLabel,0,3);
        debtMoneyLabel.setTextFill(Color.web("#2185d0"));

        debtMoney =new Label(c.getDebtMoney()+"");
        add(debtMoney,1,3);

        addressLabel =new Label("Address: ");
        add(addressLabel,0,4);
        addressLabel.setTextFill(Color.web("#2185d0"));

        address =new Label(c.getAddress());
        add(address,1,4);

        commentLabel =new Label("Comment: ");
        add(commentLabel,0,5);
        commentLabel.setTextFill(Color.web("#2185d0"));

        comment =new Label(c.getComment());
        add(comment,1,5);
        Button edit=new Button("Edit");
        edit.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                GridPane centrePane=new profieFormEdit(parent,primaryStage,c);
                parent.setCenter(centrePane);
                parent.setMargin(centrePane,new Insets(10,0,0,100));
            }
        });
        add(edit,3,7);
    }
}
