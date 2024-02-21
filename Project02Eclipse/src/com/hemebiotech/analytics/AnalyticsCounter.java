package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class AnalyticsCounter {
	private static final int headacheCount = 0;
	private static int rashCount = 0;
	private static int pupilCount = 0;
	
	public static void main(String[] args) throws Exception {

		BufferedReader reader = new BufferedReader (new FileReader("/Users/user/Documents/FORMATION 2024/OC JAVA/projets/projet2/kesse-franck-debug-Java/Project02Eclipse/symptoms.txt"));
		String line = reader.readLine();

		int i = 0;
		int headCount = 0;
		while (line != null) {
			i++;
			System.out.println("symptom from file: " + line);
			if (line.equals("headache")) {
				headCount++;
				System.out.println("number of headaches: " + headCount);
			}
			else if (line.equals("rush")) {
				AnalyticsCounter.rashCount++;
			}
			else if (line.contains("pupils")) {
				AnalyticsCounter.pupilCount++;
			}

			line = reader.readLine();
		}
		

		FileWriter writer = new FileWriter ("result.out");
		writer.write("headache: " + AnalyticsCounter.headacheCount + "\n");
		writer.write("rash: " + AnalyticsCounter.rashCount + "\n");
		writer.write("dialated pupils: " + AnalyticsCounter.pupilCount + "\n");
		writer.close();
	}
}
