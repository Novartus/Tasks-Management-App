package Novartus;

import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    private Task currenTask = new Task();

    @FXML
    private ProgressBar progressbar;

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

        progress_spinner.valueProperty().addListener(new ChangeListener<Integer>() {

            @Override
            public void changed(ObservableValue<? extends Integer> observableValue, Integer oldvalue, Integer newvalue) {
                if (newvalue.intValue() == 100) {
                    completed_checkbox.setSelected(true);
                } else {
                    completed_checkbox.setSelected(false);
                }
            //    progressbar.setProgress(1.0 * newvalue / 100);
            }
        });

        ReadOnlyIntegerProperty intProgress = ReadOnlyIntegerProperty.readOnlyIntegerProperty(progress_spinner.valueProperty());
        progressbar.progressProperty().bind(intProgress.divide(100.0));

        priority_combobox.valueProperty().bindBidirectional(currenTask.priorityProperty());
        description_field.textProperty().bindBidirectional(currenTask.descriptionProperty());
        progress_spinner.getValueFactory().valueProperty().bindBidirectional(currenTask.progressProperty());
    }
}
