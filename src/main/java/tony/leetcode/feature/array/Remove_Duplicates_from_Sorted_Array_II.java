package tony.leetcode.feature.array;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

// 80. 删除排序数组中的重复项 II
// 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
// 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
//
// 示例 1:
// 给定 nums = [1,1,1,2,2,3],
// 函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。
// 你不需要考虑数组中超出新长度后面的元素。

// 示例 2:
// 给定 nums = [0,0,1,1,1,1,2,3,3],
// 函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3 。
// 你不需要考虑数组中超出新长度后面的元素。

// 说明:
// 为什么返回数值是整数，但输出的答案是数组呢?
// 请注意，输入数组是以“引用”方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
// 你可以想象内部操作如下:
//      // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
//      int len = removeDuplicates(nums);
//
//      // 在函数里修改输入数组对于调用者是可见的。
//      // 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
//      for (int i = 0; i < len; i++) {
//          print(nums[i]);
//      }

public class Remove_Duplicates_from_Sorted_Array_II {

    public int removeDuplicates2(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length <= 2) {
            return nums.length;
        }
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            // 有序数列如此判断判断即可
            if (k < 2 || nums[i] != nums[k - 2]) {
                nums[k++] = nums[i];
            }
        }
        return k;
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Deque<Integer> skips = new ArrayDeque<>();
        int count = 1;
        int current = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (current == nums[i]) {
                if (count == 2) {
                    skips.addLast(i);
                } else {
                    count++;
                }
            } else {
                current = nums[i];
                count = 1;
            }
        }
        if (skips.size() == 0) {
            return nums.length;
        }
        int result = nums.length - skips.size();

        Integer skip = skips.pollFirst();
        int cursor = 0;
        for (int i = 0; i < nums.length; i++) {
            if (null == skip) {
                nums[cursor++] = nums[i];
            } else {
                if (skip != i) {
                    nums[cursor++] = nums[i];
                } else {
                    skip = skips.pollFirst();
                }
            }
        }

        return result;
    }
}
