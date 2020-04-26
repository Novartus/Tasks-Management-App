package Novartus;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import javax.swing.*;

public class Main extends Application {
    Button addButton = new Button("Add");
    Button cancelButton = new Button("Cancel");
    TableView tabel = new TableView();
    TextField taskname = new TextField();
    TextField another = new TextField();
    ComboBox priority = new ComboBox();

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane gridPane = new GridPane();
        gridPane.setMinWidth(600);
        gridPane.setMinHeight(400);
        gridPane.setVgap(5);
        gridPane.setHgap(20);
        gridPane.setGridLinesVisible(true);

        tabel.setMinWidth(550);
        tabel.setMinHeight(300);
        taskname.setPromptText("Enter task name");
        taskname.setText("Default Text");
        another.setText("Another Field");
        priority.getItems().addAll("High","Low","Medium");
        priority.setPromptText("Enter Priority");
        addButton.setMinWidth(100);
        cancelButton.setMinWidth(100);


        GridPane.setConstraints(tabel,1,1,3,1);
        GridPane.setConstraints(taskname,2,2); // Column,Row
        GridPane.setConstraints(priority,1,2);
        GridPane.setConstraints(addButton,3,2);
        GridPane.setConstraints(cancelButton,3,3);

        HBox progressArea = new HBox();
        progressArea.getChildren().addAll(new Label("Progress"),
                                          new Spinner<Integer>(0,100,0),
                                          new CheckBox("Completed"));

        progressArea.setAlignment(Pos.CENTER_RIGHT);
        progressArea.setSpacing(10);
        GridPane.setConstraints(progressArea,1,3,2,1);


        gridPane.getChildren().addAll(tabel,taskname,priority,addButton,cancelButton,progressArea);
        Scene scene = new Scene(gridPane, 600, 400);
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
