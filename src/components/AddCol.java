package components;

import Panes.StoragePane;
import controller.product;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.layout.VBox;

public class AddCol extends VBox {
    public AddCol() {
        setPadding(new Insets(30,20,10,20));
        ObservableList<product> products= StoragePane.getProducts();
        int c=0;
        for(product p:products){
            getChildren().add(new AddQuantity(this,p,c));
            c++;
        }
    }
}
