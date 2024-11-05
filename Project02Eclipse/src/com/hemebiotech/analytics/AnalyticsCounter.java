package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.TreeMap;

public class AnalyticsCounter {
	private static int headacheCount = 0;
	private static int rashCount = 0;
	private static int pupilCount = 0;
	
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

		/*System.out.println("number of headaches: " + headacheCount);
		System.out.println("number of rashes: " + rashCount);
		System.out.println("number of pupils: " + pupilCount);*/
		
		TreeMap<String,Integer> symptoms = new TreeMap<String, Integer>();

		symptoms.put("Headaches", 8);
		symptoms.put("Rashes", 6);
		symptoms.put("Pupils", 5);

		WriteSymptomDataToFile writeSymptomDataToFile = new WriteSymptomDataToFile();
		writeSymptomDataToFile.writeSymptoms(symptoms);
		// next generate output
		/*FileWriter writer = new FileWriter ("result.out");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.close();*/
	}
}
