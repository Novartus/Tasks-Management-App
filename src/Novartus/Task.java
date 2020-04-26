package Novartus;

import javafx.beans.property.ReadOnlyBooleanProperty;
import javafx.beans.property.ReadOnlyBooleanWrapper;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Task {
    public static void main(String[] args) {
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

    }
}
