package tony.leetcode.feature.hash;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 36. 有效的数独
// 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
//
//   数字 1-9 在每一行只能出现一次。
//   数字 1-9 在每一列只能出现一次。
//   数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。

// 数独部分空格内已填入了数字，空白格用 '.' 表示。

public class Valid_Sudoku {

    public boolean isValidSudoku2(char[][] board) {
        Set<Character> rowSet = new HashSet<>();
        Set<Character> colSet = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (rowSet.contains(board[i][j])) {
                        return false;
                    } else {
                        rowSet.add(board[i][j]);
                    }
                }

                if (board[j][i] != '.'){
                    if (colSet.contains(board[j][i])) {
                        return false;
                    } else {
                        colSet.add(board[j][i]);
                    }
                }
            }
            rowSet.clear();
            colSet.clear();
        }

        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                for (int x = 0; x < 3; x++) {
                    for (int y = 0; y < 3; y++) {
                        if (board[i + x][j + y] == '.') {
                            continue;
                        }
                        if (rowSet.contains(board[i + x][j + y])) {
                            return false;
                        } else {
                            rowSet.add(board[i + x][j + y]);
                        }
                    }
                }
                rowSet.clear();
            }
        }
        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        int row = 9;
        int col = 9;
        Set[] rowSets = new Set[row];
        Set[] colSets = new Set[col];
        Set[] blockSets = new Set[9]; // 注意第三个条件
        for (int i = 0; i < row; i++){
            rowSets[i] = new HashSet();
        }
        for (int i = 0; i < col; i++){
            colSets[i] = new HashSet();
        }
        for (int i = 0; i < 9; i++){
            blockSets[i] = new HashSet();
        }

        for (int i = 0; i < row;i++){
            for (int j = 0;j < col;j++){
                if (board[i][j] == '.'){
                    continue;
                }
                char c = board[i][j];
                if (rowSets[i].contains(c) || colSets[j].contains(c)){
                    return false;
                } else {
                    rowSets[i].add(c);
                    colSets[j].add(c);
                }
                if (i < 3){
                    if (j < 3){
                        if (blockSets[0].contains(c)){
                            return false;
                        }
                        blockSets[0].add(c);
                    } else if (j < 6){
                        if (blockSets[1].contains(c)){
                            return false;
                        }
                        blockSets[1].add(c);
                    } else {
                        if (blockSets[2].contains(c)){
                            return false;
                        }
                        blockSets[2].add(c);
                    }
                } else if (i < 6){
                    if (j < 3){
                        if (blockSets[3].contains(c)){
                            return false;
                        }
                        blockSets[3].add(c);
                    } else if (j < 6){
                        if (blockSets[4].contains(c)){
                            return false;
                        }
                        blockSets[4].add(c);
                    } else {
                        if (blockSets[5].contains(c)){
                            return false;
                        }
                        blockSets[5].add(c);
                    }
                } else {
                    if (j < 3){
                        if (blockSets[6].contains(c)){
                            return false;
                        }
                        blockSets[6].add(c);
                    } else if (j < 6){
                        if (blockSets[7].contains(c)){
                            return false;
                        }
                        blockSets[7].add(c);
                    } else {
                        if (blockSets[8].contains(c)){
                            return false;
                        }
                        blockSets[8].add(c);
                    }
                }
            }
        }
        return true;
    }
}
