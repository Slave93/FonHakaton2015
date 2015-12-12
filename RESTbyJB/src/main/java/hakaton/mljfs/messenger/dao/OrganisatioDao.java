package hakaton.mljfs.messenger.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import hakaton.mljfs.messenger.database.DatabaseConnection;
import hakaton.mljfs.messenger.model.Organisation;
import hakaton.mljfs.messenger.model.Type;

public class OrganisatioDao {
	
	public static Organisation getOrganisation(int id) {
		Connection conn = DatabaseConnection.getConnection();
		PreparedStatement stmt = null;
		String nameen = null;
		String namesr = null;
		try {
			String sql = "SELECT * from organisation where id=?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);			
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				nameen = rs.getString("nameeng");
				namesr = rs.getString("namesr");
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
			return new Organisation(id, nameen, namesr);
		} // end try

	}
}
