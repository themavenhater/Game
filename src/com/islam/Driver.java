package com.islam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Driver {
    public static void main(String[] args) {

        try {
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gamesql", "root", "");
            Statement myStmt = myConn.createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from gamesql.");
            while (myRs.next()) {
                System.out.println(myRs.getString("color") + "");
            }

        } catch (Exception exc) {
            exc.printStackTrace();
            System.out.println("erreur");
        }
    }
}