package axon;

public class Ques3
{
	public static long[] prices(double[] prices)
	{
		double sum = 0;
		int sumL = 0;
		double[] decimal = new double[prices.length];
		for (int i = 0; i < prices.length; i++)
		{
			double value = prices[i];
			sum += value;
			sumL += (int) value;
			decimal[i] = (value - (int) value);
		}

		int n = (int) (Math.round(sum) - sumL);

		int indexArr[] = new int[n];
		double max = 0;
		int index;
		for (int j = 0; j < n; j++)
		{
			max = decimal[0];
			index = 0;
			for (int i = 1; i < decimal.length; i++)
			{
				if (max < decimal[i])
				{
					max = decimal[i];
					index = i;
				}
			}
			indexArr[j] = index;
			decimal[index] = Integer.MIN_VALUE;
		}

		long[] res = new long[prices.length];
		for (int i = 0; i < prices.length; i++)
		{
			res[i] = (long) prices[i];
			for (int j = 0; j < indexArr.length; j++)
			{
				if (i == indexArr[j])
				{
					res[i] = (long) Math.ceil(prices[i]);
				}
			}

		}
		return res;
	}

	public static void main(String[] args)
	{
		double[] prices = {5.3, 3.3, 5};
		long[] res = prices(prices);

		for(int i=0;i<res.length;i++){
			System.out.println(res[i]);
		}
	}
}
