package level.medium.string;

/*
Axon
https://leetcode.com/problems/decode-string/description/
 */

import java.util.Stack;

public class DecodeString {

    public static String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            StringBuilder sbContent = new StringBuilder();
            StringBuilder sbLength = new StringBuilder();
            if (s.charAt(i) == ']') {
                // Pop content
                while (stack.peek() != '[') {
                    sbContent.append(stack.pop());
                }
                stack.pop(); // pop '['

                // Pop length
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    sbLength.append(stack.pop());
                }

                int length = Integer.parseInt(sbLength.reverse().toString());
                String content = sbContent.reverse().toString();
                for (int j = 0; j < length; j++) {
                    for (int k = 0; k < content.length(); k++) {
                        stack.push(content.charAt(k));
                    }
                }
            } else {
                stack.push(s.charAt(i));
            }
        }

        StringBuilder res = new StringBuilder();
        stack.forEach(res::append);
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(decodeString("3[a]2[bc]"));
        System.out.println(decodeString("3[a2[bc]]"));
        System.out.println(decodeString("2[abc]3[cd]ef"));
    }
}
