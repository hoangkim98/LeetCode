package company.kbtg;


import java.util.HashSet;
import java.util.Set;

public class Ques3 {
    private final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int solution(String[] R) {
        int rows = R.length;
        int cols = R[0].length();

        Set<Integer>[][] visited = new Set[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                visited[row][col] = new HashSet<>();
            }
        }

        int count = 0;
        int row = 0, col = 0, dir = 0;

        while (!visited[row][col].contains(dir)) {

            if (visited[row][col].isEmpty()) {
                count++;
            }

            visited[row][col].add(dir);

            int newRow = DIRECTIONS[dir][0] + row;
            int newCol = DIRECTIONS[dir][1] + col;

            if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && R[newRow].charAt(newCol) == '.') {
                row = newRow;
                col = newCol;
            } else {
                dir = (dir + 1) % 4;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        Ques3 ques3 = new Ques3();
        String[] test = new String[]{"...X..", "....XX", "..X..."};
        System.out.println(ques3.solution(test));
    }
}