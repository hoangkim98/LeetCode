/*
https://leetcode.com/problems/max-consecutive-ones
 */

package level.medium.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    static List<List<String>> res = new ArrayList<>();
    static List<String> part = new ArrayList<>();

    public static List<List<String>> partition(String s) {
        dfs(0,s);
        return res;
    }

    public static void dfs(int i, String s) {
        if(i>= s.length()){
            res.add(new ArrayList<>(part));
            return;
        }
        for(int j = i; j<s.length(); j++) {
            if (isPalindrome(s.substring(i, j+1))) {
                part.add(s.substring(i, j + 1));
                dfs(j + 1, s);
                part.remove(part.size() - 1);
            }
        }
    }

    public static boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(partition("cdd"));
    }
}
