package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WriteSymptomDataToFile implements ISymptomWriter{

    private static final Logger logger = LogManager.getLogger(WriteSymptomDataToFile.class);
        
    @Override
    public void writeSymptoms(Map<String,Integer> symptoms){
        try (FileWriter writer = new FileWriter ("result.out")) {
            for(Map.Entry<String,Integer> entry : symptoms.entrySet()){
                writer.write(entry.getKey() + ": " + entry.getValue() + "\n");
            }
            logger.info("Resultats copiés dans 'result.out'");
            writer.close();
        } catch(IOException e) {
            logger.error("IO Exception");
        }
    }

}
