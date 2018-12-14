package tony.leetcode.level.simple;

// 67
// 给定两个二进制字符串，返回他们的和（用二进制表示）。
// 输入为非空字符串且只包含数字 1 和 0。
//
// 示例 1:
// 输入: a = "11", b = "1"
// 输出: "100"

// 示例 2:
// 输入: a = "1010", b = "1011"
// 输出: "10101"

public class Add_Binary {

    public String addBinary(String a, String b) {
        char[] ac = a.toCharArray();
        char[] bc = b.toCharArray();
        int i = ac.length-1, j = bc.length - 1;
        StringBuilder sb = new StringBuilder();

        int left = 0;
        while (i >= 0 || j >= 0){
            int val = left;
            if (i >= 0){
                val += ac[i] - '0';
                i--;
            }
            if (j >= 0){
                val += bc[j] - '0';
                j--;
            }
            sb.append(val % 2);
            left = val / 2;
        }
        // 这种维护额外值的东西一定要记得循环结束后处理维护值
        if (left != 0){
            sb.append('1');
        }
        for (int k = sb.length()-1;k >= 0;k--){
            if ('0' == sb.charAt(k)){
                sb.deleteCharAt(k);
            } else {
                break;
            }
        }

        if (sb.length() > 0){
            return sb.reverse().toString();
        } else {
            return "0";
        }
    }

    public static void main(String[] args){
        new Add_Binary().addBinary("11","1");
    }
}
