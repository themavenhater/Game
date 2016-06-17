package com.islam.levels;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Driver {
    public int[] sqlTiles = new int[551];

    public Driver() {
        System.out.println("get to driver ");

        int i = 0, x = 0;
        int rownss = 0;

        try {
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gamesql", "root", "");
            Statement myStmt = myConn.createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from maps");
            while (myRs.next()) {
                //System.out.println(myRs.getString("id_row")+","+ myRs.getString("Rowcomp"));
                String row = myRs.getString("Row");
                System.out.println(row);
                System.out.println(row.length());

                for (i = 0; i < row.length(); i++) {
                    if (row.charAt(i) == 'n') {
                        sqlTiles[x] = -16777216;
                        x++;
                    }
                    if (row.charAt(i) == 'b') {
                        sqlTiles[x] = -15990529;
                        x++;
                    }
                    if (row.charAt(i) == 'g') {
                        sqlTiles[x] = -12566464;
                        x++;
                    }
                    if (row.charAt(i) == 'm') {
                        sqlTiles[x] = -8441088;
                        x++;
                    }
                }
                rownss++;


            }
            for (int d = 0; d < sqlTiles.length; d++) {
                if (d > 0) {
                    System.out.print(", ");
                }
                System.out.print(sqlTiles[d]);
            }
            myConn.close();

            System.out.println(rownss);
            System.out.println(x);
            Level.tiles = sqlTiles.clone();
            for (int f = 0; f < Level.tiles.length; f++) {
                if (f > 0) {
                    System.out.print(", ");
                }
                System.out.print(Level.tiles[f]);
            }
            System.out.println("Tiles Cloned");


        } catch (Exception exc) {
            exc.printStackTrace();
            System.out.println("erreur");
        }
    }
}