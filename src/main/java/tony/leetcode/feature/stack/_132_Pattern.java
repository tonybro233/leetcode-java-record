package tony.leetcode.feature.stack;

import java.util.Deque;
import java.util.LinkedList;

// 456. 132模式
// 给定一个整数序列：a1, a2, ..., an，一个132模式的子序列 ai, aj, ak 被定义为：
// 当 i < j < k 时，ai < ak < aj。设计一个算法，当给定有 n 个数字的序列时，
// 验证这个序列中是否含有132模式的子序列。
//
// 注意：n 的值小于15000。
//
// 示例1:
// 输入: [1, 2, 3, 4]
// 输出: False
// 解释: 序列中不存在132模式的子序列。

// 示例 2:
// 输入: [3, 1, 4, 2]
// 输出: True
// 解释: 序列中有 1 个132模式的子序列： [1, 4, 2].

// 示例 3:
// 输入: [-1, 3, 2, 0]
// 输出: True
// 解释: 序列中有 3 个132模式的的子序列: [-1, 3, 2], [-1, 3, 0] 和 [-1, 2, 0].

public class _132_Pattern {

    // 从最后开始遍历，用栈来辅助维护一个次大值
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        if (n < 3){
            return false;
        }

        int last = Integer.MIN_VALUE; // 132中的2
        Deque<Integer> sta = new LinkedList<>();// 用来存储132中的3
        for(int i = n-1; i >= 0; i--){
            // 若出现132中的1则返回正确值
            if (nums[i] < last) {
                return true;
            }

            // nums[i] >= last, sta.peek >= last
            // last保持增大，last是pop出来的因此必然

            // 若当前值大于或等于2则更新2（2为栈中小于当前值的最大元素）
            while(!sta.isEmpty() && sta.peek() < nums[i]){
                last = sta.pop();
            }

            // nums[i] <= sta.peek

            // 将当前值压入栈中, 栈内从顶至底递增，从顶至底也符合原来数组内的顺序
            sta.push(nums[i]);

            // last保持为小于栈顶元素的最大值
        }
        return false;
    }
}
