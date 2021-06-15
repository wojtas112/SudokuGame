package org.compprog;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;

public class PrimaryController {

    @FXML
    private void switchToGridEasy() throws ViewException {
        App.setLevel("Easy");
        try {
            App.setRoot("secondary");
        } catch (IOException e) {
            throw new ViewException(ViewException.SWITCH_EASY_ERROR);
        }
    }

    @FXML
    private void switchToGridMedium() throws ViewException {
        App.setLevel("Medium");
        try {
            App.setRoot("secondary");
        } catch (IOException e) {
            throw new ViewException(ViewException.SWITCH_MEDIUM_ERROR);
        }
    }

    @FXML
    private void switchToGridHard() throws ViewException {
        App.setLevel("Hard");
        try {
            App.setRoot("secondary");
        } catch (IOException e) {
            throw new ViewException(ViewException.SWITCH_HARD_ERROR);
        }
    }

    @FXML
    private void switchToPl() throws ViewException {
        App.setLanguage("Polski");
        try {
            App.setRoot("primary");
        } catch (IOException e) {
            throw new ViewException(ViewException.SWITCH_PL_ERROR);
        }
    }

    @FXML
    private void switchToEn() throws ViewException {
        App.setLanguage("English");
        try {
            App.setRoot("primary");
        } catch (IOException e) {
            throw new ViewException(ViewException.SWITCH_EN_ERROR);
        }
    }

    @FXML
    private void switchToAuthors() {
        Authors authors = new Authors();
        System.out.println(authors.getObject("1. "));
        System.out.println();
        System.out.println(authors.getObject("2. "));

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("");
        alert.setHeaderText(null);
        alert.setContentText(""+authors.getObject("1. ")+"\n"+authors.getObject("2. "));
        alert.showAndWait();
    }
}
