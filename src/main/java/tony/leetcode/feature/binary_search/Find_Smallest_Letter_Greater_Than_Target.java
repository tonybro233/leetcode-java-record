package tony.leetcode.feature.binary_search;

// 744. 寻找比目标字母大的最小字母
// 给你一个排序后的字符列表 letters ，列表中只包含小写英文字母。
// 另给出一个目标字母 target，请你寻找在这一有序列表里比目标字母大的最小字母。
//
// 在比较时，字母是依序循环出现的。举个例子：
// 如果目标字母 target = 'z' 并且字符列表为 letters = ['a', 'b']，则答案返回 'a'
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
        int low = 0, high = letters.length - 1;
        if (letters[high] <= target) {
            return letters[0];
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (letters[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return letters[low];
    }
}
