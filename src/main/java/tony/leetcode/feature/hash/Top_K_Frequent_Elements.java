package tony.leetcode.feature.hash;

import java.util.*;
import java.util.stream.Collectors;

// 347. 前K个高频元素
// 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
//
// 示例 1:
// 输入: nums = [1,1,1,2,2,3], k = 2
// 输出: [1,2]

// 示例 2:
// 输入: nums = [1], k = 1
// 输出: [1]

// 说明：
// 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
// 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。

public class Top_K_Frequent_Elements {

    // 也可以尝试使用大根堆
    public List<Integer> topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length;i++ ){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        List<Integer> result = new ArrayList<>();
        List<Integer>[] bucket = new List[nums.length+1];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (bucket[entry.getValue()] == null){
                bucket[entry.getValue()] = new ArrayList<>();
            }
            bucket[entry.getValue()].add(entry.getKey());
        }

        for (int i = bucket.length - 1; i >= 0 && result.size() < k; i--){
            if (bucket[i] != null){
                result.addAll(bucket[i]);
            }
        }

        return result;
    }

    // 偷懒排序
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length;i++ ){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        List<Integer> collect = map.entrySet().stream().sorted(Comparator.comparingInt(Map.Entry<Integer, Integer>::getValue).reversed()).map(Map.Entry::getKey).collect(Collectors.toList());
        return collect.subList(0, k);
    }
}
