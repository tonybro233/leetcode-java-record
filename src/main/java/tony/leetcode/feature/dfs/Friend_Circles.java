package tony.leetcode.feature.dfs;

// 547
// 班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。
// 如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C 的朋友。所谓的朋友圈，是指所有朋友的集合。

// 给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。
// 如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。
// 你必须输出所有学生中的已知的朋友圈总数。

// 输入:
// [[1,1,0],
//  [1,1,0],
//  [0,0,1]]
// 输出: 2
// 说明：已知学生0和学生1互为朋友，他们在一个朋友圈。
// 第2个学生自己在一个朋友圈。所以返回2。

public class Friend_Circles {

    // 我一开始以为就是求矩阵中独立的正方形个数，臆测了
    // dfs就ok

    public int findCircleNum(int[][] M) {
        int n = M.length;
        int[] mark = new int[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (mark[i] == 0) {
                count++;
                dfs(i, M, mark);
            }
        }
        return count;
    }

    private void dfs(int p, int[][] M, int[] mark) {
        if (mark[p] != 0) {
            return;
        }
        mark[p] = 1;
        for (int i = 0; i < M.length; i++) {
            if (M[p][i] == 1) {
                dfs(i, M, mark);
            }
        }
    }
}
