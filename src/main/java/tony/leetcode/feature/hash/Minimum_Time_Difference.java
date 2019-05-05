package tony.leetcode.feature.hash;

import java.util.Collections;
import java.util.List;

// 539. 最小时间差
// 给定一个 24 小时制（小时:分钟）的时间列表，找出列表中任意两个时间的最小时间差并已分钟数表示。
//
// 示例 1：
// 输入: ["23:59","00:00"]
// 输出: 1
//
// 备注:
// 列表中时间数在 2~20000 之间。
// 每个时间取值在 00:00~23:59 之间。

public class Minimum_Time_Difference {

    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();
        Collections.sort(timePoints);
        int result = Integer.MAX_VALUE;
        for (int i = 1; i < n;i++){
            result = Math.min(result, gap(timePoints.get(i), timePoints.get(i-1)));
        }
        result = Math.min(result, gap(timePoints.get(0),timePoints.get(n-1)));
        return result;
    }

    private int gap(String t1, String t2){
        String[] sp1 = t1.split(":");
        String[] sp2 = t2.split(":");
        int m1 = Integer.parseInt(sp1[0]) * 60 + Integer.parseInt(sp1[1]);
        int m2 = Integer.parseInt(sp2[0]) * 60 + Integer.parseInt(sp2[1]);
        if (m1 > m2){
            return Math.min(m1 - m2, 1440 - m1 + m2);
        } else if (m2 > m1){
            return Math.min(m2 - m1, 1440 - m2 + m1);
        } else {
            return 0;
        }
    }

    // 直接将所有时间放入1440（所有分钟）长度的槽中
    public int findMinDifference2(List<String> timePoints) {
        int len = 24 * 60;
        int[] times = new int[len];
        for (int i = 0;i < timePoints.size();i++){
            String[] cur = timePoints.get(i).split(":");
            int time = Integer.valueOf(cur[0]) * 60 + Integer.valueOf(cur[1]);
            times[time] ++;
            if (times[time] > 1) {
                return 0;
            }
        }
        int min = len;
        int max = 0;
        int last = -1;
        int diff = len;
        for(int i = 0;i < len;i++){
            if (times[i] == 0) {
                continue;
            }
            if (last != -1){
                diff = Math.min(diff,i - last);
            }
            last = i;
            min = Math.min(min,i);
            max = Math.max(max,i);
        }
        // 比较顺序最小间隔和最大最小间隔
        diff = Math.min(diff, min + len - max);
        return diff;
    }
}
