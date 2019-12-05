package excercise;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/missing-number/
//https://leetcode.com/problems/missing-number/submissions/
/*

Given an array containing n distinct numbers 
taken from 0, 1, 2, ..., n, 
find the one that is missing from the array.

Example 1:

Input: [3,0,1]
Output: 2
Example 2:

Input: [9,6,4,2,3,5,7,0,1]
Output: 8
*/

/*/

Algo:-
1. create hashmap from 0-9 (later on it was exented till array length
2. check each number in the map if it is missing

/*/
public class MissingNumberFromSequence {
    public static void main(String[] args) {
	int[] nums = { 0, 1, 3 };
	/*
	 * int[] nums = { 45, 35, 38, 13, 12, 23, 48, 15, 44, 21, 43, 26, 6, 37, 1, 19,
	 * 22, 3, 11, 32, 4, 16, 28, 49, 29, 36, 33, 8, 9, 39, 46, 17, 41, 7, 2, 5, 27,
	 * 20, 40, 34, 30, 25, 47, 0, 31, 42, 24, 10, 14 };
	 */
	Arrays.sort(nums);
	int i = missingNumber(nums);
	System.out.println(i);
    }

    private static int missingNumber(int[] nums) {
	Map<Integer, Integer> numberMap = new HashMap<>();
	// nums.length + 1 (+1 because in case of { 0, 1, 3 },numberMap.get(nums[i])
	// numberMap.get(3) will give NPE because Hashmap will be length 3 to avoid that
	// we have created 1 extra value.
	for (int i = 0; i < nums.length + 1; i++) {
	    numberMap.put(i, i);
	}
	for (int i = 0; i < nums.length; i++) {
	    if (i != numberMap.get(nums[i]))
		return i;
	}
	// return array length to get the end missing number ..for cases like 0,1 or
	// 0,1,2
	return nums.length;
    }
}