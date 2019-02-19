package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestBase {

	public static Properties properties;
	 
	public TestBase() {
		try {
			properties=new Properties();
			FileInputStream inputStream =new FileInputStream("C:\\Users\\samik\\eclipse-workspace\\New eclipse-workspace\\Api\\src\\main\\java\\com\\qa\\config\\config.properties");
			properties.load(inputStream);
			}
			
			catch (FileNotFoundException e) {
			e.printStackTrace();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			
		
		
	}
	
}
 