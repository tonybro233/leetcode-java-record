package tony.leetcode.level.simple;

// 1736. 替换隐藏数字得到的最晚时间
// 给你一个字符串 time ，格式为 hh:mm（小时：分钟），其中某几位数字被隐藏（用 ? 表示）。
// 有效的时间为 00:00 到 23:59 之间的所有时间，包括 00:00 和 23:59 。
// 替换 time 中隐藏的数字，返回你可以得到的最晚有效时间。

// 示例 1：
// 输入：time = "2?:?0"
// 输出："23:50"
// 解释：以数字 '2' 开头的最晚一小时是 23 ，以 '0' 结尾的最晚一分钟是 50 。

// 示例 2：
// 输入：time = "0?:3?"
// 输出："09:39"

// 示例 3：
// 输入：time = "1?:22"
// 输出："19:22"
public class Latest_Time_by_Replacing_Hidden_Digits {

    public String maximumTime2(String time) {
        char[] chars = time.toCharArray();
        if (chars[0] == '?') {
            chars[0] = chars[1] > '3' && chars[1] <= '9' ? '1' : '2';
        }

        if (chars[1] == '?') {
            chars[1] = chars[0] == '2' ? '3' : '9';
        }

        if (chars[3] == '?') {
            chars[3] = '5';
        }
        if (chars[4] == '?') {
            chars[4] = '9';
        }
        return new String(chars);
    }

    public String maximumTime(String time) {
        char[] result = new char[5];
        result[2] = ':';

        if (time.charAt(0) != '?') {
            result[0] = time.charAt(0);
            if (time.charAt(1) == '?') {
                if (result[0] == '2') {
                    result[1] = '3';
                } else {
                    result[1] = '9';
                }
            } else {
                result[1] = time.charAt(1);
            }
        } else {
            if (time.charAt(1) == '?') {
                result[0] = '2';
                result[1] = '3';
            } else {
                result[1] = time.charAt(1);
                if (((int) time.charAt(1)) - ((int) '0') < 4) {
                    result[0] = '2';
                } else {
                    result[0] = '1';
                }
            }
        }

        if (time.charAt(3) != '?') {
            result[3] = time.charAt(3);
        } else {
            result[3] = '5';
        }

        if (time.charAt(4) != '?') {
            result[4] = time.charAt(4);
        } else {
            result[4] = '9';
        }

        return new String(result);
    }

}
