package dynamic;
// https://leetcode.com/explore/featured/card/top-interview-questions-easy/97/dynamic-programming/569/

public class ClimbingStairs
{
	public static int climbStairs(int n) {
		if(n < 2)
			return n;
		int[] dp = new int[n + 1];
		dp[1] = 1;
		dp[2] = 2;
		for(int i=3;i<=n;i++){
			dp[i] = dp[i-1]  + dp[i-2];
		}
		return dp[n];
	}


	public static void main(String[] args)
	{
		System.out.println(climbStairs(2));
	}
}
