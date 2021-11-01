package Algorithm.Primary;

import java.util.HashSet;
import java.util.ServiceConfigurationError;
import java.util.Set;

public class IsValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        Set line = new HashSet();
        Set column = new HashSet();
        Set box = new HashSet();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                //line
                if (!line.add(board[i][j])&&board[i][j]!='.'){
                    return false;
                }
                //column
                if (!column.add(board[j][i])&&board[j][i]!='.'){
                    return false;
                }
                //box

            }
            line.clear();
            column.clear();
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board =
                {{'5','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}};
        System.out.println(new IsValidSudoku().isValidSudoku(board));
        System.out.println(4%3);
    }
}
