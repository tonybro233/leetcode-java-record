package tony.sword_to_offer;

// 50. 第一个只出现一次的字符
// 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
//
// 示例:
// s = "abaccdeff"
// 返回 "b"

public class _50_unique_char {

    // 原题目并没有限制只有小写字母, 用的是8bit大小的c++ char
    public char firstUniqChar(String s) {
        int[] hash = new int[26];
        for (int i = 0; i < s.length();i++) {
            hash[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length();i++) {
            if (hash[s.charAt(i) - 'a'] == 1) {
                return s.charAt(i);
            }
        }

        return ' ';
    }

}
