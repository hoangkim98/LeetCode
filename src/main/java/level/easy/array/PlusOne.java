package level.easy.array;

import java.util.Arrays;

public class PlusOne {
    public static int[] plusOne(int[] digits) {
        int[] res = new int[digits.length + 1];
        res[0] = 0;
        for (int i = 0; i < digits.length; i++) {
            res[i + 1] = digits[i];
        }
        boolean plusOne = true;
        for (int i = res.length - 1; i >= 0; i--) {
//            System.out.println(digits[i]);
            if (plusOne) {
                if (res[i] != 9) {
                    res[i]++;
                    plusOne = false;
                } else {
                    res[i] = 0;
                }
            }
        }
        if (res[0] == 0) {
            return Arrays.copyOfRange(res, 1, res.length);
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = {9, 9, 9, 9};
        int[] res = plusOne(nums);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]);
        }
    }
}
