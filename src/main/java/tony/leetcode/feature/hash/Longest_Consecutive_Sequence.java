package tony.leetcode.feature.hash;

// 128. 最长连续序列
// 给定一个未排序的整数数组 nums ，找出数字连续的最长序列
// （不要求序列元素在原数组中连续）的长度。
// 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
//
// 示例 1：
// 输入：nums = [100,4,200,1,3,2]
// 输出：4
// 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。

// 示例 2：
// 输入：nums = [0,3,7,2,5,8,4,6,0,1]
// 输出：9
//  
// 提示：
// 0 <= nums.length <= 105
// -109 <= nums[i] <= 109

import java.util.HashSet;
import java.util.Set;

public class Longest_Consecutive_Sequence {

    public int longestConsecutive(int[] nums) {
        // 这个题很奇怪啊，虽然写出来很简单，但是不容易想到
        // 组装一个set，这个set有两个作用
        // 1. 剔除连续序列中的非最小值
        // 2. 搜索连续序列
        // 因为这个set所以复杂度满足要求O(n)
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int current = 0, max = 0;
        for (int num : nums) {
            if (set.contains(num - 1)) {
                continue;
            }
            int val = num + 1;
            current = 1;
            while (set.contains(val++)) {
                current++;
            }
            max = Math.max(max, current);
        }
        return max;
    }

}
