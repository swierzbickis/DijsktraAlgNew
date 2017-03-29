package com.company.file.utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileHandler {

	/**
	 * 
	 * @return Array of lines as strings
	 */
	public static String[] readFile(String fileName) {

		String[] ArraysOfStrings = null;
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			while (line != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();
			}
			String entryFileString = sb.toString();
			ArraysOfStrings = entryFileString.split(" ");
			entryFileString = entryFileString.replaceAll("\\r?\\n"," ");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			return ArraysOfStrings;
		}

	}

}
