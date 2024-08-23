package org.abol;

import java.sql.*;
import java.sql.PreparedStatement;
public class ExamplePrepareStat{
    public static void main (String[] args)throws SQLException {
        String url = "jdbc:mysql://localhost:3306/classicmodels";
        final String USER = "root";
        final String PASS = "rootPassword1";
        Connection conn = DriverManager.getConnection(url, USER, PASS);
        String sqlQuery = "INSERT INTO EMPLOYEES (officeCode,firstName,lastName,email,extension,reportsTo,VacationHours,employeeNumber,jobTitle) VALUES (?,?,?,?,?,?,?,?,?)";
        PreparedStatement prepStmt = conn.prepareStatement(sqlQuery);
        prepStmt.setInt(1, 8);
        prepStmt.setString(2, "Sam");
        prepStmt.setString(3, "Johnson");
        prepStmt.setString(4, "sJ@gmail.com");
        prepStmt.setString(5, "2759");
        prepStmt.setInt(6, 1143);
        prepStmt.setInt(7, 9);
        prepStmt.setInt(8, 0004);
        prepStmt.setString(9, "Manager");
        int affectedRows = prepStmt.executeUpdate();
        System.out.println(affectedRows + " row(s) affected !!");


    }
}