package level.medium.array;

/*
https://leetcode.com/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/
 */

public class NumbSubArrAverageThreshold {

    public  static int numOfSubarrays(int[] arr, int k, int threshold) {
        int start = 0, end = start + k -1, count = 0;
        if(end >= arr.length) {
            return 0;
        }
        while(end < arr.length) {
            if(average(arr, start, k) >= threshold) {
                count++;
            }
            start++;
            end++;
        }
        return count;
    }

    public static int average(int[] arr, int start, int k){
        int sum = 0, temp = k;
        for (int i = start; k > 0; i++) {
            sum += arr[i];
            k--;
        }
        return sum / temp;
    }

    public static void main(String[] args) {
        int[] nums = {11,13,17,23,29,31,7,5,2,3};
        System.out.println(numOfSubarrays(nums, 3, 5));
    }


}
