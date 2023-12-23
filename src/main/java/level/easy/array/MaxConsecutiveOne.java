/*
https://leetcode.com/problems/max-consecutive-ones
 */

package level.easy.array;

public class MaxConsecutiveOne {

    public static int findMaxConsecutiveOnes(int[] nums) {
        int max = 0,count = 0;
        for (int num : nums) {
            if (num == 0) {
                max = Math.max(max, count);
                count = 0;
            } else {
                count++;
            }

        }
        return Math.max(max, count);
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 1, 1, 0, 1, 0};
        System.out.println(findMaxConsecutiveOnes(nums));
    }
}
