package sample;

import javafx.application.Application;
import javafx.geometry.NodeOrientation;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import Panes.HomePane;

public class Main extends Application {
    public static Stage primaryStageB;

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Mina 's Company");
        primaryStage.setMaximized(true);
        primaryStageB = primaryStage;
        BorderPane borderPane = new HomePane(primaryStage);
        Scene scene = new Scene(borderPane);
//        scene.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        primaryStage.setScene(scene);
//        primaryStage.setFullScreen(true);
        primaryStage.show();
        //     userName.setText("samer");
        //   grid.setGridLinesVisible(true);


    }


    public static void main(String[] args) {
        launch(args);
    }
}
