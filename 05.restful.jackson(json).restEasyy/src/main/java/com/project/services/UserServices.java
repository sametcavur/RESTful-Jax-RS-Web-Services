package com.project.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class UserServices {

	public static void main(String[] args) throws IOException {

		try {
			//url'nin sonuna 99999 yazdýðýmýz için biz sunucuya hangi id gönderirsek gönderelim bunu yazdýracak
			URL url = new URL("http://localhost:8080/05.restful.jackson/rest/app/userinfo/99999");
			HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
			httpURLConnection.setRequestMethod("GET");
			httpURLConnection.setRequestProperty("Accept","application/json");
			
			if(httpURLConnection.getResponseCode() != 200) {
				throw new RuntimeException("Response Code = "+httpURLConnection.getResponseCode());
			}
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
			String sonuc = reader.readLine();
			System.out.println(sonuc);
			httpURLConnection.disconnect();
			
			JSONParser jsonParser = new JSONParser();
			Object object = jsonParser.parse(sonuc);
			
			JSONObject jsonObject = (JSONObject) object;
			
			long userId = (long) jsonObject.get("userId");  // int yazarsak programda bug çýkýyor o yüzden long yazdýk
			String username = (String) jsonObject.get("username");
			String surname = (String) jsonObject.get("surname");
			
			
			System.out.println(userId);
			System.out.println(username);
			System.out.println(surname);
			
		}catch (Exception e) {
			// TODO: handle exception
		}

	}
}