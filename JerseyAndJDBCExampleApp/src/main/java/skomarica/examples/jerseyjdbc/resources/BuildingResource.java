package skomarica.examples.jerseyjdbc.resources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import skomarica.examples.jerseyjdbc.dao.BuildingDao;
import skomarica.examples.jerseyjdbc.model.Building;

@Path("/buildings")
@Consumes(MediaType.APPLICATION_JSON + "; charset=UTF-8")
@Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")// if you want to provide more consuming and providing formats
// you can supply media type as @Produces(value = {MediaType.APPLICATION_JSON,MediaType.TEXT_XML}) or @Consumes...
// or you can have different methods binded to same path but different media types at Produces annotation
//lets say getJSONMessages and getXMLMessages, so client can provide Accept header value and based on that
//right method will be called(same as for consumes - ContentType header value in client request)
public class BuildingResource {
	
	/*
	 Naming of this method does not count. XML(or JSON in similar way) will be returned in format
	 <messages>
	 	<message>
	 	  <id> 1 </id>
	 	  ...
	 	</message>
	 	...
	 </messages>
	 */
	@GET	
	public List<Building> getBuildings(@QueryParam("type") int type,@QueryParam("features") String features/*@BeanParam MessageFilterBean filterBean*/) {
		if (type > 0) {
			return BuildingDao.getBuildingsOfType(type);
		}
		if (features!=null) {
			String[] featureList = features.split(",");
			List<Integer> featureListInt = new ArrayList<>();
			for (String feature : featureList) {
				try{
					int f = Integer.parseInt(feature);
					featureListInt.add(f);
				}catch(Exception e){
					return null;
				}
			}
			return BuildingDao.getBuildingsWithFeatures(featureListInt);
		}		
		
		return BuildingDao.getAllBuildings();
	}
	
}
