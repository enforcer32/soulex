package com.github.enforcer32.soulex.app;

import com.github.enforcer32.soulex.controller.BaseController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class StageManager {
    private static final Map<Class, Stage> stages = new HashMap<>();

    public static void createStage(Class c, String url) {
        Stage open = stages.get(c);
        if(open != null)
            open.requestFocus();

        stages.computeIfAbsent(c, v -> {
            try {
				String fxmlpath = StageManager.class.getResource("").toExternalForm().replace("app/", "") + url.toString();
				FXMLLoader loader = new FXMLLoader(new URL(fxmlpath));
                Parent parent = loader.load();
				BaseController controller = loader.getController();
                Stage stage = new Stage();
				controller.setSceneManager(new SceneManager(stage));
                stage.setScene(new Scene(parent));
                stage.show();
                return stage;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }

    public static void closeStage(Class c) {
        Stage stage = stages.get(c);
        if(stage != null) {
            stage.close();
            stages.remove(c);
        }
    }

    public static void closeAll() {
        for(Stage stage: stages.values())
            stage.close();
        stages.clear();
    }
}

