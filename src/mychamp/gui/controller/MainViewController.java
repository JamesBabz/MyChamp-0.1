/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mychamp.gui.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import mychamp.gui.model.ChampModel;

/**
 * FXML Controller class
 *
 * @author Thomas
 */
public class MainViewController implements Initializable {

    @FXML
    private ListView listTeams;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnRemove;
    @FXML
    private Button btnEdit;
    @FXML
    private Button btnStart;

    private ObservableList teams;
    private ChampModel model;

    public MainViewController()
    {
        model = ChampModel.getInstance();
        observableListListener(model.getTeamNames());
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        btnEdit.setDisable(true);
        btnRemove.setDisable(true);
        btnStart.setDisable(true);
        listTeams.setItems(model.getTeamNames());
    }

    private void observableListListener(ObservableList list)
    {
        list.addListener(new ListChangeListener() {
            @Override
            public void onChanged(ListChangeListener.Change change)
            {
                int amount = list.size();
                if (amount >= 12)
                {
                    btnStart.setDisable(false);
                }
                if (amount == 16)
                {
                    btnAdd.setDisable(true);
                }
            }

        });
    }

    /**
     * Opens the TeamName view when pressed
     *
     * @throws IOException
     */
    @FXML
    private void handleAddTeam() throws IOException
    {
        Stage primaryStage = (Stage) listTeams.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/mychamp/gui/view/TeamName.fxml"));
        Parent root = loader.load();

        Stage newStage = new Stage();
        newStage.setScene(new Scene(root));

        newStage.initModality(Modality.WINDOW_MODAL);
        newStage.initOwner(primaryStage);

        newStage.show();
    }
    

    /**
     * Opens the TeamName view when pressed
     *
     * @throws IOException
     */
    @FXML
    private void handleEditTeam()
    {

    }

    
    @FXML
    private void macros(KeyEvent key) throws IOException
    {

        if (key.isControlDown())
        {
               if (KeyCode.N == key.getCode() && !btnAdd.isDisable())
                {
                    handleAddTeam();
                }

                if (KeyCode.P == key.getCode())
                {
                    handleEditTeam();
                }
            }
        if(KeyCode.DELETE == key.getCode())
        {
         //   handleDeleteTeam();
        }
    }
    
}
