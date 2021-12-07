package tony.leetcode.feature.array;

import java.util.*;

// 398. 随机数索引
// 给定一个可能含有重复元素的整数数组，要求随机输出给定的数字的索引。
// 您可以假设给定的数字一定存在于数组中。
//
// 注意：
// 数组大小可能非常大。 使用太多额外空间的解决方案将不会通过测试。
//
// 示例:
// int[] nums = new int[] {1,2,3,3,3};
// Solution solution = new Solution(nums);
//
// // pick(3) 应该返回索引 2,3 或者 4。每个索引的返回概率应该相等。
// solution.pick(3);
//
// // pick(1) 应该返回 0。因为只有nums[0]等于1。
// solution.pick(1);

public class Random_Pick_Index {

    private int[] nums;

    public void init(int[] nums) {
        this.nums = nums;
    }

    public int pick2(int target) {
        // 因为要取下标，所以不能做排序

        // 水塘抽样法
        int res = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                count++;
                if (random.nextInt(count) == 0) {
                    res = i;
                }
            }
        }
        return res;
    }


    // 基本的蠢方法，也能ac
    private Map<Integer, List<Integer>> map = new HashMap<>();
    private Random random = new Random();
    public Random_Pick_Index(int[] nums) {
        for (int i =0 ;i < nums.length; i++){
            List<Integer> list = map.getOrDefault(nums[i], new ArrayList<>());
            list.add(i);
            map.put(nums[i], list);
        }
    }

    public int pick(int target) {
        List<Integer> list = map.get(target);
        int n = list.size();
        return list.get(random.nextInt(n));
    }
}
