package example;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class XmlEntities6 {
	
	public static void main(String args[]) throws IOException {


		InputStream input =null;
		Properties prop = new Properties();
		input = new FileInputStream("C:\\Users\\SHrill\\eclipse-workspace\\example\\File\\Deletefiles1.properties");
		prop.load(input);

		String xmlEntity = prop.getProperty("xmlEntity");
		
		File dir = new File(xmlEntity);
		File[] file = dir.listFiles();
		XmlEntities6 obj = new XmlEntities6();
		obj.xmlReader(file);
		
	}

	private void xmlReader(File[] file) {
		// TODO Auto-generated method stub
		
	}

}
