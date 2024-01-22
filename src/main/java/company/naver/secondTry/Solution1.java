package company.naver.secondTry;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;


class Result1 {

    /*
     * Complete the 'getMinimumSize' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING_ARRAY requests
     *  2. INTEGER k
     */

    public static int getMinimumSize(List<String> requests, int k) {
        final int initCacheCapacity = k + 1;
        Map<String, String> cache = new LinkedHashMap<>(initCacheCapacity, .75F, true) {

            @Override
            public boolean removeEldestEntry(Map.Entry eldest) {
                return size() > initCacheCapacity;
            }
        };

        for (String str : requests) {
            if (cache.containsKey(str)) {
                return cache.size();
            }
            cache.put(str, str);
        }
        return -1;
    }

}

public class Solution1 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int requestsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> requests = IntStream.range(0, requestsCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result1.getMinimumSize(requests, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
