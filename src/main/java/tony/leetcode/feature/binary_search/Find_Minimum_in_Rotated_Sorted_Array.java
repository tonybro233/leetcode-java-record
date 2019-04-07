package tony.leetcode.feature.binary_search;

// 153. 寻找旋转排序数组中的最小值
// 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
//
// ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
//
// 请找出其中最小的元素。
//
// 你可以假设数组中不存在重复元素。
//
// 示例 1:
// 输入: [3,4,5,1,2]
// 输出: 1

// 示例 2:
// 输入: [4,5,6,7,0,1,2]
// 输出: 0

public class Find_Minimum_in_Rotated_Sorted_Array {

    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0) {
            return -1;
        }

        int low = 0, high = nums.length-1;
        while(low < high){
            int mid = low + (high - low) / 2;
            if (nums[mid] > nums[low]){
                if (nums[low] < nums[high]){
                    return nums[low];
                } else {
                    low = mid + 1;
                }
            } else if (nums[mid] < nums[low]){
                low++;
            } else {
                // low mid相等
                return Math.min(nums[low], nums[high]);
            }
        }

        return low;
    }

    public static void main(String[] args){
        int min = new Find_Minimum_in_Rotated_Sorted_Array().findMin(new int[]{3, 4, 5, 1, 2});
        System.out.println(min);
    }
}
