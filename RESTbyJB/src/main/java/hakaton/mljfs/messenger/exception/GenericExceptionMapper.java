package hakaton.mljfs.messenger.exception;

import hakaton.mljfs.messenger.model.ErrorMessage;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

// This class intentionally doesn't have the @Provider annotation.
// It has been disabled in order to try out other ways of throwing exceptions in JAX-RS

//Ovo je super stvar jer naprimer moze da ti se dogode razni izuzetci. Npr bas ukoliko trazis
//poruku -> /messages/99999 koja ne postoji doci ce do null pointer exceptiona. Koji i se prikazao
//korisniku uz 500 status a ovako ce dobiti samo 500 status.
//@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

	@Override
	public Response toResponse(Throwable ex) {
		ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), 500, "http://javabrains.koushik.org");
		return Response.status(Status.INTERNAL_SERVER_ERROR)
				.entity(errorMessage)
				.build();
	}

}