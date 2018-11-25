package tony.leetcode.feature.backtracking;

import java.util.ArrayList;
import java.util.List;

// 78
// 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
//
// 说明：解集不能包含重复的子集。
//
// 示例:
//
// 输入: nums = [1,2,3]
// 输出:
// [
//   [3],
//   [1],
//   [2],
//   [1,2,3],
//   [1,3],
//   [2,3],
//   [1,2],
//   []
// ]
public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        find(0, nums, new ArrayList<>(), result);
        return result;
    }

    private void find(int begin, int[] nums, List<Integer> one, List<List<Integer>> result){
        result.add(new ArrayList<>(one));
        if (one.size() == nums.length){
            return;
        }
        if (begin >= nums.length){
            return;
        }
        for (int i = begin; i< nums.length;i++){
            one.add(nums[i]);
            find(i+1, nums, one, result);
            one.remove(one.size()-1);
        }
    }
}
