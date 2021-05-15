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
	@Path(value = "/userinfo/xml/{id}")
	@Produces(MediaType.APPLICATION_XML)
	//@Produces("application/xml")
	public Response getUserInfoXml(@PathParam(value = "id") Integer id) {
		User user = new User(id,"Samet" ,"Çavur");
		return Response.status(200).entity(user).build();
	}
	@GET
	@Path(value = "/userinfo/xml/{id}/{adi}/{soyadi}")
	@Produces(MediaType.APPLICATION_XML)
	//@Produces("application/xml")
	public Response getUserInfoXml2(
			@PathParam(value = "id") Integer id,
			@PathParam(value = "adi") String adi,
			@PathParam(value = "soyadi") String soyadi) {
		User user = new User(id,adi ,soyadi);
		return Response.status(200).entity(user).build();
	}
	@GET
	@Path(value = "/userinfo/json/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	//@Produces("application/json")
	public Response getUserInfoJson(@PathParam(value = "id") Integer id) {
		User user = new User(id,"Samet" ,"Çavur");
		return Response.status(200).entity(user).build();
	}
	@GET
	@Path(value = "/userinfo/json/{id}/{adi}/{soyadi}")
	@Produces(MediaType.APPLICATION_JSON)
	//@Produces("application/json")
	public Response getUserInfoJson2(
			@PathParam(value = "id") Integer id,
			@PathParam(value = "adi") String adi,
			@PathParam(value = "soyadi") String soyadi) {
		User user = new User(id,adi ,soyadi);
		return Response.status(200).entity(user).build();
	}

}
