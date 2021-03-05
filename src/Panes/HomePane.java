package Panes;

import components.HomeButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.CacheHint;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import sample.Main;

import java.io.IOException;

public class HomePane extends BorderPane {


    public HomePane(Stage primaryStage) throws IOException {
        super();
        try {
            getStylesheets().add
                    (Main.class.getResource("style.css").toExternalForm());

            HBox hBox = new HBox(200);
            hBox.setAlignment(Pos.TOP_CENTER);
            setCenter(hBox);
            // setPadding(new Insets(10,20,0,10));
            HomeButton storageBtn = new HomeButton("images/store5.png","Store");
          //  hBox.setMargin(storageBtn,new Insets(0,500,0,0));
            storageBtn.setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    storageBtn.setTranslateX(-3);
                    storageBtn.setTranslateY(-3);
                    hBox.setSpacing(190);
                }
            });
            storageBtn.setOnMouseExited(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    storageBtn.setTranslateX(3);
                    storageBtn.setTranslateY(3);

                    hBox.setSpacing(200);

                }
            });
            HomeButton cusBtn = new HomeButton("images/cus.png","Customer");
            cusBtn.setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    cusBtn.setTranslateX(3);
                    cusBtn.setTranslateY(-3);

                    hBox.setSpacing(190);
                }
            });
            cusBtn.setOnMouseExited(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    cusBtn.setTranslateX(-3);
                    cusBtn.setTranslateY(3);

                    hBox.setSpacing(200);
                }
            });
            BorderPane me = this;
            storageBtn.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    try {
                        StoragePane storagePane=new StoragePane(primaryStage, me);
//                        storagePane.setCache(true);
//                        storagePane.setCacheShape(true);
//                        storagePane.setCacheHint(CacheHint.SPEED);
                        primaryStage.getScene().setRoot(storagePane);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });


            cusBtn.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    primaryStage.getScene().setRoot(new customerPane(primaryStage, me));

                }
            });
            setMargin(hBox, new Insets(100));
            hBox.getChildren().addAll(storageBtn, cusBtn);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
