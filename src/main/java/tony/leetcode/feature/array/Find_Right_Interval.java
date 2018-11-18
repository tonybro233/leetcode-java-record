package tony.leetcode.feature.array;

import tony.util.Interval;

import java.util.*;

public class Find_Right_Interval {

    // 436
    // 给定一组区间，对于每一个区间 i，检查是否存在一个区间 j，它的起始点大于或等于区间 i 的终点，这可以称为 j 在 i 的“右侧”。
    //
    // 对于任何区间，你需要存储的满足条件的区间 j 的最小索引，这意味着区间 j 有最小的起始点可以使其成为“右侧”区间。如果区间 j 不存在，则将区间 i 存储为 -1。最后，你需要输出一个值为存储的区间值的数组。
    //
    // 注意:
    //
    // 你可以假设区间的终点总是大于它的起始点。
    // 你可以假定这些区间都不具有相同的起始点。

    // 首先一定是按照start排序，然后就是要根据end去找到最小的大于end的start对应的下标

    public static void main(String[] args){
        Interval[] data = new Interval[3];
        data[0] = new Interval(3,4);
        data[1] = new Interval(2,3);
        data[2] = new Interval(1,2);
        int[] i = new Find_Right_Interval().findRightInterval(data);
        for (int iii : i){
            System.out.print(iii + " ");
        }
    }

    public int[] findRightInterval(Interval[] intervals) {
        int n = intervals.length;
        int[] result = new int[n];
        if (n == 0){
            return result;
        }
        TreeMap<Integer,Integer> sortMap = new TreeMap<>();
        for (int i =0;i<intervals.length;i++){
            sortMap.put(intervals[i].start,i);
        }

        for (int i = 0; i < n; i++){
            // 二分查找
            Integer key = sortMap.ceilingKey(intervals[i].end);
            if (null == key){
                result[i] = -1;
            } else {
                result[i] = sortMap.get(key);
            }
        }
        return result;
    }

    // map按值排序的应用

    // 超时
    public int[] findRightInterval2(Interval[] intervals) {
        int n = intervals.length;
        int[] result = new int[n];
        if (n == 0){
            return result;
        }

        Map<Integer,Interval> sortMap = new HashMap<>();
        for (int i =0;i<intervals.length;i++){
            sortMap.put(i,intervals[i]);
        }

        List<Map.Entry<Integer,Interval>> list = new ArrayList<>(sortMap.entrySet());
        list.sort(Comparator.comparingInt(a -> a.getValue().start));

        for (int i = 0; i < n; i++){
            int j = i+1;
            for (; j < n && list.get(j).getValue().start < list.get(i).getValue().end;j++){}
            if (j == n) {
                result[list.get(i).getKey()] = -1;
            } else {
                result[list.get(i).getKey()] = list.get(j).getKey();
            }
        }

        return result;
    }
}
