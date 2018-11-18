package tony.leetcode.feature.array;

import java.util.Arrays;

public class Valid_Triangle_Number {

    // 611
    // 给定一个包含非负整数的数组，你的任务是统计其中可以组成三角形三条边的三元组个数。

    // 输入: [2,2,3,4]
    // 输出: 3
    // 解释:
    // 有效的组合是:
    // 2,3,4 (使用第一个 2)
    // 2,3,4 (使用第二个 2)
    // 2,2,3

    // 数组长度不超过1000。
    // 数组里整数的范围为 [0, 1000]。

    public static void main(String[] args){
        int i = new Valid_Triangle_Number().triangleNumber(new int[]{66,99,36,44,26,99,32,64,19,69});
        System.out.println(i);
    }

    /**
     * 需要注意注解的信息
     */
    public int triangleNumber(int[] nums) {
        int count = 0;
        if (nums.length < 3){
            return 0;
        }
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        for (int i = 0; i < nums.length - 2; i++){
            if (nums[i] == 0){
                continue;
            }
            for (int j = i+1; j < nums.length - 1;j++){
                int max = nums[i] + nums[j] - 1;
                int pos = Arrays.binarySearch(nums, j + 1, nums.length, max);
                if (pos < 0){
                    // 大于max的第一个位置为-pos-1
                    pos = -pos-2;
                } else {
                    // 等于max的第一个位置，可能有多个相同值
                    while (pos+1 < nums.length && nums[pos+1] == max){
                        pos++;
                    }
                }
                System.out.println(nums[i]+" "+nums[j]+" :"+(pos-j));
                count += pos - j;
            }
        }

        return count;
    }

    /**
     * 这种解法更简洁
     */
    public int triangleNumber2(int[] nums) {
        int n = nums.length;
        int res = 0;
        Arrays.sort(nums);
        for (int i = n - 1; i >= 2; i--) {
            int l = 0, r = i - 1;
            while (l < r) {
                if (nums[l] + nums[r] > nums[i]) {
                    res += r - l;
                    r--;
                }else {
                    l++;
                }
            }
        }
        return res;
    }
}
