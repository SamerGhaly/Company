package components;

import Panes.StoragePane;
import controller.Bill;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import sample.Main;

public class createBill extends HBox {
    public createBill() {
        super(100);
        try {
            getStylesheets().add
                    (Main.class.getResource("style.css").toExternalForm());
            getStyleClass().add("bill");
            HBox labelHBox = new HBox(20);
            Label Product = new Label("Product");
            Product.setPrefWidth(220);
            Label Price = new Label("Price");
            Price.setPrefWidth(190);

            Label Quantity = new Label("Quantity");
            Quantity.setPrefWidth(190);

            labelHBox.getChildren().addAll(Product, Price, Quantity);
            VBox but_rec = new VBox(20);
            VBox productRecordsVbox = new VBox(20);
            Button add = new Button("add");
            productRecordsVbox.getChildren().addAll(labelHBox, new productRecord(productRecordsVbox));
            HBox add_calc = new HBox(435);
            Button calc = new Button("Calculate");
            add_calc.getChildren().addAll(add, calc);
            but_rec.getChildren().addAll(productRecordsVbox, add_calc);
            getChildren().addAll(but_rec);

            VBox dateVbox = new VBox(20);
            Label DateLabel = new Label("Date");
            DatePicker date = new DatePicker();

            date.getStyleClass().add("date");
            Label CashPaid = new Label("Cash Paid");
            TextField cash = new TextField();
            cash.setPromptText("Cash");
            date.setPromptText("Date");
            dateVbox.getChildren().addAll(DateLabel, date, CashPaid, cash);

            final SimpleDoubleProperty totalCost = new SimpleDoubleProperty(0);
            Bill bill = new Bill();

            add.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    try {
                        productRecord productRecord = (productRecord) productRecordsVbox.getChildren().get(productRecordsVbox.getChildren().size() - 1);
                        boolean isValid = productRecord.detectError();
                        productRecord.error.setVisible(isValid);
                        Label label=new Label();
                        if (!isValid) {

                            ComboBox<String> name = (ComboBox<String>) (productRecord.getChildren().get(0));
                            TextField price = (TextField) (productRecord.getChildren().get(1));
                            TextField quantity = (TextField) (productRecord.getChildren().get(2));

                            bill.addProduct(name.getEditor().getText(), Double.parseDouble(price.getText()), Integer.parseInt(quantity.getText()));
                            totalCost.add(Double.parseDouble(price.getText()));
                            productRecordsVbox.getChildren().add(new productRecord(productRecordsVbox));
                        }
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                }
            });
            getChildren().add(dateVbox);

            // productRecord productRecord = (productRecord) productRecordsVbox.getChildren().get(productRecordsVbox.getChildren().size() - 1);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
