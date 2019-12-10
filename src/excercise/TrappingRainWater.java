package excercise;

//https://www.youtube.com/watch?v=wz00uI9mDXA&t=1350s
//https://www.youtube.com/watch?v=wz00uI9mDXA&t=1350s
//https://www.youtube.com/watch?v=zdDeV5v_iUE
public class TrappingRainWater {
    public static void main(String[] args) {
	int[] nums = { 2, 1, 0, 2, 0, 0, 1, 3 };
	// System.out.println(countWater(nums));
	int num = 380;
	printDays(num);
	// System.out.println(6 / 3);

    }

    private static void printDays(int num) {

	int year = num / 365;
	System.out.println("years " + year);
	/*
	 * int months = num / 30; System.out.println("months " + months); int weeks =
	 * num / 7; System.out.println("weeks " + weeks);
	 */

	int weeks = (num % 365) / 7;
	System.out.println("week " + weeks);
	int days = (num % 365) % 7;
	System.out.println("day  " + days);

    }

    private static int countWater(int[] height) {

	int totalAmount = 0;
	if (height == null || height.length == 0) {
	    return totalAmount;
	}

	int[] leftHieghest = new int[height.length + 1];
	leftHieghest[0] = 0;
	for (int i = 0; i < height.length; i++) {
	    leftHieghest[i + 1] = Math.max(leftHieghest[i], height[i]);
	}
	// int[] rightHieghest = new int[height.length + 1];

	int rightHieghest = 0;
	for (int i = height.length - 1; i >= 0; i--) {
	    rightHieghest = Math.max(height[i], rightHieghest);
	    totalAmount += Math.min(leftHieghest[i], rightHieghest) > height[i]
		    ? Math.min(leftHieghest[i], rightHieghest) - height[i]
		    : 0;
	}

	return totalAmount;
    }
}
