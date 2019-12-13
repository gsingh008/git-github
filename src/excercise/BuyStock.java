package excercise;

//leet code submitted but with brute force solution o{n2)
/*Runtime: 235 ms, faster than 5.03% of Java online submissions for Best Time to Buy and Sell Stock.
Memory Usage: 38.9 MB, less than 28.76% of Java online submissions for Best Time to Buy and Sell Stock.*/

public class BuyStock {
    public static void main(String[] args) {
	// int[] prices = { 7, 5, 3, 6, 4, 1 };
	int[] prices = { 2, 7, 1, 11, 4 };

	// Solution-1 o(n2) with 2 loops
	System.out.println(maxProfit(prices));

	// Solution-1 o(n) with 1 loop only
	System.out.println(maxProfit_temp(prices));
	int[] price = { 7, 6, 4, 3, 1 };
    }

    private static int maxProfit(int[] prices) {
	int diff = 0;
	for (int i = 0; i < prices.length; i++) {
	    for (int j = i + 1; j < prices.length; j++) {
		if (prices[i] > prices[j]) {
		    // i++;
		    continue;
		}
		if (diff < Math.abs(prices[i] - prices[j])) {
		    diff = Math.abs(prices[i] - prices[j]);
		}

	    }

	}
	return diff;
    }

    // { 7, 5, 3, 6, 4,1 }
    // { 2, 7, 1, 11, 4 }
    public static int maxProfit_temp(int prices[]) {
	int minprice = Integer.MAX_VALUE;
	int maxprofit = 0;
	for (int i = 0; i < prices.length; i++) {
	    if (prices[i] < minprice)
		minprice = prices[i];
	    else if (prices[i] - minprice > maxprofit)
		maxprofit = prices[i] - minprice;
	}
	return maxprofit;
    }
}
