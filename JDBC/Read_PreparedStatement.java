package JDBC;

import java.sql.*;

public class Read_PreparedStatement {

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
//            Statement state =con.createStatement();


//            String query = "select * from employees where id=?";

            String query = "INSERT INTO employees(id, name, salary, department_id) VALUES (?,?,?,?)";

            PreparedStatement statement =con.prepareStatement(query);

            statement.setInt(1,20);
            statement.setString(2,"Pranav");
            statement.setInt(3,1200022);
            statement.setInt(4,2);

          //  ResultSet result = statement.executeQuery();

//            System.out.println("  "+"ID"+ "  "+"Name"+"  "+"Salary "+"  ");
//
//            while(result.next()){
//                int id = result.getInt(1);
//                String name =result.getString(2);
//                int salary =result.getInt(3);
//                System.out.println("  "+id+ "  "+name+"  "+salary+"  ");
//            }

            int row_affected = statement.executeUpdate();
            if(row_affected>0){
                System.out.println("Table Updated Successfully");
            }else{
                System.out.println("Eror");
            }

//


        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}
