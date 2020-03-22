package tony.leetcode.feature.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 90. 子集 II
// 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
//
// 说明：解集不能包含重复的子集。
//
// 示例:
//
// 输入: [1,2,2]
// 输出:
// [
//   [2],
//   [1],
//   [1,2,2],
//   [2,2],
//   [1,2],
//   []
// ]

public class Subsets_II {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        find(result, new ArrayList<>(nums.length), nums, 0);
        return result;
    }

    private void find(List<List<Integer>> result, List<Integer> buffer, int[] nums, int cur) {
        result.add(new ArrayList<>(buffer));
        Integer last = null;
        for (int i = cur; i < nums.length; i++) {
            if (last == null || nums[i] != last) {
                buffer.add(nums[i]);
                find(result, buffer, nums, i + 1);
                last = buffer.remove(buffer.size() - 1);
            }
        }
    }

}
