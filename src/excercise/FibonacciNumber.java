package excercise;
// This is not a fib series

//https://leetcode.com/problems/fibonacci-number/
/*The Fibonacci numbers, commonly denoted F(n) form a sequence, 
called the Fibonacci sequence, such that each number is the sum of the two preceding ones, 
starting from 0 and 1. That is,
F(0) = 0,   F(1) = 1
F(N) = F(N - 1) + F(N - 2), for N > 1.*/

public class FibonacciNumber {
    public static void main(String[] args) {

	int steps = 4;
	System.out.println(fib(steps));
	// System.out.println(howManyWays_II(steps));
    }

    public static int fib(int n) {
	if (n == 0) {
	    return 0;
	}
	if (n == 1) {
	    return 1;
	}
	int[] steps = new int[n + 1];
	steps[1] = 1;

	for (int i = 2; i <= n; i++) {
	    steps[i] = steps[i - 1] + steps[i - 2];
	}
	return steps[n];

    }
}
