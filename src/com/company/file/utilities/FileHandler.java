package com.company.file.utilities;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class FileHandler {

	public static int[] readFile(String fileName) {

		int[] arrayOfNumbers = null;
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File(fileName));
			 arrayOfNumbers = new int [getSizeOfArray(scanner)];
			int i = 0;
			while(scanner.hasNextInt()){
				arrayOfNumbers[i++] = scanner.nextInt();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			if(scanner!= null){
				scanner.close();
			}

			return arrayOfNumbers;
		}

	}


	private static int getSizeOfArray(Scanner scanner){
		scanner.nextInt(); //First number is not used in program
		int rowsCount = scanner.nextInt();
		return rowsCount * 2;
	}


	public static void writeToOutputFile(List<String> resultNumbers,String outputFile){

		FileWriter fw = null;

		try {
			fw = new FileWriter(outputFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

		BufferedWriter bw = new BufferedWriter(fw);
		try {
			for(String resultNumber : resultNumbers){
				bw.write(resultNumber);
				bw.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			bw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
