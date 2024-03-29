package level.medium.array;

import java.util.*;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
           
            Map<Integer, String> twoSumMap = new HashMap<>();
            for (int j = i + 1; j < nums.length; j++) {
                if (twoSumMap.containsKey(nums[j])) {
                    if ("Missing number".equalsIgnoreCase(twoSumMap.get(nums[j]))) {
                        res.add(List.of(nums[i], nums[j], -nums[i] - nums[j]));
                        twoSumMap.put(nums[j], "Already used");
                    }
                } else {
                    twoSumMap.put(-nums[i] - nums[j], "Missing number");
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] prices = {-2, 0, 0, 2, 2};
        System.out.println(threeSum(prices));
    }
}
