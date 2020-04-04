package com.w2a.testcases;

import java.util.ArrayList;

import com.w2a.utilities.ExcelReader;

public  class Excelreader 
{
	static ExcelReader reader;

	public static  ArrayList<Object[]> readdatafromexcel()
	{
		ArrayList<Object[]>ar = new ArrayList<Object[]>();
		reader =new ExcelReader("C:/Users/Admin/Documents/testdata.xlsx");
		int count= reader.getRowCount("Sheet1");
		
		for (int i =2; i<count ; i++)
		{
			String uname = reader.getCellData("Sheet1", "Username", i);
			String pwd = reader.getCellData("Sheet1", "Password", i);
			
			Object[] o = {uname,pwd};		
	      ar.add(o);
		}
	return ar ;
	}
	
	
}
