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
        // 使用一个数组表示到达某层的每一个元素的最小路径和，最终只需要得到最后一层的结果，因此数组长度可以确定
        int[] data = new int[row];

        // 初始化第一层
        data[0] = triangle.get(0).get(0);
        int pre = 0, cur = 0;

        // 循环每行
        for (int i = 1; i < row; i++){
            // 第一项一定是增加当前行的第一个值，因为只有1个邻接项
            pre = data[0];
            data[0] += triangle.get(i).get(0);
            // 循环每一项，逐个更新最小路径和
            for (int j = 1; j < i; j++){
                // 注意data中的数据在赋值操作之前还是上一层的内容，最后一个元素对应上层的内容由于数组初始化默认值就是0
                cur = data[j];
                if (pre > data[j]) {
                    data[j] += triangle.get(i).get(j);
                } else {
                    data[j] = triangle.get(i).get(j) + pre;
                }
                // 记录下上层的上一个值，最小路径和必然从上层对应值和上层的上一个值中取小值累加
                pre = cur;
            }
            data[i] = triangle.get(i).get(i) + pre;
        }

        // 对于最后一行的每一项，取最小值即是整个结构的最小路径值
        int min = Integer.MAX_VALUE;
        for (Integer ea : data){
            if (ea < min) {
                min = ea;
            }
        }
        return min;
    }
}
