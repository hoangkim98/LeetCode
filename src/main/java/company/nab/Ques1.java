package company.nab;

import java.util.LinkedHashMap;
import java.util.Map;


public class Ques1 {

    public static String solution(String message, int K) {
        // write your code in Java SE 8
        if (K >= message.length() || message.isEmpty()) {
            return message;
        }
        String[] strArr = message.split(" ");
        Map<String, Integer> mapStr = new LinkedHashMap<>();
        for (String s : strArr) {
            mapStr.put(s, s.length());
        }

        int count = 0;
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<String, Integer> entry : mapStr.entrySet()) {
            if (entry.getValue() > K) {
                break;
            }
            if (count + entry.getValue() <= K) {
                count += entry.getValue() + 1;
                sb.append(entry.getKey());
                sb.append(" ");
            }
        }

        return sb.toString().replaceAll("\\s+$", "");
    }

    public static void main(String[] args) {
        String test = "abc xy";
        String res = solution(test, 2);
        System.out.println(res);

    }
}
