package excercise;

//submitted https://leetcode.com/problems/climbing-stairs/submissions/
/*Runtime: 0 ms, faster than 100.00% of Java online submissions for Climbing Stairs.
Memory Usage: 32.7 MB, less than 5.26% of Java online submissions for Climbing Stairs.
Next challenges:*/
public class ClimbingStairs {

    public static void main(String[] args) {

	int steps = 5;
	System.out.println(howManyWays(steps));
	// System.out.println(howManyWays_II(steps));
    }

    private static int howManyWays(int n) {
	if (n == 0 || n == 1) {
	    return 1;
	}
	int[] steps = new int[n + 1];
	steps[1] = 1;
	steps[2] = 2;

	for (int i = 3; i <= n; i++) {
	    steps[i] = steps[i - 1] + steps[i - 2];
	}
	return steps[n];

    }

}
