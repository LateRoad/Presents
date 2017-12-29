package com.company.controllers;

import com.company.common.ErrorWindow;
import com.company.common.InfoWindow;
import com.company.models.factories.CandiesPresentFactory;
import com.company.models.factories.ChocolatesPresentFactory;
import com.company.models.factories.PresentFactory;
import com.company.models.presents.Package;
import com.company.models.presents.Present;
import com.company.models.presents.SweetNameValidator;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class ViewController {

    public static String fxmlPath = "../views/view.fxml";
    public static String windowTitle = "Creating present";

    @FXML Button addSweetButton;
    @FXML Button createPresentButton;
    @FXML TextField sweetNameField;
    @FXML TextField presentNameField;
    @FXML ChoiceBox sweetTypeBox;
    @FXML ListView presentsList;
    @FXML ListView sweetsList;
    @FXML TextField packageWidthField;
    @FXML TextField packageHeightField;

    PresentFactory[] factories = {new CandiesPresentFactory(), new ChocolatesPresentFactory()};
    ArrayList<Present> presents = new ArrayList<>();

    @FXML
    void initialize() {
        sweetTypeBox.setItems(FXCollections.observableArrayList("Candy", "Chocolate"));
        sweetTypeBox.getSelectionModel().selectFirst();
    }

    @FXML
    void createPresent() {
        try {
            Package packageObj = new Package(packageWidthField.getText(), packageHeightField.getText());
            Integer index = sweetTypeBox.getSelectionModel().getSelectedIndex();
            String[] sweets = new String[sweetsList.getItems().size()];
            for (int i = 0; i < sweetsList.getItems().size(); i++) {
                sweets[i] = (String)sweetsList.getItems().get(i);
            }
            Present present = factories[index].makePresent(packageObj, presentNameField.getText(), sweets);
            presents.add(present);
            presentsList.getItems().add(present.getName());
            clearFields();
        } catch (Exception err) {
            ErrorWindow.show(err.getMessage());
        }
    }

    void clearFields() {
        presentNameField.clear();
        sweetNameField.clear();
        packageWidthField.clear();
        packageHeightField.clear();
        sweetsList.getItems().clear();
    }

    @FXML
    void addSweet() {
        if (!sweetNameField.getText().isEmpty() && SweetNameValidator.validate(sweetNameField.getText())) {
            sweetsList.getItems().add(sweetNameField.getText());
            sweetNameField.clear();
        }
        else
            ErrorWindow.show("Sweet name field is badly formatted!");
    }

    @FXML
    void openPresent() {
        if (!presentsList.getItems().isEmpty()) {
            String present = presents.get(presentsList.getSelectionModel().getSelectedIndex()).open();
            InfoWindow.Companion.createWindow("Present", present);
            presentsList.getItems().remove(presentsList.getSelectionModel().getSelectedItem());
        } else
            ErrorWindow.show("Presents list is empty!");
    }
}
