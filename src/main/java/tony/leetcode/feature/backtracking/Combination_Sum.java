package tony.leetcode.feature.backtracking;

import java.util.*;

// 39
// 给定一个无重复元素的数组 candidates 和一个目标数 target ，
// 找出 candidates 中所有可以使数字和为 target 的组合。
// candidates 中的数字可以无限制重复被选取。
//
// 说明：
// 所有数字（包括 target）都是正整数。
// 解集不能包含重复的组合。

// 示例 1:
// 输入: candidates = [2,3,6,7], target = 7,
// 所求解集为:
// [
//   [7],
//   [2,2,3]
// ]

public class Combination_Sum {

    /**
     * 递归查找
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> results = new ArrayList<>();
        find(candidates, 0, target, new ArrayList<>(), results);
        return results;
    }

    private void find(int[] candidates, int step, int sum, List<Integer> nums, List<List<Integer>> results) {
        if (sum == 0) {
            results.add(new ArrayList<>(nums));
            return;
        }
        if (sum < 0 || step >= candidates.length || candidates[step] > sum) {
            return;
        }
        nums.add(candidates[step]);
        find(candidates, step, sum-candidates[step], nums, results);
        nums.remove(nums.size()-1);
        find(candidates, step+1, sum, nums, results);
    }

    /**
     * 直接进行穷举
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates.length == 0){
            return result;
        }
        Deque<Integer> deque = new ArrayDeque<>();
        deque.push(0);
        int current = candidates[0];
        while (null != deque.peekLast()){
            if (current == target){
                List<Integer> solve = new ArrayList<>();
                for (Integer i : deque){
                    solve.add(candidates[i]);
                }
                result.add(solve);
                Integer last = deque.pollLast();
                current -= candidates[last];
                if (last < candidates.length - 1){
                    current += candidates[++last];
                    deque.addLast(last);
                } else {
                    last = deque.pollLast();
                    while (last != null && last == candidates.length - 1) {
                        current -= candidates[last];
                        last = deque.pollLast();
                    }
                    if (last != null) {
                        current -= candidates[last];
                        current += candidates[++last];
                        deque.addLast(last);
                    }
                }
            } else if (current < target){
                deque.addLast(deque.peekLast());
                current += candidates[deque.peekLast()];
            } else {
                Integer last = deque.pollLast();
                while (last != null && last == candidates.length - 1){
                    current -= candidates[last];
                    last = deque.pollLast();
                }
                if (last != null){
                    current -= candidates[last];
                    current += candidates[++last];
                    deque.addLast(last);
                }
            }
        }

        return result;
    }

    public static void main(String[] args){
        List<List<Integer>> lists = new Combination_Sum().combinationSum(new int[]{4,2,8}, 8);
        System.out.println(lists.size());
    }
}
