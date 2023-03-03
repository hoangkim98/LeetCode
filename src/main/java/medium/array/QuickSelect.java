package medium.array;

public class QuickSelect {
    public static int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    private static int quickSelect(int[] nums, int l, int r, int k) {
        int p = partition(nums, l, r);
        if (p < k) return quickSelect(nums, p + 1, r, k);
        if (p > k) return quickSelect(nums, l, p - 1, k);
        return nums[p];
    }

    private static int partition(int[] nums, int l, int r) {
        int pivot = nums[r];
        int p = r;
        for (int i = l; i < p; i++) {
            if (nums[i] > pivot) {
                swap(nums, i, p - 1);
                swap(nums, p, p - 1);
                i--;
                p--;
            }
        }
        return p;
    }

    private static void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    public static void main(String[] args) {
        int[] prices = {-2, 0, 9, 8, 2};
        int kthLargest = findKthLargest(prices, 3);
        System.out.println(kthLargest);
    }
}
