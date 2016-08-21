package skomarica.examples.jerseyjdbc.helperservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import skomarica.examples.jerseyjdbc.dao.BuildingDao;
import skomarica.examples.jerseyjdbc.dao.FeatureDao;
import skomarica.examples.jerseyjdbc.dao.OrganisatioDao;
import skomarica.examples.jerseyjdbc.dao.SiteDao;
import skomarica.examples.jerseyjdbc.dao.TypeDao;
import skomarica.examples.jerseyjdbc.database.DatabaseConnection;
import skomarica.examples.jerseyjdbc.model.Building;
import skomarica.examples.jerseyjdbc.model.Feature;
import skomarica.examples.jerseyjdbc.model.Organisation;
import skomarica.examples.jerseyjdbc.model.Site;
import skomarica.examples.jerseyjdbc.model.Type;

public class TestConnectionServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*Connection conn = DatabaseConnection.getConnection();
		Statement stmt = null;
		try{
			stmt = conn.createStatement();
	      String sql;
	      sql = "SELECT * FROM test";
	      ResultSet rs = stmt.executeQuery(sql);

	      //STEP 5: Extract data from result set
	      while(rs.next()){
	         //Retrieve by column name
	         int id  = rs.getInt("id");
	         String age = rs.getString("name");         

	         //Display values
	         System.out.print("ID: " + id);
	         System.out.print(", Age: " + age);
	        
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
	   }//end try
	   System.out.println("Goodbye!");
		
		PrintWriter pr = response.getWriter();
		pr.println("connection sucessful");		
	*/
		
		/*Type t = TypeDao.getType(1);		
		System.out.println(t.getNameeng());
		System.out.println(t.getNamesr());
		System.out.println(t.getId());
		System.out.println("##################");
		System.out.println("##################");
		List<Type> listt = TypeDao.getAllTypes();
		for (int i = 0; i < listt.size(); i++) {
			t = listt.get(i);
			System.out.println(t.getNameeng());
			System.out.println(t.getNamesr());
			System.out.println(t.getId());
		}
		System.out.println("##################");
		System.out.println("##################");
		Feature f = FeatureDao.getFeature(1);
		System.out.println(f.getNameeng());
		System.out.println(f.getNamesr());
		System.out.println(f.getId());
		System.out.println("##################");
		System.out.println("##################");
		List<Feature> listf = FeatureDao.getAllFeatures();
		for (int i = 0; i < listf.size(); i++) {
			f = listf.get(i);
			System.out.println(f.getNameeng());
			System.out.println(f.getNamesr());
			System.out.println(f.getId());
		}
		System.out.println("##################");
		System.out.println("##################");
		Site s = SiteDao.getSite("bor");
		System.out.println(s.getNameeng());
		System.out.println(s.getPolygon());
		System.out.println(s.getId());
		System.out.println("##################");
		Organisation o = OrganisatioDao.getOrganisation(1);
		System.out.println(o.getNameeng());
		System.out.println(o.getNamesr());
		System.out.println(o.getId());
		System.out.println("##################");
		System.out.println("######################################");
		System.out.println("######################################");
		System.out.println("######################################");
		System.out.println("######################################");
		System.out.println("######################################");
		System.out.println("######################################");*/		
		List<Building> lb = BuildingDao.getBuildingsWithFeatures(Arrays.asList(new Integer[]{1,2,3,4,5,6,7,8,9,10}));
		for (int i = 0; i < lb.size(); i++) {
			System.out.println("######################################");
			System.out.println(lb.get(i).getId());
			System.out.println(lb.get(i).getNamesr());
			System.out.println(lb.get(i).getYearbuild());
			System.out.println(lb.get(i).getDescription());	
			
			System.out.println(lb.get(i).getFeatures());			
			System.out.println(lb.get(i).getBrojLjudiUMenzi());
			System.out.println(lb.get(i).getBrojoObrokaUMenzi());
			System.out.println("-----listafičura------");
			List<Feature> lf = lb.get(i).getFeaturelist();
			for(int j = 0; j<lf.size(); j++){
				System.out.println(lf.get(j).getId());
				System.out.println(lf.get(j).getNameeng());
				System.out.println(lf.get(j).getNamesr());
			}
			System.out.println("-----listafičura------");
			
			System.out.println(lb.get(i).getWebpage());
			System.out.println(lb.get(i).getLongitude());					
			System.out.println(lb.get(i).getLatitude());			
			System.out.println(lb.get(i).getPolygon());
			
			System.out.println("-----organizacija------");
			System.out.println(lb.get(0).getOrganisation().getId());
			System.out.println(lb.get(0).getOrganisation().getNameeng());
			System.out.println(lb.get(0).getOrganisation().getNamesr());
			System.out.println("-----organizacija------");
			
			System.out.println("-----tip------");			
			System.out.println(lb.get(0).getType().getId());
			System.out.println(lb.get(0).getType().getNameeng());
			System.out.println(lb.get(0).getType().getNamesr());
			System.out.println("-----tip------");
			
			System.out.println("-----site------");
			System.out.println(lb.get(0).getSite().getId());
			System.out.println(lb.get(0).getSite().getNameeng());
			System.out.println(lb.get(0).getSite().getPolygon());
			System.out.println("-----site------");
			
			System.out.println("######################################");
			System.out.println("######################################");
			System.out.println("######################################");
			System.out.println("######################################");
			
			
			
		}
		
		
		
	}
}
