package com.github.enforcer32.soulex.app;

import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        SceneManager sceneManager = new SceneManager(stage);
        sceneManager.switchScene("view/LoginWindow.fxml");
        stage.setTitle("Soulex");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
