package com.project.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

public class ClientWithApache {

	public static void main(String[] args) {

		getInfo();
		getInfoParam("Samco","Urfa");
	}

	public static void getInfo() {
		try {
			HttpClient httpClient = HttpClientBuilder.create().build();
			HttpGet httpGet = new HttpGet("http://localhost:8080/04.2.restful.jackson/rest/app/json");
			httpGet.addHeader("accept", "application/json");
			HttpResponse httpResponse = httpClient.execute(httpGet);
			if (httpResponse.getStatusLine().getStatusCode() != 200) {
				System.out.println("Hata Meydana Geldi,Status Code : " + httpResponse.getStatusLine().getStatusCode());
			} else {
				BufferedReader bufferedReader = new BufferedReader(
						new InputStreamReader(httpResponse.getEntity().getContent()));
				String result;
				while ((result = bufferedReader.readLine()) != null) {
					System.out.println(result);
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void getInfoParam(String name,String surname) {
		try {
			HttpClient httpClient = HttpClientBuilder.create().build();
			HttpGet httpGet = new HttpGet("http://localhost:8080/04.2.restful.jackson/rest/app/"+name+"/"+surname+"");
			httpGet.addHeader("accept", "application/json");
			HttpResponse httpResponse = httpClient.execute(httpGet);
			if (httpResponse.getStatusLine().getStatusCode() != 200) {
				System.out.println("Hata Meydana Geldi,Status Code : " + httpResponse.getStatusLine().getStatusCode());
			} else {
				BufferedReader bufferedReader = new BufferedReader(
						new InputStreamReader(httpResponse.getEntity().getContent()));
				String result;
				while ((result = bufferedReader.readLine()) != null) {
					System.out.println(result);
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
