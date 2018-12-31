package tony.leetcode.feature.math;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// 537
// 给定两个表示复数的字符串。
// 返回表示它们乘积的字符串。注意，根据定义 i2 = -1 。

// 输入: "1+-1i", "1+-1i"
// 输出: "0+-2i"

public class Complex_Number_Multiplication {

    private static final Pattern pattern = Pattern.compile("^(-*\\d+)\\+(-*\\d+)i$");

    public String complexNumberMultiply(String a, String b) {
        // 获取matcher后需要调用方法才能真正进行解析，否则直接获取group报错
        Matcher matchera = pattern.matcher(a);
        matchera.matches();
        Matcher matcherb = pattern.matcher(b);
        matcherb.matches();
        int a1 = Integer.parseInt(matchera.group(1));
        int a2 = Integer.parseInt(matchera.group(2));
        int b1 = Integer.parseInt(matcherb.group(1));
        int b2 = Integer.parseInt(matcherb.group(2));
        int val1 = a1*b1 - a2*b2;
        int val2 = a1*b2 + a2*b1;

        if (val2 >= 0){
            return val1+"+"+val2+"i";
        }else {
            return val1+""+val2+"i";
        }


    }
}
