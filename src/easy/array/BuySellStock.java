package easy.array;

public class BuySellStock {
    public static int maxProfit(int[] prices) {
        int least = Integer.MAX_VALUE;
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];
            if (price < least) {
                least = price;
            }
            int diff = prices[i] - least;
            if (diff > profit) {
                profit = diff;
            }
        }
        return profit;
    }


    public static void main(String[] args) {
        int[] prices = {1, 2};
        System.out.println(maxProfit(prices));
    }
}
