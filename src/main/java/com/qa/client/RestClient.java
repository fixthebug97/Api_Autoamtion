package com.qa.client;

import java.io.IOException;
import org.apache.http.Header;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class RestClient {
	CloseableHttpResponse closeableHttpResponse;
	 public CloseableHttpResponse get(String url) throws ClientProtocolException, IOException {
		 CloseableHttpClient httpClient=HttpClients.createDefault();
		 HttpGet httpGet=new HttpGet(url); 
	return	closeableHttpResponse= httpClient.execute(httpGet);
		
		
	 }
	 
	 public int getStatusCode(CloseableHttpResponse closeableHttpResponse) {
		 
		return closeableHttpResponse.getStatusLine().getStatusCode();
		 
	 }
	 
	 public JSONObject getStringResponse(CloseableHttpResponse closeableHttpResponse) throws ParseException, IOException
	 {
		 String responseJsonString= EntityUtils.toString(closeableHttpResponse.getEntity(),"UTF-8");
		 
		 JSONObject responseJson= new JSONObject(responseJsonString); 
		 
		 return responseJson;
		 
		 
	 }
	 
	 public Header[] headerArray(CloseableHttpResponse closeableHttpResponse) {
		 
		 Header[] headerArray=closeableHttpResponse.getAllHeaders();
		 
		 return headerArray;
	 }
	 
	 
	

}
