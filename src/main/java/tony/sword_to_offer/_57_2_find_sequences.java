package tony.sword_to_offer;

import java.util.*;

// 57 - II. 和为s的连续正数序列
// 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
// 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
//
// 示例 1：
// 输入：target = 9
// 输出：[[2,3,4],[4,5]]

// 示例 2：
// 输入：target = 15
// 输出：[[1,2,3,4,5],[4,5,6],[7,8]]

public class _57_2_find_sequences {

    public int[][] findContinuousSequence(int target) {
        if (target < 3) {
            return null;
        }

        List<int[]> result = new ArrayList<>();
        int begin = 1, end = 2;
        int sum = 3;
        while (begin <= end && end < target) {
            if (sum == target) {
                int[] array = new int[end - begin + 1];
                for (int i = 0; i < array.length;i++) {
                    array[i] = begin + i;
                }
                result.add(array);
                sum -= begin++;
            } else if (sum < target) {
                sum += ++end;
            } else {
                sum -= begin++;
            }
        }

        int[][] res = new int[result.size()][];
        int idx = 0;
        for (int[] ints : result) {
            res[idx++] = ints;
        }
        return res;
    }

}
