package Algorithm;

public class CountBattleships {
    /**
     * 419. 甲板上的战舰
     * 思路 : 如果当前位置为 'X' 、且上方和左方都为 '.' 、则可以确定此处为战舰的头 、则 res+1
     *       需要注意如果在最上面和最左面需要排除判断。
     */
    public static int countBattleships(char[][] board) {
        int c = board[0].length;//列
        int l = board.length;//行
        int res = 0;
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j]=='X'){
                    if (i!=0&&j!=0){//普通情况、上左都看
                        res += board[i-1][j]=='.'&&board[i][j-1]=='.'?1:0;
                    }else if (i==0&&j!=0){//在最上面、上不看
                        res += board[i][j-1]=='.'?1:0;
                    }else if (i!=0&&j==0){//在最左边、左不看
                        res += board[i-1][j]=='.'?1:0;
                    }else {//i==0&&j==0//在左上角、上左都不看
                        res++;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        char[][] board = {{'X','.','.','X'},{'.','.','.','X'},{'.','.','.','X'}};
        System.out.println(countBattleships(board));
    }
}
