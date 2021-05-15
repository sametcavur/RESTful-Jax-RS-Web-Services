package com.project.main;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path(value = "/app")
public class Main {
	
	@GET
	@Path(value = "/xml")
	@Produces(MediaType.APPLICATION_XML)
	public String getUserInfo() {
		String name = "Samet";
		String surname = "Cavur";
		
		return "<user>\r\n"
				+ "		<name>"+name+"</name>\r\n"
				+ "		<sname>"+surname+"</sname>\r\n"
				+ "	</user>";
	}
}
