/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import java.io.IOException;
import static java.lang.Thread.sleep;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author acer
 */
public class MaincontrolController implements Initializable {

    @FXML
    private Button btn_xz;
    @FXML
    private Button btn_tk;
    @FXML
    private Button btn_pd;
    @FXML
    private Button btn_jd;
    @FXML
    private Button btn_submit;
    @FXML
    private Label timeLabel;
    @FXML
    private Label typeLabel;
    @FXML
    private MenuItem startexam;
    @FXML
    private MenuItem endexam;
    private boolean isstart;
    static public char xz[]=new char[10];
    static public char pd[]=new char[5];
    static public String tk[]=new String[10];
    static public String jd[]=new String[5];
    Thread td=new Thread(){
                @Override
                public void run(){
                    for (int i = 6000; i >= 0; i--) {
                        final int counter=i;
                        Platform.runLater(()->{
                            timeLabel.setText(counter/60+":"+counter%60);
                        });
                        try {
                            sleep(1000);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(MaincontrolController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            };
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        for(int m=0;m<10;m++){
            tk[m]="";
            if(m<5) jd[m]="";           
        }
        timeLabel.setText("100:00");
        isstart=false;
        btn_jd.setDisable(true);
        btn_pd.setDisable(true);
        btn_tk.setDisable(true);
        btn_xz.setDisable(true);
        btn_submit.setDisable(true);
    }    

    @FXML
    private void xz_clicked(MouseEvent event) throws IOException {
        Stage stage=new Stage();
        Parent root=FXMLLoader.load(getClass().getResource("choice.fxml"));
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void tk_clicked(MouseEvent event) throws IOException{
        Stage stage=new Stage();
        Parent root=FXMLLoader.load(getClass().getResource("tiankong.fxml"));
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void pd_clicked(MouseEvent event) throws IOException{
        Stage stage=new Stage();
        Parent root=FXMLLoader.load(getClass().getResource("panduan.fxml"));
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void jd_clicked(MouseEvent event) throws IOException{
        Stage stage=new Stage();
        Parent root=FXMLLoader.load(getClass().getResource("jianda.fxml"));
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void submit(ActionEvent event){
        
    }
    @FXML
    private void startexam_clicked(ActionEvent event){
        if(isstart==true){
            JOptionPane.showMessageDialog(null, "考试已经在进行了，请不要重复点击开始考试");
        }else{
            btn_jd.setDisable(false);
            btn_pd.setDisable(false);
            btn_tk.setDisable(false);
            btn_xz.setDisable(false);
            btn_submit.setDisable(false);
            isstart=true;
            td.start();
        }
    }
    @FXML
    private void endexam_clicked(ActionEvent event) throws SQLException{
        String queren="";
        queren=JOptionPane.showInputDialog("请输入数字825确认提交试卷");
        if(!("825".equals(queren))){
            JOptionPane.showMessageDialog(null, "取消提交试卷");
            return;
        } 
        btn_jd.setDisable(true);
        btn_pd.setDisable(true);
        btn_tk.setDisable(true);
        btn_xz.setDisable(true);
        btn_submit.setDisable(true);
        td.stop();
        int sum=0;
        for(int i=0;i<10;i++){
            if(xz[i]==FXMLDocumentController.timu.xz[i].getAnswer().charAt(0)){
                sum+=FXMLDocumentController.timu.xz[i].getScores();
            }
            if(tk[i].equals(FXMLDocumentController.timu.tk[i].getAnswer())){
                    sum+=FXMLDocumentController.timu.tk[i].getScores();
                }  
            if(i<5){
                    
                if(pd[i]==FXMLDocumentController.timu.pd[i].getAnswer().charAt(0)){
                sum+=FXMLDocumentController.timu.pd[i].getScores();
            }               
            }
                
        }

        SaveScore saveScore=new  SaveScore(FXMLDocumentController.s_id, sum+"");
        String answer="";
        for(int i=0;i<5;i++){
            answer+=jd[i];
            answer+="#";
            answer+=FXMLDocumentController.timu.jd[i].getIdex();
            answer+="#";
        }
        
        System.out.println("string : "+answer);
        SaveAnswer saveAnswer=new SaveAnswer(FXMLDocumentController.s_id, answer);
    }
    
}
