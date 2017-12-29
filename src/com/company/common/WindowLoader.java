package com.company.common;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class WindowLoader {

    private static volatile WindowLoader instance;

    public static WindowLoader shared() {
        WindowLoader localInstance = instance;
        if (localInstance == null) {
            synchronized (WindowLoader.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new WindowLoader();
                }
            }
        }
        return localInstance;
    }

    private WindowLoader() { }

    public void createWindow(String fxmlPath, String title) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent load = loader.load();
            Stage stage = new Stage();
            stage.setTitle(title);
            Scene scene = new Scene(load);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}