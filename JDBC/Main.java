package JDBC;

import java.sql.*;

public class Main {

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

            String query = "select * from employees";
            ResultSet result = state.executeQuery(query);

            System.out.println("  "+"ID"+ "  "+"Name"+"  "+"Salary "+"  ");

            while(result.next()){
                int id = result.getInt(1);
                String name =result.getString(2);
                int salary =result.getInt(3);
                System.out.println("  "+id+ "  "+name+"  "+salary+"  ");
            }


        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}
