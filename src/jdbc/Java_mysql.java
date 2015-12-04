package jdbc;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class Java_mysql {


	    public static void main(String[] args) throws SQLException {
	    	
	        Connection conn = null;
	        Statement stmt = null;
	        try{
	            //STEP 2: Register JDBC driver
	            Class.forName("com.mysql.jdbc.Driver");

	            //STEP 3: Open a connection
	            System.out.println("Connecting to database...");
	            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hibernatedb_test","root","");

	            //STEP 4: Execute a query
	            System.out.println("Creating statement...");
	            stmt = conn.createStatement();
	            String sql;
	            sql = "SELECT Id, UserName FROM user";
	            ResultSet rs = stmt.executeQuery(sql);

	            //STEP 5: Extract data from result set
	            while(rs.next()){
	               //Retrieve by column name
	               int id  = rs.getInt("id");
	               
	               String name = rs.getString("UserName");
	               

	               //Display values
	               System.out.print("ID: " + id);
	               System.out.print(", First: " + name);
	            }
	            //STEP 6: Clean-up environment
	            rs.close();
	            stmt.close();
	            conn.close();
	         }catch(SQLException se){
	            //Handle errors for JDBC
	            se.printStackTrace();
	         }catch(Exception e){
	            //Handle errors for Class.forName
	            e.printStackTrace();
	         }finally{
	            //finally block used to close resources
	            try{
	               if(stmt!=null)
	                  stmt.close();
	            }catch(SQLException se2){
	            }// nothing we can do
	            try{
	               if(conn!=null)
	                  conn.close();
	            }catch(SQLException se){
	               se.printStackTrace();
	            }//end finally try
	         }
	    }
}




