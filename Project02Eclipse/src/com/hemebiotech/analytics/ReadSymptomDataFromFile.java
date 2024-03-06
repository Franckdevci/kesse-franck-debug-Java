package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * implementation of the method of the interface ISymptomReader with annotation @Override.
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {
	private String filepath;

	/* constructor assigns to the attribute "filepath" a full or partial path to file
    with String symptom in it, one per line */
	public ReadSymptomDataFromFile(String filepath) {
		this.filepath = filepath;
	}

	/**
	 * used to read the file symptoms.txt and add all content in List String.
	 *
	 * @exception IOException    if there's a problem in reading the file symptoms.txt
	 *
	 * @exception Exception    if an error unexpected has occurred
	 *
	 * @return    a List of all String Symptoms obtained from a data source symptom.txt
	 *     with unique and duplicated symptoms
	 *
	 * @see    #getSymptoms()
	 */
	@Override
	public List<String> getSymptoms() {
		List<String> result = new ArrayList<String>();

		if (filepath != null) {
			try {
				BufferedReader reader = new BufferedReader(new FileReader(filepath));
				String line = reader.readLine();

				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}

				reader.close();
				System.out.println("successfully read");

				if (result.isEmpty()) {
					System.err.println("symptoms.txt is empty, no symptoms listed");
				}
			} catch (IOException e) {
				System.err.println("reading symptoms to file symptoms.txt failed"
						+ " " + "and adding a list of symptoms failed : " + e.getMessage());
				e.printStackTrace();
			} catch (Exception e) {
				System.err.println("an error has occured");
			}
		}
		return result;
	}
}