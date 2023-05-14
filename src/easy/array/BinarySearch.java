/*
Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).

Return the running sum of nums.



Example 1:

Input: nums = [1,2,3,4]
Output: [1,3,6,10]
Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].
 */

package easy.array;

import java.util.Arrays;

public class BinarySearch {
	public static int search(int[] nums, int target) {
		int mid = nums.length / 2;
		if (mid == 0) {
			return -1;
		}
		if (target == nums[mid]) {
			return mid;
		} else if (target < nums[mid]) {
			search(Arrays.copyOfRange(nums, 0, mid), target);
		} else {
			search(Arrays.copyOfRange(nums, mid, nums.length), target);
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] nums = {2, 7, 11, 15};
		System.out.println(search(nums, 7));
	}
}
