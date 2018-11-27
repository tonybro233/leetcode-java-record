package tony.leetcode.feature.recursive_search;

// 130 被围绕的区域
// 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
// 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
//
// 示例:
// X X X X
// X O O X
// X X O X
// X O X X

// 运行你的函数后，矩阵变为：
// X X X X
// X X X X
// X X X X
// X O X X

// 解释:
// 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。
// 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。
// 如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。

public class Surrounded_Regions {

    public void solve(char[][] board) {
        if (board.length == 0){
            return;
        }
        int row = board.length;
        int col = board[0].length;
        // 使用一个与入参大小相同的二维数组做查询记录
        boolean[][] record = new boolean[board.length][board[0].length];
        // 只有与边界相通的'O'才不会被覆盖，那么直接从4条边上的'O'进行扩散查询相邻
        for (int i = 0; i < col;i++){
            expand(board, record, 0, i);
            expand(board, record, row-1,i);
        }
        for (int i = 1; i < row-1;i++){
            expand(board, record, i, 0);
            expand(board, record, i, col-1);
        }
        // 根据记录覆盖没有连通到边界的'O'
        for (int i = 0; i < row;i++){
            for (int j = 0;j < col;j++){
                if (board[i][j] == 'O' && !record[i][j]){
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void expand(char[][] board, boolean[][] record, int r, int c){
        if (r < 0 || r >= board.length){
            return;
        }
        if (c < 0 || c >= board[0].length){
            return;
        }
        if (board[r][c] == 'X' || record[r][c]){
            return;
        }
        record[r][c] = true;
        expand(board, record, r-1, c);
        expand(board, record, r+1, c);
        expand(board, record, r, c-1);
        expand(board, record, r, c+1);
    }
}
