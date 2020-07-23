package tony.sword_to_offer;

// 11. 旋转数组的最小数字
// 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
// 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
// 例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
//
// 示例 1：
// 输入：[3,4,5,1,2]
// 输出：1

// 示例 2：
// 输入：[2,2,2,0,1]
// 输出：0

public class _11_min_in_rotated_array {

    public int minArray(int[] numbers) {
        if (null == numbers || numbers.length == 0) {
            throw new IllegalArgumentException();
        }

        int low = 0, high = numbers.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;

            // if (numbers[mid] < numbers[low]) { // 这样也可以
            if (numbers[mid] < numbers[high]) {
                high = mid;
            } else if (numbers[mid] > numbers[high]) {
                low = mid + 1;
            } else {
                high--;
            }
        }

        return numbers[low];
    }

    public static void main(String[] args) {
        int i = new _11_min_in_rotated_array().minArray(new int[]{3, 3, 1, 3});
        System.out.println(i);
    }

}
