package level.medium.string;

/*
https://leetcode.com/problems/longest-palindromic-substring/
 */

public class LongestSubPalindrome {

    public static String longestPalindrome(String s) {
        int max = 0;
        String resOdd = "", resEven = "";
        for (int i = 0; i < s.length(); i++) {
            String lengthOdd = getMaxLength(s, max, i, i);
            resOdd = resOdd.length() > lengthOdd.length() ? resOdd : lengthOdd;

            String lengthEven = getMaxLength(s, max, i, i + 1);
            resEven = resEven.length() > lengthEven.length() ? resEven : lengthEven;
        }
        return resOdd.length() > resEven.length() ? resOdd : resEven;
    }

    private static String getMaxLength(String s, int max, int l, int r) {
        String res = "";
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            if (r - l + 1 > max) {
                max = r - l + 1;
                res = s.substring(l, r + 1);
            }
            l--;
            r++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("bcabas")); //3
    }
}
