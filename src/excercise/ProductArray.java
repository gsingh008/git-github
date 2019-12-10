package excercise;

//submitted leetcode
/*Runtime: 1 ms, faster than 100.00% of Java online submissions for Product of Array Except Self.
Memory Usage: 41.9 MB, less than 100.00% of Java online submissions for Product of Array Except Self.*/
//https://leetcode.com/problems/product-of-array-except-self/submissions/
public class ProductArray {
    public static void main(String[] args) {

	// use cases
	// int[] nums = { 1, 2, 3, 4 };
	int[] nums = { 1, 0 };
	// int[] nums = { 0, 0 };

	// int[] nums = { 2, 3, 4, 5 };

	// int[] products = product_one(nums);
	int[] products = product_two(nums);

	for (int i = 0; i < products.length; i++) {
	    System.out.println(products[i]);

	}

    }

    // Solution-1
    // this brute force works but failed in input {1,0).
    // Starting point for the interview
    private static int[] product_one(int[] nums) {

	if (nums == null || nums.length == 0) {
	    return null;
	}
	int[] products = new int[nums.length];
	for (int i = 0; i < nums.length; i++) {
	    int product = 1;
	    if (nums[i] == 0) {
		product = 0;
	    }

	    for (int j = 0; j < nums.length; j++) {
		if (nums[i] == nums[j]) {
		    continue;
		}
		product = product * nums[j];
	    }
	    products[i] = product;

	}
	return products;

    }

    // solution-2
    // {1,2,3,4}
    // left {1,1,2,6}
    // right {24,12,4,1}
    // {2,3,4,5}
    // left={1,2,6,24}
    // right={60,20,5,1}
    // output={60,40,30,24}

    private static int[] product_two(int[] nums) {
	if (nums == null || nums.length == 0) {
	    return null;
	}

	int[] left = new int[nums.length];
	left[0] = 1;
	int n = nums.length - 1;

	for (int i = 1; i <= n; i++) {
	    left[i] = left[i - 1] * nums[i - 1];
	}
	int[] right = new int[nums.length];
	right[n] = 1;
	for (int j = n - 1; j >= 0; j--) {
	    right[j] = nums[j + 1] * right[j + 1];
	}
	int[] result = new int[nums.length];
	for (int i = 0; i < nums.length; i++) {
	    result[i] = left[i] * right[i];

	}
	return result;

    }

    // Solution -3 too optimized
    private static int[] product_three(int[] nums) {

	int n = nums.length;
	int[] res = new int[n];
	res[0] = 1;
	for (int i = 1; i < n; i++) {
	    res[i] = res[i - 1] * nums[i - 1];
	}
	int right = 1;
	for (int i = n - 1; i >= 0; i--) {
	    res[i] *= right;
	    right *= nums[i];
	}
	return res;

    }
}
