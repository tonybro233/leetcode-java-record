package tony.leetcode.feature.array;

import java.util.*;

public class Next_Greater_Element_II {

    /**
     * 503
     *
     * 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。
     * 数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，
     * 这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。
     *
     *
         输入: [1,2,1]
         输出: [2,-1,2]
         解释: 第一个 1 的下一个更大的数是 2；
         数字 2 找不到下一个更大的数；
         第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
     *
     * 注意: 输入数组的长度不会超过 10000。
     */


    public int[] nextGreaterElements2(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        int len  = nums.length;

        int[] res = new int[len];
        Arrays.fill(res, -1);
        for (int i = 0; i < 2 * len; i++) {
            int num = nums[(i+len) % len];
            while (!stack.isEmpty() && num > nums[stack.peek()]) {
                res[stack.pop()] = num;
            }
            // use for second round
            if (i < len) {
                stack.push(i);
            }
            if (stack.isEmpty()) {
                break;
            }
        }

        return res;
    }

    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length;i++){
            boolean get = false;
            int value = -1;
            for (int j = i+1; j< nums.length;j++){
                if (nums[j] > nums[i]){
                    get = true;
                    value = nums[j];
                    break;
                }
            }
            if (get){
                result[i] = value;
                continue;
            }
            for (int j = 0; j < i;j++){
                if (nums[j] > nums[i]){
                    get = true;
                    value = nums[j];
                    break;
                }
            }
            if (get){
                result[i] = value;
            } else {
                result[i] = -1;
            }
        }
        return result;
    }

    // 这种写法要求数组内的值不能重复，但是题目里没有规定不能重复
    public int[] nextGreaterElements3(int[] nums) {
        int[] result = new int[nums.length];
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for (int i = 0; i < nums.length;i++){
            map.put(nums[i],i);
        }
        for (int i = 0; i < nums.length;i++){
            int min = Integer.MAX_VALUE, maxmin = Integer.MAX_VALUE;
            int val = nums[i];
            while (true) {
                Map.Entry<Integer, Integer> entry = map.higherEntry(val);
                if (null != entry){
                    Integer pos = entry.getValue();
                    if (pos > i && pos < maxmin){
                        maxmin = pos;
                    } else if (pos < i && pos < min){
                        min = pos;
                    }
                } else {
                    break;
                }
                val = entry.getKey();
            }
            if (min == Integer.MAX_VALUE && maxmin == Integer.MAX_VALUE){
                result[i] = -1;
            } else if (maxmin != Integer.MAX_VALUE){
                result[i] = nums[maxmin];
            } else {
                result[i] = nums[min];
            }
        }
        return result;
    }
}
