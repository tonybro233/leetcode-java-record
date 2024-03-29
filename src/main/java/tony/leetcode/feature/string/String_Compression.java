package tony.leetcode.feature.string;

// 443. 压缩字符串
// 给定一组字符，使用原地算法将其压缩。
// 压缩后的长度必须始终小于或等于原数组长度。
// 数组的每个元素应该是长度为1 的字符（不是 int 整数类型）。
// 在完成原地修改输入数组后，返回数组的新长度。
//
// 进阶：
// 你能否仅使用O(1) 空间解决问题？
//
// 示例 1：
// 输入：["a","a","b","b","c","c","c"]
// 输出：6，数组的前6个字符应该是：["a","2","b","2","c","3"]
// 说明：
// "aa"被"a2"替代。"bb"被"b2"替代。"ccc"被"c3"替代。

// 示例 2：
// 输入：["a"]
// 输出：1，数组的前1个字符应该是：["a"]
// 说明：
// 没有任何字符串被替代。

// 示例 3：
// 输入：["a","b","b","b","b","b","b","b","b","b","b","b","b"]
// 输出：4，数组的前4个字符应该是：["a","b","1","2"]。
// 说明：
// 由于字符"a"不重复，所以不会被压缩。"bbbbbbbbbbbb"被“b12”替代。
// 注意每个数字在数组中都有它自己的位置。

// 注意：
// 所有字符都有一个ASCII值在[35, 126]区间内。
// 1 <= len(chars) <= 1000。

import java.util.Arrays;

public class String_Compression {


    public int compress2(char[] chars) {
        int res = 0;
        int cnt = 1;
        char mark = chars[0];

        for (int i = 1; i < chars.length; i++) {
            if (chars[i] != mark) {
                res = modify(chars, res, cnt, mark);
                mark = chars[i];
                cnt = 1;
            } else {
                cnt++;
            }
        }

        res = modify(chars, res, cnt, mark);

        return res;
    }

    private int modify(char[] chars, int res, int cnt, char mark) {
        chars[res++] = mark;
        if (cnt > 1) {
            char[] nums = Integer.toString(cnt).toCharArray();
            for (char num : nums) {
                chars[res++] = num;
            }
        }
        return res;
    }



    public int compress(char[] chars) {
        Character before = null;
        int count = 0;
        int cursor = 0;
        for (int i = 0; i < chars.length; i++){
            if (null == before){
                count = 1;
                cursor = 1;
            } else {
                if (before.equals(chars[i])){
                    count++;
                } else {
                    if (count > 1){
                        char[] tmp = (count + "").toCharArray();
                        for (int j = 0; j < tmp.length;j++){
                            chars[cursor++] = tmp[j];
                        }
                    }
                    chars[cursor] = chars[i];
                    cursor++;
                    count = 1;
                }
            }
            before = chars[i];
        }
        if (count > 1){
            char[] tmp = (count + "").toCharArray();
            for (int j = 0; j < tmp.length;j++){
                chars[cursor++] = tmp[j];
            }
        }

        return cursor;
    }

    public static void main(String[] args){
        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        int compress = new String_Compression().compress(chars);
        System.out.println(compress);
        System.out.println(Arrays.toString(Arrays.copyOfRange(chars, 0, compress)));
    }
}
