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
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author Administrator
 */
public class PanduanController implements Initializable {

    @FXML
    private Button next_question;
    @FXML
    private Button pre_question;
    @FXML
    private RadioButton wrong;
    @FXML
    private RadioButton currect;
    @FXML
    private Label l_context;
    @FXML
    private Label l_index;
    @FXML
    private GridPane preview;
    @FXML
    private Button submit;
    private ToggleGroup tg=new ToggleGroup();
    int i=0;
    char ans[]=MaincontrolController.pd;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         switch(ans[0]){
               case '对':
                    currect.setSelected(true);
                    break;
               case '错':
                    wrong.setSelected(true);
                    break;
           } 
        for(int i=0;i<5;i++){
           if(ans[i]!='\0'){
            preview.getChildren().get(i*2).setStyle("-fx-fill:green");
            //进行显示题目操作
         } 
           
        }
        
        wrong.setToggleGroup(tg);
        currect.setToggleGroup(tg);
        l_index.setText((i+1)+"");
        l_context.setText(FXMLDocumentController.timu.pd[i].getTitle_Contents());
        pre_question.setDisable(true);
    }    

    @FXML
    private void next_clicked(MouseEvent event) {
        currect.setSelected(false);
        wrong.setSelected(false);
          i++;
          if(i==4)    next_question.setDisable(true);
          else{
              next_question.setDisable(false);
              pre_question.setDisable(false);
          }
           switch(ans[i]){
               case '对':
                    currect.setSelected(true);
                    break;
               case '错':
                    wrong.setSelected(true);
                    break;
           }   
          l_index.setText((i+1)+"");
          l_context.setText(FXMLDocumentController.timu.pd[i].getTitle_Contents());
    }

    @FXML
    private void pre_clicked(MouseEvent event) {
        currect.setSelected(false);
        wrong.setSelected(false);
            i--;
            if(i==0) {
                pre_question.setDisable(true);
            }
            else{
              pre_question.setDisable(false);
              next_question.setDisable(false);
          }
            switch(ans[i]){
               case '对':
                    currect.setSelected(true);
                    break;
               case '错':
                    wrong.setSelected(true);
                    break;
           }   
           l_index.setText((i+1)+"");
          l_context.setText(FXMLDocumentController.timu.pd[i].getTitle_Contents());
    }

    @FXML
    private void submit_clicked(MouseEvent event) {
         String string="";
        string+=currect.isSelected()?"对":"";
        string+=wrong.isSelected()?"错":"";
         if(!"".equals(string)){
            preview.getChildren().get(i*2).setStyle("-fx-fill:green");
            ans[i]=string.charAt(0);
            //进行显示题目操作
        } 
    }
    
}
