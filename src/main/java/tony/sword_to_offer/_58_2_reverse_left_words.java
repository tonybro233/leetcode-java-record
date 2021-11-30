package tony.sword_to_offer;

// 58 - II. 左旋转字符串
// 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
// 请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，
// 该函数将返回左旋转两位得到的结果"cdefgab"。
//
// 示例 1：
// 输入: s = "abcdefg", k = 2
// 输出: "cdefgab"

// 示例 2：
// 输入: s = "lrloseumgh", k = 6
// 输出: "umghlrlose"

public class _58_2_reverse_left_words {

    public String reverseLeftWords(String s, int n) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        n = n % len;
        if (n == 0) {
            return s;
        }
        reverse(chars, 0, len - 1);
        reverse(chars, 0, len - n - 1);
        reverse(chars, len - n, len - 1);
        return new String(chars);
    }

    private void reverse(char[] chars, int begin, int end) {
        while (begin < end) {
            char tmp = chars[begin];
            chars[begin] = chars[end];
            chars[end] = tmp;
            begin++;
            end--;
        }
    }

    // 狗头法
    public String reverseLeftWords2(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }

}
