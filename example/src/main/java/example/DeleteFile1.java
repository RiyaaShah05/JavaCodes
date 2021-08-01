package example;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class DeleteFile1 {

	List<String> f =null;

	public DeleteFile1(File d) throws IOException {
		f = getlist(d);

	}

	public List<String> getlist(File d) throws IOException {
		//File path = new File("D:\\EZDI\\Problem_Input\\1\\DeleteFiles.txt");
		Scanner s = new Scanner(d);
		ArrayList<String> list = new ArrayList<String>();
		while (s.hasNext()){
			list.add(s.next());
		}
		s.close();
		return list;

	}

	public void delete(File[] file) {

		for (File fi : file) {
			if(fi.isDirectory()) {
				delete(fi.listFiles());
			}else {
				if(f.contains(fi.getName())) {
					Path path = FileSystems.getDefault().getPath(fi.getAbsolutePath());
					try {
						Files.deleteIfExists(path);		
					}catch(IOException e) {
						e.printStackTrace();
					}
				}


			}
		}
	}



	public static void main(String args[]) throws IOException {


		InputStream input =null;
		Properties prop = new Properties();
		input = new FileInputStream("C:\\Users\\SHrill\\eclipse-workspace\\example\\File\\Deletefiles1.properties");
		prop.load(input);

		String deletefile = prop.getProperty("Deletefile");
		String inputfile = prop.getProperty("inputfile");

		File di = new File(deletefile);
		DeleteFile1 obj = new DeleteFile1(di);

		File dir = new File(inputfile);
		File[] file = dir.listFiles();
		if(file !=null) {
			obj.delete(file);
		}


	}

}
