/*
Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters.
 No two characters may map to the same character, but a character may map to itself.



Example 1:

Input: s = "egg", t = "add"
Output: true
 */
package level.easy.string;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicString {
    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<String, String> sMap = new HashMap<>();
        Map<String, String> tMap = new HashMap<>();
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        for (int i = 0; i < sArr.length; i++) {
            String sVal = String.valueOf(sArr[i]);
            String tVal = String.valueOf(tArr[i]);
            if (sMap.containsKey(sVal) && !sMap.get(sVal).equals(tVal)) {
                return false;
            } else {
                sMap.put(sVal, tVal);
            }
        }

        for (int i = 0; i < tArr.length; i++) {
            String sVal = String.valueOf(sArr[i]);
            String tVal = String.valueOf(tArr[i]);
            if (tMap.containsKey(tVal) && !tMap.get(tVal).equals(sVal)) {
                return false;
            } else {
                tMap.put(tVal, sVal);
            }
        }

        return true;
    }


    public static void main(String[] args) {
        String s = "badc";
        String t = "baba";
        System.out.println(isIsomorphic(s, t));
    }
}
