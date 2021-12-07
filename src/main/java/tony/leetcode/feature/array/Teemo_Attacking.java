package tony.leetcode.feature.array;

import java.util.Arrays;

// 495
// 在《英雄联盟》的世界中，有一个叫 “提莫” 的英雄，
// 他的攻击可以让敌方英雄艾希（编者注：寒冰射手）进入中毒状态。
// 现在，给出提莫对艾希的攻击时间序列和提莫攻击的中毒持续时间，你需要输出艾希的中毒状态总时长。
//
// 你可以认为提莫在给定的时间点进行攻击，并立即使艾希处于中毒状态。

public class Teemo_Attacking {

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int tmpBegin = -1;
        int tmpEnd = -1;
        int total = 0;
        Arrays.sort(timeSeries);
        for (int ea : timeSeries) {
            if (ea <= tmpEnd) {
                tmpEnd = ea + duration;
            } else {
                total += tmpEnd - tmpBegin;
                tmpBegin = ea;
                tmpEnd = ea + duration;
            }
        }
        if (tmpBegin != -1) {
            total += tmpEnd - tmpBegin;
        }

        return total;
    }
}
