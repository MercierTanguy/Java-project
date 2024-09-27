package fr.efrei.web.mon_projet;


import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("users")

public class UserEndPoint {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String get() {
		return "totot\nTiti\nTata";
	}
	
	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	public void ad(String name) {
		//inserer
	}
	public void add2(@PathParam("name")String name) {
		
	}
	
}
