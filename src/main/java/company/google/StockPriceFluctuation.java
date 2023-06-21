package company.google;/*
https://leetcode.com/problems/stock-price-fluctuation/
You are given a stream of records about a particular stock. Each record contains a timestamp and the corresponding price of the stock at that timestamp.

Unfortunately due to the volatile nature of the stock market, the records do not come in order. Even worse, some records may be incorrect. Another record with the same timestamp may appear later in the stream correcting the price of the previous wrong record.

Design an algorithm that:

Updates the price of the stock at a particular timestamp, correcting the price from any previous records at the timestamp.
Finds the latest price of the stock based on the current records. The latest price is the price at the latest timestamp recorded.
Finds the maximum price the stock has been based on the current records.
Finds the minimum price the stock has been based on the current records.

Input
["StockPrice", "update", "update", "current", "maximum", "update", "maximum", "update", "minimum"]
[[], [1, 10], [2, 5], [], [], [1, 3], [], [4, 2], []]
Output
[null, null, null, 5, 10, null, 5, null, 2]

Explanation
StockPrice stockPrice = new StockPrice();
stockPrice.update(1, 10); // Timestamps are [1] with corresponding prices [10].
stockPrice.update(2, 5);  // Timestamps are [1,2] with corresponding prices [10,5].
stockPrice.current();     // return 5, the latest timestamp is 2 with the price being 5.
stockPrice.maximum();     // return 10, the maximum price is 10 at timestamp 1.
stockPrice.update(1, 3);  // The previous timestamp 1 had the wrong price, so it is updated to 3.
                          // Timestamps are [1,2] with corresponding prices [3,5].
stockPrice.maximum();     // return 5, the maximum price is 5 after the correction.
stockPrice.update(4, 2);  // Timestamps are [1,2,4] with corresponding prices [3,5,2].
stockPrice.minimum();     // return 2, the minimum price is 2 at timestamp 4.
 */

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class StockPriceFluctuation {
    static class StockPrice {
        Map<Integer, Integer> map = new HashMap<>(); // time - price
        TreeMap<Integer, Integer> treeMap = new TreeMap<>(); // price - count
        // Need to count number of each price because if update to remove min/max from treeMap, still got count to check
//          obj.update(1, 10);
//        obj.update(2, 10);
//          obj.update(1, 1);
        int currentTime;

        public StockPrice() {

        }

        public void update(int timestamp, int price) {
            Integer prevPrice = map.get(timestamp);
            if (prevPrice != null) {
                treeMap.put(prevPrice, treeMap.getOrDefault(prevPrice, 0) - 1);
            }

            treeMap.put(price, treeMap.getOrDefault(price, 0) + 1);
            currentTime = Math.max(currentTime, timestamp);
            map.put(timestamp, price);

            if (prevPrice != null && treeMap.get(prevPrice) == 0) {
                treeMap.remove(prevPrice);
            }
        }

        public int current() {
            return map.get(currentTime);
        }

        public int maximum() {
            return treeMap.lastKey();
        }

        public int minimum() {
            return treeMap.firstKey();
        }
    }

    public static void main(String[] args) {
        StockPrice obj = new StockPrice();
        obj.update(1, 10);
        obj.update(2, 5);
        obj.update(1, 3);
        obj.update(4, 2);

        System.out.println("curr: " + obj.current());
        System.out.println("min: " + obj.minimum());
        System.out.println("max: " + obj.maximum());
    }
}