/*
Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters.
 No two characters may map to the same character, but a character may map to itself.



Example 1:

Input: s = "egg", t = "add"
Output: true
 */
package easy.string;

public class IsSubsequence {
    public static boolean isSubsequence(String s, String t) {
        if (t.length() == 0) {
            return s.length() == 0;
        }
        if (s.length() == 0) {
            return true;
        }

        int idx = 0, subIdx = 0;
        while (idx < t.length()) {
            if (s.charAt(subIdx) == t.charAt(idx)) {
                subIdx++;
            }
            idx++;
            if (subIdx == s.length()) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";
        System.out.println(isSubsequence(s, t));
    }
}
