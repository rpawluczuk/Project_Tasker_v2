package GUI.Controllers;

import javafx.event.ActionEvent;

import java.io.IOException;

public class AddNewTaskController {

    private MainController mainController;

    public void openBackAddNewTask(ActionEvent actionEvent) throws IOException {
        mainController.loadMenuScreen();
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
    
}
