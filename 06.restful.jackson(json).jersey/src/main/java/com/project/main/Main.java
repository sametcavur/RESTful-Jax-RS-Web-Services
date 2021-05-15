package com.project.main;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

@Path(value = "/app")
public class Main {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/json")
	public Response getJson() {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", "Smet");
		jsonObject.put("surname", "Cavur");
		return Response.status(200).entity(jsonObject.toString()).build();
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{name}/{surname}")
	public Response getJsonParam(@PathParam(value = "name") String name,@PathParam(value = "surname") String surname) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", name);
		jsonObject.put("surname", surname);
		return Response.status(200).entity(jsonObject.toString()).build();
	}
}
