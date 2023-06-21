package level.hard;/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

Example 1:


Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
 */

public class TrappingRainWater {
    public static int trap(int[] height) {
        int maxIdx = maxIdx(height);
        int secondMax = height[0];
        int sum = 0;
        for (int i = 1; i <= maxIdx; i++) {
            if (height[i] > secondMax) {
                secondMax = height[i];
            }
            if (height[i] < secondMax) {
                sum += secondMax - height[i];
            }
        }

        secondMax = height[height.length-1];
        for (int i = height.length - 2; i > maxIdx; i--) {
            if (height[i] > secondMax) {
                secondMax = height[i];
            }
            if (height[i] < secondMax) {
                sum += secondMax - height[i];
            }
        }
        return sum;
    }

    public static int maxIdx(int[] height) {
        int maxAt = 0;
        for (int i = 0; i < height.length; i++) {
            maxAt = height[i] > height[maxAt] ? i : maxAt;
        }
        return maxAt;
    }

    public static void main(String[] args) {
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(height));
    }
}