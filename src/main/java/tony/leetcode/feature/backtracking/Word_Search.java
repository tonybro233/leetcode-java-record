package tony.leetcode.feature.backtracking;

// 79. 单词搜索
// 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
// 同一个单元格内的字母不允许被重复使用。
//
// 示例:
// board =
// [
//   ['A','B','C','E'],
//   ['S','F','C','S'],
//   ['A','D','E','E']
// ]
// 给定 word = "ABCCED", 返回 true.
// 给定 word = "SEE", 返回 true.
// 给定 word = "ABCB", 返回 false.

public class Word_Search {

    public boolean exist(char[][] board, String word) {
        int row = board.length;
        if (row == 0){
            return false;
        }
        int col = board[0].length;
        if (col == 0){
            return false;
        }
        char[] chars = word.toCharArray();
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (check(board, new boolean[row][col], i, j, chars, 0)){
                    return true;
                }
            }
        }

        return false;
    }

    private boolean check(char[][] board, boolean[][] mark, int i, int j, char[] chars, int pos){
        if (pos == chars.length){
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length){
            return false;
        }
        if (mark[i][j] || chars[pos] != board[i][j]){
            return false;
        }
        // 也可以不使用标记，临时替换掉board[i][j]
        mark[i][j] = true;
        boolean result = check(board, mark, i+1, j, chars, pos+1) ||
                check(board, mark, i-1, j, chars, pos+1) ||
                check(board, mark, i, j+1, chars, pos+1) ||
                check(board, mark, i, j-1, chars, pos+1);
        mark[i][j] = false;
        return result;
    }
}
