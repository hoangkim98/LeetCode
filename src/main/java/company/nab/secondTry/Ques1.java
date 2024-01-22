package company.nab.secondTry;

import java.util.Arrays;

public class Ques1 {

    public static int[] solution(String[] S) {
        // write your code in Java SE 8
        if (S == null || S.length == 0) {
            return new int[]{};
        }
        int m = S[0].length();
        int[][] map = new int[26][m];
        for (int i = 0; i < 26; i++) {
            Arrays.fill(map[i], -1);
        }
        for (int i = 0; i < S.length; i++) {
            String str = S[i];
            for (int j = 0; j < str.length(); j++) {
                int c = str.charAt(j) - 'a';
                int index = map[c][j];
                if (index == -1) {
                    map[c][j] = i;
                } else {
                    return new int[]{Math.min(i, index), Math.max(i, index), j};
                }
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        String[] arr = {"abc", "bca", "dbe"};
        System.out.println(Arrays.toString(solution(arr)));

    }
}
