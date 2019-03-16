package tony.leetcode.level.hard;

// 42.接雨水
// 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。

// 示例:
// 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
// 输出: 6

public class Trapping_Rain_Water {

    public int trap(int[] height) {
        int n = height.length;
        if (n == 0){
            return 0;
        }
        int[] rmax = new int[n];
        int[] lmax = new int[n];
        rmax[0] = 0;
        for (int i = 1; i < n; i++){
            rmax[i] = Math.max(rmax[i-1], height[i-1]);
        }
        lmax[n-1] = 0;
        for (int i = n-2; i >= 0; i--){
            lmax[i] = Math.max(lmax[i+1], height[i+1]);
        }
        int result = 0;
        for (int i = 1; i < n-1; i++){
            int limit = Math.min(rmax[i], lmax[i]);
            if (limit > height[i]){
                result += limit - height[i];
            }
        }
        return result;
    }

    // 超时
    public int trap2(int[] height) {
        int n = height.length;
        int result = 0;
        int h = 1;
        while (true){
            int first = -1;
            for (int i = 0; i < n;i++){
                if (height[i] >= h){
                    first = i;
                    break;
                }
            }
            if (first == -1){
                break;
            }
            int temp = 0;
            boolean got = false;
            for (int i = first+1; i < n;i++){
                if (height[i] < h){
                    temp++;
                } else {
                    result+=temp;
                    temp = 0;
                    got = true;
                }
            }
            if (!got){
                break;
            }
            h++;
        }
        return result;
    }
}
