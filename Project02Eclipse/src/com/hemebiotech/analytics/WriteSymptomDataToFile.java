package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WriteSymptomDataToFile implements ISymptomWriter{

    private static final Logger logger = LogManager.getLogger(WriteSymptomDataToFile.class);
        
    /**
     *  Output filepath
     */
    private final String outputPath;

    /**
     * Constructor that sets the output file path.
     *
     * @param outputPath The path to the output file.
     */
    public WriteSymptomDataToFile(String outputPath) {
        this.outputPath = outputPath;
    }

    /**
     * Writes the given symptoms and their counts to the specified file.
     *
     * @param symptoms A map of symptoms and their counts to be written to the file.
     */
    @Override
    public void writeSymptoms(Map<String,Integer> symptoms){
        if (symptoms == null || symptoms.isEmpty()) {
            logger.warn("Aucun symptome. Map vide ou null");
            return;
        }
        try (FileWriter writer = new FileWriter (this.outputPath)) {
            for(Map.Entry<String,Integer> entry : symptoms.entrySet()){
                writer.write(entry.getKey() + ": " + entry.getValue() + "\n");
            }
            logger.info("Resultats copies dans '{}'", this.outputPath);
        } catch(IOException e) {
            logger.error("Erreur d'ecriture dans '{}'", this.outputPath);
        }
    }

}
