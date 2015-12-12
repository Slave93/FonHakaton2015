package hakaton.mljfs.messenger.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import hakaton.mljfs.messenger.database.DatabaseConnection;
import hakaton.mljfs.messenger.model.Site;
import hakaton.mljfs.messenger.model.Type;

public class SiteDao {
	public static Site getSite(String id) {
		Connection conn = DatabaseConnection.getConnection();
		PreparedStatement stmt = null;
		String nameeng = null;
		String polygon = null;
		try {
			String sql = "SELECT * from site where id=?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);			
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				nameeng = rs.getString("nameeng");
				polygon = rs.getString("polygon");
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
			return new Site(id, nameeng, polygon);
		} // end try

	}
}
