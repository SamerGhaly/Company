package components;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import sample.Main;

public class backButton extends Button {
    public backButton(BorderPane lastPane) {
        getStylesheets().add
                (Main.class.getResource("style.css").toExternalForm());

        Image img = new Image("images/back5.png");
        getStyleClass().add("back-button");

        ImageView view = new ImageView(img);
        view.setFitHeight(30);
        view.setFitWidth(34);
        setAlignment(Pos.CENTER);
        setGraphic(view);

       // setPadding(new Insets(10,20,0,10));
        setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Main.primaryStageB.getScene().setRoot(lastPane);

            }
        });
    }
}
