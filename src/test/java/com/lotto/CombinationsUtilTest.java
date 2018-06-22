package com.lotto;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class CombinationsUtilTest {

	CombinationsUtil combinationUtil = new CombinationsUtil();

	@Before
	public void setUp() {
	}

	@Test
	public void getCombinations_test() {
		int[] arr = { 1, 2, 3 };
		List<String> list = new ArrayList<>();
		List<String> result = new ArrayList<String>();
		result.add("1 2 3 ");
		int[] data = new int[3];
		assertEquals(result, combinationUtil.getCombinations(arr, 3, 3, 0, data, 0, list));
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void getCombinations_incorrect_total_size_test() {
		int[] arr = { 1, 2, 3 };
		List<String> list = new ArrayList<>();
		List<String> result = new ArrayList<String>();
		result.add("1 2 3 ");
		int[] data = new int[3];
		assertEquals(result, combinationUtil.getCombinations(arr, 7, 3, 0, data, 0, list));
	}

	@Test
	public void collect_incorrect_test() {
		Map<String, Integer> result = new HashMap<>();
		int[] arr = { 1, 2, 3, 4 };
		int[] arr2 = { 1, 6, 2, 3 };
		List<int[]> list = new ArrayList<>();
		list.add(arr);
		list.add(arr2);
		result.put("1 2 3 ", 2);
		result.put("2 3 4 ", 1);
		result.put("1 3 4 ", 1);
		result.put("6 2 3 ", 1);
		result.put("1 2 4 ", 1);
		result.put("1 6 2 ", 1);
		result.put("1 6 3 ", 1);
		assertEquals(result, combinationUtil.collectCombinations(list, 4, 3));
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void collect_incorrect_total_size_test() {
		Map<String, Integer> result = new HashMap<>();
		int[] arr = { 1, 2, 3 };
		int[] arr2 = { 1, 2, 3 };
		List<int[]> list = new ArrayList<>();
		list.add(arr);
		list.add(arr2);
		result.put("1 2 3 ", 2);
		assertEquals(result, combinationUtil.collectCombinations(list, 7, 3));
	}

}
