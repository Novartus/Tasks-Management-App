package Novartus;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {
    Button addButton = new Button("Add");
    Button cancelButton = new Button("Cancel");
    Label tablearea = new Label("This is where tasks table will come:");
    TextField taskname = new TextField();
    TextField another = new TextField();
    ComboBox priority = new ComboBox();

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane gridPane = new GridPane();
        gridPane.setMinHeight(400);
        gridPane.setMinWidth(600);
        gridPane.setVgap(10);
        gridPane.setHgap(20);
        //gridPane.setGridLinesVisible(true);


        tablearea.setMinWidth(600);
        taskname.setPromptText("Enter task name");
        another.setText("Another Field");
        priority.getItems().addAll("High","Low","Medium");
        priority.setPromptText("Enter Priority");
        addButton.setMinWidth(100);
        cancelButton.setMinWidth(100);

        GridPane.setConstraints(tablearea,1,1,3,1);
        GridPane.setConstraints(taskname,2,2); // Column,Row
        GridPane.setConstraints(priority,1,2);
        GridPane.setConstraints(addButton,3,2);
        GridPane.setConstraints(cancelButton,4,2);

        gridPane.getChildren().addAll(tablearea,taskname,priority,addButton,cancelButton);
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
