package tony.leetcode.feature.array;

// 59
// 给定一个正整数 n，生成一个包含 1 到 n平方 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
//
// 示例:
//
// 输入: 3
// 输出:
// [
//  [ 1, 2, 3 ],
//  [ 8, 9, 4 ],
//  [ 7, 6, 5 ]
// ]
public class Spiral_Matrix_II {

    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        boolean right = true, down = false, left = false, up = false;
        int x = 0, y = 0;
        for (int i = 1; i <= n*n;i++){
            result[x][y] = i;
            if (right){
                if (y+1 == n || result[x][y+1] != 0){
                    right = false;
                    down = true;
                    x++;
                } else {
                    y++;
                }
                // 不能漏这个continue
                continue;
            }
            if (down){
                if (x+1 == n || result[x+1][y] != 0){
                    down = false;
                    left = true;
                    y--;
                } else {
                    x++;
                }
                continue;
            }
            if (left){
                if (y == 0 || result[x][y-1] != 0){
                    left = false;
                    up = true;
                    x--;
                } else {
                    y--;
                }
                continue;
            }
            if (up){
                if (x == 0 || result[x-1][y] != 0){
                    up = false;
                    right = true;
                    y++;
                }else {
                    x--;
                }
            }
        }

        return result;
    }

    public static void main(String[] args){
        new Spiral_Matrix_II().generateMatrix(3);
    }
}
