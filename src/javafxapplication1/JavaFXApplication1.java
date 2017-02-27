/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import DAO.DAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Administrator
 */
public class JavaFXApplication1 extends Application {
    static Stage stages;
    static Statement stmt;
    static DAO dao;
    static Connection conn;
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stages=stage;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        dao=new DAO();
        stmt=dao.getstatement();
        conn=dao.getConnection();
        launch(args);
        dao.close();
    }
    
}
