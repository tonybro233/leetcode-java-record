package tony.leetcode.level.mid;

import tony.util.Interval;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// 56
// 给出一个区间的集合，请合并所有重叠的区间。
//
// 示例 1:
//
// 输入: [[1,3],[2,6],[8,10],[15,18]]
// 输出: [[1,6],[8,10],[15,18]]
// 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 示例 2:
//
// 输入: [[1,4],[4,5]]
// 输出: [[1,5]]
// 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
public class Merge_Intervals {

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        intervals.sort(Comparator.comparingInt(o -> o.start));
        Integer curBegin = null, curEnd = null;
        for (Interval each : intervals){
            if (null == curBegin){
                curBegin = each.start;
                curEnd = each.end;
            } else {
                if (each.start <= curEnd){
                    curEnd = Math.max(curEnd,each.end);
                } else {
                    result.add(new Interval(curBegin, curEnd));
                    curBegin = each.start;
                    curEnd = each.end;
                }
            }
        }
        if (null != curBegin){
            result.add(new Interval(curBegin, curEnd));
        }

        return result;
    }
}
