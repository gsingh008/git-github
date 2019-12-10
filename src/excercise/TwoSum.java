package excercise;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {

	// int[] nums = { 2, 7, 11, 15 };
	int[] nums = { 3, 2, 4 };

	int target = 6;
	int[] result_I = isTwoSum(target, nums);
	System.out.println("result_I ");

	for (int i = 0; i < result_I.length; i++)

	    System.out.println(result_I[i]);

	int[] result = twoSums_I(target, nums);
	System.out.println("result_II ");

	for (int i = 0; i < result.length; i++)
	    System.out.println(result[i]);

	int[] result_II = twoSum_II(target, nums);
	System.out.println("result_III ");

	for (int i = 0; i < result_II.length; i++)
	    System.out.println(result[i]);
	int[] result_IV = twoSum_IV(nums, target);
	System.out.println("result_IV ");

	for (int i = 0; i < result_IV.length; i++)
	    System.out.println(result[i]);

    }
//Leet code got submitted but I think it is not an elegent solution. O(n2)
    // https://leetcode.com/problems/two-sum/submissions/
    /*
     * Runtime: 56 ms, faster than 5.67% of Java online submissions for Two Sum.
     * Memory Usage: 36.3 MB, less than 99.61% of Java online submissions for Two
     * Sum.
     */

    private static int[] twoSums_I(int target, int[] nums) {
	Map<Integer, Integer> map = new HashMap<>();
	for (int i = 0; i < nums.length; i++) {
	    map.put(i, nums[i]);
	}
	int[] result = new int[2];

	for (int i = 0; i < nums.length; i++) {
	    for (int j = 0; j < nums.length; j++) {
		if (i == j) {
		    continue;
		}
		if (target - nums[i] == nums[j]) {
		    result[0] = i;
		    result[1] = j;
		    return result;
		}
	    }
	}

	return null;
    }

    // from leet code...same concept of brute forxe but in less lines
    public static int[] twoSum_II(int target, int[] nums) {
	for (int i = 0; i < nums.length; i++) {
	    for (int j = i + 1; j < nums.length; j++) {
		if (nums[j] == target - nums[i]) {
		    return new int[] { i, j };
		}
	    }
	}
	throw new IllegalArgumentException("No two sum solution");
    }

// { 2, 7, 11, 15 } {2,0
    // 7,1

    public static int[] isTwoSum(int target, int[] nums) {
	Map<Integer, Integer> map = new HashMap<>();
	for (int i = 0; i < nums.length; i++) {
	    map.put(nums[i], i);
	}
	for (int i = 0; i < nums.length; i++) {
	    int complement = target - nums[i];
	    if (map.containsKey(complement) && map.get(complement) != i) {
		return new int[] { i, map.get(complement) };
	    }
	}
	throw new IllegalArgumentException("No two sum solution");
    }

    // solution 4th { 3, 2, 4 }
    public static int[] twoSum_IV(int[] nums, int target) {
	Map<Integer, Integer> map = new HashMap<>();
	for (int i = 0; i < nums.length; i++) {
	    int complement = target - nums[i];
	    if (map.containsKey(complement)) {
		return new int[] { map.get(complement), i };
	    }
	    map.put(nums[i], i);
	}
	throw new IllegalArgumentException("No two sum solution");
    }
}