package tony.leetcode.feature.math;

// 171. Excel表列序号
// 给定一个Excel表格中的列名称，返回其相应的列序号。
//
// 例如，
//
//     A -> 1
//     B -> 2
//     C -> 3
//     ...
//     Z -> 26
//     AA -> 27
//     AB -> 28
//     ...

public class Excel_Sheet_Column_Number {

    public int titleToNumber(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int result = 0;
        // for (int i = n-1; i >=0; i--){
        //     result += Math.pow(26, n - i - 1) * (1 + (chars[i] - 'A'));
        // }

        int base = 'A' - 1;
        for (int i = 0; i < n; i++){
            result = result * 26;
            result += chars[i] - base;
        }

        return result;
    }

}
