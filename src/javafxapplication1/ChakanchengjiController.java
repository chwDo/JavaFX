/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.ScrollEvent;

/**
 * FXML Controller class
 *
 * @author Administrator
 */
public class ChakanchengjiController implements Initializable {

    @FXML
    private TableView showfield;
    @FXML
    private TableColumn co_1;
    @FXML
    private TableColumn co_2;
    @FXML
    private TableColumn co_3;
    @FXML
    private TableColumn co_4;
    @FXML
    private TableColumn co_5;
    @FXML
    private TableColumn co_6;
    @FXML
    private TableColumn co_7;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ontextchanged(InputMethodEvent event) {
    
    }

    @FXML
    private void onsrolls(ScrollEvent event) {
        
    }
    
}
