package tony.leetcode.feature.math;

// 168. Excel表列名称
// 给定一个正整数，返回它在 Excel 表中相对应的列名称。
//
// 例如，
//     1 -> A
//     2 -> B
//     3 -> C
//     ...
//     26 -> Z
//     27 -> AA
//     28 -> AB
//     ...

public class Excel_Sheet_Column_Title {

    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            n--;
            int c = n % 26;
            sb.append((char) (c + 'A'));
            n = n / 26;
        }
        sb.reverse();
        return sb.toString();
    }
}
