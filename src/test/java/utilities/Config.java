package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Config {
	
	private static Properties config;
	static{
	try {
		String filePath="./src/test/resources/testdata/configuration.properties";
		FileInputStream input=new FileInputStream(filePath);
		config=new Properties();
		config.load(input);
		input.close();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	
	}
	
	public static String getProperty(String key){
		return config.getProperty(key);
	}
}
