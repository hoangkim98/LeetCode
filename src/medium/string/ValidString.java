package medium.string;


public class ValidString {
    public static boolean isValid(String s) {
        StringBuilder sb = new StringBuilder();
        if (s.length() % "abc".length() != 0
                || s.charAt(0) != 'a'
                || s.charAt(s.length() - 1) != 'c') {
            return false;
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; ) {
            char aChar = chars[i];
            if (i + 3 < s.length()
                    && s.substring(i, i + 3).equalsIgnoreCase("abc")) {
                i = i + 3;
            } else if (aChar == 'a') {
                sb.append("a");
                i++;
            } else if (aChar == 'b' && sb.length() > 0) {
                if ("a".equalsIgnoreCase(String.valueOf(sb.toString().toCharArray()[sb.length() - 1]))) {
                    sb.append("b");
                    i++;
                } else {
                    return false;
                }
            } else if (aChar == 'c' && sb.length() > 0) {
                if ("b".equalsIgnoreCase(String.valueOf(sb.toString().toCharArray()[sb.length() - 1]))) {
                    sb.deleteCharAt(sb.length() - 1);
                    if ("a".equalsIgnoreCase(String.valueOf(sb.toString().toCharArray()[sb.length() - 1]))) {
                        sb.deleteCharAt(sb.length() - 1);
                        i++;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                i++;
            }
        }
        return sb.length() == 0;
    }

    public static void main(String[] args) {
        System.out.println(isValid("aaababccbcbc"));
    }
}
