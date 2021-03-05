package components;

import Panes.StoragePane;
import Panes.customerPane;
import controller.product;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class productRecord extends HBox {
    ComboBox<String> productsCombobox;
    TextField quantity;
    TextField price;
    Label error;
    ObservableMap<String, product> map;
    final SimpleIntegerProperty maxQuantity;
    public productRecord(VBox parent) {
        super(20);
        getStyleClass().add("pro_rec");
        productsCombobox=new ComboBox<>();
        productsCombobox.setEditable(true);
        productsCombobox.setPromptText("product"); //to set the hint text

        ObservableList<String>list= FXCollections.observableArrayList();
         map= FXCollections.observableHashMap();

        for(product p: StoragePane.productsClone){
            list.add(p.getName());
            map.put(p.getName(),p);
        }
        productsCombobox.getItems().addAll(list);
         price=new TextField();
        price.setPromptText("Price"); //to set the hint text
        quantity=new TextField();
        quantity.setPromptText("Quantity");
         maxQuantity =new SimpleIntegerProperty(0);
        productsCombobox.getEditor().textProperty().addListener((observable, oldValue, newValue) -> {
            ObservableList<String> temp = FXCollections.observableArrayList();
            String sub = newValue;
            for (String x: list) {
                if (customerPane.isSubstring(x, sub))
                    temp.add(x);
                if((x).equalsIgnoreCase(sub)) {
                    price.setText(map.get(x).getClientPrice() + "");
                    maxQuantity.set(map.get(x).getQuantity());
                    quantity.setPromptText("max : "+ maxQuantity.getValue());

                }

            }
//            if(temp.size()==0)
//                productsCombobox.getEditor().setText(oldValue);
//            else
            productsCombobox.getItems().setAll(temp);
        });
        //to set the hint text
         error = new Label("");

         error.setPrefWidth(100);
        error.setTextFill(Color.web("#cc0000"));
        error.setVisible(false);
        getChildren().addAll(productsCombobox,price,quantity,error);




    }
    public boolean detectError(){
        if(map.getOrDefault(productsCombobox.getEditor().getText(),null)==null){
            error.setVisible(true);
            error.setText("Invalid product name");
            return true;
        }
       try{
           Double.parseDouble(price.getText());
       }catch (NumberFormatException e){
//           error.setVisible(true);
           error.setText("Invalid price format");
           return true;
       }
            int quan=0;
        try{
           quan= Integer.parseInt(quantity.getText());
        }catch (NumberFormatException e){
//            error.setVisible(true);
            error.setText("Invalid Quantity format");
            return true;
        }
        if(maxQuantity.getValue()<quan) {
            error.setText("store quantity is not enough");
            return true;
        }
        return false;
    }
}
