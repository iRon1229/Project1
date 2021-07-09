package One;
import java.io.File;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class GetExcel {

	public static void main(String[] args)  throws EncryptedDocumentException, IOException {
		File xlsFile = new File("C:\\Users\\CC\\eclipse-workspace\\NewWorld\\tmp.xlsx");

		// 工作表
		Workbook workbook = WorkbookFactory.create(xlsFile);

		// 表個數。
		int numberOfSheets = workbook.getNumberOfSheets();

		// 遍歷表。
		for (int i = 0; i < numberOfSheets; i++) {
			Sheet sheet = workbook.getSheetAt(i);

			// 行數。
			int rowNumbers = sheet.getLastRowNum() + 1;

			// Excel第一行。
			Row temp = sheet.getRow(0);
			if (temp == null) {
				continue;
			}
			int cells = temp.getPhysicalNumberOfCells();
			Row r = sheet.getRow(1);
			for (int col =0 ; col < cells; col++) {
				System.out.println(r.getCell(col).toString() + " ");
			}
			// 讀資料。
//			for (int row = 0; row < rowNumbers; row++) {
//				Row r = sheet.getRow(row);
//				for (int col = 0; col < cells; col++) {
//					System.out.print(r.getCell(col).toString() + " ");
//				}
//
//				// 換行。
//				System.out.println();
//			}
			
		}
	}
}
