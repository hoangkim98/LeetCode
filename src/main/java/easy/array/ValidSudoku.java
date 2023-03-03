package easy.array;

import java.util.HashMap;
import java.util.Map;


public class ValidSudoku {
    public static boolean isValidSudoku(char[][] board) {
        // Check each row has dup
        for(int row =0;row<board.length;row++){
            Map<String, Boolean> rowMap = new HashMap<>();
            for(int col=0;col<board[row].length;col++){
                if(board[row][col] != '.'){
                    String str = String.valueOf(board[row][col]);
                    if(rowMap.containsKey(str)){
                        return false;
                    }else{
                        rowMap.put(str, true);
                    }
                }
            }
        }
        // Check each col has dup
        for(int col =0;col<board.length;col++){
            Map<String, Boolean> colMap = new HashMap<>();
            for(int row=0;row<board.length;row++){
                if(board[row][col] != '.'){
                    String str = String.valueOf(board[row][col]);
                    if(colMap.containsKey(str)){
                        return false;
                    }else{
                        colMap.put(str, true);
                    }
                }
            }
        }
        // Check each sub box has dup
        for(int row =0;row<board.length;row++){
            Map<String, Boolean> subBoxMap = new HashMap<>();
            for(int col=0;col<board[row].length;col++){
              if(row <= 3 && col <=3){

              }else{

              }
            }
        }
        return true;
    }


    public static char[] copyTo1DArray(char[][] board){
        char[] newBoard = new char[81];
        int idx = 0;
        for(int row =0;row<board.length;row++){
            for(int col=0;col<board[row].length;col++){
                newBoard[idx] = board[row][col];
                idx++;
            }
        }
        return newBoard;
    }

    public static boolean isValidSudoku1(char[][] board) {
        char[] newArr = copyTo1DArray(board);
        Map<String, Boolean> rowMap = new HashMap<>();
      return true;
    }

    public static void main(String[] args) {
        char[][] board = {{'8', '3', '.', '.', '7', '.', '.', '.', '.'}
                        , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                        , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                        , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                        , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                        , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                        , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                        , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                        , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        System.out.println(isValidSudoku(board));
    }
}
