package tony.leetcode.feature.dynamic_program;

// 62
// 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
// 问总共有多少条不同的路径？
// m,n 值均不超过100

public class Unique_Paths {


    public int uniquePaths(int m, int n) {
        // D(m,n) = D(m,n-1)+D(m-1,n)

        if (m == 0){
            return n;
        }
        if (n == 0){
            return m;
        }
        int[][] record = new int[n][m];
        record[0][0] = 1;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m ;j++){
                if (j == 0 && i == 0){
                    continue;
                }
                int v1,v2;
                if (i == 0){
                    v1 = 0;
                } else {
                    v1 = record[i-1][j];
                }
                if (j == 0){
                    v2 = 0;
                } else {
                    v2 = record[i][j-1];
                }
                record[i][j] = v1+v2;
            }
        }

        return record[n-1][m-1];
    }

    public static void main(String[] args){
        Unique_Paths go = new Unique_Paths();
        int re = go.uniquePaths(3,2);
        System.out.println(re);
    }
}
