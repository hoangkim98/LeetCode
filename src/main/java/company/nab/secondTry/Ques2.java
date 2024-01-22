package company.nab.secondTry;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Ques2 {

    public static int solution(int[] P, int[] S) {
        // Implement your solution here
        int sum = IntStream.of(P).sum();
        Arrays.sort(S);
        int count = 0;
        for (int j = S.length - 1; j >= 0; j--) {
            if (sum > 0) {
                sum -= S[j];
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
//        int[] peos = {1, 4, 1};
//        int[] peos = {1, 4, 1};

        int[] peos = {3, 2, 1, 1, 2};
        int[] seat = {2, 5, 9, 9, 5};
        System.out.println((solution(peos, seat)));

    }
}
