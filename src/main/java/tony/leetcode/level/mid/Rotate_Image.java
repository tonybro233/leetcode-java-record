package tony.leetcode.level.mid;

// 48. 旋转图像
// 给定一个 n × n 的二维矩阵表示一个图像。
//
// 将图像顺时针旋转 90 度。
//
// 说明：
// 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
//
// 示例 1:
// 给定 matrix =
// [
//   [1,2,3],
//   [4,5,6],
//   [7,8,9]
// ],
//
// 原地旋转输入矩阵，使其变为:
// [
//   [7,4,1],
//   [8,5,2],
//   [9,6,3]
// ]

// 示例 2:
// 给定 matrix =
// [
//   [ 5, 1, 9,11],
//   [ 2, 4, 8,10],
//   [13, 3, 6, 7],
//   [15,14,12,16]
// ],
//
// 原地旋转输入矩阵，使其变为:
// [
//   [15,13, 2, 5],
//   [14, 3, 4, 1],
//   [12, 6, 8, 9],
//   [16, 7,10,11]
// ]

public class Rotate_Image {

    public void rotate3(int[][] matrix) {
        if (null == matrix || matrix.length == 0) {
            return;
        }
        // 每一圈做旋转
        int len = matrix.length;
        for (int i = 0; i < len / 2; i++) {
            // 按照每圈第一行来循环(排除最后一个点)
            int limit = len - i - 1;
            for (int j = i; j < limit; j++) {
                int v1 = matrix[i][j];
                int v2 = matrix[j][len - 1 - i];
                int v3 = matrix[len - 1 - i][len - 1 - j];
                int v4 = matrix[len - 1 - j][i];

                matrix[i][j] = v4;
                matrix[j][len - 1 - i] = v1;
                matrix[len - 1 - i][len - 1 - j] = v2;
                matrix[len - 1 -j][i] = v3;
            }
        }
    }

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // (x, y) -> (n - x, y) -> (y, n - x)
        // 先上下翻转，再按对角线(左上到右下)翻转
        // 或者也可以 先对角线(左上到右下)翻转 再左右翻转
        for (int i = 0; i < n/2; i++){
            for (int j = 0; j < n;j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n-i-1][j];
                matrix[n-i-1][j] = tmp;
            }
        }
        for (int i = 0; i < n;i++){
            for (int j = i+1; j < n;j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }

    // 按圈旋转
    public void rotate2(int[][] m) {
        int i=0,j = m.length-1;
        while(i<j){
            process(m,i++,j--);
        }
    }
    private void process(int[][] m,int i,int j){
        if(i<j){
            // i , j-k, i+k, j
            for(int k=0;k<j-i;k++){
                int tmp   = m[i][i+k];
                m[i][i+k] = m[j-k][i]; // 左下 换到 左上
                m[j-k][i] = m[j][j-k]; // 右下 换到 左下
                m[j][j-k] = m[i+k][j]; // 右上 换到 右下
                m[i+k][j] = tmp;       // 左上 换到 右上
            }
        }
    }


    public static void main(String[] args){
        new Rotate_Image().rotate3(new int[][]{new int[]{1,2,3},new int[]{4,5,6}, new int[]{7,8,9}});
    }
}
