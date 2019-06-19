package tony.leetcode.feature.dfs;

import java.util.*;

// 491. 递增子序列
// 给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。
//
// 示例:
// 输入: [4, 6, 7, 7]
// 输出: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]

// 说明:
// 给定数组的长度不会超过15。
// 数组中的整数范围是 [-100,100]。
// 给定数组中可能包含重复数字，相等的数字应该被视为递增的一种情况。

public class Increasing_Subsequences {

    public List<List<Integer>> findSubsequences(int[] nums) {
        int n = nums.length;
        Deque<Integer> deque = new ArrayDeque<>(n);
        Set<List<Integer>> set = new HashSet<>();

        dfs(nums, 0, deque, set);
        return new ArrayList<>(set);
    }

    // 重复值比较难处理，数组本身并不是有序的，因此直接用Set去重
    private void dfs(int[] nums, int pos, Deque<Integer> current, Set<List<Integer>> set){
        int n = nums.length;
        if (pos >= n){
            return;
        }

        // 采用值
        if (null == current.peekLast() || current.peekLast() <= nums[pos]){
            current.addLast(nums[pos]);
            if (current.size() > 1) {
                set.add(new ArrayList<>(current));
            }
            dfs(nums, pos+1, current, set);
            current.pollLast();
        }

        // 不采用值
        dfs(nums, pos+1, current, set);
    }
}
