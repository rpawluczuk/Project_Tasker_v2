package GUI.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class MenuController {

    private  MainController mainController;

    @FXML
    public void openAddNewTask(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../FxmlFiles/AddNewTaskScreen.fxml"));
        VBox vBox = loader.load();
        AddNewTaskController addNewTaskController = loader.getController();
        addNewTaskController.setMainController(mainController);
        mainController.setScreen(vBox);
    }

    public void openDisplayAllTasks(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../FxmlFiles/DisplayAllTasksScreen.fxml"));
        VBox vBox = loader.load();
        DisplayAllTasksController displayAllTasksController = loader.getController();
        displayAllTasksController.setMainController(mainController);
        mainController.setScreen(vBox);
    }

    public void openEditSingleTask(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../FxmlFiles/EditSingleTaskScreen.fxml"));
        VBox vBox = loader.load();
        EditSingleTaskController editSingleTaskController = loader.getController();
        editSingleTaskController.setMainController(mainController);
        mainController.setScreen(vBox);
    }

    public void setMainController(MainController mainController){
        this.mainController = mainController;
    }
}
