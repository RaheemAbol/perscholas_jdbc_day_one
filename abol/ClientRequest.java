package org.abol;

import java.sql.*;

public class ClientRequest {
    public static void main(String[] args) throws ClassNotFoundException {
        String dburl = "jdbc:mysql://localhost:3306/realestatedb";
        String user = "root";
        String password = "rootPassword1";
        System.out.println("-------- MySQL JDBC Connection Demo ------------");
        try {
            Connection connection = DriverManager.getConnection(dburl, user, password);
            String SelectSQL = "Select * FROM clients";
            Statement stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery(SelectSQL);
            while(result.next())
            {
                int clientID = result.getInt("ClientID");
                String fname = result.getString("firstName");
                String lname = result.getString("lastName");
                String email = result.getString("email");
                String PhoneNumber = result.getString("PhoneNumber");

                System.out.println(clientID +" | " + fname + "|"+ lname + "|" + email + "|" + PhoneNumber );
            }
            connection.close();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
