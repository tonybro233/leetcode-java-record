package tony.leetcode.feature.math;

// 419. 甲板上的战舰
// 给定一个二维的甲板， 请计算其中有多少艘战舰。 战舰用 'X'表示，空位用 '.'表示。

// 你需要遵守以下规则：
// 给你一个有效的甲板，仅由战舰或者空位组成。
// 战舰只能水平或者垂直放置。换句话说,战舰只能由 1xN (1 行, N 列)组成，或者 Nx1 (N 行, 1 列)组成，其中N可以是任意大小。
// 两艘战舰之间至少有一个水平或垂直的空位分隔 - 即没有相邻的战舰。

// 示例 :\
// X..X
// ...X
// ...X
// 在上面的甲板中有2艘战舰。
//
// 无效样例 :\
// ...X
// XXXX
// ...X
// 你不会收到这样的无效甲板 - 因为战舰之间至少会有一个空位将它们分开。
//
// 进阶:
// 你可以用一次扫描算法，只使用O(1)额外空间，并且不修改甲板的值来解决这个问题吗？

public class Battleships_in_a_Board {

    public int countBattleships2(char[][] board) {
        if (board==null || board.length==0 || board[0].length==0) {
            return 0;
        }
        int count = 0;
        for (int i=0;i < board.length;i++){
            for (int j=0;j < board[0].length;j++){
                if (board[i][j] == '.') {
                    continue;
                }
                // 左上没有即为战舰开头
                if (i>0 && board[i-1][j]=='X') {
                    continue;
                }
                if (j>0 && board[i][j-1]=='X') {
                    continue;
                }
                count++;
            }
        }
        return count;
    }

    public int countBattleships(char[][] board) {
        int result = 0;
        if (null == board || board[0].length == 0){
            return result;
        }
        int row = board.length;
        int col = board[0].length;

        boolean[][] record = new boolean[row][col];
        for (int i = 0;i < row; i++){
            for (int j = 0; j < col;j++){
                if (expand(board, record, i,j,null)){
                    result++;
                }
            }
        }

        return result;
    }

    private boolean expand(char[][] board, boolean[][] record, int x, int y, String dir){
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || record[x][y] || '.' == board[x][y]){
            return false;
        }
        record[x][y] = true;
        if (null == dir){
            expand(board, record, x-1, y, "-x");
            expand(board, record, x+1, y, "+x");
            expand(board, record, x, y-1, "-y");
            expand(board, record, x, y+1, "+y");
        } else if ("-x".equals(dir)){
            expand(board, record, x-1, y, "-x");
        } else if ("+x".equals(dir)){
            expand(board, record, x+1, y, "+x");
        } else if ("-y".equals(dir)){
            expand(board, record, x, y-1, "-y");
        } else {
            expand(board, record, x, y+1, "+y");
        }

        return true;
    }
}
