package company.axon;

import java.util.Stack;


public class Ques1 {
    public static String angle(String angles) {
        int countL = 0;
        Stack<Character> stack = new Stack<>();
        char[] str = angles.toCharArray();
        for (int i = 0; i < str.length; i++) {
            if (stack.empty() && str[i] == '>') {
                countL++;
            } else if (str[i] == '<') {
                stack.push('<');
            } else if (str[i] == '>') {
                stack.pop();
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < countL; i++) {
            res.append('<');
        }
        res.append(angles);
        for (int i = 0; i < stack.size(); i++) {
            res.append('>');
        }
        return res.toString();
    }


    public static void main(String[] args) {
        System.out.println(angle("><<><"));
    }

}
