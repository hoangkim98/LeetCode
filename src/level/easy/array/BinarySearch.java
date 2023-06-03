/*
Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).

Return the running sum of nums.



Example 1:

Input: nums = [1,2,3,4]
Output: [1,3,6,10]
Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].
 */

package level.easy.array;

public class BinarySearch {
    public static int search(int[] nums, int target) {
        return searchRange(nums, 0, nums.length - 1, target);

    }

    public static int searchRange(int[] nums, int left, int right, int target) {
        if (left > right) {
            return -1;
        }
        int mid = (right + left) / 2;
        if (target == nums[mid]) {
            return mid;
        } else if (target < nums[mid]) {
            return searchRange(nums, left, mid - 1, target);
        } else {
            return searchRange(nums, mid + 1, right, target);
        }
    }

    public static void main(String[] args) {
        int[] nums = {-1};
        System.out.println(search(nums, -1));
    }
}
