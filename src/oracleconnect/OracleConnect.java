/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oracleconnect;

import java.sql.*;

/**
 *
 * @author jzech
 */
public class OracleConnect {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            //load the driver class make sure JAR file is in classpath
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //create the connection object
            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521/orclpdb", "hr", "jordan");
            //create the statement object
            Statement stmt = con.createStatement();
            //statement the runs insert into emp table
            stmt.executeUpdate("INSERT INTO Emp " + "VALUES (50, 'Zech', 25)");
            //execute query
            ResultSet rs = stmt.executeQuery("select * from emp");
            
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
            }
            //close connection
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
