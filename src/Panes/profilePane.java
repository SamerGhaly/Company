package Panes;

import components.*;
import controller.customer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import sample.Main;

public class profilePane extends BorderPane {
    public static Label nameLabel;
    public profilePane(BorderPane LastPane,Stage primaStage, customer c) {
        super();
        try {
            backButton backButton=new backButton(LastPane);
            backButton.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    ((customerPane)LastPane).filter.setText("s");
                    ((customerPane)LastPane).filter.setText("");

                }
            });
//            setLeft(backButton);
//            setAlignment(backButton, Pos.TOP_LEFT);

            getStylesheets().add
                    (Main.class.getResource("style.css").toExternalForm());

             nameLabel = new Label(c.getName());
            nameLabel.setFont(new Font("Arial", 40));
            nameLabel.setTextFill(Color.web("#2185d0"));
            nameLabel.setPadding(new Insets(20, 20, 20, 20));
            VBox vBoxTile=new VBox();
            HBox tabs=new HBox(20);
            tab profile=new tab("Profile");
            tab myBills=new tab("My Bills");
            tab createBillTab=new tab("Create Bill");
            tabs.getChildren().addAll(backButton,profile,createBillTab,myBills);
            vBoxTile.getChildren().addAll(nameLabel,tabs);
            vBoxTile.setMargin(tabs,new Insets(0,0,20,0));
            BorderPane me=this;
            GridPane centrePane=new profileFormView(me,c,primaStage);
            me.setCenter(centrePane);
            me.setMargin(centrePane,new Insets(10,0,0,100));
            profile.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    GridPane centrePane=new profileFormView(me,c,primaStage);
                    me.setCenter(centrePane);
                    me.setMargin(centrePane,new Insets(10,0,0,100));

                }

            });
            createBillTab.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    HBox centrePane=new createBill();
                    ScrollPane scrollPane=new ScrollPane(centrePane);

                    me.setCenter(scrollPane);
                    scrollPane.setPadding(new Insets(20,20,20,20));
                    me.setMargin(scrollPane,new Insets(10,100,0,100));
                }
            });
            setTop(vBoxTile);


        }catch(Exception e){
            System.out.println("problem in profilePane class");
            System.out.println(e.getMessage());
        }
    }
}
