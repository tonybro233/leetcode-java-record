package tony.leetcode.feature.math;

// 593
// 给定二维空间中四点的坐标，返回四点是否可以构造一个正方形。
// 一个点的坐标（x，y）由一个有两个整数的整数数组表示。

// 输入: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
// 输出: True

// 所有输入整数都在 [-10000，10000] 范围内。
// 一个有效的正方形有四个等长的正长和四个等角（90度角）。
// 输入点没有顺序。

public class Valid_Square {

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        if (same(p1,p2) || same(p1,p3) || same(p1,p4) || same(p2,p3) || same(p2,p4) || same(p3,p4)){
            return false;
        }
        if (0 == dotProduct(p1,p2,p3) && 0 == dotProduct(p4,p2,p3)){
            if (length(p1,p2) == length(p1,p3)){
                return true;
            }
        } else if (0 == dotProduct(p1,p2,p4) && 0 == dotProduct(p3,p2,p4)){
            if (length(p1,p2) == length(p1,p4)){
                return true;
            }
        } else if (0 == dotProduct(p2,p3,p4) && 0 == dotProduct(p1,p3,p4)){
            if (length(p2,p3) == length(p2,p4)){
                return true;
            }
        } else {
            return false;
        }

        return false;
    }

    private boolean same(int[] a, int[] b){
        return a[0] == b[0] && a[1] == b[1];
    }

    private int dotProduct(int[] a, int[] b, int[] c){
        int labx = b[0] - a[0];
        int laby = b[1] - a[1];
        int lacx = c[0] - a[0];
        int lacy = c[1] - a[1];
        return labx*lacx + laby*lacy;
    }

    private double length(int[] a, int[] b){
        return Math.sqrt((b[0] - a[0])*(b[0] - a[0]) + (b[1] - a[1])*(b[1] - a[1]));
    }
}
