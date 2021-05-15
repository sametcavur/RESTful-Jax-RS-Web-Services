package com.project.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import com.project.model.User;

public class UserServices {

	public static void main(String[] args) throws IOException {

		try {
			URL url = new URL("http://localhost:8080/02.restful.restEasyy/rest/app/userinfo/1");
			HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
			httpURLConnection.setRequestMethod("GET");
			httpURLConnection.setRequestProperty("Accept","application/xml");
			
			if(httpURLConnection.getResponseCode() != 200) {
				throw new RuntimeException("Response Code = "+httpURLConnection.getResponseCode());
			}
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
			String sonuc = reader.readLine();
			System.out.println(sonuc); //Burada xml formatında yazdırdık
			httpURLConnection.disconnect();
			
			JAXBContext jaxbContext = JAXBContext.newInstance(User.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			User user = (User) unmarshaller.unmarshal(new StringReader(sonuc));
		
			System.out.println(user.getUserId()); //Burada tek tek javaya uygun yazdırdık
			System.out.println(user.getUsername());
			System.out.println(user.getSurname());
			
		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}
}