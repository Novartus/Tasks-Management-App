package Novartus;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;


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
    Controller controller;
    String fileName = "Task.xml";

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

        //Creating a FXML loader using constructor
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UI.fxml"));

        controller = fxmlLoader.getController();

        GridPane gridPane = fxmlLoader.load(); //Load FXML
        Scene scene = new Scene(gridPane);
        primaryStage.setScene(scene);

        primaryStage.setTitle("Do-It Application");
        primaryStage.setAlwaysOnTop(false);
        primaryStage.setResizable(false);

        primaryStage.setOnCloseRequest(this::onClose); // JAVA 8 : Method Refrence Shortcut ,lambda expression
        primaryStage.show();
        /*primaryStage.setOnCloseRequest(windowEvent -> {
            onClose(windowEvent);
        })*/
        /*  scene.addEventFilter(MouseEvent.MOUSE_PRESSED, mouseEvent -> {
            System.out.println("Scene Filter :" + mouseEvent.getEventType().getName());
        });*/
    }

    private void onClose(WindowEvent windowEvent) {
        // new Alert(Alert.AlertType.INFORMATION, windowEvent.getEventType().getName()).showAndWait();
        FileOutputStream out = null;
        XMLEncoder encoder = null;
        try {
            out = new FileOutputStream(fileName);
            encoder = new XMLEncoder(new BufferedOutputStream(out));
            encoder.writeObject(controller.getTasksMap());
            encoder.close();
        } catch (Exception e) {
            if (out != null)
                try {
                    out.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
