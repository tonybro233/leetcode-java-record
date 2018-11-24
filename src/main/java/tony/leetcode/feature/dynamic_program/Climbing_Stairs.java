package tony.leetcode.feature.dynamic_program;


// 70
// 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
//
// 注意：给定 n 是一个正整数。
//
// 示例 1：
//
// 输入： 2
// 输出： 2
// 解释： 有两种方法可以爬到楼顶。
//   1.  1 阶 + 1 阶
//   2.  2 阶

// 经典的动态规划基础题
public class Climbing_Stairs {

    public int climbStairs(int n) {
        if (n == 0){
            return 0;
        } else if (n == 1){
            return 1;
        }
        int[] record = new int[n+1];
        record[0] = 0;
        record[1] = 1;
        record[2] = 2;
        for (int i = 3; i <= n; i++){
            record[i] = record[i-1]+record[i-2];
        }
        return record[n];
    }
}
