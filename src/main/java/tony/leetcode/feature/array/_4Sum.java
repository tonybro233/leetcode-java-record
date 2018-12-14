package tony.leetcode.feature.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 18. 四数之和
// 给定一个包含 n 个整数的数组 nums 和一个目标值 target，
// 判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？
// 找出所有满足条件且不重复的四元组。
//
// 注意：
// 答案中不可以包含重复的四元组。
//
// 示例：
// 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
//
// 满足要求的四元组集合为：
// [
//   [-1,  0, 0, 1],
//   [-2, -1, 1, 2],
//   [-2,  0, 0, 2]
// ]

public class _4Sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++){
            if (i != 0 && nums[i] == nums[i-1]){
                continue;
            }
            for (int f = nums.length-1; f >= i+3; f--){
                if (f < nums.length - 1 && nums[f] == nums[f+1]){
                    continue;
                }
                int j = i+1, k = f-1;
                while (j < k){
                    if (nums[i]+nums[j]+nums[k]+nums[f] < target) {
                        j++;
                    } else if (nums[i]+nums[j]+nums[k]+nums[f] > target) {
                        k--;
                    } else{
                        List<Integer> solve = new ArrayList<>();
                        solve.add(nums[i]);
                        solve.add(nums[j]);
                        solve.add(nums[k]);
                        solve.add(nums[f]);
                        result.add(solve);
                        // 防止重复
                        do{j++;}while(j<k && nums[j]==nums[j-1]);
                        do{k--;}while(j<k && nums[k]==nums[k+1]);
                    }
                }
            }
        }
        return result;
    }
}
