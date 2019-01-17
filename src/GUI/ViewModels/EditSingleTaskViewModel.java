package GUI.ViewModels;

import javafx.beans.binding.When;
import javafx.beans.property.*;

public class EditSingleTaskViewModel {

    // textfields and visibility/invisibility OK-labels
    private StringProperty chooseTaskProperty = new SimpleStringProperty();

    private BooleanProperty nameAbilityProperty = new SimpleBooleanProperty(false);
    private BooleanProperty endDateAbilityProperty = new SimpleBooleanProperty(false);
    private BooleanProperty statusAbilityProperty = new SimpleBooleanProperty(false);
    private BooleanProperty commentAbilityProperty = new SimpleBooleanProperty(false);

    private StringProperty nameContentProperty = new SimpleStringProperty();
    private StringProperty endDateContentProperty = new SimpleStringProperty();
    private StringProperty statusContentProperty = new SimpleStringProperty();
    private StringProperty commentContentProperty = new SimpleStringProperty();

    private BooleanProperty nameOkProperty = new SimpleBooleanProperty(false);
    private BooleanProperty endDateOkProperty = new SimpleBooleanProperty(false);
    private BooleanProperty statusOkProperty = new SimpleBooleanProperty(false);
    private BooleanProperty commentOkProperty = new SimpleBooleanProperty(false);

    private BooleanProperty editTaskProperty = new SimpleBooleanProperty(true);
    private BooleanProperty deleteTaskProperty = new SimpleBooleanProperty(true);

    public EditSingleTaskViewModel(){
        nameAbilityProperty.bind(chooseTaskProperty.isEmpty());
        endDateAbilityProperty.bind(chooseTaskProperty.isEmpty());
        statusAbilityProperty.bind(chooseTaskProperty.isEmpty());
        commentAbilityProperty.bind(chooseTaskProperty.isEmpty());

        nameOkProperty.bind(nameContentProperty.isNotEmpty());
        endDateOkProperty.bind(endDateContentProperty.isNotEmpty());
        statusOkProperty.bind(statusContentProperty.isNotEmpty());
        commentOkProperty.bind(commentContentProperty.isNotEmpty());

        editTaskProperty.bind(new When(nameContentProperty.isEmpty().or(endDateContentProperty.isEmpty())
                .or(statusContentProperty.isEmpty()).or(commentContentProperty.isEmpty()))
                .then(true).otherwise(false));
        deleteTaskProperty.bind(new When(nameContentProperty.isEmpty().or(endDateContentProperty.isEmpty())
                .or(statusContentProperty.isEmpty()).or(commentContentProperty.isEmpty()))
                .then(true).otherwise(false));
    }

    public StringProperty getChooseTaskProperty() {
        return chooseTaskProperty;
    }

    public BooleanProperty getNameAbilityProperty() {
        return nameAbilityProperty;
    }
    public BooleanProperty getEndDateAbilityProperty() {
        return endDateAbilityProperty;
    }
    public BooleanProperty getStatusAbilityProperty() {
        return statusAbilityProperty;
    }
    public BooleanProperty getCommentAbilityProperty() {
        return commentAbilityProperty;
    }

    public StringProperty getNameContentProperty() {
        return nameContentProperty;
    }
    public StringProperty getEndDateContentProperty() {
        return endDateContentProperty;
    }
    public StringProperty getStatusContentProperty() {
        return statusContentProperty;
    }
    public StringProperty getCommentContentProperty() {
        return commentContentProperty;
    }

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

    public BooleanProperty getEditTaskProperty() {
        return editTaskProperty;
    }
    public BooleanProperty getDeleteTaskProperty() {
        return deleteTaskProperty;
    }
}
