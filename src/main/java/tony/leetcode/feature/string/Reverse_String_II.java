package tony.leetcode.feature.string;

public class Reverse_String_II {

    // 541
    // 给定一个字符串和一个整数 k，你需要对从字符串开头算起的每个 2k 个字符的前k个字符进行反转。
    // 如果剩余少于 k 个字符，则将剩余的所有全部反转。
    // 如果有小于 2k 但大于或等于 k 个字符，则反转前 k 个字符，并将剩余的字符保持原样。

    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        if (chars.length < k){
            reverse(chars,0,chars.length-1);
        } else if (chars.length < 2*k){
            reverse(chars,0,k-1);
        } else {
            for (int i = 0; i < chars.length; i += 2*k){
                int ed = Math.min(chars.length-1,i+k-1);
                reverse(chars, i, ed);
            }
        }
        return new String(chars);
    }

    private void reverse(char[] chars, int a, int b){
        for (int i = a; i < b; i++, b--){
            char tmp = chars[a];
            chars[a] = chars[b];
            chars[b] = tmp;
        }
    }
}
