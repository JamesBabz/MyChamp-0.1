/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mychamp.gui.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import mychamp.gui.model.ChampModel;

/**
 * FXML Controller class
 *
 * @author James
 */
public class TeamNameController implements Initializable {

    @FXML
    private Button btnCancel;
    @FXML
    private TextField txtName;

    
    private ChampModel model;
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        model = ChampModel.getInstance();
    }    

    /**
     * Saves when "save" is pressed
     */
    @FXML
    private void handleSave()
    {
        String name = txtName.getText();
        model.addTeam(name);
        closeWindow();
    }

    /**
     * Cancels and closes the window when "cancel" is pressed
     */
    @FXML
    private void handleCancel()
    {
        closeWindow();
    }
    
    private void closeWindow()
    {
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();
    }
    
    
    
}
