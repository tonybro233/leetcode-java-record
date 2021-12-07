package tony.leetcode.feature.array.double_pointer;

// 125. 验证回文串
// 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。

// 说明：本题中，我们将空字符串定义为有效的回文串。
//
// 示例 1:
// 输入: "A man, a plan, a canal: Panama"
// 输出: true

// 示例 2:
// 输入: "race a car"
// 输出: false

public class Valid_Palindrome {

    public boolean isPalindrome(String s) {
        if (null == s || "".equals(s)) {
            return true;
        }
        char[] chars = s.toCharArray();
        int cur1 = 0, cur2 = chars.length - 1;
        while (cur2 > cur1) {
            while (cur1 < chars.length && !Character.isLetterOrDigit(chars[cur1])) {
                cur1++;
            }
            while (cur2 >= 0 && !Character.isLetterOrDigit(chars[cur2])) {
                cur2--;
            }
            if (cur1 >= cur2) {
                return true;
            }
            if (Character.toLowerCase(chars[cur1++]) != Character.toLowerCase(chars[cur2--])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean op = new Valid_Palindrome().isPalindrome("OP");
        System.out.println(op);
    }
}
