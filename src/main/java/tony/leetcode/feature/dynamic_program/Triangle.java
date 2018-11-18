package tony.leetcode.feature.dynamic_program;

import java.util.List;

/**
 * 120
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * 例如，给定三角形：
 * [
        [2],
       [3,4],
      [6,5,7],
     [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 */
public class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        if (row == 0) {
            return 0;
        }
        if (row == 1) {
            return triangle.get(0).get(0);
        }

        // 只采用O(n)的额外空间，n=row
        // 使用pre 和 cur 来保证能够读取上一层的相邻元素
        int[] data = new int[row];
        data[0] = triangle.get(0).get(0);
        int pre = 0, cur = 0;

        for (int i = 1; i < row; i++){
            pre = data[0];
            data[0] += triangle.get(i).get(0);
            for (int j = 1; j < i; j++){
                cur = data[j];
                if (pre > data[j]) {
                    data[j] += triangle.get(i).get(j);
                } else {
                    data[j] = triangle.get(i).get(j) + pre;
                }
                pre = cur;
            }
            data[i] = triangle.get(i).get(i) + pre;
        }
        int min = Integer.MAX_VALUE;
        for (Integer ea : data){
            if (ea < min) {
                min = ea;
            }
        }
        return min;
    }
}
