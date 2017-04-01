package com.company.file.utilities;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class FileHandler {

	private static final String ENTRY_FILE_NAME = "inputFile.txt";
	private static final String OUTPUT_FILE_NAME = "outputFile.txt";

	public static InputFileData readFile(InputFileData inputData) {

		int[] arrayOfNumbers = null;
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File(ENTRY_FILE_NAME));
			inputData.setPrimeNumberRange(getCountOfDigits(scanner));
			 arrayOfNumbers = new int [getSizeOfArray(scanner)];
			int i = 0;
			while(scanner.hasNextInt()){
				arrayOfNumbers[i++] = scanner.nextInt();
			}
			inputData.setInputParameters(arrayOfNumbers);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			if(scanner!= null){
				scanner.close();
			}

			return inputData;
		}

	}

	/**
	 * Reads the first number from input file
	 * @param scanner
	 * @return
	 */
	private static int getCountOfDigits(Scanner scanner){
		int digitsCount = scanner.nextInt(); //First number is not used in program
		return digitsCount;
	}

	/**
	 * Reads the second number from input file which describes number of rows.
	 * Then multiplies this value by two , because in each line there are two numbers
	 * which describes source and dest nodes.
	 * @param scanner
	 * @return
	 */
	private static int getSizeOfArray(Scanner scanner){
		int rowsCount = scanner.nextInt();
		return rowsCount * 2;
	}


	public static void writeToOutputFile(List<String> resultNumbers){

		FileWriter fw = null;

		try {
			fw = new FileWriter(OUTPUT_FILE_NAME);
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
