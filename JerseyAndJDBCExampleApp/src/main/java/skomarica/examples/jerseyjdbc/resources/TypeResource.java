package skomarica.examples.jerseyjdbc.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import skomarica.examples.jerseyjdbc.dao.TypeDao;
import skomarica.examples.jerseyjdbc.model.Type;

@Path("/types")
@Consumes(MediaType.APPLICATION_JSON + "; charset=UTF-8")
@Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
public class TypeResource {
	@GET	
	public List<Type> getFeatures() {		
		return TypeDao.getAllTypes();
	}
}
