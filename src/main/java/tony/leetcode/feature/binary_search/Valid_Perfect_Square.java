package tony.leetcode.feature.binary_search;

// 367. 有效的完全平方数
// 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
//
// 说明：不要使用任何内置的库函数，如  sqrt。
//
// 示例 1：
// 输入：16
// 输出：True

// 示例 2：
// 输入：14
// 输出：False

public class Valid_Perfect_Square {

    public boolean isPerfectSquare(int num) {
        if (num == 1){
            return true;
        }
        int left = 1, right = num/2;
        while (left <= right){
            int mid = left + (right-left)/2;
            int val = num / mid;
            if (val == mid && num % mid == 0){
                return true;
            }
            if (val > mid){
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return false;
    }
}
