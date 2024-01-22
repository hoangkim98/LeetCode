package company.naver.secondTry;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Result2 {

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

    public static List<String> topArticles(int limit) {
        // Write your code here
        JSONParser parser = new JSONParser();
        List<JSONObject> jsonValues = new ArrayList<>();

        try {
            JSONObject test = (JSONObject) parser.parse(getHTTPRes(0));
            Long totalPages = (Long) test.get("total_pages");

            for (int pageNum = 1; pageNum <= totalPages; pageNum++) {
                JSONObject json = (JSONObject) parser.parse(getHTTPRes(pageNum));
                JSONArray data = (JSONArray) json.get("data");
                for (Object datum : data) {
                    jsonValues.add((JSONObject) datum);
                }
            }
            jsonValues.removeIf(json -> null == json.get("title") && null == json.get("story_title"));

            Comparator<JSONObject> compareComment = new Comparator<>() {

                private static final String KEY_NAME = "num_comments";

                @Override
                public int compare(JSONObject a, JSONObject b) {
                    Long valA = (Long) a.get(KEY_NAME);
                    Long valB = (Long) b.get(KEY_NAME);

                    if (valA == null) {
                        valA = Long.valueOf("0");
                    }
                    if (valB == null) {
                        valB = Long.valueOf("0");
                    }
                    return valB.compareTo(valA);
                }
            };

            Comparator<JSONObject> compareArtName = new Comparator<>() {

                private static final String TITLE = "title";

                private static final String STORY_TITLE = "story_title";

                @Override
                public int compare(JSONObject a, JSONObject b) {
                    String valA = new String();
                    String valB = new String();
                    valA = (String) a.get(TITLE);
                    valB = (String) b.get(TITLE);
                    if (valA == null) {
                        valA = (String) a.get(STORY_TITLE);
                    }
                    if (valB == null) {
                        valB = (String) b.get(STORY_TITLE);
                    }
                    return valB.compareTo(valA);
                }
            };

            jsonValues.sort(compareComment.thenComparing(compareArtName));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        List<String> res = jsonValues.stream().map(json -> {
            if (null != json.get("title")) {
                return (String) json.get("title");
            } else {
                return (String) json.get("story_title");
            }
        }).collect(Collectors.toList());
        return res.subList(0, limit);
    }

    public static String getHTTPRes(int pageNum) {
        StringBuilder res = new StringBuilder();
        try {
            URL yahoo = new URL("https://jsonmock.hackerrank.com/api/articles?page=" + pageNum);
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

public class Solution2 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int limit = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> result = Result2.topArticles(limit);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(result.get(i));

            if (i != result.size() - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
