package org.abol;

import java.sql.*;

public class ClientResponse {
    public static void main(String[] args) throws SQLException {
        String dburl = "jdbc:mysql://localhost:3306/realestatedb";
        String user = "root";
        String password = "rootPassword1";
        System.out.println("-------- MySQL JDBC Connection Demo ------------");

        Connection conn = DriverManager.getConnection(dburl, user , password );
        String sqlQuery = "INSERT INTO clients (ClientID, firstName, lastName, email, PhoneNumber)VALUES( ?,?,?,?,?) ";
        PreparedStatement prepstmt = conn.prepareStatement(sqlQuery);
        prepstmt.setInt(1, 11);
        prepstmt.setString(2, "Sally");
        prepstmt.setString(3, "Johnson");
        prepstmt.setString(4, "sally@gmail.com");
        prepstmt.setString(5, "444-8888");
        int rowsUpdated = prepstmt.executeUpdate();
        System.out.println("Rows updated: " + rowsUpdated);
        conn.close();
    }

}
