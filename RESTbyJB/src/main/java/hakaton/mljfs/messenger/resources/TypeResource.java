package hakaton.mljfs.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import hakaton.mljfs.messenger.dao.FeatureDao;
import hakaton.mljfs.messenger.dao.TypeDao;
import hakaton.mljfs.messenger.model.Feature;
import hakaton.mljfs.messenger.model.Type;

@Path("/types")
@Consumes(MediaType.APPLICATION_JSON + "; charset=UTF-8")
@Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
public class TypeResource {
	@GET	
	public List<Type> getFeatures() {		
		return TypeDao.getAllTypes();
	}
}
