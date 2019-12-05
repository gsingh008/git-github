package excercise;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//level-Medium
//https://leetcode.com/problems/find-the-duplicate-number/
/*Input: [1,3,4,2,2]
Output: 2
Input: [3,1,3,4,2]
Output: 3*/

//leet code submission-https://leetcode.com/problems/find-the-duplicate-number/submissions/

public class FindDuplicateNumber {

    public static void main(String[] args) {
	int[] nums = { 1, 6, 8, 3, 2, 5, 3 };
	// Solution-1 using Hashmap
	System.out.println("Solution-1 using Hashmap");
	System.out.println("duplicate number is " + findDuplicate(nums));

	System.out.println("Solution-2 using Set");
	System.out.println("duplicate number is " + findDuplicateUsingSet(nums));

	System.out.println("Solution-3 brute force");
	System.out.println("duplicate number is " + usingBruteForce(nums));

    }

    // Solution-1-Using HashMap

    /*
     * Runtime: 5 ms, faster than 16.09% of Java online submissions for Find the
     * Duplicate Number. Memory Usage: 39.5 MB, less than 5.09% of Java online
     * submissions for Find the Duplicate Number.
     */
    private static int findDuplicate(int[] nums) {
	Map<Integer, Integer> numberCountMap = new HashMap<>();
	for (int i : nums) {
	    Integer count = numberCountMap.get(i);
	    if (count == null) {
		numberCountMap.put(i, 1);
	    } else
		numberCountMap.put(i, ++count);
	}
	for (int i = 0; i < nums.length; i++) {
	    if (numberCountMap.get(nums[i]) > 1)
		return nums[i];
	}
	return 0;
    }

    // Solution-2-Using Set

    /*
     * Runtime: 4 ms, faster than 27.11% of Java online submissions for Find the
     * Duplicate Number. Memory Usage: 36.7 MB, less than 100.00% of Java online
     * submissions for Find the Duplicate Number.
     */
    private static int findDuplicateUsingSet(int[] nums) {
	Set<Integer> numberCountSet = new HashSet<>();
	for (int i : nums) {
	    if (!numberCountSet.contains(i)) {
		numberCountSet.add(i);
	    } else {
		return i;
	    }
	}
	return 0;
    }

    // Solution-3 using brute force
    /*
     * Runtime: 98 ms, faster than 5.14% of Java online submissions for Find the
     * Duplicate Number. Memory Usage: 37.8 MB, less than 37.29% of Java online
     * submissions for Find the Duplicate Number.
     */
    private static int usingBruteForce(int[] nums) {

	for (int i = 0; i < nums.length; i++) {
	    for (int j = i + 1; j < nums.length; j++) {
		if (nums[i] == nums[j]) {
		    return nums[i];
		}
	    }
	}
	return 0;
    }
}
