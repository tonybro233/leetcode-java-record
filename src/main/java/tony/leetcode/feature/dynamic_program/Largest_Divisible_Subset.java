package tony.leetcode.feature.dynamic_program;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// 368. 最大整除子集
// 给出一个由无重复的正整数组成的集合，找出其中最大的整除子集，
// 子集中任意一对 (Si，Sj) 都要满足：Si % Sj = 0 或 Sj % Si = 0。
//
// 如果有多个目标子集，返回其中任何一个均可。
//
// 示例 1:
// 输入: [1,2,3]
// 输出: [1,2] (当然, [1,3] 也正确)

// 示例 2:
// 输入: [1,2,4,8]
// 输出: [1,2,4,8]

public class Largest_Divisible_Subset {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return new ArrayList<>();
        } else if (n == 1) {
            return Collections.singletonList(nums[0]);
        }

        Arrays.sort(nums);

        // count[i]表示以nums[i]作为集合中最大元素的子集成员数量
        int[] count = new int[n];
        // 用来追踪子集，pre[i]表示以nums[i]作为集合中最大元素，子集成员数最大时，前一个成员的下标
        int[] pre = new int[n];

        int max = 1;
        int pos = 0;

        for (int i = 0; i < n; i++) {
            pre[i] = -1;
            count[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && count[j] + 1 > count[i]) {
                    count[i] = count[j] + 1;
                    pre[i] = j;
                }
            }
            if (count[i] > max) {
                max = count[i];
                pos = i;
            }
        }

        List<Integer> result = new ArrayList<>(n);
        int c = pos;
        while (c != -1) {
            result.add(nums[c]);
            c = pre[c];
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> list = new Largest_Divisible_Subset().largestDivisibleSubset(new int[]{1, 2, 3});
        System.out.println(list);
    }
}
