package company.nab.secondTry;

public class Ques3 {

    public static String solution(int AA, int AB, int BB) {
        // Implement your solution here
        StringBuilder sb = new StringBuilder();
        if (AA == 0 && BB == 0) {
            sb.append("AB".repeat(AB));
        } else if (AA == 0 && BB > 0) {
            sb.append("BB");
            sb.append("AB".repeat(AB));
        } else if (BB == 0 && AA > 0) {
            sb.append("AB".repeat(AB));
            sb.append("AA");
        } else if (AA > BB) {
            sb.append("AA");
            for (int i = 0; i < BB; i++) {
                sb.append("BB");
                sb.append("AB".repeat(AB));
                sb.append("AA");
            }
        } else if (BB > AA) {
            sb.append("BB");
            sb.append("AB".repeat(AB));
            for (int i = 0; i < AA; i++) {
                sb.append("AA");
                sb.append("BB");
            }
        } else {
            sb.append("AABB".repeat(AA));
            sb.append("AB".repeat(AB));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println((solution(10, 0, 1)));
        System.out.println((solution(1, 0, 3)));
        System.out.println((solution(3, 5, 3)));

    }
}
