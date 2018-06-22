package com.lotto;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/*
 * Ticket Purchser helps in getting most frequently
 * occured group of 3 numbers which may have more
 * probablity of winning the Lotto. 
*/
public class TicketPurchase {

	public static void main(String[] args) throws Exception {
		int combination = 3;
		int total = 7;
		
		CombinationsUtil combinationsUtil = new CombinationsUtil();
		LottoDetailsReader detailsReader = new LottoDetailsReader();
		
		// details reader reads data from csv and return meaningful lotto entries
		List<int[]> lottoList = detailsReader.Read();
		Map<String, Integer> map = combinationsUtil.collectCombinations(lottoList, total, combination);
		int maxFrequencyCount = Collections.max(map.values());
		System.out.println("Most frequent groups of 3 numbers :");

		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			if (entry.getValue() == maxFrequencyCount)
				System.out.println(entry.getKey());
		}

	}

}
