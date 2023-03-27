package mock.interview;

/*
Balanced strings are those that have an equal quantity of 'L' and 'R' characters.

Given a balanced string s, split it into some number of substrings such that:

Each substring is balanced.
Return the maximum number of balanced strings you can obtain.



Example 1:

Input: s = "RLRRLLRLRL"
Output: 4
Explanation: s can be split into "RL", "RRLL", "RL", "RL", each substring contains same number of 'L' and 'R'.
Example 2:

Input: s = "RLRRRLLRLL"
Output: 2
Explanation: s can be split into "RL", "RRRLLRLL", each substring contains same number of 'L' and 'R'.
Note that s cannot be split into "RL", "RR", "RL", "LR", "LL", because the 2nd and 5th substrings are not balanced.
 */

import java.util.ArrayDeque;
import java.util.Deque;

public class BalanceString {
    public static int balancedStringSplit(String s) {
        Deque<String> deque = new ArrayDeque<>();
        int balance = 0;
        int count = 0;
        for (char c : s.toCharArray()) {
            deque.addLast(String.valueOf(c));
            if (c == 'R') {
                balance--;
            } else if (c == 'L') {
                balance++;
            }
            if (balance == 0) {
                deque.removeAll(deque);
                count++;
            }
        }
        return count;

    }


    public static void main(String[] args) {
        String s = "RLRRRLLRLL";
        System.out.println(balancedStringSplit(s));
    }
}
