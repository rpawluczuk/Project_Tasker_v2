package GUI.ViewModels;

import javafx.beans.binding.When;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class AddNewTaskViewModel {

    // textfields and visibility/invisibility OK-labels
    private StringProperty nameProperty = new SimpleStringProperty();
    private BooleanProperty nameOkProperty = new SimpleBooleanProperty(false);

    private StringProperty endDateProperty = new SimpleStringProperty();
    private BooleanProperty endDateOkProperty = new SimpleBooleanProperty(false);

    private StringProperty statusProperty = new SimpleStringProperty();
    private BooleanProperty statusOkProperty = new SimpleBooleanProperty(false);

    private StringProperty commentProperty = new SimpleStringProperty();
    private BooleanProperty commentOkProperty = new SimpleBooleanProperty(false);

    private BooleanProperty addTaskProperty = new SimpleBooleanProperty(true);

    public AddNewTaskViewModel() {
        //Wiązanie OK labeli z polami tekstowymi
        nameOkProperty.bind(nameProperty.isNotEmpty());
        endDateOkProperty.bind(endDateProperty.isNotEmpty());
        statusOkProperty.bind(statusProperty.isNotEmpty());
        commentOkProperty.bind(commentProperty.isNotEmpty());

        addTaskProperty.bind(new When(nameProperty.isEmpty().or(endDateProperty.isEmpty())
                .or(statusProperty.isEmpty()).or(commentProperty.isEmpty()))
                .then(true).otherwise(false));
    }

    //gettery propertisów pól tekstowych
    public StringProperty getNameProperty() {
        return nameProperty;
    }
    public StringProperty getEndDateProperty() {
        return endDateProperty;
    }
    public StringProperty getStatusProperty() {
        return statusProperty;
    }
    public StringProperty getCommentProperty() {
        return commentProperty;
    }

    //gettery propertisów etykiet
    public BooleanProperty getNameOkProperty() {
        return nameOkProperty;
    }
    public BooleanProperty getEndDateOkProperty() {
        return endDateOkProperty;
    }
    public BooleanProperty getStatusOkProperty() {
        return statusOkProperty;
    }
    public BooleanProperty getCommentOkProperty() {
        return commentOkProperty;
    }

    //settery propertisów pól tekstowych
    public void setNameProperty(StringProperty nameProperty) {
        this.nameProperty = nameProperty;
    }
    public void setEndDateProperty(StringProperty endDateProperty) {
        this.endDateProperty = endDateProperty;
    }
    public void setStatusProperty(StringProperty statusProperty) {
        this.statusProperty = statusProperty;
    }
    public void setCommentProperty(StringProperty commentProperty) {
        this.commentProperty = commentProperty;
    }

    //settery propertisów etykiet
    public void setNameOkProperty(BooleanProperty nameOkProperty) {
        this.nameOkProperty = nameOkProperty;
    }
    public void setEndDateOkProperty(BooleanProperty endDateOkProperty) {
        this.endDateOkProperty = endDateOkProperty;
    }
    public void setStatusOkProperty(BooleanProperty statusOkProperty) {
        this.statusOkProperty = statusOkProperty;
    }
    public void setCommentOkProperty(BooleanProperty commentOkProperty) {
        this.commentOkProperty = commentOkProperty;
    }

    //getter i setter przycisku buttonAddTask

    public BooleanProperty getAddTaskProperty() {
        return addTaskProperty;
    }
    public void setAddTaskProperty(BooleanProperty addTaskProperty) {
        this.addTaskProperty = addTaskProperty;
    }
}
