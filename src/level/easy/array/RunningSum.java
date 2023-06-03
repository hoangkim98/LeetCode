/*
Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).

Return the running sum of nums.



Example 1:

Input: nums = [1,2,3,4]
Output: [1,3,6,10]
Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].
 */

package level.easy.array;

public class RunningSum {
	public static int[] runningSum(int[] nums) {
		int sum = 0;
		int[] res = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			res[i] = num + sum;
			sum += num;
		}
		return res;
	}

	public static void main(String[] args) {
		int[] nums = {2, 7, 11, 15};
		int[] res = runningSum(nums);
		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i] + " ");
		}
	}
}
