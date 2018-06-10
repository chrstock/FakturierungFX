package tools;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import fakturierung.Auftrag;

public abstract class FileManager {

	public static String readFile(String path) {
		StringBuilder content = new StringBuilder();

		try {
			BufferedReader reader = new BufferedReader(new FileReader(path));
			String line = reader.readLine();
			while (line != null) {
				content.append(line);
				content.append(System.lineSeparator());
				line = reader.readLine();
			}

			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return content.toString();
	}

	public static void writeFile(String path, String content) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(path));

		for (String s : content.split(System.lineSeparator())) {
			writer.write(s);
			writer.newLine();
		}
		writer.close();
	}
}
