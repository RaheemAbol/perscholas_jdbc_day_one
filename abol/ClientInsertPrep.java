package org.abol;

import java.sql.*;

public class ClientInsertPrep {
    public static void main(String[] args) throws SQLException {

        String url = "jdbc:mysql://localhost:3306/realestatedb";
        final String USER = "root";
        final String PASS = "rootPassword1";
        Connection conn = DriverManager.getConnection(url, USER , PASS );
        PreparedStatement prep = conn.prepareStatement(SqlQuries.GetClientByID);
        prep.setInt(1, 10);
        ResultSet rs = prep.executeQuery();
        while (rs.next()) {
            int id = rs.getInt(1);
            String fname = rs.getString(2);
            String lname = rs.getString(3);
            String email = rs.getString(4);
            String phone = rs.getString(5);
            System.out.println(id + " " + fname + " " + lname + " " + email + " " + phone );
        }

        conn.close();

    }
}
