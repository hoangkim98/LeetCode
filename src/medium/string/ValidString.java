package medium.string;

/*
Given a string s, determine if it is valid.

A string s is valid if, starting with an empty string t = "", you can transform t into s after performing the following operation any number of times:

Insert string "abc" into any position in t. More formally, t becomes tleft + "abc" + tright, where t == tleft + tright. Note that tleft and tright may be empty.
Return true if s is a valid string, otherwise, return false.



Example 1:

Input: s = "aabcbc"
Output: true
Explanation:
"" -> "abc" -> "aabcbc"
Thus, "aabcbc" is valid.
 */

public class ValidString {
    public static final String CONST = "abc";

    public static boolean isValid(String s) {
        StringBuilder sb = new StringBuilder();
        if (s.length() % CONST.length() != 0
                || s.charAt(0) != 'a'
                || s.charAt(s.length() - 1) != 'c') {
            return false;
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; ) {
            char aChar = chars[i];
            if (i + 3 < s.length()
                    && s.substring(i, i + 3).equalsIgnoreCase(CONST)) {
                i = i + 3;
            } else if (aChar == 'a') {
                sb.append("a");
                i++;
            } else if (aChar == 'b' && sb.length() > 0) {
                if ("a".equalsIgnoreCase(String.valueOf(sb.toString().toCharArray()[sb.length() - 1]))) {
                    sb.append("b");
                    i++;
                } else {
                    return false;
                }
            } else if (aChar == 'c' && sb.length() > 0) {
                if ("b".equalsIgnoreCase(String.valueOf(sb.toString().toCharArray()[sb.length() - 1]))) {
                    sb.deleteCharAt(sb.length() - 1);
                    if ("a".equalsIgnoreCase(String.valueOf(sb.toString().toCharArray()[sb.length() - 1]))) {
                        sb.deleteCharAt(sb.length() - 1);
                        i++;
                    } else {
                        return false;
                    }
                    i++;
                } else {
                    return false;
                }
            } else {
                i++;
            }
        }
        return sb.length() == 0;
    }

    public static void main(String[] args) {
        System.out.println(isValid("aaababccbcbc"));

    }
}
