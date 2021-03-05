package components;

import controller.customer;
import javafx.scene.layout.VBox;
import sample.Main;

public class profile extends VBox {
    public profile(customer c) {
        super();
        try {
            getStylesheets().add
                    (Main.class.getResource("style.css").toExternalForm());

        }catch(Exception e){
            System.out.println("problem in profile class");
            System.out.println(e.getMessage());
        }
        }
}
