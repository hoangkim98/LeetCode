/*
Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).

Return the running sum of nums.



Example 1:

Input: nums = [1,2,3,4]
Output: [1,3,6,10]
Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].
 */

package level.easy.array;

public class MinOpsToAlternateBinString {
    public static int minOperations(String s) {
        if (s.length() < 2) {
            return 0;
        }
        return Math.min(compareDiff(s, genResult('1', '0', s.length())),
                compareDiff(s, genResult('0', '1', s.length())));
    }

    public static String genResult(char startDigit, char secondDigit, int length) {
        StringBuilder sb = new StringBuilder();
        while (length > 0) {
            sb.append(length % 2 == 0 ? startDigit : secondDigit);
            length--;
        }
        return sb.toString();
    }

    public static int compareDiff(String origin, String sample) {
        int count = 0, length = sample.length() - 1;
        while (length >= 0) {
            if (origin.charAt(length) != sample.charAt(length)) {
                count++;
            }
            length--;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(minOperations("1111"));
        System.out.println(minOperations("101011"));
        System.out.println(minOperations("110010"));
    }
}
