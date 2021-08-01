package example;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import json.Entity;
import json.Root;

public class Json3 {

	ObjectMapper om = new ObjectMapper();

	public static void main(String args[]) throws IOException {


		InputStream input =null;
		Properties prop = new Properties();
		input = new FileInputStream("C:\\Users\\SHrill\\eclipse-workspace\\example\\File\\Deletefiles1.properties");
		prop.load(input);

		String json = prop.getProperty("json");
		File dir = new File(json);
		File[] file = dir.listFiles();

		Json3 obj = new Json3();
		obj.jsonExtract(file);
	}

	private void jsonExtract(File[] file) throws JsonParseException, JsonMappingException, IOException {

		for(File f: file) {
			if (f.isFile()) {

				om.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

				try {
					Root root = om.readValue(f.getAbsoluteFile(), Root.class);
					for(Entity e:root.getEntities()) {
						if(e.getScore()< 0.90) {
							System.out.println("Score: " +e.getScore()+"  "+ "Text: " +e.getText());
						}
					}
				}catch(Exception e) {
					e.printStackTrace();

				}
			}
		}
	}
}


