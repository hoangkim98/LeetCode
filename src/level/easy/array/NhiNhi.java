package level.easy.array;

import java.util.ArrayList;
import java.util.List;

public class NhiNhi {
    public static List<List<Integer>> allSum(int[] nums, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int check = nums[i] + nums[j];
                if (check == sum) {
                    res.add(List.of(nums[i], nums[j]));
                } else if (check > sum) {
                    continue;
                } else {
                    
                }

            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 6, 5, 4, 8, 9, 7};
        System.out.println(allSum(nums, 9));
    }
}
