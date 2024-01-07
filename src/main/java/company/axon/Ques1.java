package company.axon;

import java.util.Stack;


public class Ques1 {

    public static String angle(String angles) {
        int countL = 0;
        Stack<Character> stack = new Stack<>();
        char[] str = angles.toCharArray();
        for (char c : str) {
            if (stack.empty() && c == '>') {
                countL++;
            } else if (c == '<') {
                stack.push('<');
            } else if (c == '>') {
                stack.pop();
            }
        }
        return "<".repeat(Math.max(0, countL)) +
                angles +
                ">".repeat(stack.size());
    }


    public static void main(String[] args) {
        System.out.println(angle("><<><"));
    }

}
