package Novartus;

import javafx.beans.property.*;

public class Task {
/*    public static void main(String[] args) {
        SimpleIntegerProperty intProp = new SimpleIntegerProperty();
        intProp.set(10);
        System.out.println(intProp.get());

        SimpleStringProperty stringPop = new SimpleStringProperty("InitialValue");
        System.out.println(stringPop.get());
        stringPop.set("NEW  VALUE");
        System.out.println(stringPop.get());

        ReadOnlyBooleanWrapper readOnlyBooleanWrapper = new ReadOnlyBooleanWrapper(true);
        ReadOnlyBooleanProperty readOnlyBooleanProperty = readOnlyBooleanWrapper.getReadOnlyProperty();
        readOnlyBooleanWrapper.set(false);
        System.out.println(readOnlyBooleanProperty.get());

    }*/

    private final StringProperty priority = new SimpleStringProperty();
    private final StringProperty description = new SimpleStringProperty();
    private final ObjectProperty<Integer> progress = new SimpleObjectProperty<>(0);
    private final ObjectProperty<Integer> id = new SimpleObjectProperty<>(null);

    public Task() {

    }

    public Task(Integer id, String priority, String description, Integer progress) {
        this.id.set(id);
        this.priority.set(priority);
        this.description.set(description);
        this.progress.set(progress);
    }

    public void setId(Integer value) {
        this.id.set(value);
    }

    public Integer getId() {
        return this.id.get();
    }

    public ObjectProperty<Integer> idProperty() {
        return id;
    }

    public String getPriority() {
        return priority.get();
    }

    public StringProperty priorityProperty() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority.set(priority);
    }

    public String getDescription() {
        return description.get();
    }

    public StringProperty descriptionProperty() {
        return description;
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public Integer getProgress() {
        return progress.get();
    }

    public ObjectProperty<Integer> progressProperty() {
        return progress;
    }

    public void setProgress(Integer progress) {
        this.progress.set(progress);
    }
}
