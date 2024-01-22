package company.naver.secondTry;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;


class Result3 {

    /*
     * Complete the 'getMessageStatus' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY timestamps
     *  2. STRING_ARRAY messages
     *  3. INTEGER k
     */

    public static List<String> getMessageStatus(List<Integer> timestamps, List<String> messages, int k) {
        // Write your code here
        List<String> arrivedStatus = new ArrayList<>();
        Map<String, List<Integer>> messageArrivedMap = new HashMap<>();
        for (int i = 0; i < messages.size(); i++) {
            if (messageArrivedMap.containsKey(messages.get(i))) {
                List<Integer> arrivedTime = messageArrivedMap.get(messages.get(i));
                boolean isArrived = timestamps.get(i) > arrivedTime.get(arrivedTime.size() - 1) + k;
                arrivedStatus.add(isArrived ? "true" : "false");
                arrivedTime.add(timestamps.get(i));
                continue;
            }
            List<Integer> arrivedTime = new ArrayList<>();
            arrivedTime.add(timestamps.get(i));
            messageArrivedMap.put(messages.get(i), arrivedTime);
            arrivedStatus.add("true");
        }

        return arrivedStatus;
    }

}

public class Solution3 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int timestampsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> timestamps = IntStream.range(0, timestampsCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int messagesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> messages = IntStream.range(0, messagesCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> result = Result3.getMessageStatus(timestamps, messages, k);

        bufferedWriter.write(
                result.stream()
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
