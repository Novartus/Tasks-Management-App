package Novartus;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class Main extends Application {
  /*  Button addButton = new Button("Add");
    Button cancelButton = new Button("Cancel");
    TableView table = new TableView();
    TextField taskname = new TextField();
    TextField another = new TextField();
    ComboBox priority = new ComboBox();
    TableColumn column1 = new TableColumn("Priority");
    TableColumn column2 = new TableColumn("Description");
    TableColumn column3 = new TableColumn("Progress");*/


    @Override
    public void start(Stage primaryStage) throws Exception {
       /* GridPane gridPane = new GridPane();
        gridPane.setMinWidth(600);
        gridPane.setMinHeight(400);
        gridPane.setVgap(5);
        gridPane.setHgap(20);
        //gridPane.setGridLinesVisible(true);

        table.setMinWidth(550);
        table.setMinHeight(300);
        taskname.setPromptText("Enter task name");
        taskname.setText("Default Text");
        another.setText("Another Field");
        priority.getItems().addAll("High", "Low", "Medium");
        priority.setPromptText("Enter Priority");
        addButton.setMinWidth(100);
        cancelButton.setMinWidth(100);
        table.getColumns().addAll(column1, column2, column3);

        GridPane.setConstraints(table, 1, 1, 3, 1);
        GridPane.setConstraints(taskname, 2, 2); // Column,Row
        GridPane.setConstraints(priority, 1, 2);
        GridPane.setConstraints(addButton, 4, 2);
        GridPane.setConstraints(cancelButton, 4, 3);

        HBox progressArea = new HBox();
        progressArea.getChildren().addAll(
                new Label("Progress"),
                new Spinner<Integer>(0, 100, 0),
                new CheckBox("Completed"));

        progressArea.setAlignment(Pos.CENTER_RIGHT);
        progressArea.setSpacing(10);
        GridPane.setConstraints(progressArea, 1, 3, 2, 1);


        gridPane.getChildren().addAll(table, taskname, priority, addButton, cancelButton, progressArea);
        Scene scene = new Scene(gridPane, 600, 400);
        primaryStage.setScene(scene);

        primaryStage.setTitle("Do-It");
        primaryStage.setAlwaysOnTop(true);
        primaryStage.setResizable(false);
        primaryStage.show();*/

        HBox box =FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene scene = new Scene(box);
        primaryStage.setScene(scene);

        primaryStage.setTitle("Do-It");
        primaryStage.setAlwaysOnTop(true);
        primaryStage.setResizable(false);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
