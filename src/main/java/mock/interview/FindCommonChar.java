package mock.interview;

/*
Given a string array words, return an array of all characters that show up in all strings within the words (including duplicates). You may return the answer in any order.


Example 1:

Input: words = ["bella","label","roller"]
Output: ["e","l","l"]
Example 2:

Input: words = ["cool","lock","cook"]
Output: ["c","o"]
 */

import java.util.*;

public class FindCommonChar {
    public static List<String> commonChars(String[] words) {
        Map<String, Integer> commonMap = new HashMap<>();
        List<String> blackList = new ArrayList<>();

        for (String word : words) {
            Iterator<Map.Entry<String, Integer>> iter = commonMap.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry<String, Integer> entry = iter.next();
                if (!word.contains(entry.getKey())) {
                    iter.remove();
                    blackList.add(entry.getKey());
                }
            }

            for (char c : word.toCharArray()) {
                String s = String.valueOf(c);
                if (!blackList.contains(s)) {
                    commonMap.merge(s, 1, Integer::sum);
                }
            }
        }

        Iterator<Map.Entry<String, Integer>> iter = commonMap.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<String, Integer> entry = iter.next();
            if (!words[0].contains(entry.getKey())) {
                iter.remove();
                blackList.add(entry.getKey());
            }
        }

        List<String> res = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : commonMap.entrySet()) {
            if (entry.getValue() >= words.length) {
                for (int i = 0; i < entry.getValue() / words.length; i++) {
                    res.add(entry.getKey());
                }
            }
        }

        return res;
    }


    public static void main(String[] args) {
        String[] words = new String[]{"bbddabab", "cbcddbdd", "bbcadcab", "dabcacad", "cddcacbc", "ccbdbcba", "cbddaccc", "accdcdbb"};
        List<String> res = commonChars(words);
        for (String s : res) {
            System.out.print(s);
        }
    }
}
