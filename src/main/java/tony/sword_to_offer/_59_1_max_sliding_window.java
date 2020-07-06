package tony.sword_to_offer;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

// 59 - I. 滑动窗口的最大值
// 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
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

public class _59_1_max_sliding_window {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if (k <= 0 || k > len) {
            return new int[0];
        }
        int[] result = new int[len - k + 1];
        Deque<Integer> queue = new LinkedList<>();

        for (int i = 0; i < len;i++) {
            // 注意是小于 不是 小于等于
            while (null != queue.peekLast() && queue.peekLast() < nums[i]) {
                queue.pollLast();
            }
            queue.addLast(nums[i]);
            if (i >= k - 1) {
                result[i - k + 1] = queue.peekFirst();
                if (queue.peekFirst() == nums[i - k + 1]) {
                    queue.pollFirst();
                }
            }
        }

        return result;
    }

    public int[] maxSlidingWindow2(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return new int[0];
        }
        int[] res = new int[nums.length - k + 1];

        // 队列中存储属于窗口的下标值，这样可以快速判断是否需要poll掉头部
        Deque<Integer> queue = new LinkedList<>();
        for(int i = 0, j = 0; i < nums.length; i++) {
            // 此时队列里还没有i, 因此条件为 (i - 1) - queue.peek() + 1 >= k
            if(!queue.isEmpty() && i - queue.peek() >= k) {
                queue.poll();
            }
            while(!queue.isEmpty() && nums[i] > nums[queue.peekLast()]) {
                queue.pollLast();
            }
            queue.offer(i);
            if(i >= k - 1) {
                res[j++] = nums[queue.peek()];
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] ints = new _59_1_max_sliding_window().maxSlidingWindow2(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        System.out.println(Arrays.toString(ints));
    }

}
