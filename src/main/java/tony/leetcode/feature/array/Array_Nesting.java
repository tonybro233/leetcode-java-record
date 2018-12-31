package tony.leetcode.feature.array;

import java.util.HashSet;
import java.util.Set;

// 565
// 索引从0开始长度为N的数组A，包含0到N - 1的所有整数。找到并返回长度最大的集合S
// 假设选择索引为i的元素A[i]为S的第一个元素，S的下一个元素应该是A[A[i]]，
// 之后是A[A[A[i]]]... 以此类推，不断添加直到S出现重复的元素。

// N是[1, 20,000]之间的整数。
// A中不含有重复的元素。
// A中的元素大小在[0, N-1]之间。

public class Array_Nesting {

    /**
     * 如果不注释掉下面的那一句，将会超时
     *
     * 可以注释掉是因为符合题目条件的话，数组中所有元素都会被划分为N个独立的环
     * 这他妈的。。
     *
     * @param nums
     * @return
     */
    public int arrayNesting(int[] nums) {
        int max = 0;
        Set<Integer> record = new HashSet<>();
        for (int i = 0; i < nums.length; i++){
            // record.clear();
            int current = 0;
            int val = i;
            while (!record.contains(val)){
                record.add(val);
                current++;
                val = nums[val];
            }
            max = Math.max(max, current);
        }

        return max;
    }
}
