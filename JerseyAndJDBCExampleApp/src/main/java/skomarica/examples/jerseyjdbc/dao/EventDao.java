package skomarica.examples.jerseyjdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import skomarica.examples.jerseyjdbc.database.DatabaseConnection;
import skomarica.examples.jerseyjdbc.model.Building;
import skomarica.examples.jerseyjdbc.model.Event;
import skomarica.examples.jerseyjdbc.model.Feature;
import skomarica.examples.jerseyjdbc.model.Profile;

public class EventDao {
public static List<Event> getAllEvents() {
		
		List<Event> le = new ArrayList<>();
	
		Connection conn = DatabaseConnection.getConnection();
		PreparedStatement stmt = null;

		int id;
		int adminID;
		Profile admin;
		List<Profile> atendies;
		String type;
		String place;
		Date time;
		int minatend;
		int maxatend;
		String description;
		String name;	
		
		
		try {
			String sql = "SELECT * from event";
			stmt = conn.prepareStatement(sql);					
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				id = rs.getInt("id");
				adminID = rs.getInt("admin");
				admin = ProfileDao.getProfileByID(adminID);
				atendies = EventAtendingDao.getEventAtendies(id);		
				type = rs.getString("type");
				place = rs.getString("place");
				time = rs.getDate("time");
				minatend = rs.getInt("minatend");
				maxatend = rs.getInt("maxatend");		
				description = rs.getString("description");
				name = rs.getString("name");
				le.add(new Event(id,admin,atendies,type,place,time,minatend,maxatend,description,name));
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
			return le;
		} // end try

	}

public static boolean addAtendie(int profileID, int eventID) {
	Connection conn = DatabaseConnection.getConnection();
	PreparedStatement stmt = null;
	boolean sucess = false;
	
	try {
		String sql = "insert into eventatending(atendie,event) values(?,?)";
		stmt = conn.prepareStatement(sql);
		stmt.setInt(1,profileID);
		stmt.setInt(2,eventID);			
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
}
