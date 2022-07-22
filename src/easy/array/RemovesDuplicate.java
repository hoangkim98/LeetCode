package easy.array;

public class RemovesDuplicate {
    //Remove Duplicates from Sorted Array

    public static int removeDuplicates(int[] nums) {
        int dupIdx = 0, preVal = 0;
        // Get first duplicate position -> dupIdx
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                dupIdx = i + 1;
                preVal = nums[i];
                break;
            }

        }
        if (dupIdx != 0) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > preVal) {
                    preVal = nums[i];
                    swap(nums, i, dupIdx);
                    dupIdx++;
                }
            }
        }

        return dupIdx != 0 ? dupIdx : nums.length;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
//        int[] nums = {2, 7, 11, 15, 15};
        int[] nums = {0, 1, 2};
//        int[] nums = {2, 2, 7, 11, 15, 15, 16, 19, 19};

        System.out.println("=== " + removeDuplicates(nums));
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }

    }


}
