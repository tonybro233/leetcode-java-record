package tony.leetcode.feature.hash;

import java.util.HashMap;

public class Number_of_Boomerangs {

    // 447
    // 给定平面上 n 对不同的点，“回旋镖” 是由点表示的元组 (i, j, k) ，
    // 其中 i 和 j 之间的距离和 i 和 k 之间的距离相等（需要考虑元组的顺序）。
    //
    // 找到所有回旋镖的数量。你可以假设 n 最大为 500，所有点的坐标在闭区间 [-10000, 10000] 中。

    // 输入: [[0,0],[1,0],[2,0]]
    // 输出: 2
    // 解释:
    // 两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]

    public static void main(String[] args){
        int[][] input = {{0,0},{1,0},{-1,0},{0,1},{0,-1}};
        int re = new Number_of_Boomerangs().numberOfBoomerangs(input);
        System.out.print(re);
    }


    /**
     * 使用map记录距离(key)和边数(value)，注意j、k位置可以互换，每多一条边数量要增加原本的2倍
     */
    public int numberOfBoomerangs(int[][] points) {
        int count = 0;
        int n = points.length;
        // 直接统计距离过来就可以
        for (int i = 0; i < n; i++) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < n; j++) {
                int dis = (points[i][0] - points[j][0]) * (points[i][0] - points[j][0]) + (points[i][1] - points[j][1]) * (points[i][1] - points[j][1]);
                if (!map.containsKey(dis)) {
                    map.put(dis, 0);
                }
                count += map.get(dis) * 2;
                map.put(dis, map.get(dis) + 1);
            }
        }
        return count;
    }

    // 超时
    public int numberOfBoomerangs2(int[][] points) {
        int pcount = points.length;
        if (pcount < 3){
            return 0;
        }
        int total = 0;
        for (int i = 0 ; i < pcount; i++){
            for (int j = 0; j < pcount; j++){
                if (i == j){
                    continue;
                }
                for (int k = 0; k < pcount; k++ ){
                    if (j == k || i == k){
                        continue;
                    }
                    if (distance(points[i],points[j]) == distance(points[i],points[k])){
                        System.out.println(i+" "+j+" "+k);
                        total++;
                    }
                }
            }
        }
        return total;
    }

    private double distance(int[] point1, int[] point2){
        return Math.sqrt((point1[0] - point2[0])*(point1[0] - point2[0])+(point1[1] - point2[1])*(point1[1] - point2[1]));
    }
}
