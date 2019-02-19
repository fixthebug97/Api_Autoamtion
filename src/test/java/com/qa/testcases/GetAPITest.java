package com.qa.testcases;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.client.RestClient;
import com.qa.testutil.TestUtil;

public class GetAPITest extends TestBase {

	TestBase testBase;
	String serviceURL;
	String apiURL;
	String url;
	RestClient client;
	
	
	@BeforeMethod
	public void setUp() {
		
		testBase=new TestBase();
		client=new RestClient();
	
		serviceURL=properties.getProperty("URL");
		apiURL=properties.getProperty("serviceURL");
		
		url=serviceURL+apiURL;
		
		
		
	}
	
	@Test
	public void getTest() throws ClientProtocolException, IOException {
		
		 
		 
		
		client.get(url);
		
	}
	
	@Test
	public void getResponseCode() throws ClientProtocolException, IOException {
		
		int statuscode=client.getStatusCode(client.get(url));
		System.out.println("Status code---->"+statuscode);
		Assert.assertEquals(statuscode, 200);
		
	}
	
	@Test
	public void jsonObjectValues() throws ParseException, IOException {
		String total_value=TestUtil.getValueByJPath(client.getStringResponse(client.get(url)), "/total");
		System.out.println("The total value is---->"+total_value);
		Assert.assertEquals(Integer.parseInt(total_value), 12);
		
		String total_page=TestUtil.getValueByJPath(client.getStringResponse(client.get(url)), "/per_page");
		System.out.println("Total pages--->"+total_page);
		Assert.assertEquals(Integer.parseInt(total_page),3);
		
		
	}
	
	@Test
	public void jsonArrayValues() throws ParseException, ClientProtocolException, IOException
	{String id;
	String firstName;
	String lastName;
	String avatar;
	
		for (int i=0; i<=2; i++) {
		
		id=TestUtil.getValueByJPath(client.getStringResponse(client.get(url)), "/data["+i+"]/id");
		firstName=TestUtil.getValueByJPath(client.getStringResponse(client.get(url)), "/data["+i+"]/first_name");
		lastName=TestUtil.getValueByJPath(client.getStringResponse(client.get(url)), "/data["+i+"]/last_name");
		avatar=TestUtil.getValueByJPath(client.getStringResponse(client.get(url)), "/data["+i+"]/avatar");
		
		System.out.println(id);
		System.out.println(firstName);
		System.out.println(lastName);
		System.out.println(avatar);
		}
		
		
}
	
	@Test
	public void headers() throws ClientProtocolException, IOException {
		
		Header[] headerArray=client.headerArray(client.get(url));
		HashMap<String,String> allHeaders=new HashMap<String, String>();
		 
		 for(Header header: headerArray)
		 {
			 allHeaders.put(header.getName(), header.getValue());
			 
		 }
		 
		 System.out.println("Header Array-->"+allHeaders);
		  
		
		
	}
	
}
