package Algorithm.Primary;

import java.util.HashSet;
import java.util.ServiceConfigurationError;
import java.util.Set;

public class IsValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        Set row = new HashSet();
        Set column = new HashSet();
        Set boxH = new HashSet(),boxM = new HashSet(),boxF = new HashSet();
        for (int i = 0; i < 9; i++) {
            if (i==3||i==6){
                boxH.clear();boxM.clear();boxF.clear();
            }
            for (int j = 0; j < 9; j++) {
                if (!row.add(board[i][j])&&board[i][j]!='.') {
                    return false;
                }
                if (!column.add(board[j][i])&&board[j][i]!='.') {
                    return false;
                }
                if (j<3&&!boxH.add(board[i][j])&&board[i][j]!='.') {
                    return false;
                }else if(j>5&&!boxF.add(board[i][j])&&board[i][j]!='.'){
                    return false;
                }else if (j>=3&&j<=5&&!boxM.add(board[i][j])&&board[i][j]!='.'){
                    return false;
                }

            }
            row.clear();
            column.clear();
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {{'.','.','.','3','.','.','.','1','.'},
                         {'.','.','.','.','.','7','.','.','.'},
                         {'.','.','.','.','.','.','.','.','.'},
                         {'.','.','.','.','.','8','2','7','.'},
                         {'1','.','.','.','.','.','.','.','.'},
                         {'.','.','.','5','.','.','.','.','.'},
                         {'2','.','.','.','8','.','.','.','7'},
                         {'7','.','.','.','.','.','.','.','.'},
                         {'.','.','.','.','.','.','.','.','.'}};
        System.out.println(new IsValidSudoku().isValidSudoku(board));
    }
}
