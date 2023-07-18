package company.naver;

import java.io.*;

import static java.util.stream.Collectors.joining;


class Result2 {

    /*
     * Complete the 'maxXor' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER lo
     *  2. INTEGER hi
     *  3. INTEGER k
     */

    public static int maxXor(int lo, int hi, int k) {
        int max = 0;
        for (int i = lo; i < hi; i++) {
            for (int j = i + 1; j <= hi; j++) {
                int temp = i ^ j;
                if(temp >= max && temp <=k){
                    max = temp;
                }
            }
        }
        return max;
    }

}

public class Solution2 {
    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int lo = Integer.parseInt(bufferedReader.readLine().trim());
//
//        int hi = Integer.parseInt(bufferedReader.readLine().trim());
//
//        int k = Integer.parseInt(bufferedReader.readLine().trim());
//
//        int result = Result.maxXor(lo, hi, k);
//
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
        System.out.println(Result2.maxXor(1,3 ,3));
        System.out.println(Result2.maxXor(2, 4, 8));
        System.out.println(Result2.maxXor(11, 61, 32));
    }
}
