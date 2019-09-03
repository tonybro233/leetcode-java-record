package tony.leetcode.level.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

// 480. 滑动窗口中位数
// 中位数是有序序列最中间的那个数。如果序列的大小是偶数，则没有最中间的数；
// 此时中位数是最中间的两个数的平均数。
//
// 例如：
// [2,3,4]，中位数是 3
// [2,3]，中位数是 (2 + 3) / 2 = 2.5
//
// 给出一个数组 nums，有一个大小为 k 的窗口从最左端滑动到最右端。
// 窗口中有 k 个数，每次窗口移动 1 位。你的任务是找出每次窗口移动后得到的新窗口中元素的中位数，
// 并输出由它们组成的数组。
//
// 例如：
// 给出 nums = [1,3,-1,-3,5,3,6,7]，以及 k = 3。
//
// 窗口位置                      中位数
// ---------------               -----
// [1  3  -1] -3  5  3  6  7       1
//  1 [3  -1  -3] 5  3  6  7       -1
//  1  3 [-1  -3  5] 3  6  7       -1
//  1  3  -1 [-3  5  3] 6  7       3
//  1  3  -1  -3 [5  3  6] 7       5
//  1  3  -1  -3  5 [3  6  7]      6
//  因此，返回该滑动窗口的中位数数组 [1,-1,-1,3,5,6]。
//
// 提示：
// 假设k是合法的，即：k 始终小于输入的非空数组的元素个数.

public class Sliding_Window_Median {

    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        double[] result = new double[n - k + 1];

        List<Integer> list = new ArrayList<>();
        int j = 0;
        for(int i = 0; i < n; i++){
            if (i < k - 1) {
                list.add(nums[i]);
            } else if (i == k - 1){
                list.add(nums[i]);
                Collections.sort(list);
                // 必须先强转double，否则出现int越界
                result[j++] = ((double)list.get((k-1)/2)+(double)list.get(k/2))/2.0;
            } else {
                list.remove(Collections.binarySearch(list, nums[i-k]));
                int pos = Collections.binarySearch(list, nums[i]);
                pos = pos >= 0 ? pos : -(pos+1);
                list.add(pos, nums[i]);
                result[j++] = ((double)list.get((k-1)/2)+(double)list.get(k/2))/2.0;
            }
        }

        return result;
    }

    public double[] medianSlidingWindow2(int[] nums, int k) {
        double[] res = new double[nums.length - k + 1];
        PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> right = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            if (left.size() <= right.size()) {
                right.add(nums[i]);
                left.add(right.remove());
            } else {
                left.add(nums[i]);
                right.add(left.remove());
            }
            if (left.size() + right.size() == k) {
                double median;
                if (left.size() == right.size()) {
                    median = (double) ((long) left.peek() + (long) right.peek()) / 2;
                } else {
                    median = (double) left.peek();
                }
                int start = i - k + 1;
                res[start] = median;
                if (!left.remove(nums[start])) {
                    right.remove(nums[start]);
                }
            }
        }
        return res;
    }
}
