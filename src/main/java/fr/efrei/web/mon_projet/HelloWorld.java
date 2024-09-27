package fr.efrei.web.mon_projet;



import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("")
public class HelloWorld {

	@Path("/hello")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String sayHello() {
		return "<h1>hello</h1>";
	}
	
	@Path("/ping")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response ping() {
	    String jsonResponse = "{\"message\": \"png\"}";
	    return Response.ok(jsonResponse, MediaType.APPLICATION_JSON).build();
	}
}
