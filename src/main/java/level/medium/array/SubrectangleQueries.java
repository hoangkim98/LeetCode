package level.medium.array;

/*
https://leetcode.com/problems/subrectangle-queries/
 */

class SubrectangleQueries {
    public int[][] rectangle;
    public int rowLength;
    public int colLength;

    public SubrectangleQueries(int[][] rectangle) {
        this.rectangle = rectangle;
        rowLength = rectangle.length;
        colLength = rectangle[0].length;
    }

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        for (int i = row1; i < rowLength; i++) {
            for (int j = col1; j < colLength; j++) {
                if (i <= row2 && j <= col2) {
                    rectangle[i][j] = newValue;
                }
            }
        }
    }

    public int getValue(int row, int col) {
        return rectangle[row][col];
    }


    public static void main(String[] args) {
        int[][] rec = new int[][]{
                {1, 2, 1},
                {4, 3, 4},
                {3, 2, 1},
                {1, 1, 1}
        };
        SubrectangleQueries query = new SubrectangleQueries(rec);
        System.out.println(query.getValue(0, 1));
        query.updateSubrectangle(0, 2, 1, 2, 10);
        System.out.println(query.getValue(0, 1));
        System.out.println(query.getValue(1, 2));
    }
}
