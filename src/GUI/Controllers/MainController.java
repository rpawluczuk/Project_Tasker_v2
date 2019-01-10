package GUI.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class MainController {

    @FXML
    private VBox mainVBox;

    @FXML
    public void initialize() throws IOException {
        loadMenuScreen();
    }

    public void loadMenuScreen() throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../FxmlFiles/MenuScreen.fxml"));
        VBox menuVBox = loader.load();
        MenuController menuController = loader.getController();
        menuController.setMainController(this);
        setScreen(menuVBox);
    }

    public void setScreen(VBox menuVBox) {
        mainVBox.getChildren().clear();
        mainVBox.getChildren().add(menuVBox);
    }
}
