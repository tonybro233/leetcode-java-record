package tony.leetcode.feature.recursive_search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 46. 全排列
// 给定一个没有重复数字的序列，返回其所有可能的全排列。
//
// 示例:
//
// 输入: [1,2,3]
// 输出:
// [
//   [1,2,3],
//   [1,3,2],
//   [2,1,3],
//   [2,3,1],
//   [3,1,2],
//   [3,2,1]
// ]
public class Permutations {

    // 回溯解法
    public List<List<Integer>> permute2(int[] nums) {
        boolean[] mark = new boolean[nums.length];
        List<List<Integer>> result = new ArrayList<>();
        search(nums, mark, new ArrayList<>(nums.length), result);
        return result;
    }

    private void search(int[] nums, boolean[] mark, List<Integer> buffer, List<List<Integer>> result) {
        if (buffer.size() == nums.length) {
            result.add(new ArrayList<>(buffer));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!mark[i]) {
                mark[i] = true;
                buffer.add(nums[i]);
                search(nums, mark, buffer, result);
                buffer.remove(buffer.size() - 1);
                mark[i] = false;
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        search(nums, 0, result);

        return result;
    }

    // 恕我直言，这方法我想不出
    private void search(int[] nums, int pos, List<List<Integer>> result) {
        if (pos == nums.length - 1) {
            List<Integer> each = new ArrayList<>();
            for (int num : nums) {
                each.add(num);
            }
            result.add(each);
        }
        // 这个循环中pos是不变的，i以pos为起始（起始保持不变）递增
        for (int i = pos; i < nums.length; i++) {
            swap(nums, pos, i);
            search(nums, pos + 1, result);
            swap(nums, pos, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        new Permutations().permute(new int[]{1, 2, 3});
    }
}
