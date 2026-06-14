package JDBC;

import java.sql.*;
import java.util.Scanner;

public class BatchProcessing {

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



            while (true) {
                Scanner sc =new Scanner(System.in);
                System.out.println("Enter the id");
                int id=sc.nextInt();
                System.out.println("Enter the name ");
                String name =sc.next();
                System.out.println("Enter the salary : ");
                int salary =sc.nextInt();
                System.out.println("ENter the department id");
                int deptId=sc.nextInt();

                String query = String.format("INSERT INTO employees(id, name, salary, department_id) VALUES (%d,'%s',%d,%d)",id,name,salary,deptId);

                state.addBatch(query);
                System.out.println("Do you want to enter more data (Y/N)");
                String choice =sc.next();
                if(choice.toUpperCase().equals("N")){
                    break;
                }

            }

            int[] arr = state.executeBatch();

           for(int i : arr){
               System.out.print(" "+ i + " ");
           }
            System.out.println();



        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}
