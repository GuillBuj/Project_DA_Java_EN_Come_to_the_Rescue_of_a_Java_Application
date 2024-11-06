package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Class that handles the analytics of symptoms by reading, counting, sorting, and writing the data.
 */
public class AnalyticsCounter {
	
	private final ISymptomReader reader;
	private final ISymptomWriter writer;

	/**
     * Constructs an AnalyticsCounter object with the provided reader and writer.
     * 
     * @param reader An object that reads symptoms from a data source.
     * @param writer An object that writes symptoms to a destination (e.g., file).
     */
	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer){
		this.reader = reader;
		this.writer = writer;
	}

	
	/**
     * Retrieves symptoms from the data source. If no data is available, returns an empty list.
     *
     * @return A list of symptoms obtained from a data source. Duplicates are possible.
     */
	public List<String> getSymptoms(){
		return this.reader.GetSymptoms();
	}

	
	/**
	 * Converts a List of symptoms into a Map with their respective counts
	 *
	 * @param symptoms The list of the symptoms
	 * @return A map with symptoms and their count of occurences
	 */
	public Map<String,Integer> countSymptoms(List<String> symptoms){

		Map<String,Integer> symptomsCount = new HashMap<>();
		
		for(String symptom : symptoms){
			symptomsCount.put(symptom, symptomsCount.getOrDefault(symptom, 0)+1);
		}

		return symptomsCount;
	}

	
	/**
	 * Converts an unsorted map of symptoms into a map sorted alphabetically by the symptom names (keys).
	 *
	 * @param unsortedSymptoms The map containing symptoms and their associated counts, in any order.
	 * @return A map containing the same symptoms, but sorted alphabetically by the symptom names (keys).
	 */
	public Map<String,Integer> sortSymptoms(Map<String,Integer> unsortedSymptoms){
		return new TreeMap<>(unsortedSymptoms);
	}

	/**
	 * Writes the symptoms and their counts into a file.
	 *
	 * @param symptoms A map where the keys are symptom names and the values are the counts of occurrences.
	 */
	public void writeSymptoms(Map<String,Integer> symptoms){
		this.writer.writeSymptoms(symptoms);
	}
	
	public static void main(String args[]) throws Exception {
		
		ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
		ISymptomWriter writer = new WriteSymptomDataToFile("result.out");
		AnalyticsCounter analyticsCounter = new AnalyticsCounter(reader,writer);

		Map<String,Integer> symptoms = analyticsCounter.sortSymptoms(analyticsCounter.countSymptoms(analyticsCounter.getSymptoms()));
		
		analyticsCounter.writeSymptoms(symptoms);
	}

}
