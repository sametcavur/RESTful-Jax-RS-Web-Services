package com.project.main;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.project.model.User;

@Path(value = "/app")
public class Main {
	@GET
	@Path(value = "/userinfo/{id}")
	@Produces(MediaType.APPLICATION_XML)
	//@Produces("application/xml")
	public Response getUserInfo(@PathParam(value = "id") Integer id) {
		User user = new User(id,"Samet" ,"Çöğşavur");
		return Response.status(200).entity(user).build();
	}

}
