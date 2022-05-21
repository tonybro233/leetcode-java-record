package tony.leetcode.feature.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// 56. 合并区间
// 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
// 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
//
// 示例 1：
// 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
// 输出：[[1,6],[8,10],[15,18]]
// 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].

// 示例 2：
// 输入：intervals = [[1,4],[4,5]]
// 输出：[[1,5]]
// 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
//  
// 提示：
// 1 <= intervals.length <= 104
// intervals[i].length == 2
// 0 <= starti <= endi <= 104

public class Merge_Intervals {

    public int[][] merge(int[][] intervals) {
        if (null == intervals || intervals.length < 2) {
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> res = new ArrayList<>();
        Integer st = null, ed = null;
        for (int[] interval : intervals) {
            if (ed == null) {
                st = interval[0];
                ed = interval[1];
            } else {
                if (ed >= interval[0]) {
                    // 千万注意这里要判断最大值
                    ed = Math.max(ed, interval[1]);
                } else {
                    res.add(new int[]{st, ed});
                    st = interval[0];
                    ed = interval[1];
                }
            }
        }
        res.add(new int[]{st, ed});

        int[][] result = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }

}
