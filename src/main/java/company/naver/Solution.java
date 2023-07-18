package company.naver;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'getServerIndex' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY arrival
     *  3. INTEGER_ARRAY burstTime
     */

    public static List<Integer> getServerIndex(int n, List<Integer> arrival, List<Integer> burstTime) {
        // Write your code here
        Map<Integer, Integer> map = new TreeMap<>();
        Map<Integer, Integer> tempMap = new TreeMap<>();
        for(int i = 0;i<arrival.size();i++){
            map.put(arrival.get(i), burstTime.get(i));
            tempMap.put(arrival.get(i), i);
        }
        List<Integer> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for(int i = 0;i < arrival.size();i++){
            temp.add(0);
        }

        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            int sum = entry.getKey() + entry.getValue();
            for(int j = 0 ; j < arrival.size(); j++){
                if(entry.getKey() > temp.get(j)){
                    temp.set(j, sum);
                    res.add(tempMap.get(j));
                    break;
                }
            }
        }
        return res;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int arrivalCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arrival = IntStream.range(0, arrivalCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int burstTimeCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> burstTime = IntStream.range(0, burstTimeCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.getServerIndex(n, arrival, burstTime);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
