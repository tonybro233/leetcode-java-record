package tony.leetcode.feature.heap;

import java.util.PriorityQueue;

// 215 数组中的第K个最大元素
// 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的
// 第 k 个最大的元素，而不是第 k 个不同的元素。
//
// 示例 1:
// 输入: [3,2,1,5,6,4] 和 k = 2
// 输出: 5

// 示例 2:
// 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
// 输出: 4
// 说明:
//
// 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。

public class Kth_Largest_Element_in_an_Array {

    public int findKthLargest(int[] nums, int k) {
        // 这题一眼看过去就是用大根堆，但是并不如排序后获取效率高，堆主要作用还是维护最大值
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(
                nums.length, (o1, o2) -> o2 - o1);
        for (int i : nums){
            priorityQueue.add(i);
        }
        int result = 0;
        for (int i = 0; i < k;i++){
            result = priorityQueue.poll();
        }

        return result;
    }
}
