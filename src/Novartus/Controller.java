package Novartus;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.StringBinding;
import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.HashMap;
import java.util.Optional;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    private final Task currenTask = new Task();
    private final ObservableList<Task> tasks = FXCollections.observableArrayList();
    private final HashMap<Integer, Task> tasksMap = new HashMap<>();

    public HashMap<Integer, Task> getTasksMap() {
        return tasksMap;
    }

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

        priority_combobox.getItems().addAll("High", "Medium", "Low");
        progress_spinner.setValueFactory(
                new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0)
        );

        progress_spinner.valueProperty().addListener((observableValue, oldvalue, newvalue) -> {
            if (newvalue.intValue() == 100) {
                completed_checkbox.setSelected(true);
            } else {
                completed_checkbox.setSelected(false);
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

        /* tasks.addAll(
                new Task(1, "High", "Completed Doc", 10),
                new Task(2, "Medium", "JavaFX", 0));*/


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
        tasksTable.getSelectionModel().selectedItemProperty().addListener((observableValue, oldTask, NewTask) -> {
            setCurrenTask(NewTask);
        });

    }

    int lastId = 0;

    @FXML
    void addButtonClicked(ActionEvent event) {
        if (currenTask.getId() == null) {
            Task t = new Task(++lastId, currenTask.getPriority(), currenTask.getDescription(), currenTask.getProgress());
            tasks.add(t);
            tasksMap.put(lastId, t);
        } else {
            Task t = tasksMap.get(currenTask.getId());
            t.setDescription(currenTask.getDescription());
            t.setPriority(currenTask.getPriority());
            t.setProgress(currenTask.getProgress());
        }
        setCurrenTask(null);
    }

    @FXML
    void cancelButtonClicked(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("Are you sure you want to cancel");
        alert.setTitle("Cancelling The Update");
        //alert.setContentText("This is the detailed info");
        alert.getButtonTypes().remove(0, 2);
        alert.getButtonTypes().add(0, ButtonType.YES);
        alert.getButtonTypes().add(1, ButtonType.NO);
        Optional<ButtonType> confirmationResponse = alert.showAndWait();
        if (confirmationResponse.get() == ButtonType.YES) {
            setCurrenTask(null);
            tasksTable.getSelectionModel().clearSelection();
        } else {
            System.out.println("Cancel Button Clicked");
        }
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

    void setTasksMap(HashMap<Integer, Task> initialTaskMap) {
        tasksMap.clear();
        tasks.clear();
        tasksMap.putAll(initialTaskMap);
        tasks.addAll(initialTaskMap.values());
        lastId = tasksMap.keySet().stream().max(Integer::compareTo).get();
    }
}


