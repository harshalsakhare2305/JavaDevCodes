package JDBC;

import java.sql.*;

public class InsertOperation {

    private static  final String url ="jdbc:mysql://localhost:3306/harshal1";
    private static final String username="root";
    private static final String password="Harshal@2305";

    public static void main(String[] args) {



        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        try {
            Connection con = DriverManager.getConnection(url,username,password);
            Statement state =con.createStatement();

            String query = String.format("INSERT INTO employees(id, name, salary, department_id) VALUES (%d,'%s',%d,%d)",19,"sdd",150000,1);
            int rowChanged =state.executeUpdate(query);

            if(rowChanged>0){
                System.out.println("Data inserted successfully");
            }else{
                System.out.println("Error");
            }



        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}
