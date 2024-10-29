package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter{

    public void writeSymptoms(Map<String,Integer> symptoms){
        FileWriter writer = new FileWriter ("result.out");
        for(Map.Entry<String,Integer> entry : symptoms.entrySet()){
            writer.write(entry.getKey() + " : " + entry.getValue());
        }
		writer.close();
    }

}
