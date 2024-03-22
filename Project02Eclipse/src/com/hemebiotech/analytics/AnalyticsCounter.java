package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {
	private static final int headacheCount = 0;	// initialize to 0
	private static int rashCount = 0;		// initialize to 0
	private static int pupilCount = 0;		// initialize to 0
	private  ISymptomReader reader;
	private ISymptomWriter writer;

	private int a = 2;
	
	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer){
		this.reader = reader;
		this.writer = writer;
	}

	public List<String> getSymptoms() {
		return reader.getSymptoms();
	}

	public Map<String, Integer> countSymptoms(List<String> symptoms) {
		Map<String, Integer> mapSymptomsOccurences = new HashMap<>();

		try {
			if (!symptoms.isEmpty()) {
				for (String symptom:symptoms) {
					if (!mapSymptomsOccurences.containsKey(symptom)) {
						mapSymptomsOccurences.put(symptom, 1);
					} else {
						int numberOfOccurrencesSymptom = mapSymptomsOccurences.get(symptom);
						mapSymptomsOccurences.put(symptom, numberOfOccurrencesSymptom + 1);
					}
				}
			}
		} catch (NullPointerException e) {
			System.err.println(
					"the readListSymptoms is empty : " + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println(
					"an error has occurred : " + e.getMessage());
			e.printStackTrace();
		}
		return mapSymptomsOccurences;
	}

	public static void main(String[] args) throws Exception {
		// first get input
		BufferedReader reader = new BufferedReader (new FileReader("/Users/user/Documents/FORMATION 2024/OC JAVA/projets/projet2/kesse-franck-debug-Java/Project02Eclipse/symptoms.txt"));
		String line = reader.readLine();

		int headCount = 0;	// counts headaches
		while (line != null) {

			System.out.println("symptom from file: " + line);
			if (line.equals("headache")) {
				headCount++;
				System.out.println("number of headaches: " + headCount);
			}
			else if (line.equals("rush")) {
				rashCount++;
			}
			else if (line.contains("pupils")) {
				pupilCount++;
			}

			line = reader.readLine();
		}

		FileWriter writer = new FileWriter ("result.out");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.close();
	}

	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		Map<String, Integer> mapSymptomsOccurencesSorted = new TreeMap<String, Integer>();
		try {
			if (!symptoms.isEmpty()) {
				mapSymptomsOccurencesSorted.putAll(symptoms);
			}
		} catch (NullPointerException e) {
			System.err.println("mapSymptomsOccurences is empty : " + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("an error has occurred : " + e.getMessage());
			e.printStackTrace();
		}
		return mapSymptomsOccurencesSorted;
	}

	public void writeSymptoms(Map<String, Integer> symptoms) {
		this.writer.writeSymptoms(symptoms);
	}

}