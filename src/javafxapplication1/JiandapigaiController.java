/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Administrator
 */
public class JiandapigaiController implements Initializable {
    //控件部分
    @FXML
    private Button next_question;
    @FXML
    private Button pre_question;
    @FXML
    private Button submit;
    @FXML
    private Label l_context;
    @FXML
    private TextArea stu_answer;
    @FXML
    private TextArea standed_answer;
    @FXML
    private TextArea get_score;
    
    //取值于外部静态变量
    private String examtype=FXMLDocumentController.s_examtype;//批改的科目类型
    Statement stmt=JavaFXApplication1.stmt;//来自于主舞台的数据库状态
    
    private Map<String,String> allanswerMap=new HashMap<>();
    private String currect_judge_userid;//当前批改的学生id(char[])
    private String[] ans_timuindex;//单个学生的题目编号以及答案分割   格式为：答案 题目编号
    private int curr_peruser=0;//当前已经批改该学生的题目数
    private ResultSet rs;//当前所要批改的全部学生答案集合
    private ResultSet ti_context;//题目与正确答案的暂存集
    private int temp_score=0;//暂存每个学生的5题分数，到达每个学生最后一题的时候写入数据库
    Statement Use4GetAnswer;
    int com=0;
    //数据暂存用于刷新部分
    Map<String, String> map=new HashMap<>();
    //用于MAP遍历的迭代器，一次next()就是一条学生数据
    Iterator<Map.Entry<String,String>> iter;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            Use4GetAnswer=JavaFXApplication1.conn.createStatement();
            ReadAllData();
            splitinlineData();
            SendData2field();
        } catch (SQLException ex) {
            Logger.getLogger(JiandapigaiController.class.getName()).log(Level.SEVERE, null, ex);
        }
        curr_peruser+=1;
        
    }    
    @FXML
    private void next_clicked(MouseEvent event) throws SQLException {
        if("".equals(get_score.getText())||com==0){
            JOptionPane.showMessageDialog(null, "未批改不允许下一题");
            return ;
        }
        SendData2field();
        curr_peruser++;
        com=0;
    }
    @FXML
    private void sub_clicked(MouseEvent event) throws SQLException {
        com=1;
        if(curr_peruser==5){
            temp_score+=Integer.parseInt(get_score.getText());
            addAllscore(temp_score);
            temp_score=0;
            if(!iter.hasNext()) {
                JOptionPane.showMessageDialog(null, "全部批改完成");
                next_question.setDisable(true);
            }
            else splitinlineData();
            curr_peruser=0;
        }else{
            temp_score+=Integer.parseInt(get_score.getText());
        }
    }
    /**
     * 从数据库读取数据到map中，且生成迭代器便于遍历数据
     * @throws SQLException 
     */
    public void ReadAllData() throws SQLException{
        map.put("语文", "Chinese");  map.put("数学", "Math");
        map.put("英语", "English");  map.put("物理", "Physics");
        map.put("化学", "Chemistry");map.put("生物", "Biological");
        rs=stmt.executeQuery("select `name`,"+map.get(examtype)+" from answer");
        
        while (rs.next()) {            
            allanswerMap.put(rs.getString("name"),rs.getString(map.get(examtype)));
        }
        iter=allanswerMap.entrySet().iterator();//数据输入后的迭代器的生成
    }
    /**
     * 一行学生答案的数据分割，数据流向SendData2field
     * @throws SQLException 
     */
    public void splitinlineData() throws SQLException{
        Map.Entry<String,String> entry=iter.next();
        currect_judge_userid=entry.getKey();
        ans_timuindex=(entry.getValue()).split("#");
    }
    /**
     * 将分割好的数据显示在field中
     * @throws SQLException 
     */
    public void SendData2field() throws SQLException{
        stu_answer.setText(ans_timuindex[curr_peruser*2]);
        ti_context=stmt.executeQuery("select Title_Contents,answer from exam where idex ="+ans_timuindex[(curr_peruser*2)+1]);
        ti_context.next();
        l_context.setText(ti_context.getString("Title_Contents"));
        standed_answer.setText(ti_context.getString("answer"));
    }
    /**
     * 分数加总
     * @param score 5题分数总和
     * @throws SQLException 
     */
    public void addAllscore(int score) throws SQLException{
        ResultSet prefenshu=Use4GetAnswer.executeQuery("select * from user_accout where id=\""+currect_judge_userid+"\"");
        prefenshu.next();
        SaveScore saveScore=new SaveScore(currect_judge_userid, (score+prefenshu.getInt(map.get(examtype)+"_score"))+"");
    }
    
}
