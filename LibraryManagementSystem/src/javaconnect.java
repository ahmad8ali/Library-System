/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AHMAD
 */
import java.sql.*;
import javax.swing.JOptionPane;

public class javaconnect {

    private static javaconnect obj;

    private javaconnect() {
    }

    public static synchronized javaconnect getInstance() {
        if (obj == null) {
            obj = new javaconnect();
        }
        return obj;
    }

    private Connection con = null;

    public Connection Connect() {
        try {
            if (con == null) {
                Class.forName("org.sqlite.JDBC");
                   con = DriverManager.getConnection("jdbc:sqlite:DataBase/NewUserDataBase.db");
               // con = DriverManager.getConnection("jdbc.sqlite:DataBase/Library_DB.db");
                System.out.println("Done ");
            
            }
            return con;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getCause() + " -> " + e.getMessage());
            return null;
        }

    }
}

