package tony.leetcode.feature.array;

import java.util.Arrays;

// 167 两数之和 II - 输入有序数组
// 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
// 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
//
// 说明:
// 1.返回的下标值（index1 和 index2）不是从零开始的。
// 2.你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。

// 示例:
// 输入: numbers = [2, 7, 11, 15], target = 9
// 输出: [1,2]
// 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。

public class Two_Sum_II {

    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int pos = Arrays.binarySearch(numbers, target);
        if (pos < 0) {
            pos = -pos + 1;
        } else {
            pos += 1;
        }

        for (int i = 0; i < pos; i++) {
            int val = target - numbers[i];
            int pos2 = Arrays.binarySearch(numbers, i + 1, numbers.length, val);
            if (pos2 > 0) {
                // 注意审题
                result[0] = i + 1;
                result[1] = pos2 + 1;
                break;
            }
        }

        return result;
    }

    // 这个解法更优雅一些
    public int[] twoSum2(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                return new int[]{i + 1, j + 1};
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
        return null;

    }
}
