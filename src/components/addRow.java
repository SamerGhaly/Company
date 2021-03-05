package components;

import Panes.StoragePane;
import controller.product;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class addRow extends HBox {
    public static void clean() {
        nameField.setText("");
        priceField.setText("");
        quantityField.setText("");
        clientField.setText("");
        error.setVisible(false);
    }

    static TextField nameField, priceField, quantityField, clientField;
    static Label error;

    public addRow() {
        nameField = new TextField();
        nameField.setPromptText("Name"); //to set the hint text
        nameField.setPrefWidth(300);

        priceField = new TextField();
        priceField.setPromptText("Production Price"); //to set the hint text
        priceField.setPrefWidth(300);

        clientField = new TextField();
        clientField.setPromptText("client Price"); //to set the hint text
        clientField.setPrefWidth(300);

        quantityField = new TextField();
        quantityField.setPromptText("Quantity"); //to set the hint text
        quantityField.setPrefWidth(300);
        VBox vBox = new VBox();

        Button addProduct = new Button("Add Product");

        error = new Label("try again");
        error.setFont(new Font("Arial", 14));
        error.setTextFill(Color.web("#cc0000"));
        error.setPadding(new Insets(5, 0, 0, 0));
        error.setVisible(false);

        vBox.getChildren().addAll(addProduct, error);
        vBox.setMargin(addProduct, new Insets(0, 0, 0, 10));
        getChildren().addAll(nameField, priceField, clientField, quantityField, vBox);
        addProduct.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    product p = new product(
                            Double.parseDouble(priceField.getText()),
                            nameField.getText(),
                            Integer.parseInt(quantityField.getText()),
                            Double.parseDouble(clientField.getText()));
                    StoragePane.productsClone.add(p);
                    String sub = StoragePane.filter.getText();
                    String name = nameField.getText();
                    if (StoragePane.productSet.contains(nameField.getText())) {
                        error.setText("this name is already taken");
                        throw new Exception();
                    } else if (StoragePane.isSubstring(name, sub)) {
                        StoragePane.getProducts().add(p);
                        StoragePane.addCol.getChildren().add(new AddQuantity(StoragePane.addCol, p, StoragePane.getProducts().size() - 1));
                    }

                    clean();
                    //        System.out.println(StoragePane.getProducts());
                } catch (Exception e) {
                    error.setVisible(true);
                }

            }
        });
    }
}
