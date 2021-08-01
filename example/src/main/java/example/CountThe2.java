package example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CountThe2 {

	public static void main(String args[]) throws IOException {

		InputStream input =null;
		Properties prop = new Properties();
		input = new FileInputStream("C:\\Users\\SHrill\\eclipse-workspace\\example\\File\\Deletefiles1.properties");
		prop.load(input);

		String count = prop.getProperty("count");
		File dir = new File(count);
		File[] file = dir.listFiles();

		CountThe2 obj = new CountThe2();
		obj.countword(file);

	}

	private void countword(File[] file) throws IOException {
		int count = 0;
		for(File f: file) {
			if (f.isFile()) {
				BufferedReader br = new BufferedReader(new FileReader(f));
				String curLine = br.readLine();

				while (curLine != null) {
					if(curLine.startsWith("The")) {
						count = count+1;
						curLine = br.readLine();
					}else
					{
						curLine = br.readLine();
					}
				}
				br.close();
			}
		}
		System.out.println(count);
	}
}

