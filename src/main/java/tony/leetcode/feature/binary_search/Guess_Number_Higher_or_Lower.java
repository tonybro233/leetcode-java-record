package tony.leetcode.feature.binary_search;

import com.sun.imageio.plugins.common.BogusColorSpace;

import java.time.Duration;
import java.time.Instant;
import java.time.Period;

public class Guess_Number_Higher_or_Lower {

    // 374
    // 我们正在玩一个猜数字游戏。 游戏规则如下：
    // 我从 1 到 n 选择一个数字。 你需要猜我选择了哪个数字。
    // 每次你猜错了，我会告诉你这个数字是大了还是小了。

    // 你调用一个预先定义好的接口 guess(int num)，它会返回 3 个可能的结果（-1，1 或 0）：
    // -1 : 我的数字比较小
    //  1 : 我的数字比较大
    //  0 : 恭喜！你猜对了！


    int targt = 1702766719;

    public static void main(String[] args){
        Instant begin = Instant.now();
        new Guess_Number_Higher_or_Lower().guess(2126753390);
        Instant end = Instant.now();
        System.out.println(Duration.between(begin, end));
    }

    public int guessNumber(int n) {
        int low = 1;
        int high = n;
        while (low <= high){
            // int mid = (low+high)/2;   // 越界
            int mid = low + (high - low) / 2;
            int re = guess(mid);
            if (0 == re){
                return mid;
            } else if (re < 0){
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return -1;
    }

    private int guess(int val){
        if (val == targt) {
            return 0;
        } else if (val < targt) {
            return -1;
        } else {
            return 1;
        }
    }
}
