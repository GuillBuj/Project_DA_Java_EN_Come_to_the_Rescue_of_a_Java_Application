package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {
	private static int headacheCount = 0;
	private static int rashCount = 0;
	private static int pupilCount = 0;

	private ISymptomReader reader;
	private ISymptomWriter writer;

	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer){
		this.reader = reader;
		this.writer = writer;
	}




	
	public static void main(String args[]) throws Exception {
		// first get input
		BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
		String line = reader.readLine();

		while (line != null) {
			System.out.println("symptom from file: " + line);
			if (line.equals("headache")) {
				headacheCount++;
			}
			else if (line.equals("rash")) {
				rashCount++;
			}
			else if (line.contains("pupils")) {
				pupilCount++;
			}

			line = reader.readLine();	// get another symptom
		}
		
		reader.close();

		
		//pour le test
		TreeMap<String,Integer> symptoms = new TreeMap<String, Integer>();

		symptoms.put("Headaches", 8);
		symptoms.put("Rashes", 6);
		symptoms.put("Pupils", 5);

		WriteSymptomDataToFile writeSymptomDataToFile = new WriteSymptomDataToFile();
		writeSymptomDataToFile.writeSymptoms(symptoms);
	}

	public List<String> getSymptoms(){
		return this.reader.GetSymptoms();
	}

	public Map<String,Integer> sortSymptoms(Map<String,Integer symptomesNonTries){
		return new TreeMap<>()
	}

}
