package tony.leetcode.feature.math;

// 504
// 给定一个整数，将其转化为7进制，并以字符串形式输出。
// 输入: 100
// 输出: "202"

// 注意: 输入范围是 [-1e7, 1e7] 。

public class Base7 {

    public static void main(String[] args){
        String s = new Base7().convertToBase7(100);
        System.out.println(s);
    }

    public String convertToBase72(int num) {
        String data = Integer.toString(num, 7);
        return data;
    }

    public String convertToBase7(int num) {
        boolean b = false;
        if (num < 0){
            b = true;
            num = -num;
        }
        int c = 1;
        int copy = num;
        while (copy / 7 > 0){
            c++;
            copy /= 7;
        }
        copy = num;
        StringBuilder sb = new StringBuilder();
        if (b){
            sb.append("-");
        }
        for (int i = 1; i <= c;i++){
            int ea = copy / (int)(Math.pow(7,c-i));
            char eac = (char) ('0' + ea);
            sb.append(eac);
            copy -= ea * (Math.pow(7,c-i));
        }
        return sb.toString();
    }
}
