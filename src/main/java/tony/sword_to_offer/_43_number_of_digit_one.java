package tony.sword_to_offer;

// 43. 1～n整数中1出现的次数
// 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
// 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。

public class _43_number_of_digit_one {

    // 这题想的头疼
    public int countDigitOne(int n) {
        if (n == 0) {
            return 0;
        }
        String s = Integer.toString(n);
        // 高位
        int high = s.charAt(0) - '0';
        // 2134 => 1000
        int powerBase = (int) Math.pow(10, s.length() - 1);
        // 去除高位后剩下的数字
        int last = n - high * powerBase;

        if (high == 1) {
            // 例如 1234
            // (1) dfs(powerBase - 1)代表[0,999]中1的个数;
            // (2) dfs(last)代表234中1出现的个数;
            // (3) last+1代表固定高位1有多少种情况。
            return countDigitOne(powerBase - 1) + countDigitOne(last) + (last + 1);
        } else {
            // 例如2234
            // (1) high * dfs(pow - 1)代表999以内和1999以内低三位1出现的个数;
            // (2) dfs(last)同上。
            // (3) powerBase代表固定高位1，有多少种情况;
            return high * countDigitOne(powerBase - 1) + countDigitOne(last) + powerBase;
        }

        // 即：
        // (1) 除了最高位以外剩下几位从0到最大值的1的个数 * 高位的范围(如3124 => 0,1,2 => 3)
        // (2) 去除最高位后, 剩下的几位的1的个数
        // (3) 最高位取1时, 有几种情况

    }

}
