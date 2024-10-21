package com.demo.objects.util;

import com.demo.objects.constants.AppConstants;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpConnectionUtil {

	
	public static String getUrl(String baseUrl, String addOnUrl) throws IOException {
		HttpGet request = new HttpGet(baseUrl + addOnUrl);
		request.addHeader(AppConstants.AUTHORIZATION_HEADER,
				"Basic dGVzdEBsaWZlcmF5LmNvbToxMjM0");

		try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
			HttpEntity httpEntity = httpClient.execute(request).getEntity();
			return httpEntity != null ? EntityUtils.toString(httpEntity) : null;
		}
	}
	
	public static String postUrl(String jsonValue, String baseUrl, String addOnUrl) throws UnirestException {
		System.out.println("jsonValue>>>>>>>>>>"+jsonValue);				
		Unirest.setTimeouts(0, 0);
		HttpResponse<String> response = Unirest.post(baseUrl+addOnUrl)
		  .header("Content-Type", "application/json")
		  .header("Authorization", "Basic dGVzdEBsaWZlcmF5LmNvbToxMjM0")
		  .body(jsonValue)
		  .asString();
		
		return response.getBody();
    }

	public static String putUrl(String jsonInput, String baseUrl, String endpoint, long id) throws UnirestException {
		System.out.println("jsonInputsssssssssss>>>>>>>>>>"+jsonInput);		
		
		Unirest.setTimeouts(0, 0);
		HttpResponse<String> response = Unirest.put(baseUrl + endpoint + id)
				.header("Content-Type", "application/json")
				.header("Authorization", "Basic dGVzdEBsaWZlcmF5LmNvbToxMjM0")
				.body(jsonInput)
				.asString();
		return response.getBody();
	}
	
}
