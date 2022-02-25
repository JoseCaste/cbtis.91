package com.cbtis91.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class PoiTest {

	public static void main(String[] args) {
		 // workbook object
        XSSFWorkbook workbook = new XSSFWorkbook();
  
        // spreadsheet object
        XSSFSheet spreadsheet
            = workbook.createSheet(" Student Data ");
  
        // creating a row object
        XSSFRow row;
  
        // This data needs to be written (Object[])
        Map<String, Object[]> studentData
            = new TreeMap<String, Object[]>();
  
        studentData.put(
            "1",
            new Object[] { "# Ficha", "Nombres", "Apellidos","Edad","CURP","Residencia actual","Dirección","Lugar de nacimiento","Opción 1 especialidad","Opción 2 especialidad","Correo electrónico","Número de teléfono","Lengua","Discapacidad","Tipo de secundaria" });
  
        studentData.put("2", new Object[] { "128", "Aditya",
                                            "2nd year" });
  
        studentData.put(
            "3",
            new Object[] { "129", "Narayana", "2nd year" });
  
        studentData.put("4", new Object[] { "130", "Mohan",
                                            "2nd year" });
  
        studentData.put("5", new Object[] { "131", "Radha",
                                            "2nd year" });
  
        studentData.put("6", new Object[] { "132", "Gopal",
                                            "2nd year" });
  
        Set<String> keyid = studentData.keySet();
  
        int rowid = 0;
  
        // writing the data into the sheets...
  
        for (String key : keyid) {
  
            row = spreadsheet.createRow(rowid++);
            Object[] objectArr = studentData.get(key);
            int cellid = 0;
  
            for (Object obj : objectArr) {
                Cell cell = row.createCell(cellid++);
                cell.setCellValue((String)obj);
            }
        }
  
        try {
            // .xlsx is the format for Excel Sheets...
            // writing the workbook into the file...
            FileOutputStream out = new FileOutputStream(
                new File("/home/jose/Documents/GFGsheet.xlsx"));
			workbook.write(out);
			out.close();
			workbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}

}
