package tony.sword_to_offer;

// 46. 把数字翻译成字符串
// 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，
// 1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
// 一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
//
// 示例 1:
// 输入: 12258
// 输出: 5

// 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"

import java.util.ArrayList;
import java.util.List;

public class _46_translate_num {

    public int translateNum(int num) {
        if (num == 0) {
            return 1;
        }
        List<Integer> ints = new ArrayList<>();
        while (num != 0) {
            ints.add(num % 10);
            num /= 10;
        }
        int len = ints.size();
        int[] D = new int[len];
        D[0] = 1;
        for (int i = 1; i < len;i++) {
            D[i] = D[i - 1];
            int val = ints.get(i) * 10 + ints.get(i - 1);
            if (val >= 10 && val <= 25) {
                if (i > 1) {
                    D[i] += D[i - 2];
                } else {
                    D[i] += 1;
                }
            }
        }

        return D[len - 1];
    }

}
