package One;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class main {

	public static void main(String[] args) throws IOException {
		crawler("htc", 1);
		
	}

	public static void crawler(String name, int pages) throws IOException {
//		���쪺���e��즹��Ƨ���tmp.xlsx
		Runtime rt = Runtime.getRuntime();
		try {
			Process proc = rt.exec(String.format("python pchome.py %s %s", name, pages));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
