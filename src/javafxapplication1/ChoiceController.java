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
public class ChoiceController implements Initializable {

    @FXML
    private GridPane preview;
    @FXML
    private Button next_question;
    @FXML
    private Button pre_question;
    @FXML
    private Button confirm;
    @FXML
    private RadioButton answer_D;
    @FXML
    private RadioButton answer_C;
    @FXML
    private RadioButton answer_B;
    @FXML
    private RadioButton answer_A;
    @FXML
    private Label ti_context;
    @FXML
    private Label timu_index;
    private int i=0;
    private ToggleGroup tg=new ToggleGroup();
    char[] ans=MaincontrolController.xz;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        switch(ans[0]){
            case 'A':
                answer_A.setSelected(true);
                break;
            case 'B':
                answer_B.setSelected(true);
                break;
            case 'C':
                answer_C.setSelected(true);
                break;
            case 'D':
                answer_D.setSelected(true);
                break;
        }
        for(int i=0;i<10;i++){
           if(ans[i]!='\0'){
            preview.getChildren().get(i*2).setStyle("-fx-fill:green");
            //进行显示题目操作
         } 
           
        }
        
        answer_A.setToggleGroup(tg);
        answer_B.setToggleGroup(tg);
        answer_C.setToggleGroup(tg);
        answer_D.setToggleGroup(tg);
        pre_question.setDisable(true);
        String[] ex_context=FXMLDocumentController.timu.spiltc(0);
        ti_context.setText(ex_context[0]);
        answer_A.setText(ex_context[1]);
        answer_B.setText(ex_context[2]);
        answer_C.setText(ex_context[3]);
        answer_D.setText(ex_context[4]);
        timu_index.setText("1");
        ti_context.setWrapText(true);
    }    
    @FXML
    public void pre_clicked(MouseEvent event){
        //显示上一题目所对应的选择
        answer_A.setSelected(false);answer_B.setSelected(false);
        answer_C.setSelected(false);answer_D.setSelected(false);
        next_question.setDisable(false);
        --i;
        String[] ex_context=FXMLDocumentController.timu.spiltc(i);
        ti_context.setText(ex_context[0]);
        answer_A.setText(ex_context[1]);
        answer_B.setText(ex_context[2]);
        answer_C.setText(ex_context[3]);
        answer_D.setText(ex_context[4]);
        timu_index.setText((i+1)+"");
        switch(ans[i]){
            case 'A':
                answer_A.setSelected(true);
                break;
            case 'B':
                answer_B.setSelected(true);
                break;
            case 'C':
                answer_C.setSelected(true);
                break;
            case 'D':
                answer_D.setSelected(true);
                break;
        }
        if(i-1<0) pre_question.setDisable(true);
    }
    @FXML 
    public void next_clicked(MouseEvent event){
        //显示下一题的所选项
        i++;
        String[] ex_context=FXMLDocumentController.timu.spiltc(i);
        ti_context.setText(ex_context[0]);
        answer_A.setText(ex_context[1]);
        answer_B.setText(ex_context[2]);
        answer_C.setText(ex_context[3]);
        answer_D.setText(ex_context[4]);
        timu_index.setText((i+1)+"");
        pre_question.setDisable(false);
        if(i+1==10){ next_question.setDisable(true); return;}
        answer_A.setSelected(false);answer_B.setSelected(false);
        answer_C.setSelected(false);answer_D.setSelected(false);
        switch(ans[i]){
            case 'A':
                answer_A.setSelected(true);
                break;
            case 'B':
                answer_B.setSelected(true);
                break;
            case 'C':
                answer_C.setSelected(true);
                break;
            case 'D':
                answer_D.setSelected(true);
                break;
        }
    }
    @FXML
    public void confirm_clicked(MouseEvent event){
        String string="";
        string+=answer_A.isSelected()?"A":"";
        string+=answer_B.isSelected()?"B":"";
        string+=answer_C.isSelected()?"C":"";
        string+=answer_D.isSelected()?"D":"";
        if(!"".equals(string)){
            preview.getChildren().get(i*2).setStyle("-fx-fill:green");
            ans[i]=string.charAt(0);
            //进行显示题目操作
        } 
    }
}
