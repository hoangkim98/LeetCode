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
            JSONObject json = (JSONObject) parser.parse(getHTTPRes());
            JSONArray data = (JSONArray) json.get("data");
            
            for (int i = 0; i <data.size(); i++) {
                JSONObject element = (JSONObject) data.get(i);
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
                if(lst.get(0) >= startYear && (lst.size() < 2 || lst.get(1)<= endYear)){
                    res.add(name);
                }
            }
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        Collections.sort(res);
        return res;
    }

    public static String getHTTPRes() {
        StringBuilder res = new StringBuilder();
        try {
            URL yahoo = new URL("https://jsonmock.hackerrank.com/api/tvseries");
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
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

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
