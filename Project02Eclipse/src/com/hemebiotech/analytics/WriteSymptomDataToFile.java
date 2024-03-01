package com.hemebiotech.analytics;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter{

    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) {

        Map<String, Integer> input = new HashMap<>();

        input.put("Palu", 101);
        input.put("Palue", 102);

        //new file object
        String filepath = "/Users/user/Documents/FORMATION 2024/OC JAVA/projets/projet2/kesse-franck-debug-Java/Project02Eclipse/symptoms.txt";
        File file = new File(filepath);

        try (BufferedWriter bf = new BufferedWriter(new FileWriter(file))) {

            //create new BufferedWriter for the output file

            //iterate map entries
            for (Map.Entry<String, Integer> entry : input.entrySet()) {

                // put key and value separated by a colon
                bf.write(entry.getKey() + ":" + entry.getValue());

                //new line
                bf.newLine();
            }

            bf.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
