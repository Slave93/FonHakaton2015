package hakaton.mljfs.messenger.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import hakaton.mljfs.messenger.database.DatabaseConnection;
import hakaton.mljfs.messenger.model.Building;
import hakaton.mljfs.messenger.model.Feature;
import hakaton.mljfs.messenger.model.Organisation;
import hakaton.mljfs.messenger.model.Site;
import hakaton.mljfs.messenger.model.Type;

public class BuildingDao {
	public static List<Building> getAllBuildings() {
		List<Building> buildings = new ArrayList<>();

		Connection conn = DatabaseConnection.getConnection();
		PreparedStatement stmt = null;

		int id = -1;
		String namesr = null;
		int yearbuild = -1;
		String description = null;

		String features = null;
		List<Feature> featurelist = new ArrayList<>();
		String brojoObrokaUMenzi = null;
		String brojLjudiUMenzi = null;

		String webpage = null;
		String longitude = null;
		String latitude = null;
		String polygon = null;

		String organisationIdString = null;
		Organisation organisation = null;

		int typeId = -1;
		Type type = null;

		String siteId = null;
		Site site = null;

		try {
			String sql = "SELECT * from building";
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				featurelist = new ArrayList<>();
				id = rs.getInt("id");
				namesr = rs.getString("namesr");
				yearbuild = rs.getInt("yearbuild");
				description = rs.getString("description");
				typeId = rs.getInt("type");
				type = TypeDao.getType(typeId);
				features = rs.getString("features");
				if (type != null) {
					List<String> featureStringList = extractFeatures(features);
					if (type.getNamesr().equals("Menza")) {
						try {
							brojLjudiUMenzi = featureStringList.get(0);
							brojoObrokaUMenzi = featureStringList.get(1);
						} catch (Exception e) {
							// e.printStackTrace();
						}
					} else {
						for (int i = 0; i < featureStringList.size(); i++) {
							int featureID = -1;
							try {
								featureID = Integer.parseInt(featureStringList.get(i));
							} catch (Exception e) {
								// e.printStackTrace();
							}
							Feature f = FeatureDao.getFeature(featureID);
							featurelist.add(f);
						}
					}
				}
				webpage = rs.getString("webpage");
				longitude = rs.getString("longitude");
				latitude = rs.getString("latitude");
				polygon = rs.getString("polygon");

				siteId = rs.getString("site");
				site = SiteDao.getSite(siteId);

				int orgID = rs.getInt("organisation");
				organisation = OrganisatioDao.getOrganisation(orgID);

				buildings.add(new Building(id, namesr, yearbuild, description, features, featurelist, brojoObrokaUMenzi,
						brojLjudiUMenzi, webpage, longitude, latitude, polygon, organisation, type, site));
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
			return buildings;
		} // end try

	}

	public static Building getBuilding(int id) {

		Connection conn = DatabaseConnection.getConnection();
		PreparedStatement stmt = null;

		String namesr = null;
		int yearbuild = -1;
		String description = null;

		String features = null;
		List<Feature> featurelist = new ArrayList<>();
		String brojoObrokaUMenzi = null;
		String brojLjudiUMenzi = null;

		String webpage = null;
		String longitude = null;
		String latitude = null;
		String polygon = null;

		String organisationIdString = null;
		Organisation organisation = null;

		int typeId = -1;
		Type type = null;

		String siteId = null;
		Site site = null;

		try {
			String sql = "SELECT * from building where id=?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				featurelist = new ArrayList<>();
				id = rs.getInt("id");
				namesr = rs.getString("namesr");
				yearbuild = rs.getInt("yearbuild");
				description = rs.getString("description");
				typeId = rs.getInt("type");
				type = TypeDao.getType(typeId);
				features = rs.getString("features");
				if (type != null) {
					List<String> featureStringList = extractFeatures(features);
					if (type.getNamesr().equals("Menza")) {
						try {
							brojLjudiUMenzi = featureStringList.get(0);
							brojoObrokaUMenzi = featureStringList.get(1);
						} catch (Exception e) {
							// e.printStackTrace();
						}
					} else {
						for (int i = 0; i < featureStringList.size(); i++) {
							int featureID = -1;
							try {
								featureID = Integer.parseInt(featureStringList.get(i));
							} catch (Exception e) {
								// e.printStackTrace();
							}
							Feature f = FeatureDao.getFeature(featureID);
							featurelist.add(f);
						}
					}
				}
				webpage = rs.getString("webpage");
				longitude = rs.getString("longitude");
				latitude = rs.getString("latitude");
				polygon = rs.getString("polygon");

				siteId = rs.getString("site");
				site = SiteDao.getSite(siteId);

				int orgID = rs.getInt("organisation");
				organisation = OrganisatioDao.getOrganisation(orgID);

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
			return new Building(id, namesr, yearbuild, description, features, featurelist, brojoObrokaUMenzi,
					brojLjudiUMenzi, webpage, longitude, latitude, polygon, organisation, type, site);
		} // end try

	}

	public static Building getBuilding(String namesr) {

		Connection conn = DatabaseConnection.getConnection();
		PreparedStatement stmt = null;

		int id = -1;
		int yearbuild = -1;
		String description = null;

		String features = null;
		List<Feature> featurelist = new ArrayList<>();
		String brojoObrokaUMenzi = null;
		String brojLjudiUMenzi = null;

		String webpage = null;
		String longitude = null;
		String latitude = null;
		String polygon = null;

		String organisationIdString = null;
		Organisation organisation = null;

		int typeId = -1;
		Type type = null;

		String siteId = null;
		Site site = null;

		try {
			String sql = "SELECT * from building where namesr=?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, namesr);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				featurelist = new ArrayList<>();
				id = rs.getInt("id");				
				yearbuild = rs.getInt("yearbuild");
				description = rs.getString("description");
				typeId = rs.getInt("type");
				type = TypeDao.getType(typeId);
				features = rs.getString("features");
				if (type != null) {
					List<String> featureStringList = extractFeatures(features);
					if (type.getNamesr().equals("Menza")) {
						try {
							brojLjudiUMenzi = featureStringList.get(0);
							brojoObrokaUMenzi = featureStringList.get(1);
						} catch (Exception e) {
							// e.printStackTrace();
						}
					} else {
						for (int i = 0; i < featureStringList.size(); i++) {
							int featureID = -1;
							try {
								featureID = Integer.parseInt(featureStringList.get(i));
							} catch (Exception e) {
								// e.printStackTrace();
							}
							Feature f = FeatureDao.getFeature(featureID);
							featurelist.add(f);
						}
					}
				}
				webpage = rs.getString("webpage");
				longitude = rs.getString("longitude");
				latitude = rs.getString("latitude");
				polygon = rs.getString("polygon");

				siteId = rs.getString("site");
				site = SiteDao.getSite(siteId);

				int orgID = rs.getInt("organisation");
				organisation = OrganisatioDao.getOrganisation(orgID);

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
			return new Building(id, namesr, yearbuild, description, features, featurelist, brojoObrokaUMenzi,
					brojLjudiUMenzi, webpage, longitude, latitude, polygon, organisation, type, site);
		} // end try

	}

	private static List<String> extractFeatures(String features) {
		String[] featureList = features.split(",");
		return Arrays.asList(featureList);
	}

	public static List<Building> getBuildingsOfType(int typeID) {
		List<Building> buildings = new ArrayList<>();

		Connection conn = DatabaseConnection.getConnection();
		PreparedStatement stmt = null;

		int id = -1;
		String namesr = null;
		int yearbuild = -1;
		String description = null;

		String features = null;
		List<Feature> featurelist = new ArrayList<>();
		String brojoObrokaUMenzi = null;
		String brojLjudiUMenzi = null;

		String webpage = null;
		String longitude = null;
		String latitude = null;
		String polygon = null;

		String organisationIdString = null;
		Organisation organisation = null;

		int typeId = -1;
		Type type = null;

		String siteId = null;
		Site site = null;

		try {
			String sql = "SELECT * from building where type=?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, typeID);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				featurelist = new ArrayList<>();
				id = rs.getInt("id");
				namesr = rs.getString("namesr");
				yearbuild = rs.getInt("yearbuild");
				description = rs.getString("description");
				typeId = rs.getInt("type");
				type = TypeDao.getType(typeId);
				features = rs.getString("features");
				if (type != null) {
					List<String> featureStringList = extractFeatures(features);
					if (type.getNamesr().equals("Menza")) {
						try {
							brojLjudiUMenzi = featureStringList.get(0);
							brojoObrokaUMenzi = featureStringList.get(1);
						} catch (Exception e) {
							// e.printStackTrace();
						}
					} else {
						for (int i = 0; i < featureStringList.size(); i++) {
							int featureID = -1;
							try {
								featureID = Integer.parseInt(featureStringList.get(i));
							} catch (Exception e) {
								// e.printStackTrace();
							}
							Feature f = FeatureDao.getFeature(featureID);
							featurelist.add(f);
						}
					}
				}
				webpage = rs.getString("webpage");
				longitude = rs.getString("longitude");
				latitude = rs.getString("latitude");
				polygon = rs.getString("polygon");

				siteId = rs.getString("site");
				site = SiteDao.getSite(siteId);

				int orgID = rs.getInt("organisation");
				organisation = OrganisatioDao.getOrganisation(orgID);

				buildings.add(new Building(id, namesr, yearbuild, description, features, featurelist, brojoObrokaUMenzi,
						brojLjudiUMenzi, webpage, longitude, latitude, polygon, organisation, type, site));
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
			return buildings;
		}
	}

	/*
	 * public static List<Building> getBuildingsWithFeatures(List<Integer>
	 * featuresID) { List<Building> buildings = new ArrayList<>();
	 * 
	 * Connection conn = DatabaseConnection.getConnection(); PreparedStatement
	 * stmt = null;
	 * 
	 * int id = -1; String namesr = null; int yearbuild = -1; String description
	 * = null;
	 * 
	 * String features = null; List<Feature> featurelist = new ArrayList<>();
	 * String brojoObrokaUMenzi = null; String brojLjudiUMenzi = null;
	 * 
	 * String webpage = null; String longitude = null; String latitude = null;
	 * String polygon = null;
	 * 
	 * String organisationIdString = null; Organisation organisation = null;
	 * 
	 * int typeId = -1; Type type = null;
	 * 
	 * String siteId = null; Site site = null;
	 * 
	 * try { String sql = "SELECT * from building where features like ?"; String
	 * where = ""; for (int i = 0; i < featuresID.size(); i++) { String zarez =
	 * ""; if (i != featuresID.size() - 1) { zarez += ","; } where +=
	 * featuresID.get(i) + zarez; } stmt = conn.prepareStatement(sql);
	 * stmt.setString(1, "%" + where + "%"); ResultSet rs = stmt.executeQuery();
	 * while (rs.next()) { featurelist = new ArrayList<>(); id =
	 * rs.getInt("id"); namesr = rs.getString("namesr"); yearbuild =
	 * rs.getInt("yearbuild"); description = rs.getString("description"); typeId
	 * = rs.getInt("type"); type = TypeDao.getType(typeId); features =
	 * rs.getString("features"); if (type != null) { List<String>
	 * featureStringList = extractFeatures(features); if
	 * (type.getNamesr().equals("Menza")) { try { brojLjudiUMenzi =
	 * featureStringList.get(0); brojoObrokaUMenzi = featureStringList.get(1); }
	 * catch (Exception e) { e.printStackTrace(); } } else { for (int i = 0; i <
	 * featureStringList.size(); i++) { int featureID = -1; try { featureID =
	 * Integer.parseInt(featureStringList.get(i)); } catch (Exception e) {
	 * e.printStackTrace(); } Feature f = FeatureDao.getFeature(featureID);
	 * featurelist.add(f); } } } webpage = rs.getString("webpage"); longitude =
	 * rs.getString("longitude"); latitude = rs.getString("latitude"); polygon =
	 * rs.getString("polygon");
	 * 
	 * siteId = rs.getString("site"); site = SiteDao.getSite(siteId);
	 * 
	 * int orgID = rs.getInt("organisation"); organisation =
	 * OrganisatioDao.getOrganisation(orgID);
	 * 
	 * buildings.add(new Building(id, namesr, yearbuild, description, features,
	 * featurelist, brojoObrokaUMenzi, brojLjudiUMenzi, webpage, longitude,
	 * latitude, polygon, organisation, type, site)); } rs.close();
	 * stmt.close(); conn.close();
	 * 
	 * } catch (SQLException se) { // Handle errors for JDBC
	 * se.printStackTrace(); } catch (Exception e) { // Handle errors for
	 * Class.forName e.printStackTrace(); } finally { // finally block used to
	 * close resources try { if (stmt != null) stmt.close(); } catch
	 * (SQLException se2) { } // nothing we can do try { if (conn != null)
	 * conn.close(); } catch (SQLException se) { se.printStackTrace(); } // end
	 * finally try return buildings; } }
	 */

	public static List<Building> getBuildingsWithFeatures(List<Integer> featuresID) {
		List<Building> allBuildings = getAllBuildings();
		List<Building> buildingsWithFeatures = new ArrayList<>();
		for (int i = 0; i < allBuildings.size(); i++) {
			Building b = allBuildings.get(i);
			String buildingFeatures = b.getFeatures();
			String[] buildingFeaturesNiz = buildingFeatures.split(",");
			boolean sadrziSve = true;
			sadrziSve = containsAllFeatures(buildingFeaturesNiz, featuresID);
			if (sadrziSve) {
				buildingsWithFeatures.add(b);
			}
		}
		return buildingsWithFeatures;
	}

	public static boolean containsAllFeatures(String[] features, List<Integer> featuresToContain) {
		boolean sadrzi = false;
		for (int i = 0; i < featuresToContain.size(); i++) {
			for (int j = 0; j < features.length; j++) {
				if (features[j].equals(featuresToContain.get(i).toString())) {
					sadrzi = true;
					break;
				}
				sadrzi = false;
			}
			if (sadrzi == false)
				break;
		}
		return sadrzi;
	}
}
