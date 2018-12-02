package tony.leetcode.feature.array;

import java.util.ArrayList;
import java.util.List;

// 283 移动零
// 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//
// 示例:
// 输入: [0,1,0,3,12]
// 输出: [1,3,12,0,0]

// 说明:
// 必须在原数组上操作，不能拷贝额外的数组。
// 尽量减少操作次数。

public class Move_Zeroes {

    public void moveZeroes(int[] nums) {
        List<Integer> zeros = new ArrayList<>();
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == 0){
                zeros.add(i);
            }
        }
        if (zeros.size() == 0 || zeros.size() == nums.length){
            return;
        }
        for (int i = 0; i < zeros.size(); i++){
            if (i == zeros.size()-1){
                for (int j = zeros.get(i); j < nums.length - 1;j++){
                    nums[j-i] = nums[j+1];
                }

            } else {
                for (int j = zeros.get(i); j < zeros.get(i+1) - 1;j++){
                    nums[j-i] = nums[j+1];
                }
            }
        }
        int i = nums.length-1;
        int count = zeros.size();
        while (count > 0){
            nums[i--] = 0;
            count--;
        }
    }

    // 更加优雅的写法，核心思想是双指针
    public void moveZeroes2(int[] nums) {
        int index = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }
        for(int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
