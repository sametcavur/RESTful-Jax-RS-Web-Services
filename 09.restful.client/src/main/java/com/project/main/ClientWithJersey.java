package com.project.main;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class ClientWithJersey {

	public static void main(String[] args) {
		
		//aþaðýya yazdýðýmýz clientleri burada çalýþtýrmalýyýz
		getInfo();
		getInfoParam("ssset", "cavur");

	}
	
	
	//*******************************************************************************************************
	// 1.Bu clienti çalýþtýrmak için ilk önce bir sunucunun çalýþmasý lazým.
	// Ýlk önce 06.restful.jackson(json).jersey projesini çalýþtýrdým 
	// Daha sonra alttaki WebResource ye bu çalýþtýrdýðým sunucunun url'sini yazdým.
	//2.Client olaylarýný try-catch içinde yazmak daha saðlýklýdýr.Zorunlu olmadýðým halde try-catch içine aldým.
	public static void getInfo() {
		try {
			Client client = Client.create();
			WebResource webResource = client.resource("http://localhost:8080/04.2.restful.jackson/rest/app/json");
			ClientResponse clientResponse = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
			if (clientResponse.getStatus() != 200) {
				System.out.println("Hata Meydana Geldi,Status Code : " + clientResponse.getStatus());
			} else {
				System.out.println(clientResponse.getEntity(String.class));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	//*******************************************************************************************************
	
	
	
	//*******************************************************************************************************
	//Parametreli versiyonuda böyledir.
	public static void getInfoParam(String name,String surname) {
		try {
			Client client = Client.create();
			WebResource webResource = client.resource("http://localhost:8080/04.2.restful.jackson/rest/app/"+name+"/"+surname+"");
			ClientResponse clientResponse = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
			if (clientResponse.getStatus() != 200) {
				System.out.println("Hata Meydana Geldi,Status Code : " + clientResponse.getStatus());
			} else {
				System.out.println(clientResponse.getEntity(String.class));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	//*******************************************************************************************************
}
