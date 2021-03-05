package components;

import Panes.customerPane;
import controller.customer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class CreateCustomer extends GridPane {
    TextField nameTextField;
    TextArea addressTextField;
    TextField cityTextField;
    TextField phoneNumberTextField;
    TextArea commentTextField;

    public CreateCustomer(TextField filter) {
        super();

        setAlignment(Pos.CENTER);
        setHgap(10);
        setVgap(10);
        setPadding(new Insets(25, 25, 25, 25));


        Text sceneTitle = new Text("Add new customer");
        sceneTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        add(sceneTitle, 0, 0, 1, 1);

        Label userName = new Label("Name");
        add(userName, 0, 1);

        nameTextField = new TextField();
        add(nameTextField, 1, 1);

        Label phoneNumber = new Label("Phone number");

        add(phoneNumber, 0, 2);

        phoneNumberTextField = new TextField();
        add(phoneNumberTextField, 1, 2);

        Label city = new Label("City");

        add(city, 0, 3);


        cityTextField = new TextField();
        add(cityTextField, 1, 3);



        Label address = new Label("Address");

        add(address, 0, 4);

        addressTextField = new TextArea();
        add(addressTextField, 1, 4);

        Label comment = new Label("comment");

        add(comment, 0, 5);

        commentTextField = new TextArea();
        commentTextField.maxWidth(50);
        commentTextField.maxHeight(50);
        commentTextField.minHeight(50);
        commentTextField.prefWidth(50);

        add(commentTextField, 1, 5);


        Button btn = new Button("Submit");

        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().addAll(btn);
        //    hbBtn.getChildren().add(btn);

        add(hbBtn, 1, 7);
        HBox hbErr = new HBox(10);
        Text error = new Text("");
        hbErr.getChildren().addAll(error);
        hbErr.setAlignment(Pos.BOTTOM_RIGHT);
        error.setFill(Color.web("#cc0000"));
        add(hbErr, 1, 6);
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(customerPane.customerSet.contains(nameTextField.getText()))
                    error.setText("name is already taken");
                else if (nameTextField.getText().equals(""))
                    error.setText("name is empty");
                else if (addressTextField.getText().equals(""))
                    error.setText("address is empty");
                else if (cityTextField.getText().equals(""))
                    error.setText("city is empty");
                else if (phoneNumberTextField.getText().equals(""))
                    error.setText("phone number is empty");
                else {

                    customer c = new customer(
                            nameTextField.getText(), cityTextField.getText()
                            , addressTextField.getText(), phoneNumberTextField.getText()
                            , 0, commentTextField.getText()
                    );
                    customerPane.customersClone.add(c);
                    System.out.println(nameTextField.getText());
                    System.out.println(filter.getText());

                    if (isSubstring(nameTextField.getText(), filter.getText())) {
                        customerPane.customers.add(c);

                    }
                    error.setText("");
                    clean();
                }

            }
        });


    }

    public void clean() {
        nameTextField.setText("");
        addressTextField.setText("");
        cityTextField.setText("");
        phoneNumberTextField.setText("");
        commentTextField.setText("");
    }

    public static boolean isSubstring(String str, String sub) {
        int n = str.length();
        int m = sub.length();
        str = str.toLowerCase();
        sub = sub.toLowerCase();
        for (int i = 0; i < n - m + 1; i++) {
            if (str.substring(i, i + m).equals(sub))
                return true;
        }
        return false;
    }

}
