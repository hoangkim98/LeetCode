public class RotateArray
{
	public static int[] rotate(int[] nums, int k) {
		int[] res = new int[nums.length];
		for(int i=0;i<nums.length;i++){
			res[(i+k) % nums.length] = nums[i];
		}
		return res;
	}



	public static void main(String[] args)
	{
		int[] nums = {1,2,3,4,5,6,7};
		int[] res = rotate(nums, 3);
		for(int i = 0; i<res.length; i++){
			System.out.print(res[i] + " ");
		}
	}
}
