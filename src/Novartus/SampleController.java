package Novartus;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class SampleController {

    @FXML
    public TextField textfield;

    public void initialize(){
        textfield.setText("This is init");
        //System.out.println("Init is done");
    }
}
