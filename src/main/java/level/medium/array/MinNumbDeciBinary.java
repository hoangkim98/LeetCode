package level.medium.array;

/*
https://leetcode.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers/description/
 */

public class MinNumbDeciBinary {

    public static int minPartitions(String n) {
        int max = 0;
        for (int i = 0; i < n.length(); i++) {
             max = Math.max(max,  Integer.parseInt(String.valueOf(n.charAt(i))));
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(minPartitions("32"));
    }
}
