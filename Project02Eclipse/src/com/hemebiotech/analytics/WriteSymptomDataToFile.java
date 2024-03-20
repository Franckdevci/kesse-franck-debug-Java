package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/**
 * implementation of the method of the interface ISymptomWriter with annotation @Override.
 *
 */
public class WriteSymptomDataToFile implements ISymptomWriter {
    private String filepath;

    public WriteSymptomDataToFile() {
        this.filepath = "/Users/user/Documents/FORMATION 2024/OC JAVA/projets/projet2/kesse-franck-debug-Java/Project02Eclipse/result.out";
    }

    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) {

        try {

            if (filepath != null && !symptoms.isEmpty()) {

                FileWriter fileWriter = new FileWriter(filepath, false);
                BufferedWriter writer = new BufferedWriter(fileWriter);

                Iterator<Map.Entry<String, Integer>> iteratorMap = symptoms.entrySet().iterator();

                iteratorMap.forEachRemaining(
                        (entrySymptomAndNumberOfOccurrences) -> {
                            System.out.println(
                                    "Symptoms :"
                                            + entrySymptomAndNumberOfOccurrences.getKey()
                                            + "   "
                                            + entrySymptomAndNumberOfOccurrences.getValue()
                            );
                            try {
                                writer.write(entrySymptomAndNumberOfOccurrences.getKey()
                                        + " : "
                                        + entrySymptomAndNumberOfOccurrences.getValue());
                                writer.newLine();
                            } catch (IOException e) {
                                System.err.println(" writing symptoms to file result.out failed : "
                                        + e.getMessage());
                                e.printStackTrace();
                            }
                        });

                writer.close();
                System.out.println("The file result.out get all list of symtoms,"
                        + "the number of occurrences after writing in it");
            }
        } catch (FileNotFoundException e) {
            System.err.println("a possible error of path of the file result.out : " + e.getMessage());
            e.printStackTrace();
        } catch (NullPointerException e) {
            System.err.println("mapSymptomsOccurencesSorted is empty : " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("an error has occured" + e.getMessage());
            e.printStackTrace();
        }
    }
}