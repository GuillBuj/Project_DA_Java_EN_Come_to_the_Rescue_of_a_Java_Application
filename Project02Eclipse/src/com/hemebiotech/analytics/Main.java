package com.hemebiotech.analytics;

import java.util.Map;

public class Main {

    public static void main(String[] args) throws Exception {

        ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
        ISymptomWriter writer = new WriteSymptomDataToFile("result.out");
        AnalyticsCounter analyticsCounter = new AnalyticsCounter(reader, writer);

        Map<String, Integer> symptoms = analyticsCounter
                .sortSymptoms(analyticsCounter.countSymptoms(analyticsCounter.getSymptoms()));

        analyticsCounter.writeSymptoms(symptoms);
    }
}
