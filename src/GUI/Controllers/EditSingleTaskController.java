package GUI.Controllers;

import javafx.event.ActionEvent;

import java.io.IOException;

public class EditSingleTaskController {

    private MainController mainController;

    public void openBackEditSingleTask(ActionEvent actionEvent) throws IOException {
        mainController.loadMenuScreen();
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
}
