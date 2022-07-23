package easy.array;

public class RemovesDuplicate {
    //Remove Duplicates from Sorted Array
    public static int removeDuplicates(int[] nums) {
        int dupVal = nums[0];
        int dupIdx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > dupVal) {
                dupIdx++;
                dupVal = nums[i];
                nums[dupIdx] = nums[i];
            }
        }
        return dupIdx + 1;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 7, 11, 15, 15, 16, 19, 19};

        System.out.println("=== " + removeDuplicates(nums));
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }

    }


}
