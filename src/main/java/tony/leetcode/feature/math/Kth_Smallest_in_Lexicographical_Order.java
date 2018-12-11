package tony.leetcode.feature.math;

// 440 字典序第K小的数字
// 给定两个整数 n 和 k, 找到按字典序排序的1到n范围内的第k小的整数
//
// 注意: 1 ≤ k ≤ n ≤ 109.
//
// 示例:
// 输入: n: 13   k: 2
// 输出: 10
// 解释:
// 字典序为 [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9], 所以第二小的数是 10.

public class Kth_Smallest_in_Lexicographical_Order {

    public int findKthNumber(int n, int k) {
        int cur = 1;
        for (int i = 1; i < k;i++){
            if (cur * 10 <= n){
                cur *= 10;
            } else if (cur % 10 != 9 && cur+1 <= n){
                cur++;
            } else {
                while ((cur / 10) % 10 == 9) {
                    cur = cur / 10;
                }
                cur = cur / 10 + 1;
            }
        }
        return cur;
    }
}
