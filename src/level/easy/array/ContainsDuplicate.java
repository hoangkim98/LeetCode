package level.easy.array;

import java.util.HashMap;
import java.util.Map;


public class ContainsDuplicate {
    public static boolean containsDuplicate(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return true;
            } else {
                map.put(nums[i], true);
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15, 15};
        System.out.println(containsDuplicate(nums));
    }
}
