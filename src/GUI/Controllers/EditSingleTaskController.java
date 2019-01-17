package GUI.Controllers;

import GUI.Allgorithms.Memory;
import GUI.Allgorithms.Task;
import GUI.ViewModels.EditSingleTaskViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EditSingleTaskController {

    //deklaracja komponentów okienka
    @FXML
    private ComboBox<String> chooseTaskComboBox;
    @FXML
    private TextField editNameTextField;
    @FXML
    private Label editNameLabel;
    @FXML
    private TextField editEndDateTextField;
    @FXML
    private Label editEndDateLabel;
    @FXML
    private ComboBox<String> editStatusComboBox;
    @FXML
    private Label editStatusLabel;
    @FXML
    private TextField editCommentTextField;
    @FXML
    private Label editCommentLabel;
    @FXML
    private Button buttonEditTask;
    @FXML
    private Button buttonDeleteTask;


    private EditSingleTaskViewModel editSingleTaskViewModel = new EditSingleTaskViewModel();
    private Memory memory = new Memory();

    @FXML
    public void initialize() throws IOException, ClassNotFoundException {
        // textProperty bindujemy z property typu String
        chooseTaskComboBox.valueProperty().bindBidirectional(editSingleTaskViewModel.getChooseTaskProperty());

        editNameTextField.disableProperty().bind(editSingleTaskViewModel.getNameAbilityProperty());
        editEndDateTextField.disableProperty().bind(editSingleTaskViewModel.getEndDateAbilityProperty());
        editStatusComboBox.disableProperty().bind(editSingleTaskViewModel.getStatusAbilityProperty());
        editCommentTextField.disableProperty().bind(editSingleTaskViewModel.getCommentAbilityProperty());

        editNameTextField.textProperty().bindBidirectional(editSingleTaskViewModel.getNameContentProperty());
        editEndDateTextField.textProperty().bindBidirectional(editSingleTaskViewModel.getEndDateContentProperty());
        editStatusComboBox.valueProperty().bindBidirectional(editSingleTaskViewModel.getStatusContentProperty());
        editCommentTextField.textProperty().bindBidirectional(editSingleTaskViewModel.getCommentContentProperty());

        editNameLabel.visibleProperty().bind(editSingleTaskViewModel.getNameOkProperty());
        editEndDateLabel.visibleProperty().bindBidirectional(editSingleTaskViewModel.getEndDateOkProperty());
        editStatusLabel.visibleProperty().bind(editSingleTaskViewModel.getStatusOkProperty());
        editCommentLabel.visibleProperty().bind(editSingleTaskViewModel.getCommentOkProperty());

        buttonEditTask.disableProperty().bind(editSingleTaskViewModel.getEditTaskProperty());
        buttonDeleteTask.disableProperty().bind(editSingleTaskViewModel.getDeleteTaskProperty());

        // Loading task names to combo box
        memory.deserialization();
        for (int i = 0; i < memory.getListWithTasks().size(); i++) {
            chooseTaskComboBox.getItems().add(memory.getListWithTasks().get(i).getName());
        }

        List<String> statusList = new ArrayList<>();
        statusList.add(new String("Done"));
        statusList.add(new String("In progress"));
        statusList.add(new String("Abandoned"));
        editStatusComboBox.getItems().addAll(statusList);
    }

    private MainController mainController;

    public void openBackEditSingleTask(ActionEvent actionEvent) throws IOException {
        mainController.loadMenuScreen();
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
}
