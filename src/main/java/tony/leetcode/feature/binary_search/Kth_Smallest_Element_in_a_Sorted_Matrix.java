package tony.leetcode.feature.binary_search;

import java.util.PriorityQueue;

// 378. 有序矩阵中第K小的元素
// 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第k小的元素。
// 请注意，它是排序后的第k小元素，而不是第k个元素。
//
// 示例:
// matrix = [
//    [ 1,  5,  9],
//    [10, 11, 13],
//    [12, 13, 15]
// ],
// k = 8,
//
// 返回 13。
// 说明:
// 你可以假设 k 的值永远是有效的, 1 ≤ k ≤ n2 。

public class Kth_Smallest_Element_in_a_Sorted_Matrix {

    // 变体二分
    public int kthSmallest2(int[][] matrix, int k) {
        int n = matrix.length;
        int m = matrix[0].length;
        int low = matrix[0][0], high = matrix[n -  1][m - 1];
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (lessNum(matrix, mid) >= k) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    // 计算小于等于val的数量
    private int lessNum(int[][] matrix, int val) {
        int n = matrix.length;
        int m = matrix[0].length;
        int p = 0;
        int ans = 0;
        for (int i = n - 1; i >= 0; -- i) {
            while (p < m && matrix[i][p] <= val) {
                p ++ ;
            }
            ans += p;
        }
        return ans;
    }

    // 直接使用优先队列
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(n*n);
        for (int i = 0; i < n;i++){
            for (int j = 0; j < n; j++){
                priorityQueue.add(matrix[i][j]);
            }
        }
        int result = 0;
        for (int i = 0; i < k;i++){
            result = priorityQueue.poll();
        }

        return result;
    }

    public static void main(String[] args){
        int[][] ints = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        int i = new Kth_Smallest_Element_in_a_Sorted_Matrix().kthSmallest(ints, 5);
        System.out.println(i);
    }

}
