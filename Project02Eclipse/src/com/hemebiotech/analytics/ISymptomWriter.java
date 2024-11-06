package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Interface for writing symptom data to a destination (e.g., a file, database, etc.).
 */
public interface ISymptomWriter {
    
    /**
     * Writes the given symptoms and their counts to a destination.
     * 
     * @param symptoms A map where the keys are symptom names and the values are their counts.
     */
    public void writeSymptoms(Map<String, Integer> symptoms);

}
