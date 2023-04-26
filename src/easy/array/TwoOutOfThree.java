/*
Given three integer arrays nums1, nums2, and nums3, return a distinct array containing all the values that are present in at least two out of the three arrays. You may return the values in any order.


Example 1:

Input: nums1 = [1,1,3,2], nums2 = [2,3], nums3 = [3]
Output: [3,2]
Explanation: The values that are present in at least two arrays are:
- 3, in all three arrays.
- 2, in nums1 and nums2.
 */

package easy.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TwoOutOfThree {
    public static List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        List<Integer> distinctNum = new ArrayList<>();
        addToDistinctList(nums1, distinctNum);
        addToDistinctList(nums2, distinctNum);
        addToDistinctList(nums3, distinctNum);

        Set<Integer> resSet = new HashSet<>();
        Set<Integer> checkDup = new HashSet<>();
        for (int i = 0; i < distinctNum.size(); i++) {
            if (checkDup.contains(distinctNum.get(i))) {
                resSet.add(distinctNum.get(i));
            } else {
                checkDup.add(distinctNum.get(i));
            }

        }
        List<Integer> res = new ArrayList<>(resSet);
        return res;
    }

    private static void addToDistinctList(int[] nums, List<Integer> distinctNumEachArr) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
                distinctNumEachArr.add(nums[i]);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 1, 3, 2};
        int[] nums2 = {2, 3};
        int[] nums3 = {3};
        System.out.println(twoOutOfThree(nums1, nums2, nums3));
    }

}
