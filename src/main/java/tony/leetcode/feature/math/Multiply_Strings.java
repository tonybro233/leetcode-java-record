package tony.leetcode.feature.math;

// 43. 字符串相乘
// 给定两个以字符串形式表示的非负整数 num1 和 num2，
// 返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
//
// 示例 1:
// 输入: num1 = "2", num2 = "3"
// 输出: "6"

// 示例 2:
// 输入: num1 = "123", num2 = "456"
// 输出: "56088"

// 说明：
// num1 和 num2 的长度小于110。
// num1 和 num2 只包含数字 0-9。
// num1 和 num2 均不以零开头，除非是数字 0 本身。
// 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。

public class Multiply_Strings {

    public String multiply2(String num1, String num2) {
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();
        // even 99 * 99 is < 10000, so maximaly 4 digits
        int[] d = new int[num1.length() + num2.length()];
        // 先不考虑进位进行各位相乘
        for (int i = 0; i < num1.length(); i++) {
            int a = num1.charAt(i) - '0';
            for (int j = 0; j < num2.length(); j++) {
                int b = num2.charAt(j) - '0';
                d[i + j] += a * b;
            }
        }
        StringBuilder sb = new StringBuilder();
        // 处理进位
        for (int i = 0; i < d.length; i++) {
            int digit = d[i] % 10;
            int carry = d[i] / 10;
            sb.insert(0, digit);
            if (i < d.length - 1) {
                d[i + 1] += carry;
            }
        }
        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public String multiply(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        for (int i = num1.length()-1; i >= 0; i--){
            int one = num1.charAt(i) - '0';
            int left = 0;
            int totalLeft = 0;
            for (int j = num2.length()-1; j >= 0;j--){
                int val = left + one * (num2.charAt(j)-'0');
                if (val > 9){
                    left = val / 10;
                    val = val % 10;
                } else {
                    left = 0;
                }
                int pos = (num1.length() - 1 - i) + (num2.length() - 1 - j);
                while (sb.length() < (pos + 1)){
                    sb.append('0');
                }
                int val2 = sb.charAt(pos) - '0' + val + totalLeft;
                if (val2 > 9){
                    totalLeft = val2 / 10;
                    val2 = val2 % 10;
                } else {
                    totalLeft = 0;
                }
                sb.setCharAt(pos, (char) ('0'+val2));
            }
            // 不要忘记剩余的内容处理
            totalLeft += left;
            if (totalLeft > 0){
                int pos = (num1.length() - 1 - i) + num2.length();
                while (true){
                    while (sb.length() < (pos + 1)){
                        sb.append('0');
                    }
                    int val3 = sb.charAt(pos) - '0' + totalLeft;
                    if (val3 > 9){
                        totalLeft = val3 / 10;
                        val3 = val3 % 10;
                        sb.setCharAt(pos++, (char) ('0'+val3));
                    } else {
                        sb.setCharAt(pos, (char) ('0'+val3));
                        break;
                    }
                }
            }
        }
        while (sb.length() > 0 && sb.charAt(sb.length()-1) == '0'){
            sb.deleteCharAt(sb.length()-1);
        }
        sb.reverse();
        if (sb.length() == 0){
            return "0";
        } else {
            return sb.toString();
        }
    }

    public static void main(String[] args){
        String multiply = new Multiply_Strings().multiply("123", "456");
        System.out.println(multiply);
    }
}
