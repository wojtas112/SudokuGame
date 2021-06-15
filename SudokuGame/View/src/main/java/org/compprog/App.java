package org.compprog;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private static String level;
    private static String language = "English";

    public static String getLanguage() {
        return language;
    }

    public static void setLanguage(String language) {
        App.language = language;
    }


    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"));
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }


    private static Parent loadFXML(String fxml) throws IOException {
        if(getLanguage().equals("English")) {
            Locale.setDefault(new Locale("en"));
        } else if(getLanguage().equals("Polski")) {
            Locale.setDefault(new Locale("pl"));
        }

        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        ResourceBundle bundle = ResourceBundle.getBundle("org.compprog.Languages");
        fxmlLoader.setResources(bundle);
        return fxmlLoader.load();
    }

    public static String getLevel() {
        return level;
    }

    public static void setLevel(String level) {
        App.level = level;
    }

    public static void main(String[] args) {
        launch();
    }

}