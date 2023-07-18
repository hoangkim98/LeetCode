package company.naver;

import java.io.*;
import java.util.*;
import java.util.regex.*;

import static java.util.stream.Collectors.joining;

import java.net.*;

import org.json.simple.*;
import org.json.simple.parser.*;
import org.json.simple.parser.ParseException;

class Result1 {

    /*
     * Complete the 'showsInProduction' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER startYear
     *  2. INTEGER endYear
     *
     * Base url: https://jsonmock.hackerrank.com/api/tvseries
     */

    public static List<String> showsInProduction(int startYear, int endYear) {
        // Write your code here
        JSONParser parser = new JSONParser();
        List<String> res = new ArrayList<>();
        try {
            for (int pageNum = 1; pageNum <= 20; pageNum++) {
                JSONObject json = (JSONObject) parser.parse(getHTTPRes(pageNum));
                JSONArray data = (JSONArray) json.get("data");

                for (Object datum : data) {
                    JSONObject element = (JSONObject) datum;
                    String time = (String) element.get("runtime_of_series");
                    String name = (String) element.get("name");

                    String pattern = "\\d{4}";

                    Pattern regexPattern = Pattern.compile(pattern);
                    Matcher matcher = regexPattern.matcher(time);

                    List<Integer> lst = new ArrayList<>();
                    while (matcher.find()) {
                        String year = matcher.group();
                        lst.add(Integer.valueOf(year));
                    }

                    if (lst.size() == 1) {
                        if (!time.contains("-")) {
                            lst.add(lst.get(0));
                        } else {
                            lst.add(Integer.MAX_VALUE);
                        }
                    }

                    if (endYear == -1 && lst.get(0) >= startYear && time.contains("-") && lst.get(1) == Integer.MAX_VALUE) {
                        res.add(name + "-" + lst.get(0) + "-" + lst.get(1));
//                        res.add(name);
                    } else {
                        if (lst.get(0) >= startYear && lst.get(1) <= endYear) {
                            res.add(name + "-" + lst.get(0) + "-" + lst.get(1));
//                            res.add(name);
                        }
                    }
                }
            }
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Collections.sort(res);
        return res;
    }

    public static String getHTTPRes(int pageNum) {
        StringBuilder res = new StringBuilder();
        try {
            URL yahoo = new URL("https://jsonmock.hackerrank.com/api/tvseries?page=" + pageNum);
            URLConnection yc = yahoo.openConnection();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            yc.getInputStream()));
            String inputLine;


            while ((inputLine = in.readLine()) != null) {
                res.append(inputLine);
            }
            in.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return res.toString();
    }

}

public class Solution3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int startYear = Integer.parseInt(bufferedReader.readLine().trim());

        int endYear = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> result = Result1.showsInProduction(startYear, endYear);

        bufferedWriter.write(
                result.stream()
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
