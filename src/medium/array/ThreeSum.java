package medium.array;

import java.util.*;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, Boolean> checkDup = new HashMap<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0 || checkDup.containsKey(nums[i])) {
                break;
            }
            Map<Integer, Boolean> twoSumMap = new HashMap<>();
            for (int j = 0; j < nums.length; j++) {
                if (i == j) {
                    continue;
                }
                if (twoSumMap.containsKey(nums[j])) {
                    res.add(List.of(nums[i], nums[j], -nums[i] - nums[j]));
                    checkDup.put(nums[i], true);
                } else {
                    twoSumMap.put(-nums[i] - nums[j], true);
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] prices = {-1, -1, 3, 2, 4};
        System.out.println(threeSum(prices));
    }
}
