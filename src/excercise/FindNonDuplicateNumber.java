package excercise;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindNonDuplicateNumber {

    public static void main(String[] args) {
	int[] number = { 2, 2, 1, 1, 1, 3, 2, 1 };
	// Solution-1st not working need to work on it
	int j = findNumber(number);

	System.out.println(j);
	// Solution-2nd
	// using set ..its working but cant handle exception if uniq number is not
	// present
	// need to fix this
	int k = findNumberUsingSet(number);
	System.out.println(k);

	// Solution-3rd
	// using hashmap-working but there is a bug in the count of value when it is not
	// uniq
	// need to fix it

	/*
	 * Leet code accepted this and commented:- Runtime: 9 ms, faster than 17.96% of
	 * Java online submissions for Single Number. Memory Usage: 40 MB, less than
	 * 96.30% of Java online submissions for Single Number.
	 */

	System.out.println("Solution-3rd");
	int l = findNumberUsingHashMap(number);
	System.out.println(l);

    }

    // 2 2 1 1
    private static int findNumberUsingHashMap(int[] number) {
	Map<Integer, Integer> findUniqKey = new HashMap<>();
	int value = 1;
	int firstValue = 1;
	for (int i : number) {
	    if (!findUniqKey.containsKey(i)) {
		findUniqKey.put(i, firstValue);
	    } else {
		findUniqKey.put(i, ++value);
	    }
	}

	for (int key : findUniqKey.keySet()) {
	    if (findUniqKey.get(key) == 1) {
		return key;
	    }
	}
	return 0;
    }

    // not working need to work on it
    private static int findNumber(int[] number) {

	int i = 0;
	int j = number.length - 1;
	boolean uniqNumberFound = false;
	for (i = 0; i < j; i++) {
	    for (int k = i + 1; k <= j; k++) {
		if (number[i] == number[k]) {
		    continue;
		}
		uniqNumberFound = true;
		return number[i];
	    }

	}

	return 0;

    }

    public static int findNumberUsingSet(int[] A) {
	Set<Integer> s = new HashSet<Integer>();
	for (int i : A) {
	    if (!s.add(i)) {
		s.remove(i);
	    }
	}
	return s.iterator().next();
    }

}
