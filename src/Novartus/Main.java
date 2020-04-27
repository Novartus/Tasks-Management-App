package Novartus;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;


public class Main extends Application {


    Controller controller;
    String fileName = "Task.xml";

    @Override
    public void start(Stage primaryStage) throws Exception {

        //Creating a FXML loader using constructor
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UI.fxml"));

        controller = fxmlLoader.getController();

        GridPane gridPane = fxmlLoader.load(); //Load FXML
        Scene scene = new Scene(gridPane);
        primaryStage.setScene(scene);

        primaryStage.setTitle("Do-It Application");
        primaryStage.setAlwaysOnTop(false);
        primaryStage.setResizable(false);

//        controller.setTasksMap(readTasksFile());

        primaryStage.setOnCloseRequest(this::onClose); // JAVA 8 : Method Refrence Shortcut ,lambda expression
        primaryStage.show();

    }

    //READ FROM EXISTING FILE
    //UNCOMMENT THIS
   /* private HashMap<Integer, Task> readTasksFile(){
        FileInputStream in = null;
        HashMap<Integer, Task> tasksMap= new HashMap<Integer, Task>();
                try{
                    in = new FileInputStream(fileName);
                    XMLDecoder decoder = new XMLDecoder(in);
                    tasksMap= (HashMap<Integer, Task>) decoder.readObject();
                    decoder.close();
                }catch (Exception e){
                    if (in != null)
                        try {
                            in.close();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                }finally {
                    return tasksMap;
                }
    }
*/
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
