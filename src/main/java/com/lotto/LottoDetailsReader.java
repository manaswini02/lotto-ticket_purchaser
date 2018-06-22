package com.lotto;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LottoDetailsReader {
	public List<int[]> Read() throws Exception {
		String csvFile = "src/main/resources/data.csv";
		BufferedReader reader = null;
		String line = "",cvsSplitBy = ",";
		List<int[]> records = new ArrayList<>();
		try {
			reader = new BufferedReader(new FileReader(csvFile));
			while ((line = reader.readLine()) != null) {
				int input[] = new int[7];
				int j = 0;
				// use comma as separator
				String[] recordByDay = line.split(cvsSplitBy);
				for (int i = 1; i < 8; i++) {
					input[j] = Integer.parseInt(recordByDay[i]);
					j++;
				}
				records.add(input);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}catch (NumberFormatException e) {
			throw new Exception("non integer values are not accepted");
		}
		finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return records;
	}
}
