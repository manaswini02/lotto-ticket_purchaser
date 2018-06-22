package com.lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
 Gives possible combinations for a given input 
 * 
 * @Author Manaswini Nalamuthu
 * Created date 21 june 2018
*/
public class CombinationsUtil {
	
	/**
	 * lottoList array of size total. This metthod calls getCombinations() and
	 * collects combinations of numbers in a map
	 * 
	 * @param lottoList
	 * @param total
	 * @param var
	 * @return
	 * @throws ArrayIndexOutOfBoundsException
	 */
	public Map<String, Integer> collectCombinations(List<int[]> lottoList, int total, int var)
			throws ArrayIndexOutOfBoundsException {
		// A map to store all combination one by one
		Map<String, Integer> map = new HashMap<String, Integer>();

		// Put all combinations to map
		for (int[] i : lottoList) {
			List<String> result = new ArrayList<>();
			int data[] = new int[var];
			result = getCombinations(i, total, var, 0, data, 0, result);
			for (String str : result) {
				if (map.containsKey(str))
					map.put(str, map.get(str) + 1);
				else
					map.put(str, 1);
			}
		}

		return map;
	}

	/**
	 * @param arr
	 * @param total
	 * @param var
	 * @param index
	 * @param data
	 * @param result
	 * @return
	 */
	public List<String> getCombinations(int arr[], int total, int var, int index, int data[], int i,
			List<String> result) {
		try {
			// forming current combination/group
			if (index == var) {
				StringBuffer tempString = new StringBuffer();
				for (int j = 0; j < var; j++) {
					tempString.append(data[j] + " ");
				}
				result.add(tempString.toString());
				return result;
			}

			// When no more elements are there to put in data[]
			if (i >= total)
				return result;

			data[index] = arr[i];
			// current combination is stored, put next at next location
			result = getCombinations(arr, total, var, index + 1, data, i + 1, result);

			// current is excluded, replace it with next (Note that
			// i+1 is passed, but index is not changed)
			result = getCombinations(arr, total, var, index, data, i + 1, result);
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new ArrayIndexOutOfBoundsException("In correct Inputs given");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
}
