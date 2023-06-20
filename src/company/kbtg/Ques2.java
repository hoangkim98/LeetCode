package company.kbtg;


public class Ques2 {
    public static int solution(int[] A) {
        // Implement your solution here
        int max = 0, idx = 0;
        for (int i = 0; i < A.length; i++) {
            if (max < A[i]) {
                max = A[i];
                idx = i;
            }
        }
        A[idx] = sumDigit(max);

        max = 0;
        idx = 0;
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            if (max < A[i]) {
                max = A[i];
                idx = i;
            }
        }
        int oldVal = A[idx];
        A[idx] = sumDigit(max);
        sum = sum - oldVal + A[idx];
        return sum;
    }

    public static int sumDigit(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num = num / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 10, 12, 3}));
        System.out.println(solution(new int[]{2, 29, 3}));
        System.out.println(solution(new int[]{100, 101, 102, 103}));
        System.out.println(solution(new int[]{55}));
        System.out.println(solution(new int[]{203, 217, 390, 171}));
        System.out.println(solution(new int[]{1967, 20, 17, 18}));
    }
}