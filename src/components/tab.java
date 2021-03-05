package components;

import javafx.scene.control.Button;
import sample.Main;

public class tab extends Button {
    public tab(String name) {
        super(name);
        getStylesheets().add
                (Main.class.getResource("style.css").toExternalForm());
        getStyleClass().add("tab-button");
    }


}
