package One;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.joda.time.DateTime;
import org.joda.time.Instant;




public class BTEST{

	public static void main(String args[]) throws IOException {
		
		String path = "C:\\Users\\CC\\eclipse-workspace\\future.java\\bin\\FFXV";
		
		Workbook workbook = new HSSFWorkbook();
		
		Sheet sheet = workbook.createSheet("XBX");
		
		Row row1 = sheet.createRow(0);
		
		Cell cell11 = row1.createCell(0);
		cell11.setCellValue("forza4");
		
		Cell cell12 = row1.createCell(1);
		cell12.setCellValue("halo5");
		
		Row row2 = sheet.createRow(1);
		
		Cell cell21 = row2.createCell(0);
		cell21.setCellValue("統計時間");
		
		Cell cell22 = row2.createCell(1);
//		String time = new DateTime().toString("yyyy-MM-dd HH:mm:ss");
//		cell22.setCellValue(time);
		
		FileOutputStream FileOutputStream = new FileOutputStream(path+"XBXGame.xlxs"); 
		workbook.write(FileOutputStream);
		FileOutputStream.close();
		
		System.out.println("Done");

     
   }
}






