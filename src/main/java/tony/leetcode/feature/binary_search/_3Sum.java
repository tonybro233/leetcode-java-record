package tony.leetcode.feature.binary_search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 15. 三数之和
// 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
// 使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
//
// 注意：答案中不可以包含重复的三元组。
//
// 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
// 满足要求的三元组集合为：
// [
//   [-1, 0, 1],
//   [-1, -1, 2]
// ]

public class _3Sum {

    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        if (n < 3){
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < n-2 && nums[i] <= 0;i++){
            int target = -nums[i];
            int j = i+1, k = n-1;
            while (j < k){
                int sum = nums[j] + nums[k];
                if (sum == target){
                    result.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
                    while (j < k && nums[j] == nums[j-1]){
                        j++;
                    }
                    while (k > j && nums[k] == nums[k+1]){
                        k--;
                    }
                } else if (sum < target){
                    j++;
                } else if (sum > target){
                    k--;
                }
            }
            while (i+1 < n && nums[i] == nums[i+1]){
                i++;
            }
        }
        return result;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        if (n < 3){
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < n-2 && nums[i] <= 0;i++){
            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            for (int j = i+1; j < n-1;j++){
                if (j > i+1 && nums[j] == nums[j-1]){
                    continue;
                }
                int val = -(nums[i]+nums[j]);
                int k = Arrays.binarySearch(nums, j + 1, n, val);
                if (k > 0){
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                }
            }
        }
        return result;
    }
}
