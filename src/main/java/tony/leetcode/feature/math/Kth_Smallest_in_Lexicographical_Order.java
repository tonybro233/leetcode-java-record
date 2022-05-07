package tony.leetcode.feature.math;

// 440 字典序第K小的数字
// 给定两个整数 n 和 k, 找到按字典序排序的1到n范围内的第k小的整数
//
// 注意: 1 ≤ k ≤ n ≤ 10的9次.
//
// 示例:
// 输入: n: 13   k: 2
// 输出: 10
// 解释:
// 字典序为 [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9], 所以第二小的数是 10.

public class Kth_Smallest_in_Lexicographical_Order {


    public int findKthNumber3(int n, int k) {
        // 字典树
        //                  1                       2
        //         10           11 ... 18 19    20 ... 29
        // 100 101 102 ... 109

        // 先走到1节点，k的意义变更为还剩下几个数
        long cur = 1;
        k -= 1;

        while (k > 0) {
            // subCount是不包含自己的子节点数量
            long subCount = findLimitedSubNodes(n, cur) - 1;
            if (k > subCount) {
                // 减去所有子节点
                k -= subCount;
                // 移动到下一个平级节点，移动以后k要减一
                cur++;
                k--;
            } else {
                // 移动到下一层的首节点，移动后k要减一
                cur *= 10;
                k--;
            }
        }

        return (int) cur;
    }

    private long findLimitedSubNodes(int limit, long root) {
        //          root  nextRoot
        // 第一层    1     2
        // 第二层    10    20
        // 第三层    100   200
        // ...
        long nextRoot = root + 1;
        long count = 0;
        while (root <= limit) {
            // 增加这一层的节点数量，可以观察到一整层的数量是 1、10、100 ...
            // 有可能上限已经在这一层，那么这一层数量就是有限的，且会跳出循环
            count += Math.min(nextRoot - root, limit - root + 1);
            root *= 10;
            nextRoot *= 10;
        }

        return count;
    }

    public int findKthNumber2(int n, int k) {
        long ans = 1;
        k -= 1;
        while (k > 0) {
            long gap = findGap(n, ans, ans + 1);
            if (gap <= k) {
                ans += 1;
                k -= gap;
            } else {
                ans *= 10;
                k -= 1;
            }
        }
        return (int) ans;
    }

    private long findGap(long limit, long low, long high) {
        int gap = 0;
        while (low <= limit) {
            gap += Math.max(0, Math.min(limit + 1, high) - low);
            low *= 10;
            high *= 10;
        }
        return gap;
    }


    // 解法超时
    public int findKthNumber(int n, int k) {
        long cur = 1; // int存在越界情况
        for (int i = 1; i < k; i++) {
            if (cur * 10 <= n) {
                cur *= 10;
            } else if (cur % 10 != 9 && cur + 1 <= n) {
                cur++;
            } else {
                while ((cur / 10) % 10 == 9) {
                    cur = cur / 10;
                }
                cur = cur / 10 + 1;
            }
        }
        return (int) cur;
    }

    public static void main(String[] args) {
        int kthNumber = new Kth_Smallest_in_Lexicographical_Order().findKthNumber(681692778
                , 351251360);
        System.out.println(kthNumber);
    }
}
