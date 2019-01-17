package GUI.Controllers;

import GUI.Allgorithms.Memory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.io.IOException;

public class DisplayAllTasksController {

    @FXML
    private Button buttonDisplayAllTasks;
    @FXML
    private Button buttonDeleteAllTasks;
    @FXML
    private TextArea textAreaDisplayTasks;

    private Memory memory = new Memory();
    private MainController mainController;
    public void openBackDisplayAllTasks(ActionEvent actionEvent) throws IOException {
        mainController.loadMenuScreen();
    }
    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    public void displayAllTasks(ActionEvent actionEvent) throws IOException, ClassNotFoundException {
        textAreaDisplayTasks.clear();
        memory.deserialization();
        textAreaDisplayTasks.setText(memory.getListWithTasks().toString());
    }

    public void DeleteAllTasks(ActionEvent actionEvent) throws IOException {
        textAreaDisplayTasks.clear();
        memory.getListWithTasks().clear();
        memory.serialization(memory.getListWithTasks());
    }
}
