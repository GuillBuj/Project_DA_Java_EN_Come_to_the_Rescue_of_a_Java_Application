package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of ISymptomReader that reads symptoms from a file.
 * This implementation assumes that the file contains one symptom per line.
 * If no symptoms are found or an error occurs, an empty list is returned.
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private final String filepath;
	
	/**
     * Constructor that initializes the file path.
     * 
     * @param filepath The full or partial path to the file containing symptom strings, one per line.
     */
	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;
	}
	
	
	/**
     * Reads the symptoms from the specified file.
     * If the file is missing or an error occurs, an empty list will be returned.
     * 
     * @return A list of symptoms read from the file. Duplicates are possible.
     */
	@Override
	public List<String> GetSymptoms() {
		ArrayList<String> result = new ArrayList<>();
		
		if (filepath != null) {
			try {
				BufferedReader reader = new BufferedReader (new FileReader(filepath));
				String line = reader.readLine();
				
				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

}
