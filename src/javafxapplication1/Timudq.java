/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import Model.Timu;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Administrator
 */
public class Timudq {
          static    Timu []  xz=new Timu[10];
          static    Timu []  tk=new Timu[10];
          static    Timu []  pd=new Timu[5];
          static    Timu []  jd=new Timu[5];   
        public Timudq() throws SQLException{
                        
            for(int i=0;i<10;i++){
                xz[i] =new Timu();
                tk[i] =new Timu();
                if(i<5){
                    pd[i] =new Timu();
                    jd[i] =new Timu();
            }
            }
            
           String sqls1="select * from exam  where Title_Types= \""+FXMLDocumentController.s_examtype+"\" and type= \"选择题\" "+"order by rand() limit 0,10";
           String sqls2="select * from exam  where Title_Types= \""+FXMLDocumentController.s_examtype+"\" and type= \"填空题\" "+"order by rand() limit 0,10";
           String sqls3="select * from exam  where Title_Types= \""+FXMLDocumentController.s_examtype+"\" and type= \"判断题\" "+"order by rand() limit 0,5";
           String sqls4="select * from exam  where Title_Types= \""+FXMLDocumentController.s_examtype+"\" and type= \"简答题\" "+"order by rand() limit 0,5";
           Statement stmt=JavaFXApplication1.stmt;
           ResultSet rs=stmt.executeQuery(sqls1); 
           for(int i=0;i<10;i++){
                rs.next();
                xz[i].setTitle_Types(rs.getString("Title_Types"));
                xz[i].setScores(rs.getInt("Scores"));
                xz[i].setAnswer(rs.getString("answer"));
                xz[i].setTitle_Contents(rs.getString("Title_Contents"));
                xz[i].setType(rs.getString("type"));
                xz[i].setIdex(rs.getInt("idex"));
            }
           rs=stmt.executeQuery(sqls2);          
           for(int i=0;i<10;i++){
                 rs.next();
                tk[i].setTitle_Types(rs.getString("Title_Types"));
                tk[i].setScores(rs.getInt("Scores"));
                tk[i].setAnswer(rs.getString("answer"));
                tk[i].setTitle_Contents(rs.getString("Title_Contents"));
                tk[i].setType(rs.getString("type"));
                tk[i].setIdex(rs.getInt("idex"));
            }            
            rs=stmt.executeQuery(sqls3);
            for(int i=0;i<5;i++){
                 rs.next();
                pd[i].setTitle_Types(rs.getString("Title_Types"));
                pd[i].setScores(rs.getInt("Scores"));
                pd[i].setAnswer(rs.getString("answer"));
                pd[i].setTitle_Contents(rs.getString("Title_Contents"));
                pd[i].setType(rs.getString("type"));
                pd[i].setIdex(rs.getInt("idex"));
            }  
            
            rs=stmt.executeQuery(sqls4);
            for(int i=0;i<5;i++){
                 rs.next();
                jd[i].setTitle_Types(rs.getString("Title_Types"));
                jd[i].setScores(rs.getInt("Scores"));
                jd[i].setAnswer(rs.getString("answer"));
                jd[i].setTitle_Contents(rs.getString("Title_Contents"));
                jd[i].setType(rs.getString("type"));
                jd[i].setIdex(rs.getInt("idex"));
                
            }  
            

    }
        public String [] spiltc(int i) {
            return xz[i].getTitle_Contents().split("#");
    }
        
}