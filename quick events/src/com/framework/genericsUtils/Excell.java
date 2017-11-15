package com.framework.genericsUtils;

import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excell {
	
	public static String getCellValue(String filepath,String sheet,int i,int j) throws  EncryptedDocumentException, InvalidFormatException, IOException{
		
		String v="";
		FileInputStream fis=new FileInputStream(filepath);
		Workbook wb = WorkbookFactory.create(fis);
		v=wb.getSheet(sheet).getRow(i).getCell(j).toString();
		return v;
	}

}
