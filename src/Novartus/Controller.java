package Novartus;

import javafx.beans.binding.Binding;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.StringBinding;
import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    private final Task currenTask = new Task();
    private final ObservableList<Task> tasks = FXCollections.observableArrayList();


    @FXML
    private ProgressBar progressbar;

    @FXML
    private TableView<Task> tasksTable;

    @FXML
    private TableColumn<Task, String> priority_col;

    @FXML
    private TableColumn<Task, String> description_col;

    @FXML
    private TableColumn<Task, String> progress_col;

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
               /* System.out.println(currentTask.getDescription());
                System.out.println(currentTask.getPriority());
                System.out.println(currentTask.getProgress());

               currentTask.setDescription(currentTask.getProgress().toString());*/
            }
        });

        ReadOnlyIntegerProperty intProgress = ReadOnlyIntegerProperty.readOnlyIntegerProperty(progress_spinner.valueProperty());
        progressbar.progressProperty().bind(intProgress.divide(100.0));

        priority_combobox.valueProperty().bindBidirectional(currenTask.priorityProperty());
        description_field.textProperty().bindBidirectional(currenTask.descriptionProperty());
        progress_spinner.getValueFactory().valueProperty().bindBidirectional(currenTask.progressProperty());

        tasksTable.setItems(tasks);
        priority_col.setCellValueFactory(rowData -> rowData.getValue().priorityProperty());
        description_col.setCellValueFactory(rowData -> rowData.getValue().descriptionProperty());
        progress_col.setCellValueFactory(rowData -> Bindings.concat(rowData.getValue().progressProperty(), "%"));

        //Manually Added Tasks for Testing
        tasks.addAll(
                new Task(1, "High", "Completed Doc", 10),
                new Task(2, "Medium", "JavaFX", 0));


        // ADD -> Update Button || Update -> Add Button
        StringBinding addButtonTextBinding = new StringBinding() {
            {
                super.bind(currenTask.idProperty());
            }

            @Override
            protected String computeValue() {
                if (currenTask.getId() == null)
                    return "Add";
                else
                    return "Update";
            }
        };

        add_btn.textProperty().bind(addButtonTextBinding);

        //Text is below 3 Button is Disabled
        add_btn.disableProperty().bind(Bindings.greaterThan(3, currenTask.descriptionProperty().length()));
        tasksTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Task>() {

            @Override
            public void changed(ObservableValue<? extends Task> observableValue, Task oldTask, Task NewTask) {
                setCurrenTask(NewTask);
            }
        });
    }

    private void setCurrenTask(Task selectedTask) {
        if (selectedTask != null) {
            currenTask.setId(selectedTask.getId());
            currenTask.setPriority((selectedTask.getPriority()));
            currenTask.setDescription(selectedTask.getDescription());
            currenTask.setProgress(selectedTask.getProgress());
        } else {
            currenTask.setId(null);
            currenTask.setPriority("");
            currenTask.setDescription("");
            currenTask.setProgress(0);
        }
    }
}


