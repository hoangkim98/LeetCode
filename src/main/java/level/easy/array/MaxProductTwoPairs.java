/*
The product difference between two pairs (a, b) and (c, d) is defined as (a * b) - (c * d).

For example, the product difference between (5, 6) and (2, 7) is (5 * 6) - (2 * 7) = 16.
Given an integer array nums, choose four distinct indices w, x, y, and z such that the product difference between pairs (nums[w], nums[x]) and (nums[y], nums[z]) is maximized.

Return the maximum such product difference.



Example 1:

Input: nums = [5,6,2,7,4]
Output: 34
Explanation: We can choose indices 1 and 3 for the first pair (6, 7) and indices 2 and 4 for the second pair (2, 4).
The product difference is (6 * 7) - (2 * 4) = 34.
 */

package level.easy.array;

import java.util.Arrays;

public class MaxProductTwoPairs {
    public static int maxProductDifference(int[] nums) {
        int[] sortedArr = Arrays.stream(nums).sorted().toArray();
        int length = nums.length;
        int max = sortedArr[length - 1];
        int secondMax = sortedArr[length - 2];
        int min = sortedArr[0];
        int secondMin = sortedArr[1];

        return (max * secondMax) - (min * secondMin);
    }


    public static void main(String[] args) {
        int[] prices = {5, 6, 2, 7, 4};
        System.out.println(maxProductDifference(prices));
    }
}
