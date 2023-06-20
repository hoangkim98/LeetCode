package company.kbtg;

import java.util.HashMap;
import java.util.Map;


public class Ques1 {
    public static int solution(String S) {
        // Implement your solution here
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            String str = String.valueOf(S.charAt(i));
            Integer count = map.getOrDefault(str, 0);
            map.put(str, count + 1);
        }

        Integer bCount = map.getOrDefault("B", 0);
        Integer aCount = map.getOrDefault("A", 0);
        Integer nCount = map.getOrDefault("N", 0);
        return Math.min(nCount / 2, Math.min(bCount, aCount / 3));


//        int count = 0;
//        boolean aCheck = map.getOrDefault("A", 0);
//        boolean nCheck = map.getOrDefault("N", 0);
//        while (true) {
//            boolean bCheck = map.getOrDefault("B", 0) < 1;
//            boolean aCheck = map.getOrDefault("A", 0) < 3;
//            boolean nCheck = map.getOrDefault("N", 0) < 2;
//            if (aCheck || bCheck || nCheck) {
//                break;
//            } else {
//                count++;
//                map.put("B", map.get("B") - 1);
//                map.put("A", map.get("A") - 3);
//                map.put("N", map.get("N") - 2);
//            }
//        }
//        return count;
    }

    public static void main(String[] args) {
        System.out.println(solution("CCCCANANNA"));
        System.out.println(solution("BXANBYANAAN"));
        System.out.println(solution("BAANBNBNXNB"));
        System.out.println(solution("BACDNNNNNNXYAZTAMBAAZAATBAXYAZ"));
        System.out.println(solution("BBBNNNNNNAAAAAAAAA"));
        System.out.println(solution("XYZBTAYNTAABGNNAYNZAYAZ"));
    }
}