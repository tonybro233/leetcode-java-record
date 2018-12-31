package tony.leetcode.feature.array;

// 73
// 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
// 示例 2:
//
// 输入:
// [
//   [0,1,2,0],
//   [3,4,5,2],
//   [1,3,1,5]
// ]
// 输出:
// [
//   [0,0,0,0],
//   [0,4,5,0],
//   [0,3,1,0]
// ]

// 进阶:
// 一个直接的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
// 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
// 你能想出一个常数空间的解决方案吗？

public class Set_Matrix_Zeroes {

    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        // 为了不使用额外的空间
        // 先计算第一行和第一列是否需要清零，但是先不进行清零
        boolean rowzero = false, colzero = false;
        for (int i = 0; i < m;i++){
            if (matrix[i][0] == 0){
                colzero = true;
            }
        }
        for (int i = 0; i < n;i++){
            if (matrix[0][i] == 0){
                rowzero = true;
            }
        }
        // 使用第一行和第一列标记行列是否需要清零
        for (int i = 1; i < m; i++){
            for (int j = 1;j < n;j++){
                if (matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        // 对第一行第一列之外的内容执行清零
        for (int i = 1; i < m; i++){
            if (matrix[i][0] == 0){
                for (int j = 1; j < n;j++ ){
                    matrix[i][j] = 0;
                }
            }
        }
        for (int j = 1; j < n; j++){
            if (matrix[0][j] == 0){
                for (int i = 1; i < m;i++ ){
                    matrix[i][j] = 0;
                }
            }
        }
        // 对第一行和第一列执行清零
        if (rowzero){
            for (int i = 0; i < n;i++){
                matrix[0][i] = 0;
            }
        }
        if (colzero){
            for (int i = 0; i < m;i++){
                matrix[i][0] = 0;
            }
        }
    }
}
