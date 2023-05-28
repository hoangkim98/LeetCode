///*
//Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
//
//Return the running sum of nums.
//
//
//
//Example 1:
//
//Input: nums = [1,2,3,4]
//Output: [1,3,6,10]
//Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].
// */
//
///*
//Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
//
//You are given an API bool isBadVersion(version) which returns whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.
//
//
//
//Example 1:
//
//Input: n = 5, bad = 4
//Output: 4
//Explanation:
//call isBadVersion(3) -> false
//call isBadVersion(5) -> true
//call isBadVersion(4) -> true
//Then 4 is the first bad version.
// */
//package easy.array;
//
//public class FirstBadVersion {
//    public int firstBadVersion(int n) {
//
//    }
//
//    public static int searchRange(int[] nums, int left, int right, int target) {
//        if (left > right) {
//            return -1;
//        }
//        int mid = (right + left) / 2;
//        if (target == nums[mid]) {
//            return mid;
//        } else if (target < nums[mid]) {
//            return searchRange(nums, left, mid - 1, target);
//        } else {
//            return searchRange(nums, mid + 1, right, target);
//        }
//    }
//
//    public static boolean isBadVersion(int n) {
//        return true;
//    }
//
//    public static void main(String[] args) {
//        int[] nums = {-1};
////        System.out.println(search(nums, -1));
//    }
//}
