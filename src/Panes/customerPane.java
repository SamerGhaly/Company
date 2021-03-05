package Panes;

import components.backButton;
import components.CreateCustomer;
import controller.customer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableSet;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Callback;
import sample.Main;

public class customerPane extends BorderPane {
    public static ListView<customer> listView ;
    public static TextField filter;


    public static ObservableList<customer> customers = FXCollections.observableArrayList(
            new customer("samer", "fayoum", "el hadka 3omart el tatbikeen floor 5 flat 22 ", "01200018081", 0, ""),
            new customer("samer", "fayoum", "el hadka 3omart el tatbikeen floor 5 flat 22 ", "01200018081", 0, ""),
            new customer("john", "sohag", "tahtaa", "01288474336", 130, ""),
            new customer("bisho", "matrooh", "zahr glal", "01277932108", -20, ""),
            new customer("john", "sohag", "tahtaa", "01288474336", 130, ""),
            new customer("bisho", "matrooh", "zahr glal", "01277932108", -20, ""),
            new customer("john", "sohag", "tahtaa", "01288474336", 130, ""),
            new customer("bisho", "matrooh", "zahr glal", "01277932108", -20, ""),
            new customer("makary", "el 3areesh", "dahit el slam", "01277932108", 1000, "")
            ,
            new customer("john", "sohag", "tahtaa", "01288474336", 130, ""),
            new customer("bisho", "matrooh", "zahr glal", "01277932108", -20, ""),
            new customer("bisho", "matrooh", "zahr glal", "01277932108", -20, ""),
            new customer("john", "sohag", "tahtaa", "01288474336", 130, ""),
            new customer("bisho", "matrooh", "zahr glal", "01277932108", -20, ""),
            new customer("makary", "el 3areesh", "dahit el slam", "01277932108", 1000, "")
    );
    public static ObservableList<customer> customersClone = getCustomersClone();

    public static ObservableList<customer> getCustomers() {

        return customers;
    }
    public  static ObservableSet<String> customerSet;
    public static ObservableList<customer> getCustomersClone() {
        customerSet=FXCollections.observableSet();
        ObservableList<customer> Clone = FXCollections.observableArrayList();
        for (customer c : customers) {
            Clone.add(c);
            customerSet.add(c.getName());
        }return Clone;
    }

    public customerPane(Stage primaryStage,BorderPane LastPane) {
        super();
        try {
            listView = new ListView<>();
            setLeft(new backButton(LastPane));
            getStylesheets().add
                    (Main.class.getResource("style.css").toExternalForm());


            final Label title = new Label("Customer List");
            title.setFont(new Font("Arial", 40));
            title.setPadding(new Insets(20, 20, 20, 20));
            setTop(title);


            VBox vbox = new VBox(50);
            vbox.setSpacing(5);
            HBox hBox = new HBox();

            listView.setItems(getCustomers());
            listView.setFixedCellSize(50);
            listView.setMinHeight(700);
            listView.setMaxWidth(750);
            listView.setMinWidth(750);

//            listView.setOnMouseEntered(new EventHandler<MouseEvent>()
//                                       {
//                                           @Override
//                                           public void handle(MouseEvent event) {
//                                                listView.getSelectionModel().getSelectedItems().
//                                           }
//                                       }
//            );

            BorderPane me=this;
            listView.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    try {
                        customer c = listView.getSelectionModel().getSelectedItem();
                        primaryStage.getScene().setRoot(new profilePane(me,primaryStage,c));

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            listView.setCellFactory(new Callback<ListView<customer>, ListCell<customer>>() {
                @Override
                public ListCell<customer> call(ListView<customer> studentListView) {
                    return new cusCell();
                }
            });
             filter = new TextField();
            filter.setPromptText("Search"); //to set the hint text
            filter.setMaxWidth(300);

            filter.textProperty().addListener((observable, oldValue, newValue) -> {
                ObservableList<customer> temp = FXCollections.observableArrayList();
                String sub = newValue;
                for (customer x : customersClone) {
                    if (isSubstring(x.getName(), sub))
                        temp.add(x);
                }
                listView.getItems().setAll(temp);
            });

//            HBox list = new HBox();
//            addCol = new AddCol();
//            hBox.getChildren().addAll(listView, addCol);
//            ScrollPane scrollPane = new ScrollPane();
//            scrollPane.setContent(list);

            hBox.setMargin(listView, new Insets(0, 50, 20, 0));

            vbox.setMargin(hBox, new Insets(10, 40, 20, 20));
            vbox.setMargin(filter, new Insets(10, 40, 20, 20));
            CreateCustomer newCus = new CreateCustomer(filter);
            newCus.setAlignment(Pos.TOP_CENTER);
            hBox.getChildren().addAll(listView, newCus);

            vbox.getChildren().addAll(filter, hBox);
            setCenter(vbox);

        } catch (Exception e) {
            System.out.println("threr is a problem");
            System.out.println(e.getMessage());
        }
    }

    public static boolean isSubstring(String str, String sub) {
        int n = str.length();
        int m = sub.length();
        str = str.toLowerCase();
        sub = sub.toLowerCase();
        for (int i = 0; i < n - m + 1; i++) {
            if (str.substring(i, i + m).equals(sub))
                return true;
        }
        return false;
    }

    static class cusCell extends ListCell<customer> {
        @Override

        protected void updateItem(customer customer, boolean empty) {
            super.updateItem(customer, empty);
            VBox vBox = new VBox();
            if (empty || customer == null) {

                setText(null);
                setGraphic(null);

            } else {
                final Label name = new Label(customer.getName());
                name.setFont(new Font("Arial", 17));
                //  name.setPadding(new Insets(20, 20, 20, 20));


                final Label address = new Label(""+customer.getDebtMoney());
                address.setFont(new Font("Arial", 13));
                //   address.setPadding(new Insets(20, 20, 20, 20));
                address.setTextFill(Color.web("#0076a3"));
                vBox.getChildren().addAll(name, address);
                setText(null);
                vBox.setPadding(new Insets(5));
                setGraphic(vBox);
            }

        }
    }
}
