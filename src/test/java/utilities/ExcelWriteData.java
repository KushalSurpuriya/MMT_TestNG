package utilities;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import testBase.BaseClass_TNG;

public class ExcelWriteData extends BaseClass_TNG{
	
	public static void excelWrite(List<String> li,String price, String errorMsg) throws IOException 
	{
		String filePath = "C:\\Users\\2304035\\Downloads\\MakeMyTrip_TestNG.xlsx";
	   
			System.out.println("==========================="+price);
			System.out.println("==========================="+errorMsg);
	    	FileOutputStream file = new FileOutputStream(filePath);
	        XSSFWorkbook workbook=new XSSFWorkbook();
	    	XSSFSheet sheet=workbook.createSheet("MMT");
	   		// Headers
	    	XSSFRow headerRow = sheet.createRow(0);
	        headerRow.createCell(0).setCellValue("Price");
	        headerRow.createCell(1).setCellValue("Error Message");
	        headerRow.createCell(2).setCellValue("Adults Count");
	        
	        XSSFRow infoRow = sheet.createRow(1);
	        infoRow.createCell(0).setCellValue(price);
	        infoRow.createCell(1).setCellValue(errorMsg);
	        // Data
	        int rowCount = 2;
	        for (int i = 0; i<40; i++) 
            {
	        	XSSFRow row = sheet.createRow(rowCount++);	            
	            XSSFCell countCell = row.createCell(2);
	            
	            countCell.setCellValue(li.get(i));
            }
	            // Adjusting cell width
	            sheet.autoSizeColumn(0);
	            sheet.autoSizeColumn(1);
	            sheet.autoSizeColumn(2);

	            // Adjusting cell height
	            for (int i = 0; i <= sheet.getLastRowNum(); i++) {
	                sheet.getRow(i).setHeight((short) -1);
	            }	
	            workbook.write(file);
	            file.close();
	            workbook.close();
	            System.out.println("Excel file created successfully at: " + filePath);
	    	}
	}

