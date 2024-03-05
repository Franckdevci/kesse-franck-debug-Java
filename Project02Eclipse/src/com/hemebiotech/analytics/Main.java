package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        ISymptomReader reader = new ReadSymptomDataFromFile("/Users/user/Documents/FORMATION 2024/OC JAVA/projets/projet2/kesse-franck-debug-Java/Project02Eclipse/symptoms.txt");
        ISymptomWriter writer = new WriteSymptomDataToFile();
        AnalyticsCounter counter = new AnalyticsCounter(reader, writer);

        List<String> getSymptoms = counter.getSymptoms();
        Map<String, Integer> mapSymptomsOccurences = counter.countSymptoms(getSymptoms);
        Map<String, Integer> mapSymptomsOccurencesSorted = counter.sortSymptoms(mapSymptomsOccurences);
        counter.writeSymptoms(mapSymptomsOccurencesSorted);

    }
}