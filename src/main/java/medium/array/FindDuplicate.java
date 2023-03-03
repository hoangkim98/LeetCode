package medium.array;

/*
Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one repeated number in nums, return this repeated number.

You must solve the problem without modifying the array nums and uses only constant extra space.



Example 1:

Input: nums = [1,3,4,2,2]
Output: 2
Example 2:

Input: nums = [3,1,3,4,2]
Output: 3
 */

public class FindDuplicate {
    public static int findDuplicate(int[] nums) {
        int slow = -1, fast = -1;
        while (true) {
            slow++;
            fast += 2;
            if (fast >= nums.length) {
                fast = fast - nums.length;
            }
            if (nums[nums[slow]] == nums[nums[fast]]) {
                return nums[nums[slow]];
            }
        }
    }


    public static void main(String[] args) {
        int[] nums = {3, 1, 3, 4, 2};
        int res = findDuplicate(nums);
        System.out.println(res);
    }
}
