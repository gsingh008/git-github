package excercise;

//leet code submission:: https://leetcode.com/problems/reverse-string/submissions/
/*Runtime: 1 ms, faster than 100.00% of Java online submissions for Reverse String.
Memory Usage: 51.8 MB, less than 12.43% of Java online submissions for Reverse String.*/
public class ReverseString {

    public static void main(String[] args) {
	// char[] s = {};
	char[] s = { 'h', 'e', 'l', 'l', 'o' };
	// char[] s = { 'h', 'e', 'l', 'l', 'o', 'w', 'o', 'r', 'l', 'd' };

	// 1st solution o(N)
	for (int i = s.length - 1; i >= 0; i--) {
	    System.out.println(s[i]);
	}

	// 2nd Solution Two Pointers, Iteration,O(1) Space
	System.out.println(reverseString(s));

	// 3rd Solution Recursion
	// Time complexity : O(N) time to perform N/2 swaps.
	// Space complexity : O(N) to keep the recursion stack.
	System.out.println(reverseStringRecurrsion(s));

	// 4th Solution ...cool
	// leet code accepted
	/*
	 * Runtime: 1 ms, faster than 100.00% of Java online submissions for Reverse
	 * String. Memory Usage: 51.9 MB, less than 10.65% of Java online submissions
	 * for Reverse String.
	 */
	System.out.println(reverseStringWithOneLoop(s));
	char[] v = new char[s.length];

	for (int i = 0; i < s.length; i++) {
	    if (s[i] == 'a' || s[i] == 'e' || s[i] == 'i' || s[i] == 'o' || s[i] == 'u') {
		continue;
	    }
	    v[i] = s[i];
	}
	System.out.println(reverseWithOutVowel(v));

	// Reverse only Vowels of a String
	String m = "leetcode";
	System.out.println(reverseVowels(m));
    }

    private static char[] reverseWithOutVowel(char[] s) {
	if (s == null || s.length == 0) {
	    return s;
	}
	// char[] v = { 'a', 'e', 'i', 'o', 'u' };
	int right = s.length - 1;
	int left = 0;
	char temp;
	while (right > left) {
	    temp = s[left];
	    s[left] = s[right];
	    s[right] = temp;
	    left++;
	    right--;
	}

	return s;
    }

    public static boolean[] vowels = new boolean[256];
    static {
	vowels['a'] = true;
	vowels['o'] = true;
	vowels['e'] = true;
	vowels['i'] = true;
	vowels['u'] = true;
	vowels['A'] = true;
	vowels['O'] = true;
	vowels['E'] = true;
	vowels['I'] = true;
	vowels['U'] = true;
    }

    public static String reverseVowels(String s) {
	if (s == null || s.isEmpty()) {
	    return "";
	}
	int i, j;
	i = 0;
	j = s.length() - 1;
	char[] str = s.toCharArray();
	while (i < j) {
	    while (i < j && !vowels[str[i]])
		i++;
	    while (i < j && !vowels[str[j]])
		j--;
	    if (i < j) {
		char temp = str[i];
		str[i] = str[j];
		str[j] = temp;
		i++;
		j--;
	    }
	}
	return String.valueOf(str);
    }

    // 2nd Solution Two Pointers, Iteration,O(1) Space
    private static char[] reverseString(char[] s) {
	if (s == null || s.length == 0) {
	    return s;
	}
	int right = s.length - 1;
	int left = 0;
	char temp;
	while (right > left) {
	    temp = s[left];
	    s[left] = s[right];
	    s[right] = temp;
	    left++;
	    right--;
	}

	return s;
    }

    // 3rd Solution Recursion

    private static char[] reverseStringRecurrsion(char[] s) {

	withRegression(s, s.length - 1, 0);

	return s;

    }

    private static void withRegression(char[] s, int right, int left) {
	if (left >= right) {
	    return;
	}
	char temp = s[left];
	s[left++] = s[right];
	s[right--] = temp;
	withRegression(s, right, left);
    }

    // 4th Solution // { 'h', 'e', 'l', 'm', 'l', 'o' };
    private static char[] reverseStringWithOneLoop(char[] s) {
	for (int i = 0; i < s.length / 2; i++) {
	    char temp = s[i];
	    s[i] = s[s.length - 1 - i];
	    s[s.length - 1 - i] = temp;
	}
	return s;
    }
}
