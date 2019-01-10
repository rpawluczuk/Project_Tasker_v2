package GUI.Controllers;

import javafx.event.ActionEvent;

import java.io.IOException;

public class DisplayAllTasksController {
    private MainController mainController;

    public void openBackDisplayAllTasks(ActionEvent actionEvent) throws IOException {
        mainController.loadMenuScreen();
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
}
