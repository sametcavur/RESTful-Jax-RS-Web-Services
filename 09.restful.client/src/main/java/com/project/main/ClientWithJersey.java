package com.project.main;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class ClientWithJersey {

	public static void main(String[] args) {
		
		//a�a��ya yazd���m�z clientleri burada �al��t�rmal�y�z
		getInfo();
		getInfoParam("ssset", "cavur");

	}
	
	
	//*******************************************************************************************************
	// 1.Bu clienti �al��t�rmak i�in ilk �nce bir sunucunun �al��mas� laz�m.
	// �lk �nce 06.restful.jackson(json).jersey projesini �al��t�rd�m 
	// Daha sonra alttaki WebResource ye bu �al��t�rd���m sunucunun url'sini yazd�m.
	//2.Client olaylar�n� try-catch i�inde yazmak daha sa�l�kl�d�r.Zorunlu olmad���m halde try-catch i�ine ald�m.
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
	//Parametreli versiyonuda b�yledir.
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
