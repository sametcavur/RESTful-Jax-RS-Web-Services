package com.project.main;

import javax.websocket.server.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.project.model.User;

@Path(value = "/app")
public class Main {
	/*
	 * Burada bir nesne yani jsonın elementleri belli bir json dosyası döndürdük.
	 * elementlerini ise User pojosunda otomatik oluşturdu.Contructor yoluyla.
	 *
	 * Fakat elementleri belli olmayan,elementlerini manuel olarak verebileceğimiz
	 * Json dosyalı rest apiyi  04.2 dersinde yaptım.
	 *
	 */

	@GET
	@Path(value = "/userinfo/{id}")
	//@Produces(MediaType.APPLICATION_JSON)
	@Produces("application/json")
	public Response getUserInfo(@PathParam(value = "id") Integer id) {
		User user = new User(id, "Samet", "cavur");
		return Response.status(200).entity(user).build();
	}

}
