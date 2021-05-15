package com.project;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/app")
public class Main {
	// -----------------------------------
	// Standart Rest API
	@GET
	@Path("/selam")
	@Produces(value = MediaType.TEXT_PLAIN)
	public String selam1() {
		return "Selam";
	}
	// -----------------------------------
	/*
	 * Alternatif Yol,200 yanýtý olumlu sonuç döndüðünde bu metodu çaðýracak, 404
	 * yazarak sorun olmasaydý bile kullanýcýya 404 not found döndürebiliriz.
	 */
	@GET
	@Path("/selamAlternatif")
	@Produces(value = MediaType.TEXT_PLAIN)
	public Response selamAlternatif() {
		return Response.status(200).entity("Selam Alternatif Yol").build();
	}
	// -----------------------------------
	// Parametreli yol
	@GET
	@Path("/selam/{adi}")
	@Produces(value = MediaType.TEXT_PLAIN)
	public Response selamParametreli(@PathParam(value = "adi") String adi) {
		return Response.status(200).entity("Selam " + adi).build();
	}
	// -----------------------------------
	// 2 Parametreli yol
	@GET
	@Path("/selam/{adi}/{soyadi}")
	@Produces(value = MediaType.TEXT_PLAIN)
	public Response selam2Parametreli(@PathParam(value = "adi") String adi, @PathParam(value = "soyadi") String soyadi) {
		return Response.status(200).entity("Selam " + adi +" " + soyadi).build();
	}
	// -----------------------------------
	// Burada gonderilen cevap text deðil html'dir
	@GET
	@Path("/selamhtml")
	@Produces(MediaType.TEXT_HTML)
	public Response selamHtmlGonder() {
		return Response.status(200).entity("<font size=25> Selam HTML </font>").build();
	}
	// -----------------------------------
	// Burada gonderilen cevap text deðil html'dir
	@GET
	@Path("/selamxml")
	@Produces(value = MediaType.TEXT_XML)
	public Response selamXmlGonder() {
		String mesaj ="<selam> Selam XML </selam>";
		return Response.status(200).entity(mesaj).build();
	}
}
