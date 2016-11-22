package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtil {

	static {
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();			
		}
	}

	public static Connection getConnection(){
		Connection con = null;
		try{
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_db", "root", "1234");
			con.setAutoCommit(false);
		}
		catch(Exception e) {
			e.printStackTrace();			
		}
		return con;
	}

	public static void close(Connection con) {
		try{
			con.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}

	public static void close(Statement stmt) {
		try{
			stmt.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}

	public static void close(ResultSet rs) {
		try{
			rs.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}

	public static void commit(Connection con) {
		try{
			con.commit();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void rollback(Connection con) {
		try{
			con.rollback();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
