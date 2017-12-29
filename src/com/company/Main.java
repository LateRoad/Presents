package com.company;

import com.company.common.WindowLoader;
import com.company.controllers.ViewController;
import com.company.models.factories.CandiesPresentFactory;
import com.company.models.factories.ChocolatesPresentFactory;
import com.company.models.factories.PresentFactory;
import com.company.models.presents.Package;
import com.company.models.presents.Present;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        WindowLoader.shared().createWindow(ViewController.fxmlPath, ViewController.windowTitle);
    }

    public static void main(String[] args) {
        launch(args);
    }
}