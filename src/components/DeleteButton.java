package components;

import Panes.StoragePane;
import controller.customer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class DeleteButton extends Button {
    public DeleteButton(AddCol parent, customer c, int idx) {
        Image img = new Image("images/delete.png");

        ImageView view = new ImageView(img);
        view.setFitHeight(20);
        view.setFitWidth(20);
        //Setting the size of the button
        //Setting a graphic to the button
        setGraphic(view);

        setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                StoragePane.table.getItems().remove(idx);
                parent.getChildren().remove(StoragePane.table.getItems().size());
            }
        });
    }
}
