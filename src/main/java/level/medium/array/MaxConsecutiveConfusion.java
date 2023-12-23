package level.medium.array;

/*
https://leetcode.com/problems/maximize-the-confusion-of-an-exam/
 */

public class MaxConsecutiveConfusion {

    public static int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(maxConsecutiveReplayCharacters(answerKey, 'T', k),
                maxConsecutiveReplayCharacters(answerKey, 'F', k));
    }

    public static int maxConsecutiveReplayCharacters(String s, char c, int k) {
        int start = 0, end =0;
        while(end < s.length()) {
            if(s.charAt(end) == c) {
                k--;
            }
            if(k<0){
                if(s.charAt(start) == c) {
                    k++;
                }
                start++;
            }
            end++;
        }
        return end - start;
    }

    public static void main(String[] args) {
        String str = "TFFT";
        System.out.println(maxConsecutiveAnswers(str, 2));
    }
}
