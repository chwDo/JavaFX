/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Administrator
 */
public class GuanliController implements Initializable {

    @FXML
    private Button judge_jianda;
    @FXML
    private Button view_score;
    @FXML
    private Button edit_exam;
    @FXML
    private Button make_paper;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void pigai_clicked(MouseEvent event) throws IOException {
        Stage stage=new Stage();
        Parent root=FXMLLoader.load(getClass().getResource("jiandapigai.fxml"));
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void view_clicked(MouseEvent event) {
    }

    @FXML
    private void edit_clicked(MouseEvent event) {
    }

    @FXML
    private void paper_clicked(MouseEvent event) {
    }
    
}
