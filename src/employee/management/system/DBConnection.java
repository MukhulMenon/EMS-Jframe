package employee.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBConnection {

    Connection conn;
    Statement statement;

    public DBConnection(){
        try{
           conn= DriverManager.getConnection (
                    "jdbc:postgresql://localhost:5432/employeemanagement",
                    "postgres", "mirev");
           statement = conn.createStatement();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
