package propertiesFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileExample {

	public static void main(String[] args)  {
		try {
			String filePath="./src/test/resources/testdata/configuration.properties";
			FileInputStream input=new FileInputStream(filePath);
			Properties config=new Properties();
			config.load(input);
			input.close();
			System.out.println(config.getProperty("toLanguage"));
			System.out.println(config.getProperty("url"));
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		System.out.println("After try catch");

	}

}
