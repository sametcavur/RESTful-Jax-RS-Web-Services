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

import org.codehaus.jackson.JsonParseException;
import org.json.simple.parser.ParseException;

import com.project.model.User;

public class UserServices {

	public static void main(String[] args) throws IOException, ParseException, JAXBException {

		try {
			// json olduğunda buraya jsonı bize verecek olan url,xml olduğunda xml verecek
			// url'i alta yaz
			URL url = new URL("http://localhost:8080/02.restful.restEasyy/rest/app/userinfo/xml/1");
			HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
			httpURLConnection.setRequestMethod("GET");
			// json olduğunda json,xml olduğunda xml yazmayı unutma alt satıra
			httpURLConnection.setRequestProperty("Accept", "application/xml");

			if (httpURLConnection.getResponseCode() != 200) {
				throw new RuntimeException("Response Code = " + httpURLConnection.getResponseCode());
			}

			BufferedReader reader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
			String sonuc = reader.readLine();
			System.out.println(sonuc);
			httpURLConnection.disconnect();

			// **************BURASI JAXB YANİ GELEN XML DOSYALARINI ÇEVİRDİĞİMİZ KISIM
			JAXBContext jaxbContext = JAXBContext.newInstance(User.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			User user = (User) unmarshaller.unmarshal(new StringReader(sonuc));

			System.out.println(user.getUserId());
			System.out.println(user.getUsername());
			System.out.println(user.getSurname());
		} catch (JsonParseException e) {
			e.printStackTrace();
		}
		// ************************************************************************

		
		
		
		
// **************BURASI JACKSON YANİ GELEN JSON DOSYALARINI ÇEVİRDİĞİMİZ KISIM
//			JSONParser jsonParser = new JSONParser();
//			Object object = jsonParser.parse(sonuc);
//			JSONObject jsonObject = (JSONObject) object;
//			
//			//****id aslında integer ama programda bug var longa çeviriyoruz o yüzden****
//			long id = (long) jsonObject.get("ıd"); 
//			String adi = (String) jsonObject.get("uname");
//			String soyadi = (String) jsonObject.get("sname");
//			
//			System.out.println(id);
//			System.out.println(adi);
//			System.out.println(soyadi);
//			} catch (JsonParseException e) {
//			e.printStackTrace();
//			}
// ************************************************************************

	}
}