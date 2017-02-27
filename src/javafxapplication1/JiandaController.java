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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Administrator
 */
public class JiandaController implements Initializable {

    @FXML
    private Button next_question;
    @FXML
    private Button pre_question;
    @FXML
    private TextArea answer_field;
    @FXML
    private Label l_context;
    @FXML
    private Label l_index;
    @FXML
    private GridPane preview;
    @FXML
    private Button submit;
    
     int i=0;
    String s[]=MaincontrolController.jd;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        answer_field.setText(s[0]);
        for(int j=0;j<5;j++){
            
        if(!"".equals(s[j])){
            preview.getChildren().get(j*2).setStyle("-fx-fill:green");
            //进行显示题目操作
        }else{
             preview.getChildren().get(j*2).setStyle("-fx-fill:white");
            } 
        }
        l_index.setText((i+1)+"");
        l_context.setText(FXMLDocumentController.timu.jd[i].getTitle_Contents());
        pre_question.setDisable(true);
        l_context.setWrapText(true);
       // System.out.println("javafxapplication1.JiandaController.initialize()"+answer_field.getText()+"|");
    }    

    @FXML
    private void next_clicked(MouseEvent event) {
          i++;
          answer_field.setText(s[i]);
          if(i==4)  next_question.setDisable(true);
          else{
              next_question.setDisable(false);
              pre_question.setDisable(false);
          }
            l_index.setText((i+1)+"");
            l_context.setText(FXMLDocumentController.timu.jd[i].getTitle_Contents());
            l_context.setWrapText(true);
            
    }

    @FXML
    private void pre_clicked(MouseEvent event) {
           i--;
          answer_field.setText(s[i]);
          if(i==0) {
                pre_question.setDisable(true);
            }
            else{
              pre_question.setDisable(false);
              next_question.setDisable(false);
          }
            l_index.setText((i+1)+"");
            l_context.setText(FXMLDocumentController.timu.jd[i].getTitle_Contents());
            
            
    }

   @FXML
    private void sub_clicked(MouseEvent event) {
         s[i]=answer_field.getText();
         if(!"".equals(s[i])&&!"\n".equals(s[i])){
            preview.getChildren().get(i*2).setStyle("-fx-fill:green");
        }
         else{
             preview.getChildren().get(i*2).setStyle("-fx-fill:white");
    }
    
    
}
}
