package skomarica.examples.jerseyjdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import skomarica.examples.jerseyjdbc.database.DatabaseConnection;
import skomarica.examples.jerseyjdbc.model.Type;

public class TypeDao {

	public static Type getType(int id) {
		Connection conn = DatabaseConnection.getConnection();
		PreparedStatement stmt = null;
		String namesr = null;
		String nameeng = null;
		try {
			String sql = "SELECT * from type where id=?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);			
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				namesr = rs.getString("nameeng");
				nameeng = rs.getString("namesr");
			}
			rs.close();
			stmt.close();
			conn.close();			
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
			return new Type(id, namesr, nameeng);
		} // end try

	}
	
	public static List<Type> getAllTypes(){
		List<Type> lt = new ArrayList<>();
		
		Connection conn = DatabaseConnection.getConnection();
		PreparedStatement stmt = null;
		String namesr = null;
		String nameeng = null;
		int id;
		try {
			String sql = "SELECT * from type";
			stmt = conn.prepareStatement(sql);					
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				id = rs.getInt("id");
				namesr = rs.getString("nameeng");
				nameeng = rs.getString("namesr");
				lt.add(new Type(id, namesr, nameeng));
				
			}
			rs.close();
			stmt.close();
			conn.close();			
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
			return lt;
		} // end try

	}
	
}
