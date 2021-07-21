package One;

import java.io.IOException;

public class ExcelWorking {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		crawler("htc",1);
		System.out.print(false);
	}
	public static void crawler(String name, int pages) throws IOException {
//		爬到的內容放到此資料夾的tmp.xlsx
		Runtime rt = Runtime.getRuntime(); 
		try {
			rt.exec(String.format("python pchome.py %s %s", name, pages)); //執行Python爬蟲
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
