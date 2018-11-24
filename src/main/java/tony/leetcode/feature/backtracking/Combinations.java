package tony.leetcode.feature.backtracking;

import java.util.ArrayList;
import java.util.List;

// 77
// 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
//
// 示例:
//
// 输入: n = 4, k = 2
// 输出:
// [
//   [2,4],
//   [3,4],
//   [2,3],
//   [1,2],
//   [1,3],
//   [1,4],
// ]
public class Combinations {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        find(1, n, k , new ArrayList<>(),result);
        return result;
    }

    private void find(int begin, int n, int k, List<Integer> list, List<List<Integer>> result){
        if (list.size() == k){
            result.add(new ArrayList<>(list));
            return;
        }
        if (begin > n){
            return;
        }

        for (int i = begin; i <= n;i++){
            list.add(i);
            find(i+1, n, k, list, result);
            list.remove(list.size()-1);
        }
    }
}
