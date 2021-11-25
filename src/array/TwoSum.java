package array;

import java.util.HashMap;
import java.util.Map;


public class TwoSum
{
	public static int[] twoSum(int[] nums, int target)
	{
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++)
		{
			if (map.containsKey(target - nums[i]))
			{
				return new int[] { i, map.get(target-nums[i])};
			}
			if (map.get(nums[i]) == null)
			{
				map.put(nums[i], i);
			}
		}
		return null;
	}



	public static void main(String[] args)
	{
		int[] nums = { 2, 7, 11, 15 };
		int[] res = twoSum(nums, 9);
		for (int i = 0; i < res.length; i++)
		{
			System.out.print(res[i] + " ");
		}
	}
}
