package tony.leetcode.feature.greedy;

import tony.util.Interval;

import java.util.Arrays;
import java.util.Comparator;

public class Non_overlapping_Intervals {

    // 435
    // 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
    //
    // 注意:
    //
    // 可以认为区间的终点总是大于它的起点。
    // 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。


    // 这个问题主要就是容易想太多，解题就一点：区间的尾部越小，越能安排更多的活动

    public static void main(String[] args){
        Interval[] data = new Interval[4];
        data[0] = new Interval(1,100);
        data[1] = new Interval(11,22);
        data[2] = new Interval(1,11);
        data[3] = new Interval(2,12);
        int i = new Non_overlapping_Intervals().eraseOverlapIntervals(data);
        System.out.println("answer :"+i);
    }

    public int eraseOverlapIntervals(Interval[] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a.end));
        int count = 0;
        int cursor = Integer.MIN_VALUE;
        for (int i = 0;i < intervals.length; i++){
            if (intervals[i].start >= cursor ){
                cursor = intervals[i].end;
            } else {
                count++;
            }
        }
        return count;
    }
}
