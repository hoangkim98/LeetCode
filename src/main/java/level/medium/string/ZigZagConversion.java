package level.medium.string;

/*
https://leetcode.com/problems/zigzag-conversion/
 */

public class ZigZagConversion {

    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < numRows; row++) {
            for (int i = row; i < s.length(); i += (numRows - 1) * 2) {
                sb.append(s.charAt(i));
                if (row > 0 && row < numRows - 1 && i + (numRows - 1) * 2 - 2 * row < s.length()) {
                    sb.append(s.charAt(i + (numRows - 1) * 2 - 2 * row));
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 4));
    }
}
