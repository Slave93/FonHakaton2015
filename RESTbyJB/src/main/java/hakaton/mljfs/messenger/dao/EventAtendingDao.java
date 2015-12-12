package hakaton.mljfs.messenger.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hakaton.mljfs.messenger.database.DatabaseConnection;
import hakaton.mljfs.messenger.model.Feature;
import hakaton.mljfs.messenger.model.Profile;

public class EventAtendingDao {
	
public static List<Profile> getEventAtendies(int eventid) {
		
		List<Profile> lp = new ArrayList<>();
	
		Connection conn = DatabaseConnection.getConnection();
		PreparedStatement stmt = null;
		int atendieID = -1;
		Profile atendie = null;		
		try {
			String sql = "SELECT atendie from eventatending where event = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, eventid);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {				
				atendieID = rs.getInt("atendie");
				atendie = ProfileDao.getProfileByID(atendieID);
				lp.add(atendie);
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
			return lp;
		} // end try

	}
	
}
