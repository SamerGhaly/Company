package components;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import sample.Main;

public class HomeButton extends Button {

    public HomeButton(String url,String name) {
        super();

        getStylesheets().add
                (Main.class.getResource("style.css").toExternalForm());
     //   getStyleClass().clear();
        getStyleClass().add("home-btn");
        Image img = new Image(url);
        ImageView view = new ImageView(img);
        view.setFitHeight(100);
        view.setFitWidth(100);
        Label label=new Label(name);
        label.setFont(new Font("Arial", 40));
       // label.setPadding(new Insets(20, 20, 20, 20));
        label.setTextFill(Color.web("fff"));
        VBox vBox=new VBox(view,label);
        vBox.setAlignment(Pos.CENTER);
        setGraphic(vBox);

    }
}
