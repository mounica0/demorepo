package com.w2a.rough;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Properties Config=new Properties();
		Properties OR=new Properties();
		FileInputStream Fis =new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Config.properties");
		Config.load(Fis);
		Config.getProperty("browser");
		FileInputStream Fis1 =new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\OR.properties");
		OR.load(Fis1);
		
		

	}

}
