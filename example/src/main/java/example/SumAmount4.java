package example;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;
import com.univocity.parsers.tsv.TsvParser;
import com.univocity.parsers.tsv.TsvParserSettings;

public class SumAmount4 {

	public static void main(String args[]) throws IOException {


		InputStream input =null;
		Properties prop = new Properties();
		input = new FileInputStream("C:\\Users\\SHrill\\eclipse-workspace\\example\\File\\Deletefiles1.properties");
		prop.load(input);

		String path = prop.getProperty("path");
		String tsv = prop.getProperty("tsv");
		String csv = prop.getProperty("csv");
		String txt = prop.getProperty("txt");

		File dir = new File(path);
		File file = new File(tsv);
		File file1 = new File(csv);
		File file2 = new File(txt);

		SumAmount4 obj = new SumAmount4();

		File[] f = dir.listFiles();
		for(File fi : f) {
			// convert the file name into string
			String fileName = fi.toString();

			int index = fileName.lastIndexOf('.');
			if(index > 0) {
				String extension = fileName.substring(index + 1);
				System.out.println("file :"+fileName+"\t"+" Extension:" + extension);
			}
		}

		System.out.println("Operation");
		try (Scanner sc = new Scanner(System.in)) {

			System.out.println("1\t TSV Parser");
			System.out.println("2\t CSV Parser");
			System.out.println("3\t Text Parser");

			System.out.println("Please enter your choice:");

			int o=sc.nextInt();
			//
			switch(o)
			{
			case 1:
				obj.tsvparsar(file);
				break;
			case 2:
				obj.csvparsar(file1);
				break;
			case 3:
				obj.txtparsar(file2);
				break;
			default:
				System.out.println("Enter a Valid Choice");

			}
		}
	}

	private void mainmenu() throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
		System.out.println("Do you want to go to main menu: y/n");  
		String s=br.readLine();  
		if(s.startsWith("y")) {
			SumAmount4.main(null);
		}
	}

	private void txtparsar(File file2) throws IOException {
		TsvParserSettings settings = new TsvParserSettings();

		settings.getFormat().setLineSeparator("\\t");

		// creates a TSV parser
		TsvParser parser = new TsvParser(settings);

		// parses all rows in one go.
		List<String[]> allRows = parser.parseAll(new FileReader(file2));
		//System.out.print(allRows);
		Double sum = 0.0;
		for(String[] i : allRows) {
			try {
				//System.out.print(i[4]);
				sum = sum + Double.parseDouble(i[2]);

			}catch(Exception e) {
				System.out.print("Amount: ");
			}
		}
		System.out.print(sum);	
		System.out.println("\n");
		mainmenu();
	}

	private void csvparsar(File file1) throws IOException {

		CsvParserSettings settings = new CsvParserSettings();

		settings.getFormat().setLineSeparator("\n");

		// creates a CSV parser
		CsvParser parser = new CsvParser(settings);

		// parses all rows in one go.
		List<String[]> allRows = parser.parseAll(new FileReader(file1));

		int sum = 0;
		for(String[] i : allRows) {
			try {
				//System.out.print(i[4]);
				sum = sum + Integer.parseInt(i[6]);

			}catch(Exception e) {
				System.out.print("Amount: ");
			}
		}
		System.out.print(sum);
		System.out.println("\n");
		mainmenu();
	}

	private void tsvparsar(File file) throws IOException {

		TsvParserSettings settings = new TsvParserSettings();

		settings.getFormat().setLineSeparator("\\t");

		// creates a TSV parser
		TsvParser parser = new TsvParser(settings);

		// parses all rows in one go.
		List<String[]> allRows = parser.parseAll(new FileReader(file));
		//System.out.print(allRows);
		int sum = 0;
		for(String[] i : allRows) {
			try {
				//System.out.print(i[4]);
				sum = sum + Integer.parseInt(i[4]);

			}catch(Exception e) {
				System.out.print("Amount: ");
			}
		}
		System.out.print(sum);
		System.out.println("\n");
		mainmenu();
	}
}
