package tony.leetcode.level.simple;

// 58. 最后一个单词的长度
// 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
// 如果不存在最后一个单词，请返回 0 。
//
// 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
//
// 示例:
// 输入: "Hello World"
// 输出: 5

public class Length_of_Last_Word {

    // 审清题目即可，比较简单
    public int lengthOfLastWord(String s) {
        char[] chars = s.toCharArray();
        int count = 0;
        for (int i = chars.length - 1; i >=0;i--){
            if (chars[i] == ' '){
                if (count != 0) {
                    return count;
                }
            } else {
                count++;
            }
        }
        return count;
    }
}
