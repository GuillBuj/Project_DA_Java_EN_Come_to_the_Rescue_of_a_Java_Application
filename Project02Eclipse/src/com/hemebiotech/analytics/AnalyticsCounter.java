package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {
	
	private final ISymptomReader reader;
	private final ISymptomWriter writer;

	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer){
		this.reader = reader;
		this.writer = writer;
	}

	public List<String> getSymptoms(){
		return this.reader.GetSymptoms();
	}

	public Map<String,Integer> countSymptoms(List<String> symptoms){

		Map<String,Integer> symptomsCount = new HashMap<>();
		
		for(String symptom : symptoms){
			symptomsCount.put(symptom, symptomsCount.getOrDefault(symptom, 0)+1);
		}

		return symptomsCount;
	}

	public void writeSymptoms(Map<String,Integer> symptoms){
		this.writer.writeSymptoms(symptoms);
	}

	public Map<String,Integer> sortSymptoms(Map<String,Integer> symptomesNonTries){
		return new TreeMap<>(symptomesNonTries);
	}
	
	public static void main(String args[]) throws Exception {
		
		ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
		ISymptomWriter writer = new WriteSymptomDataToFile();
		AnalyticsCounter analyticsCounter = new AnalyticsCounter(reader,writer);

		//recupère, compte et trie les symptomes
		Map<String,Integer> symptoms = analyticsCounter.sortSymptoms(analyticsCounter.countSymptoms(analyticsCounter.getSymptoms()));
		
		//ecriture dans le fichier
		analyticsCounter.writeSymptoms(symptoms);
	}

}
