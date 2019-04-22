package tony.leetcode.feature.hash;

import java.util.*;

// 149. 直线上最多的点数
// 给定一个二维平面，平面上有 n 个点，求最多有多少个点在同一条直线上。
//
// 示例 1:
// 输入: [[1,1],[2,2],[3,3]]
// 输出: 3
// 解释:
// ^
// |
// |        o
// |     o
// |  o
// +------------->
// 0  1  2  3  4

// 示例 2:
// 输入: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
// 输出: 4
// 解释:
// ^
// |
// |  o
// |     o        o
// |        o
// |  o        o
// +------------------->
// 0  1  2  3  4  5  6

public class Max_Points_on_a_Line {

    class Point {
        int x;
        int y;
        Point() { x = 0; y = 0; }
        Point(int a, int b) { x = a; y = b; }
    }

    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n < 3){
            return n;
        }
        boolean[] mark = new boolean[n];
        int max = 0;
        Map<line, Integer> map = new HashMap<>();
        for (int i = 0; i < n-1;i++){
            if (mark[i]){
                continue;
            }
            int dup = 1;
            for (int j = i + 1; j < n; j++){
                if (points[j][0] == points[i][0] && points[j][1] == points[i][1]){
                    mark[j] = true;
                    dup++;
                }
            }
            max = Math.max(max, dup);
            Set<line> old = new HashSet<>(map.keySet());
            for (int j = i + 1; j < n; j++){
                if (points[j][0] == points[i][0] && points[j][1] == points[i][1]){
                    continue;
                }
                line line = getLine(points[i], points[j]);
                if (old.contains(line)){
                    continue;
                }
                int c = map.getOrDefault(line, dup)+1;
                max = Math.max(max, c);
                map.put(line, c);
            }
        }

        return max;
    }

    private line getLine(int[] p1, int[] p2){
        if (p1[0] == p2[0]){
            return new line(p1[0], Double.POSITIVE_INFINITY);
        } else {
            double ratio = (p2[1] - p1[1])*1000.0/(p2[0] - p1[0]);
            if (ratio == -0.0){
                ratio = 0.0;
            }
            double y = p1[1] - ratio*p1[0];
            return new line(y, ratio);
        }
    }

    class line {
        double y; // 直线经过y轴时的坐标值（或是垂线经过x轴的值）
        double ratio; // 斜率

        public line(double y, double ratio) {
            this.y = y;
            this.ratio = ratio;
        }

        @Override
        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (object == null || getClass() != object.getClass()) {
                return false;
            }
            line line = (line) object;
            return y == line.y &&  ratio == line.ratio;
        }

        @Override
        public int hashCode() {
            return Objects.hash(y, ratio);
        }
    }

    public static void main(String[] args){
        int i = new Max_Points_on_a_Line().maxPoints(new int[][]{{0,0},{94911151,94911150},{94911152,94911151}});
        System.out.print(i);
    }


}
