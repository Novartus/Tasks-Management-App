package Novartus;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private TableView<?> tasksTable;

    @FXML
    private TableColumn<?, ?> priority_col;

    @FXML
    private TableColumn<?, ?> description_col;

    @FXML
    private TableColumn<?, ?> progress_col;

    @FXML
    private ComboBox<String> priority_combobox;

    @FXML
    private TextField description_field;

    @FXML
    private Button add_btn;

    @FXML
    private Spinner<Integer> progress_spinner;

    @FXML
    private CheckBox completed_checkbox;

    @FXML
    private Button cancel_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //description_field.setText("Test");

        priority_combobox.getItems().addAll("High", "Medium", "Low");
        progress_spinner.setValueFactory(
                new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0)
        );

    }
}
