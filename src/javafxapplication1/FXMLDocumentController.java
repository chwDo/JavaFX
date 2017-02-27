/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Administrator
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TextField username;
    @FXML
    private ChoiceBox<java.lang.String> examtype;
    @FXML
    private PasswordField password;
    @FXML
    private Button f_login;
    @FXML
    private RadioButton isadmin;
    static String s_examtype;
    static String s_id;
    static Timudq timu;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        examtype.getItems().addAll("语文","数学","英语","物理","化学","生物");
    }    

    @FXML
    private void Login_clicked(MouseEvent event) throws SQLException, IOException {
        
        if(!isadmin.isSelected()){
            if(examtype.getValue()==null) {
                JOptionPane.showMessageDialog(null, "请选择考试科目");
                return;
            }
            if(username.getText().equals("")){
                JOptionPane.showMessageDialog(null,"用户名为空");
                return;
            }
            String sqls="select * from user_accout where id="+username.getText();
            Statement stmt=JavaFXApplication1.stmt;
            ResultSet rs=stmt.executeQuery(sqls);
            if(!rs.next()){
                JOptionPane.showMessageDialog(null, "用户名或密码错误");
            }else{
                if(rs.getString("password").equals(password.getText())){
                    JOptionPane.showMessageDialog(null, "登录成功，本次考试科目为："+examtype.getValue());
                    s_examtype=examtype.getValue();
                    s_id=username.getText();
                    timu=new Timudq();
                    //进入主考试界面
                    Parent root = FXMLLoader.load(getClass().getResource("maincontrol.fxml"));
                    Scene scene = new Scene(root);
                    Stage stage=new Stage();
                    stage.setTitle("考试");
                    stage.setScene(scene);
                    stage.show();
                    JavaFXApplication1.stages.close();
                    stmt=null;
                }else{
                    JOptionPane.showMessageDialog(null, "用户名或密码错误");
                }
            }
        }else{
            if(examtype.getValue()==null) {
                JOptionPane.showMessageDialog(null, "请选择考试科目");
                return;
            }
            if(username.getText().equals("")){
                JOptionPane.showMessageDialog(null,"用户名为空");
                return;
            }
            String sqls="select * from administrator_account where account="+username.getText();
            Statement stmt=JavaFXApplication1.stmt;
            ResultSet rs=stmt.executeQuery(sqls);
            if(!rs.next()){
                JOptionPane.showMessageDialog(null, "用户名或密码错误");
            }else{
                if(rs.getString("password").equals(password.getText())){
                    //进入主考试界面
                    s_examtype=examtype.getValue();
                    Parent root = FXMLLoader.load(getClass().getResource("guanli.fxml"));
                    Scene scene = new Scene(root);
                    Stage stage=new Stage();
                    stage.setTitle("管理员");
                    stage.setScene(scene);
                    stage.show();
                    JavaFXApplication1.stages.close();
                    stmt=null;
                }else{
                    JOptionPane.showMessageDialog(null, "用户名或密码错误");
                }
            }
        }
    }
    @FXML
    private void isadmin_clicked(MouseEvent event){
        if(!isadmin.isSelected()){
            isadmin.setSelected(false);
        }else{
            isadmin.setSelected(true);
        }
    }
    
}
