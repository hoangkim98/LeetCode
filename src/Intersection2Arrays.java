import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Intersection2Arrays
{
	public static int[] intersect(int[] nums1, int[] nums2)
	{
		Map<Integer, Integer> countNums1 = new HashMap<>();
		Map<Integer, Integer> countNums2 = new HashMap<>();
		for (int i = 0; i < nums1.length; i++)
		{
			if (null == countNums1.get(nums1[i]))
			{
				countNums1.put(nums1[i], 1);
			}
			else
			{
				countNums1.put(nums1[i], countNums1.get(nums1[i]) + 1);
			}
		}

		for (int i = 0; i < nums2.length; i++)
		{
			int value = nums2[i];
			if (countNums1.containsKey(value))
			{
				if (null == countNums2.get(value))
				{
					countNums2.put(value, 1);
				}
				else
				{
					countNums2.put(value, countNums2.get(value) + 1);
				}
			}
		}

		List<Integer> res = new ArrayList<>();
		for (Map.Entry<Integer, Integer> entry : countNums2.entrySet())
		{
			int value = entry.getKey();
			int eleCount = smaller(countNums1.get(value), countNums2.get(value));
			for (int i = 0; i < eleCount; i++)
			{
				res.add(value);
			}
		}
		return res.stream().mapToInt(i -> i).toArray();
	}

	public static int smaller(int a, int b){
		return a < b ? a : b;
	}

	public static void main(String[] args)
	{
		int[] nums1 = { 1,2,2,1 };
		int[] nums2 = { 2 };
		int[] res = intersect(nums1, nums2);
		for (int i = 0; i < res.length; i++)
		{
			System.out.print(res[i] + " ");
		}
	}
}
