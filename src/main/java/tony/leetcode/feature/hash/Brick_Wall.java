package tony.leetcode.feature.hash;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Brick_Wall {

    // 554
    // 你的面前有一堵方形的、由多行砖块组成的砖墙。 这些砖块高度相同但是宽度不同。
    // 你现在要画一条自顶向下的、穿过最少砖块的垂线。

    // 砖墙由行的列表表示。 每一行都是一个代表从左至右每块砖的宽度的整数列表。
    // 如果你画的线只是从砖块的边缘经过，就不算穿过这块砖。
    // 你需要找出怎样画才能使这条线穿过的砖块数量最少，并且返回穿过的砖块数量。

    // 你不能沿着墙的两个垂直边缘之一画线，这样显然是没有穿过一块砖的。

    /**
     * 每行分别递增求和置入map，求和数出现频率最大的次数即为解
     */
    public int leastBricks(List<List<Integer>> wall) {
        int rowcount = wall.size();
        Map<Integer,Integer> map = new HashMap<>();
        for (List<Integer> row : wall){
            int val = 0;
            for (int i = 0; i < row.size()-1;i++){
                val += row.get(i);
                map.put(val, map.getOrDefault(val,0) + 1);
                // 可以在这里取最小的count，就不需要再进行一次循环
            }
        }
        int maxhit = 0;
        for (Map.Entry<Integer,Integer> entry : map.entrySet()){
            maxhit = Math.max(entry.getValue(),maxhit);
        }
        return rowcount - maxhit;
    }
}
