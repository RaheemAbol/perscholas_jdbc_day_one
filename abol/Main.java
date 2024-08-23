package org.abol;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        String dburl = "jdbc:mysql://localhost:3306/classicmodels";
        String user = "root";
        String password = "rootPassword1";
        System.out.println("-------- MySQL JDBC Connection Demo ------------");
        try {
            Connection connection = DriverManager.getConnection(dburl, user, password);
            String SelectSQL = "Select * FROM employees";
            Statement stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery(SelectSQL);
            while (result.next()) {
                String EmployeeID = result.getString("employeeNumber");
                String fname = result.getString("firstName");
                String lname = result.getString("lastName");
                System.out.println(EmployeeID + " | " + fname + "|" + lname);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

