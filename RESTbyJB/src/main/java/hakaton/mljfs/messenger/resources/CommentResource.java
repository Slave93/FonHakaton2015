package hakaton.mljfs.messenger.resources;

import hakaton.mljfs.messenger.model.Comment;
import hakaton.mljfs.messenger.model.ErrorMessage;
import hakaton.mljfs.messenger.service.CommentService;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CommentResource {

	//kod ovih metoda imas i @PathParam messageId od MessageResource klase jer
	//smo odale dosli pa se path samo dopunjuje
	
	private CommentService commentService = new CommentService();
	
	@GET
	public List<Comment> getAllComments(@PathParam("messageId") long messageId) {
		return commentService.getAllComments(messageId);
	}
	
	@POST
	public Comment addComment(@PathParam("messageId") long messageId, Comment comment) {
		return commentService.addComment(messageId, comment);
	}
	
	@PUT
	@Path("/{commentId}")
	public Comment updateComment(@PathParam("messageId") long messageId, @PathParam("commentId") long id, Comment comment) {
		comment.setId(id);
		return commentService.updateComment(messageId, comment);
	}
	
	@DELETE
	@Path("/{commentId}")
	public void deleteComment(@PathParam("messageId") long messageId, @PathParam("commentId") long commentId) {
		commentService.removeComment(messageId, commentId);
	}
	
	
	@GET
	@Path("/{commentId}")
	public Comment getMessage(@PathParam("messageId") long messageId, @PathParam("commentId") long commentId) {
		Comment comment = commentService.getComment(messageId, commentId);
		if(comment==null){
			// Ovo su BUILT IN 	exceptioni JAX-RS-a koje mozes da koristis bez mappera
			// mozes da koristis i neke od podklasa WebApplicationException klase
			// kao sto su NotFound,ServerError, gde je status vec podesen pa ne moras da bildujes
			// response samo prosledis errorMessage konstruktoru exceptiona
			ErrorMessage errorMessage = new ErrorMessage("Not found", 404, "http://javabrains.koushik.org");
			Response res =  Response.status(Status.NOT_FOUND).entity(errorMessage).build();
			throw new  WebApplicationException(res);
		}
		return comment;
	}
	
}
