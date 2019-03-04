package tony.leetcode.feature.queue;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

// 239. 滑动窗口最大值
// 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
// 你只可以看到在滑动窗口 k 内的数字。滑动窗口每次只向右移动一位。
//
// 返回滑动窗口最大值。
//
// 示例:
// 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
// 输出: [3,3,5,5,6,7]

// 解释:
//   滑动窗口的位置                最大值
// ---------------               -----
// [1  3  -1] -3  5  3  6  7       3
//  1 [3  -1  -3] 5  3  6  7       3
//  1  3 [-1  -3  5] 3  6  7       5
//  1  3  -1 [-3  5  3] 6  7       5
//  1  3  -1  -3 [5  3  6] 7       6
//  1  3  -1  -3  5 [3  6  7]      7

// 注意：
// 你可以假设 k 总是有效的，1 ≤ k ≤ 输入数组的大小，且输入数组不为空。
//
// 进阶：
// 你能在线性时间复杂度内解决此题吗？

public class Sliding_Window_Maximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 0){
            return new int[0];
        }
        // 维护下标队列，保持头部下标对应的值最大
        Deque<Integer> windows = new LinkedList<>();
        int j = 0;
        int[] result = new int[nums.length - k + 1];
        for(int i = 0; i < nums.length; i++){
            // 检查当前的最大值是否已经离开窗口
            if(i >= k && windows.peekFirst() <= i-k) {
                windows.pollFirst();
            }
            // 保证尾部左侧没有比当前值更大的下标
            while(!windows.isEmpty() && nums[windows.peekLast()] <= nums[i]) {
                windows.pollLast();
            }
            // 当前下标加入尾部
            windows.addLast(i);

            if(i >= k - 1) {
                // 开始出现完整的窗口
                result[j++] = nums[windows.peekFirst()];
            }
        }
        return result;
    }

    public static void main(String[] args){
        int[] ints = new Sliding_Window_Maximum().maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        System.out.println(Arrays.toString(ints));
    }
}
