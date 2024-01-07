package company.axon;

public class Ques3 {

    public static long[] prices(double[] prices) {
        double sum = 0;
        int sumL = 0;
        double[] decimal = new double[prices.length];
        for (int i = 0; i < prices.length; i++) {
            double value = prices[i];
            sum += value;
            sumL += (int) value;
            decimal[i] = (value - (int) value);
        }

        // Chênh lệch giữa tổng và tổng phần nguyên
//		VD: 14 - (5+6+5) =1
        int n = (int) (Math.round(sum) - sumL);

        // Tìm indexArr chứa index của n phần thập phân lớn nhất
        // [5.5, 3.3, 5] -> phần thập phân [0.5, 0.3, 0] -> indexArr [0] do 0.5 lớn nhất
        // Bài toán: find k-th largest elements
        int[] indexArr = new int[n];
        double max;
        int index;
        for (int j = 0; j < n; j++) {
            max = decimal[0];
            index = 0;
            for (int i = 1; i < decimal.length; i++) {
                if (max < decimal[i]) {
                    max = decimal[i];
                    index = i;
                }
            }
            indexArr[j] = index;
            decimal[index] = Integer.MIN_VALUE;
        }

        // Lấy ceil với n giá trị có phần thập phân lớn nhất dựa theo indexArr
        // Lấy floor với những giá trị còn lại
        long[] res = new long[prices.length];
        for (int i = 0; i < prices.length; i++) {
            res[i] = (long) prices[i];
            for (int k : indexArr) {
                if (i == k) {
                    res[i] = (long) Math.ceil(prices[i]);
                    break;
                }
            }

        }
        // Ez
        return res;
    }

    public static void main(String[] args) {
        double[] prices = {5.3, 3.3, 5};
        long[] res = prices(prices);

        for (long re : res) {
            System.out.println(re);
        }
    }
}
