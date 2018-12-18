package tony.leetcode.level.simple;

// 69. x 的平方根
// 实现 int sqrt(int x) 函数。
// 计算并返回 x 的平方根，其中 x 是非负整数。
// 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
//
// 示例 1:
// 输入: 4
// 输出: 2

// 示例 2:
// 输入: 8
// 输出: 2
// 说明: 8 的平方根是 2.82842...,
//      由于返回类型是整数，小数部分将被舍去。

public class SqrtX {

    // 这道题我日。。
    public int mySqrt(int x) {
        int low = 1; // low取0还是取1
        int high = x;

        while(low <= high){
            // 取上界而不是取下界，所以low从1开始
            int mid = (high + low) / 2;
            // 如果使用乘法则要考虑越界
            if(x / mid < mid){
                high = mid - 1;
            }else if(x / mid > mid){
                low = mid + 1;
            }else {
                return mid;
            }
        }
        // 返回值的考量
        return low-1;
    }

    public int mySqrt3(int x) {
        if (x == 0 || x == 1){
            return x;
        }
        int low = 0, high = x, mid = x/2;
        while (low < high){
            if (mid == x / mid){
                return mid;
            } else if (mid > x / mid){
                high = mid-1;
            } else {
                low = mid + 1;
            }
            mid = (low + high)/2;
        }
        if ((mid+1) <= x/(mid+1)){
            return mid + 1;
        } else if (mid <= x / mid){
            return mid;
        } else {
            return mid-1;
        }
    }

    // 超时
    public int mySqrt2(int x) {
        if (x == 0){
            return x;
        }
        int result = 0;
        while (result * result < x){
            result++;
        }
        if (result* result == x){
            return result;
        } else {
            return result-1;
        }
    }

    public static void main(String[] args){
        System.out.println(new SqrtX().mySqrt(8));
    }
}
