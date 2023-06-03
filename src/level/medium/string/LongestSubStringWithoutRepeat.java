package level.medium.string;

/*
https://leetcode.com/problems/longest-substring-without-repeating-characters/
Given a string s, find the length of the longest
substring
 without repeating characters.

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
 */

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithoutRepeat {

    public static int lengthOfLongestSubstring(String s) {
        Map<String, Integer> map = new HashMap<>(); // char - index
        int max = 0;
        for (int i = 0, j = 0; j < s.length(); j++) {
            String oneStr = String.valueOf(s.charAt(j));
            if (map.containsKey(oneStr)) {
                i = Math.max(i, map.get(oneStr) + 1);
            }
            map.put(oneStr, j);
            max = Math.max(max, j - i + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb")); //3
        System.out.println(lengthOfLongestSubstring("abc01abc023")); //7
        System.out.println(lengthOfLongestSubstring("abababab;")); // 3
        System.out.println(lengthOfLongestSubstring("01ab.d 2")); //8
        System.out.println(lengthOfLongestSubstring("aaaaada")); //2
        System.out.println(lengthOfLongestSubstring("<<>>abca")); //4
        System.out.println(lengthOfLongestSubstring("abcdabcded")); //5
        System.out.println(lengthOfLongestSubstring("ab01abcda37>>99")); //7
        System.out.println(lengthOfLongestSubstring("tmmzuxt")); //5
    }
}
