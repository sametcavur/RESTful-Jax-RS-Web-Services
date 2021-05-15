package com.project.restfulServices;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.project.model.User;
import com.project.repository.UserRepository;

@Path(value = "/app")
public class UserRestfulServices {
	
	// @Consumes(MediaType.APPLICATION_XML) > Programa bir xml yada json yollacaksak bu
	// @Produces(MediaType.APPLICATION_XML) > Programdan bir xml yada json dosyası alacaksak bu
	// Her ikisinide kullanabiliriz.
	
	//*****************************************************************************************
	@GET
	@Path(value = "/userinfo")
	@Produces(MediaType.APPLICATION_XML)
	public List<User> findAllUsers() throws ClassNotFoundException{
		UserRepository repository = new UserRepository();
		List<User> users = repository.findAllUsers();
		return users;
	}
	
	//*****************************************************************************************
	@GET
	@Path(value = "/userinfo/{userId}")
	@Produces(MediaType.APPLICATION_XML)
	public User findUserById(@PathParam ("userId") int userId) throws ClassNotFoundException{
		UserRepository repository = new UserRepository();
		User user = repository.findUserById(userId);
		return user;
	}
	
	//*****************************************************************************************
	//1.Postmana gir url satırına bu alttaki url yi gir ve POST olarak seç daha sonra altta 
	//'Body' diye bir kısım var oraya istediğim bilgileri 'xml' formatında gir ve send'e bas
	//2.Metodun üstüne POST yazdığımız için gönderilen xml formatındaki Useri alıp bu metodda kullanacak
	@POST
	@Path("/userinfo/insertuser")
	@Consumes(MediaType.APPLICATION_XML)
	public Response insertUser(User user) throws ClassNotFoundException {
		UserRepository repository = new UserRepository();
		repository.insertUser(user);
		return Response.status(200).build();
	}

	//*****************************************************************************************
	//1.Parametrede ki userId ile güncellemek istediğimiz useri bulduk ve 
	//yine parametredeki User user ile güncellenmiş veriyi döndürdük
	//2.Hem güncellenmiş veriyi gönderdik hemde bunu xml formatında yazdırdığımız için
	//aşağıda hem consumes hem produces yazdık,sadece gönderecek olsaydık consumes yazmamız yeterliydi.
	@PUT
	@Path("/userinfo/updateuser/{userId}")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public User updateUser(@PathParam ("userId") int userId,User user) throws ClassNotFoundException {
		UserRepository repository = new UserRepository();
		repository.updateUser(userId, user);
		return user;
	}
	
	//*****************************************************************************************
	//Herhangi bir xml gönderip almayacağız sadece bir veri sileceğimiz için produces yada consumes kullanmadık.
	@DELETE
	@Path("/userinfo/deleteuser/{userId}")
	public Response deleteUser(@PathParam ("userId") int userId){
		UserRepository repository = new UserRepository();
		try {
			repository.deleteUser(userId);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return Response.status(404).build();
		}
		return Response.status(200).build();
	}
	//*****************************************************************************************
}
