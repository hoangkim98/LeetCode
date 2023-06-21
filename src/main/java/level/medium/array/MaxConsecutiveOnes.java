package level.medium.array;

/*
Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.



Example 1:

Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output: 6
Explanation: [1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
Example 2:

Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
Output: 10
Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 */

public class MaxConsecutiveOnes {
    public static int longestOnes(int[] nums, int k) {
        int start = 0, end = 0, max = 0, countZero = 0;
        while (end < nums.length) {
            if (nums[end] == 1) {
                max++;
            } else if (nums[end] == 0 && countZero < k) {
                countZero++;
                max++;
            } else if (nums[end] == 0 && countZero >= k) {
                int findZero = 0;
                while (start < nums.length) {
                    if (nums[start] == 0) {
                        findZero++;
                    }
                    if (findZero == 2) {
                        end = start + max;
                        break;
                    }
                    start++;
                }

            }
            end++;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
        System.out.println(longestOnes(nums, 3));
    }
}
