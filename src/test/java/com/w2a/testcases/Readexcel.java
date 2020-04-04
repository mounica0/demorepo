package com.w2a.testcases;

import java.util.ArrayList;

import com.w2a.utilities.ExcelReader;

public class Readexcel {
	
	static ExcelReader reader; // import the excel reader from util pkg where we have defined the excel properties
	
	public static ArrayList<Object[]> getdatafromexcel()
	{
		ArrayList<Object[]> mydata=new ArrayList<Object[]>();
		
		reader= new ExcelReader("E:/manual testing Mind Q/selenium/seleniumprograms/testdata.xlsx");// path of excel must be provided here
		int count=reader.getRowCount("mydata");// the getrowcount and all defined in excel reader present in util
		//mydata is the sheet name of testdata excel
		for(int i=2;i<count;i++)
		{
			
	String Username	=reader.getCellData("mydata", "Uname", 2);
	String Password	=reader.getCellData("mydata", "Pwd", 2);		
	Object ob[]= {Username,Password};
	
	mydata.add(ob);
	
		}

		
		return mydata;
	
		
	}
	
	

}
