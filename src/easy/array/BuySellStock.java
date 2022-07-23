package easy.array;

public class BuySellStock {
    public static int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i - 1];
            if (diff > 0) {
                profit += diff;
            }
        }
        return profit;
    }


    public static void main(String[] args) {
        int[] prices = {7, 10, 4, 9, 1};
        System.out.println(maxProfit(prices));
    }
}
