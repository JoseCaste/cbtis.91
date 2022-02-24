package com.cbtis91.excelCreator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.swing.JOptionPane;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.cbtis91.metadata.ExcelMetaData;

public class ExcelCreator {

	List<ExcelMetaData> excelMetaDatas;

	public ExcelCreator(List<ExcelMetaData> excelMetaDatas) {

		this.excelMetaDatas = excelMetaDatas;
	}

	public boolean createExcelReport() {
		XSSFWorkbook workbook = new XSSFWorkbook();

		// spreadsheet object
		XSSFSheet spreadsheet = workbook.createSheet(" Detalle de fichas ");

		// creating a row object
		XSSFRow row;
		
		Map<String, Object[]> fichaData = new TreeMap<String, Object[]>();

		fichaData.put("0",
				new Object[] { "# Ficha", "Nombres", "Apellidos", "Edad", "CURP", "Residencia actual", "Dirección",
						"Lugar de nacimiento", "Opción 1 especialidad", "Opción 2 especialidad", "Correo electrónico",
						"Número de teléfono", "Lengua", "Discapacidad", "Tipo de secundaria" });
		for (int i = 0; i < excelMetaDatas.size(); i++) {
			Object [] valueFichaData= new Object[15];
			final ExcelMetaData metadata_= excelMetaDatas.get(i);
			
			valueFichaData[0]= metadata_.getNumeroFicha();
			valueFichaData[1]= metadata_.getNames();
			valueFichaData[2]= metadata_.getLastNames();
			valueFichaData[3]= metadata_.getAge();
			valueFichaData[4]= metadata_.getCurp();
			valueFichaData[5]= metadata_.getLocality();
			valueFichaData[6]= metadata_.getAddress();
			valueFichaData[7]= metadata_.getBirthPlace();
			valueFichaData[8]= metadata_.getOp1().getName_especialidad();
			valueFichaData[9]= metadata_.getOp2().getName_especialidad();
			valueFichaData[10]= metadata_.getEmail();
			valueFichaData[11]= metadata_.getContact();
			valueFichaData[12]= metadata_.getLanguaje();
			valueFichaData[13]= metadata_.getDisability();
			valueFichaData[14]= metadata_.getKindSchool();
			fichaData.put(String.format("%d", i+1), valueFichaData);
		}
		Set<String> keyid = fichaData.keySet();
		  
        int rowid = 0;
  
        // writing the data into the sheets...
  
        for (String key : keyid) {
  
            row = spreadsheet.createRow(rowid++);
            Object[] objectArr = fichaData.get(key);
            int cellid = 0;
  
            for (Object obj : objectArr) {
                Cell cell = row.createCell(cellid++);
                //cell.setCellValue((String)obj);
                if(obj instanceof Integer) 
                	cell.setCellValue(String.format("%d", obj));
                else
                	cell.setCellValue((String)obj);
            }
        }
        
        try {
            // .xlsx is the format for Excel Sheets...
            // writing the workbook into the file...
            FileOutputStream out = new FileOutputStream(
                new File("/home/jose/Documents/reporte de fichas.xlsx"));
			workbook.write(out);
			out.close();
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al generar el reporte de excel","Error",2);
			return false;
		}
	}
}
