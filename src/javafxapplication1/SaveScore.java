/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author acer
 */
public class SaveScore {
    Map<String, String> map=new HashMap<>();
    private SaveScore(){
        map.put("语文", "Chinese");
        map.put("数学", "Math");
        map.put("英语", "English");
        map.put("物理", "Physics");
        map.put("化学", "Chemistry");
        map.put("生物", "Biological");
    }
    public SaveScore(String id,String score) throws SQLException {
        this();
        String sql= " UPDATE user_accout SET "+map.get(FXMLDocumentController.s_examtype)+"_score = "+score+" WHERE id="+id;
        Statement stmt= new JavaFXApplication1().stmt;
         int c=stmt.executeUpdate(sql);
    }

}

   
