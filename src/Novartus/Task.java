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

    StringProperty priority = new SimpleStringProperty() ;
    StringProperty description = new SimpleStringProperty() ;
    ObjectProperty<Integer> progress = new SimpleObjectProperty<>(0);


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
