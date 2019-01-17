package GUI.Controllers;

import GUI.Allgorithms.Memory;
import GUI.Allgorithms.Task;
import GUI.ViewModels.AddNewTaskViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AddNewTaskController {

    //deklaracja komponentów okienka
    @FXML
    private TextField nameTextField;

    @FXML
    private Label nameLabel;

    @FXML
    private TextField endDateTextField;

    @FXML
    private Label endDateLabel;

    @FXML
    private ComboBox<String> statusComboBox;

    @FXML
    private Label statusLabel;

    @FXML
    private TextField commentTextField;

    @FXML
    private Label commentLabel;

    @FXML
    private Button buttonAddTask;

    //utworzenie instancji klasy zawierającej deklaracje uzywanych propertisów
    private AddNewTaskViewModel addNewTaskViewModel = new AddNewTaskViewModel();

    private Memory memory = new Memory();

    @FXML
    public void initialize(){
        // textProperty bindujemy z property typu String
        nameTextField.textProperty().bindBidirectional(addNewTaskViewModel.getNameProperty());
        endDateTextField.textProperty().bindBidirectional(addNewTaskViewModel.getEndDateProperty());
        statusComboBox.valueProperty().bindBidirectional(addNewTaskViewModel.getStatusProperty());
        commentTextField.textProperty().bindBidirectional(addNewTaskViewModel.getCommentProperty());

        nameLabel.visibleProperty().bind(addNewTaskViewModel.getNameOkProperty());
        endDateLabel.visibleProperty().bind(addNewTaskViewModel.getEndDateOkProperty());
        statusLabel.visibleProperty().bind(addNewTaskViewModel.getStatusOkProperty());
        commentLabel.visibleProperty().bind(addNewTaskViewModel.getCommentOkProperty());

        buttonAddTask.disableProperty().bind(addNewTaskViewModel.getAddTaskProperty());

        List<String> statusList = new ArrayList<>();
        statusList.add(new String("Done"));
        statusList.add(new String("In progress"));
        statusList.add(new String("Abandoned"));

        statusComboBox.getItems().addAll(statusList);
    }

    private MainController mainController;

    public void openBackAddNewTask(ActionEvent actionEvent) throws IOException {
        mainController.loadMenuScreen();
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    public void actionAddTask(ActionEvent actionEvent) throws IOException, ClassNotFoundException {
        String name = (nameTextField.getText());
        String endDate = (endDateTextField.getText());
        String status = (statusComboBox.getValue());
        String comment = (commentTextField.getText());
        Task task = new Task(name, endDate, status, comment);
        memory.deserialization();
        memory.getListWithTasks().add(task);
        memory.serialization(memory.getListWithTasks());
        nameTextField.setText("");
        endDateTextField.setText("");
        statusComboBox.setValue("");
        commentTextField.setText("");
    }
}
