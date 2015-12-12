package hakaton.mljfs.messenger.resources;

import hakaton.mljfs.messenger.exception.DataNotFoundException;
import hakaton.mljfs.messenger.model.Message;
import hakaton.mljfs.messenger.resources.beans.MessageFilterBean;
import hakaton.mljfs.messenger.service.MessageService;

import java.net.URI;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("/jbmessages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)// if you want to provide more consuming and providing formats
// you can supply media type as @Produces(value = {MediaType.APPLICATION_JSON,MediaType.TEXT_XML}) or @Consumes...
// or you can have different methods binded to same path but different media types at Produces annotation
//lets say getJSONMessages and getXMLMessages, so client can provide Accept header value and based on that
//right method will be called(same as for consumes - ContentType header value in client request)
public class MessageResource {

	MessageService messageService = new MessageService();
	/*
	 Naming of this method does not count. XML will be returned in format
	 <messages>
	 	<message>
	 	  <id> 1 </id>
	 	  ...
	 	</message>
	 	...
	 </messages>
	 */
	@GET
	@Produces(value = {MediaType.APPLICATION_JSON,MediaType.TEXT_XML})
	public List<Message> getMessages(@BeanParam MessageFilterBean filterBean) {
		if (filterBean.getYear() > 0) {
			return messageService.getAllMessagesForYear(filterBean.getYear());
		}
		if (filterBean.getStart() >= 0 && filterBean.getSize() > 0) {
			return messageService.getAllMessagesPaginated(filterBean.getStart(), filterBean.getSize());
		}
		return messageService.getAllMessages();
	}

	@POST
	public Response addMessage(Message message,@Context UriInfo uriInfo) {
		messageService.addMessage(message);
		//mozes da koristis i Response.status(...).entity().build(); ali imas i ovako metode koje automatski
		//postavljaju status plus ova created prima sta je to kreirano
		return Response.created(uriInfo.getAbsolutePathBuilder().path(String.valueOf(message.getId())).build())
					   .entity(message).build();
	}
	
	@PUT
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId") long id, Message message) {
		message.setId(id);
		//mogao si i ovde da menjas statuse i to...
		return messageService.updateMessage(message);
	}
	
	@DELETE
	@Path("/{messageId}")
	public void deleteMessage(@PathParam("messageId") long id) {
		messageService.removeMessage(id);
	}
	
	
	@GET
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId") long id, @Context UriInfo uriInfo) {
		Message message = messageService.getMessage(id);
		message.addLink(getUriForSelf(uriInfo, message), "self");
		message.addLink(getUriForProfile(uriInfo, message), "profile");
		message.addLink(getUriForComments(uriInfo, message), "comments");
		
		return message;
		
	}
	
	@Path("/{messageId}/comments")
	public CommentResource getCommentResource() {
		return new CommentResource();
	}

	private String getUriForComments(UriInfo uriInfo, Message message) {
		URI uri = uriInfo.getBaseUriBuilder()
				.path(MessageResource.class)
	       		.path(MessageResource.class, "getCommentResource")
	       		.path(CommentResource.class)
	       		.resolveTemplate("messageId", message.getId())// cause now link contain's variable portion of messageId we need to resolve that to a value
	            .build();
	    return uri.toString();
	}

	private String getUriForProfile(UriInfo uriInfo, Message message) {
		URI uri = uriInfo.getBaseUriBuilder()
       		 .path(ProfileResource.class)
       		 .path(message.getAuthor())
             .build();
        return uri.toString();
	}

	private String getUriForSelf(UriInfo uriInfo, Message message) {
		String uri = uriInfo.getBaseUriBuilder()
		 .path(MessageResource.class)
		 .path(Long.toString(message.getId()))
		 .build()
		 .toString();
		return uri;
	}
	
	
	
}
