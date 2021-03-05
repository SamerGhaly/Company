package components;

import Panes.StoragePane;
import Panes.customerPane;
import controller.customer;
import controller.product;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.layout.VBox;

public class DeleteCol extends VBox {
    public DeleteCol() {
        setPadding(new Insets(30,20,10,20));
        ObservableList<product> products= StoragePane.getProducts();
        int c=0;

        for(customer p:customerPane.getCustomers()){
         //   getChildren().add(new AddQuantity(this,p,c));
            c++;
        }
    }
}
