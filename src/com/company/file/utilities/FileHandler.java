package com.company.file.utilities;

import java.io.*;
import java.util.Scanner;

public class FileHandler {

	private static final String outputFile = "sredni2_out.txt";

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


	public static void writeToOutputFile(String resultNumber){

		Writer output = null;

		try {
			output = new BufferedWriter(new FileWriter(outputFile));
			output.write(resultNumber + "\n");
		}catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				output.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
