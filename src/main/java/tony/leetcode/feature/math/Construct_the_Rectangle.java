package tony.leetcode.feature.math;

public class Construct_the_Rectangle {

    // 492
    // 现给定一个具体的矩形页面面积，你的任务是设计一个长度为 L 和宽度为 W 且满足以下要求的矩形
    // 1. 你设计的矩形必须等于给定的目标面积。
    // 2. 宽度 W 不应大于长度 L，换言之，要求 L >= W 。
    // 3. 长度 L 和宽度 W 之间的差距应当尽可能小。

    // 输出数组[L,W]


    /**
     * 需要差距尽可能小，那么先进行开方，如果是完全平方数，那么再依次减少检查是否能够整除
     */
    public int[] constructRectangle(int area) {
        int[] re = new int[2];
        int sqrt = (int) Math.sqrt(area);
        if (sqrt * sqrt == area){
            re[0] = sqrt;
            re[1] = sqrt;
        } else {
            for (int i = 1; i <= sqrt;i++){
                if (area % i == 0){
                    re[1] = i;
                    re[0] = area / i;
                }
            }
        }
        return re;
    }
}
