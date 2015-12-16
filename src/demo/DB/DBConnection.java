package demo.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class DBConnection {

	private static Connection con;

	private DBConnection(){


	}




	static{

		try{
			con=myConnection();
		}catch(Exception e){
			System.out.println("in catch block of DBConnection class");
		}

	}

	private static Connection myConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver is loaded"); 
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
			System.out.println("got connection");


		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return con;
	}







	public static Connection getConnection(){

		if(con==null)
			con=myConnection();


		return con;
	}





}
