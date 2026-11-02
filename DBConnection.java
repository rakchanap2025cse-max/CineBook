import java.sql.*;
public class DBConnection {
    public static Connection getConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/cinebook_db","root","Ramuna@2007");
        }catch(Exception e){
            System.out.println("DB Connection Failed: "+e.getMessage());
            return null;
        }
    }
}