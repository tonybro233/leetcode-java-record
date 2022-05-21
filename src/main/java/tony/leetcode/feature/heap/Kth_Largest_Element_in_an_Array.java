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

    public int findKthLargest3(int[] nums, int k) {
        // 快排优化
        return sort(nums, 0, nums.length - 1, k);
    }

    private int sort(int[] nums, int low, int high, int k) {
        int mid = partition(nums, low, high);
        int rightCount = high - mid + 1; // 包括mid在内mid右边有几个
        if (rightCount == k) {
            // 正好切分到第k个
            return nums[mid];
        } else if (rightCount > k) {
            // 超过k个大值，搜右区间
            return sort(nums, mid + 1, high, k);
        } else {
            // 不到k个大值，搜左区间
            return sort(nums, low, mid - 1, k - rightCount);
        }
    }

    private int partition(int[] nums, int low, int high) {
        int mid = low + (high - low) / 2;
        int val = nums[mid];
        exch(nums, mid, high);
        int pivot = low - 1;
        for (int i = low; i <= high; i++) {
            if (nums[i] <= val) {
                pivot++;
                if (pivot < i) {
                    exch(nums, pivot, i);
                }
            }
        }
        return pivot;
    }

    public int findKthLargest2(int[] nums, int k) {
        // 堆排序
        // 从大到小做下沉操作构建堆结构
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            sink(nums, i, nums.length);
        }

        // 头部交换到尾部做下沉，依次取出最大值
        for (int i = 1; i <= k; i++) {
            exch(nums, 0, nums.length - i);
            sink(nums, 0, nums.length - i);
        }

        return nums[nums.length - k];
    }

    private void sink(int[] nums, int idx, int limit) {
        int next;
        while ((next = (idx + 1) * 2 - 1) < limit) {
            if (next + 1 < limit && nums[next + 1] > nums[next]) {
                next++;
            }
            if (nums[idx] < nums[next]) {
                exch(nums, idx, next);
                idx = next;
            } else {
                break;
            }
        }
    }

    private void exch(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

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
