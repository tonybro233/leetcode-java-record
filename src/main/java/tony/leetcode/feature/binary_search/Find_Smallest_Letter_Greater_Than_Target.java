package tony.leetcode.feature.binary_search;

// 744. 寻找比目标字母大的最小字母
// 给定一个只包含小写字母的有序数组letters 和一个目标字母 target，
// 寻找有序数组里面比目标字母大的最小字母。
//
// 数组里字母的顺序是循环的。举个例子，如果目标字母target = 'z'
// 并且有序数组为 letters = ['a', 'b']，则答案返回 'a'。
//
// 示例:
//
// 输入:
// letters = ["c", "f", "j"]
// target = "a"
// 输出: "c"
//
// 输入:
// letters = ["c", "f", "j"]
// target = "c"
// 输出: "f"

public class Find_Smallest_Letter_Greater_Than_Target {

    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0, right = letters.length-1;
        if (letters[right] <= target){
            return letters[0];
        }
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (letters[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return letters[left];
    }
}
