package hakaton.mljfs.messenger.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hakaton.mljfs.messenger.database.DatabaseConnection;
import hakaton.mljfs.messenger.model.Building;
import hakaton.mljfs.messenger.model.Profile;
import hakaton.mljfs.messenger.model.Site;

public class ProfileDao {

	public static Profile getProfileByEmail(String email){
		Connection conn = DatabaseConnection.getConnection();
		PreparedStatement stmt = null;
		
		int id = -1;		
		String password = null;
		String phone = null;
		String city = null;
		String state = null;
		int facultyID = -1;
		Building faculty = null;
		int hallID = -1;
		Building hall = null;
		String name = null;
		
		try {
			String sql = "SELECT * from profile where email=?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, email);			
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				id = rs.getInt("id");				
				password = rs.getString("password");
				phone = rs.getString("phone");
				city = rs.getString("city");
				state = rs.getString("state");
				facultyID = rs.getInt("faculty");
				hallID = rs.getInt("hall");
				faculty = BuildingDao.getBuilding(facultyID);
				hall = BuildingDao.getBuilding(hallID);
				name = rs.getString("name");
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
			return new Profile(id,email,password,phone,city,state,faculty,hall,name);
		} // end try

	}
	
	public static Profile getProfileByID(int id){
		Connection conn = DatabaseConnection.getConnection();
		PreparedStatement stmt = null;
		
		String email = null;		
		String password = null;
		String phone = null;
		String city = null;
		String state = null;
		int facultyID = -1;
		Building faculty = null;
		int hallID = -1;
		Building hall = null;
		String name = null;
		
		try {
			String sql = "SELECT * from profile where id=?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);			
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				email = rs.getString("email");				
				password = rs.getString("password");
				phone = rs.getString("phone");
				city = rs.getString("city");
				state = rs.getString("state");
				facultyID = rs.getInt("faculty");
				hallID = rs.getInt("hall");
				faculty = BuildingDao.getBuilding(facultyID);
				hall = BuildingDao.getBuilding(hallID);
				name = rs.getString("name");
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
			return new Profile(id,email,password,phone,city,state,faculty,hall,name);
		} // end try

	}
	
	
	public static List<Profile> getAllProfiles(){
		List<Profile> pl = new ArrayList<>();
		
		Connection conn = DatabaseConnection.getConnection();
		PreparedStatement stmt = null;
		
		int id = -1;
		String email = null;
		String password = null;
		String phone = null;
		String city = null;
		String state = null;
		int facultyID = -1;
		Building faculty = null;
		int hallID = -1;
		Building hall = null;
		String name;
		
		try {
			String sql = "SELECT * from profile";
			stmt = conn.prepareStatement(sql);					
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				id = rs.getInt("id");
				email = rs.getString("email");
				password = rs.getString("password");
				phone = rs.getString("phone");
				city = rs.getString("city");
				state = rs.getString("state");
				facultyID = rs.getInt("faculty");
				hallID = rs.getInt("hall");
				faculty = BuildingDao.getBuilding(facultyID);
				hall = BuildingDao.getBuilding(hallID);
				name = rs.getString("name");
				pl.add(new Profile(id,email,password,phone,city,state,faculty,hall,name));
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
			return pl;
		} // end try

	}

	public static boolean addProfile(Profile profile) {
		Connection conn = DatabaseConnection.getConnection();
		PreparedStatement stmt = null;
		boolean sucess = false;
		
		try {
			String sql = "insert into profile (email,password,phone,"
					+ "city,state,faculty,hall) values (?,?,?,?,?,?,?)";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, profile.getEmail());
			stmt.setString(2, profile.getPassword());
			stmt.setString(3, profile.getPhone());
			stmt.setString(4, profile.getCity());
			stmt.setString(5, profile.getState());
			stmt.setInt(6, profile.getFaculty().getId());
			stmt.setInt(7, profile.getHall().getId());			
			int rs = stmt.executeUpdate();
			if(rs==1){
				sucess = true;
			}		
			
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
			return sucess;
		} // end try

		
		
		
		
		
		
		
	}

	
	/*public static boolean addProfile(Profile profile){
		Connection conn = DatabaseConnection.getConnection();
		PreparedStatement stmt = null;		
		
		try {
			String sql = "insert into profile(email,password,phone,city,"
					+ "state,faculty,hall)";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);			
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				email = rs.getString("email");				
				password = rs.getString("password");
				phone = rs.getString("phone");
				city = rs.getString("city");
				state = rs.getString("state");
				facultyID = rs.getInt("faculty");
				hallID = rs.getInt("hall");
				faculty = BuildingDao.getBuilding(facultyID);
				hall = BuildingDao.getBuilding(hallID);
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
			return new Profile(id,email,password,phone,city,state,faculty,hall);
		} // end try
		
	}*/
}
