package components;

import Panes.StoragePane;
import controller.product;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;

public class AddQuantity extends HBox {
    public AddQuantity(AddCol parent, product p, int idx) {

        Image img = new Image("images/delete.png");

        ImageView view = new ImageView(img);
        view.setFitHeight(20);
        view.setFitWidth(20);
        Button del = new Button("");
        //Setting the size of the button
        //Setting a graphic to the button
        del.setGraphic(view);

        del.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
              //  System.out.println(StoragePane.table.getItems().get(idx));
               StoragePane.productsClone.remove( StoragePane.table.getItems().get(idx));
                StoragePane.table.getItems().remove(idx);

                StoragePane.addCol.getChildren().remove(StoragePane.table.getItems().size());
            }
        });


        Button button=new Button("Add");
        TextField numberField = new TextField();
        numberField.setPromptText("Add Quantity"); //to set the hint text
//        numberField.setTextFormatter(new TextFormatter<>(new NumberStringConverter()));
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    int value = Integer.parseInt(numberField.getText());
                    p.setQuantity(p.getQuantity()+value);
                    StoragePane.table.getItems().set(idx,p);
                    numberField.setText("");
                }catch (Exception e){
                    System.out.println("err");
                }
            }
        });
        setPadding(new Insets(3,0,3,0));
        getChildren().addAll(button,numberField,del);
        setMargin(del,new Insets(0,0,0,15));
    }
}
