package org.abol;
import java.sql.*;

public class EmpDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        String dburl = "jdbc:mysql://localhost:3306/classicmodels";
        String user = "root";
        String password = "rootPassword1";
        System.out.println("-------- MySQL JDBC Connection Demo ------------");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(dburl, user, password);
            String SelectSQL = "Select * FROM employees";
            Statement stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery(SelectSQL);
            while(result.next())
            {
                String EmployeeID = result.getString("employeeNumber");
                String fname = result.getString("firstName");
                String lname = result.getString("lastName");
                String email = result.getString("email");
                int officeCode = result.getInt("officeCode");

                System.out.println(EmployeeID +" | " + fname + "|"+ lname + "|" + email + "|" + officeCode );
            }
            connection.close();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
