package excercise;

//leet code submission
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/submissions/
/*Runtime: 1 ms, faster than 91.22% of Java online submissions for Best Time to Buy and Sell Stock II.
Memory Usage: 36.9 MB, less than 100.00% of Java online submissions for Best Time to Buy and Sell Stock II.*/
public class BuyStock_II {

    public static void main(String[] args) {

	int[] price = { 7, 6, 4, 3, 1 };

	System.out.println(maxProfit(price));
    }

    public static int maxProfit(int prices[]) {

	if (prices.length == 0 || prices.length == 1) {
	    return 0;
	}
	int maxprofit = 0;
	for (int i = 1; i < prices.length; i++) {
	    if (prices[i] > prices[i - 1]) {
		maxprofit += prices[i] - prices[i - 1];
	    }
	}
	return maxprofit;
    }
}
