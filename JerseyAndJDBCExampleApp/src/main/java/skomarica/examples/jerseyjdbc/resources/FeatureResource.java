package skomarica.examples.jerseyjdbc.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import skomarica.examples.jerseyjdbc.dao.FeatureDao;
import skomarica.examples.jerseyjdbc.model.Feature;

@Path("/features")
@Consumes(MediaType.APPLICATION_JSON + "; charset=UTF-8")
@Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
public class FeatureResource {
	
	@GET	
	public List<Feature> getFeatures() {		
		return FeatureDao.getAllFeatures();
	}
}
