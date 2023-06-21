package level.easy.array;

public class MoveZeroes {
    public static void moveZeroes(int[] nums) {
        int zeroIdx = -1;
        for (int i = 0; i < nums.length; i++) {
            if (0 != nums[i]) {
                zeroIdx++;
                nums[zeroIdx] = nums[i];
            }
        }

        for (int i = zeroIdx + 1; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 0, 15, 0, 20};
        moveZeroes(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
