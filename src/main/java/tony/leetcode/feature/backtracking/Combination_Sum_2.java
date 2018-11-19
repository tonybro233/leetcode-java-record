package tony.leetcode.feature.backtracking;

import java.util.*;

public class Combination_Sum_2 {

    // 40
    // 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
    // candidates 中的每个数字在每个组合中只能使用一次。
    //
    // 说明：
    // 所有数字（包括目标数）都是正整数。
    // 解集不能包含重复的组合。

    // 示例 1:
    //
    // 输入: candidates = [10,1,2,7,6,1,5], target = 8,
    // 所求解集为:
    // [
    //   [1, 7],
    //   [1, 2, 5],
    //   [2, 6],
    //   [1, 1, 6]
    // ]

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> results = new ArrayList<>();
        find(candidates, 0, target, new ArrayList<>(), results);
        return results;
    }

    private void find(int[] candidates, int step, int sum, List<Integer> nums, List<List<Integer>> results){
        if (sum == 0) {
            results.add(new ArrayList<>(nums));
            return;
        }
        if (sum < 0 || step >= candidates.length || candidates[step] > sum) {
            return;
        }
        for (int i = step; i < candidates.length; i++){
            // 防止重复
            if (i > step && candidates[i] == candidates[i-1]){
                continue;
            }
            nums.add(candidates[i]);
            find(candidates,i+1, sum - candidates[i], nums, results);
            nums.remove(nums.size()-1);
        }

    }

    /**
     * 错误解法
     */
    public List<List<Integer>> combinationSum2err(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates.length == 0){
            return result;
        }
        Arrays.sort(candidates);
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
                int val = candidates[last];
                current -= candidates[last];
                last = deque.pollLast();
                while (null != last && last == candidates.length - 1){
                    current -= candidates[last];
                    last = deque.pollLast();
                }
                if (null != last){
                    current -= candidates[last];
                    current += candidates[++last];
                    deque.addLast(last);
                }
                // 防止重复。不正确，不止是第一项会重复
                if (deque.size() == 1){
                    int f = deque.peekFirst();
                    while (f < candidates.length){
                        if (candidates[f] != val){
                            break;
                        } else {
                            f++;
                        }
                    }
                    if (f == candidates.length){
                        return result;
                    } else {
                        deque.pollFirst();
                        deque.addFirst(f);
                        current = candidates[f];
                    }
                }
            } else if (current < target){
                Integer last = deque.peekLast();
                if (last < candidates.length-1){
                    current += candidates[++last];
                    deque.addLast(last);
                } else {
                    Integer first = deque.peekFirst();
                    deque.clear();
                    current = 0;
                    if (first != candidates.length - 1){
                        deque.addLast(++first);
                        current = candidates[first];
                    }
                }
            } else {
                Integer last = deque.pollLast();
                current -= candidates[last];
                last = deque.pollLast();

                while (null != last && last == candidates.length - 1){
                    current -= candidates[last];
                    last = deque.pollLast();
                }
                if (null != last){
                    int val = candidates[last];
                    current -= candidates[last];
                    current += candidates[++last];
                    deque.addLast(last);
                    // 防止重复
                    if (deque.size() == 1){
                        int f = deque.peekFirst();
                        while (f < candidates.length){
                            if (candidates[f] != val){
                                break;
                            } else {
                                f++;
                            }
                        }
                        if (f == candidates.length){
                            return result;
                        } else {
                            deque.pollFirst();
                            deque.addFirst(f);
                            current = candidates[f];
                        }
                    }
                }

            }
        }

        return result;
    }

    public static void main(String[] args){
        List<List<Integer>> lists = new Combination_Sum_2().combinationSum2(new int[]{10,1,2,7,6,1,5}, 8);
        System.out.println(lists.size());
    }
}
