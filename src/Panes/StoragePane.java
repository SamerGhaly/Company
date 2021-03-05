package Panes;

import components.*;
import controller.product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableSet;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;
import sample.Main;

import java.io.IOException;

public class StoragePane extends BorderPane {
    public static TableView<product> table ;
    public static AddCol addCol;
    public  static TextField filter;

    static ObservableList<product> products = FXCollections.observableArrayList(
            new product(5, "Smith", 255,5),
            new product(20, "Johnson", 1000,10),
            new product(150, "Williams", 2500,500),
            new product(70, "Jones", 3000,700),
            new product(135, "Brown", 450,800),
            new product(5, "Smith", 255,5),
            new product(20, "Johnson", 1000,10),
            new product(150, "Williams", 2500,500),
            new product(70, "Jones", 3000,700),
            new product(135, "Brown", 450,800),
            new product(5, "Smith", 255,5),
            new product(20, "Johnson", 1000,10),
            new product(150, "Williams", 2500,500),
            new product(70, "Jones", 3000,700),
            new product(135, "Brown", 450,800));

    public static ObservableSet<String> productSet;
    public static ObservableList<product> productsClone = getProductsClone();

    public static ObservableList<product> getProductsClone() {
        productSet=FXCollections.observableSet();
        ObservableList<product> Clone = FXCollections.observableArrayList();
        for (product p : products) {
            Clone.add(p);
            productSet.add(p.getName());
        }
        return Clone;
    }

    public static ObservableList<product> getProducts() {
        return products;
    }
    static boolean is=true;

    public StoragePane(Stage primaryStage,BorderPane lastPane) throws IOException {
        super();
        table=new TableView<>();
        getStylesheets().add
                (Main.class.getResource("style.css").toExternalForm());
        //   getStyleClass().clear();
        //   getStyleClass().add("home-btn");
        try {
            table.setEditable(true);
//            table.addEventFilter(ScrollEvent.ANY, Event::consume);
//            table.setPrefWidth(1000.0);
            //  products= FXCollections.observableArrayList();
            final Label label = new Label("Products details");
            label.setFont(new Font("Arial", 40));
            label.setPadding(new Insets(20, 20, 20, 20));
            setLeft(new backButton(lastPane));
            setTop(label);
            TableColumn<product, Double> priceCol = new TableColumn<>("Production Price");
            priceCol.setCellValueFactory(new PropertyValueFactory<>("productionPrice"));

            priceCol.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
            priceCol.setOnEditCommit(
                    new EventHandler<TableColumn.CellEditEvent<product, Double>>() {
                        @Override
                        public void handle(TableColumn.CellEditEvent<product, Double> t) {
                            ((product) t.getTableView().getItems().get(
                                    t.getTablePosition().getRow())
                            ).setProductionPrice(t.getNewValue());
                        }
                    }
            );



            TableColumn<product, Double> clientPriceCol = new TableColumn<>("Client Price");
            clientPriceCol.setCellValueFactory(new PropertyValueFactory<>("clientPrice"));

            clientPriceCol.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
            clientPriceCol.setOnEditCommit(
                    new EventHandler<TableColumn.CellEditEvent<product, Double>>() {
                        @Override
                        public void handle(TableColumn.CellEditEvent<product, Double> t) {
                            ((product) t.getTableView().getItems().get(
                                    t.getTablePosition().getRow())
                            ).setClientPrice(t.getNewValue());
                        }
                    }
            );




            TableColumn<product, Integer> quantityCol = new TableColumn("Quantity");
            quantityCol.setCellValueFactory(new PropertyValueFactory("quantity"));

            quantityCol.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
            quantityCol.setOnEditCommit(
                    new EventHandler<TableColumn.CellEditEvent<product, Integer>>() {
                        @Override
                        public void handle(TableColumn.CellEditEvent<product, Integer> t) {
                            ((product) t.getTableView().getItems().get(
                                    t.getTablePosition().getRow())
                            ).setQuantity(t.getNewValue());
                        }
                    }
            );

            TableColumn<product, String> nameCol = new TableColumn("Name");
            nameCol.setCellValueFactory(new PropertyValueFactory("name"));

            nameCol.setCellFactory(TextFieldTableCell.forTableColumn());
            nameCol.setOnEditCommit(
                    new EventHandler<TableColumn.CellEditEvent<product, String>>() {
                        @Override
                        public void handle(TableColumn.CellEditEvent<product, String> t) {
                            ((product) t.getTableView().getItems().get(
                                    t.getTablePosition().getRow())
                            ).setName(t.getNewValue());
                        }
                    }
            );
            priceCol.setPrefWidth(300);
            clientPriceCol.setPrefWidth(300);
            nameCol.setPrefWidth(300);
            quantityCol.setPrefWidth(300);

            table.setItems(getProducts());
            table.getColumns().addAll(nameCol, priceCol, clientPriceCol,quantityCol);
            table.setFixedCellSize(37);
            VBox vbox = new VBox(50);
            vbox.setSpacing(3);
            vbox.setSpacing(5);
            vbox.setPadding(new Insets(10, 0, 0, 10));
            HBox hBox = new HBox();
            addCol = new AddCol();
            hBox.getChildren().addAll(table, addCol);

            ScrollPane scrollPane = new ScrollPane();
            scrollPane.setContent(hBox);
            //   scrollPane.setPadding(new Insets(30,20,30,10));

            final Label addProductLabel = new Label("Add Product");
            addProductLabel.setFont(new Font("Arial", 20));
            addProductLabel.setPadding(new Insets(10, 10, 10, 10));

            // search part

             filter = new TextField();
            filter.setPromptText("Search"); //to set the hint text
            filter.setMaxWidth(300);

            filter.textProperty().addListener((observable, oldValue, newValue) -> {
                ObservableList<product> temp = FXCollections.observableArrayList();
                String sub = newValue;
                for (product x : productsClone) {
                    if (isSubstring(x.getName(), sub))
                        temp.add(x);
                }
                table.getItems().setAll(temp);
                addCol.getChildren().setAll(new AddCol().getChildren());

            });



            vbox.getChildren().addAll( addProductLabel, new addRow(),filter, scrollPane);
            vbox.setMargin(scrollPane, new Insets(30, 0, 0, 0));
            setCenter(vbox);

            //  table.refresh();


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static boolean isSubstring(String str,String sub){
        int n=str.length();
        int m=sub.length();
        str=str.toLowerCase();
        sub=sub.toLowerCase();
        for (int i = 0; i < n-m+1; i++) {
            if(str.substring(i,i+m).equals(sub))
                return true;
        }
        return false;
    }


}
