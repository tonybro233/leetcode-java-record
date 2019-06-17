package tony.leetcode.feature.string;

// 467. 环绕字符串中唯一的子字符串
// 把字符串 s 看作是“abcdefghijklmnopqrstuvwxyz”的无限环绕字符串，
// 所以 s 看起来是这样的："...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd....". 
//
// 现在我们有了另一个字符串 p 。你需要的是找出 s 中有多少个唯一的 p 的非空子串，
// 尤其是当你的输入是字符串 p ，你需要输出字符串 s 中 p 的不同的非空子串的数目。 
//
// 注意: p 仅由小写的英文字母组成，p 的大小可能超过 10000。
//
// 示例 1:
// 输入: "a"
// 输出: 1
// 解释: 字符串 S 中只有一个"a"子字符
//  
// 示例 2:
// 输入: "cac"
// 输出: 2
// 解释: 字符串 S 中的字符串“cac”只有两个子串“a”、“c”
//  
// 示例 3:
// 输入: "zab"
// 输出: 6
// 解释: 在字符串 S 中有六个子串“z”、“a”、“b”、“za”、“ab”、“zab”

public class Unique_Substrings_in_Wraparound_String {

    /**
     * 统计以每个字符作为结尾的最长连续序列(可以覆盖掉重复的短序列的情况), 他们的和即为所求
     * 例如:abcdbcd, 对于以d结尾的有abcd, bcd, cd和d, 而bcd产生的序列都会被abcd所覆盖
     * 总和即以a、b、c和d结尾的所有连续最长序列1 + 2 + 3 + 4 = 10
     */
    public int findSubstringInWraproundString(String p) {
        int n = p.length();
        if (n < 1) {
            return 0;
        }
        int ret = 0;
        int[] count = new int[26];
        char[] str = p.toCharArray();
        int curMaxLen = 1;
        for(int i = 0; i < n; ++i) {
            if (i > 0 && (str[i]-str[i-1] == 1 || str[i-1]-str[i] == 25)) {
                curMaxLen++;
            } else {
                curMaxLen = 1;
            }
            count[str[i]-'a'] = Math.max(count[str[i]-'a'], curMaxLen);
        }
        for(int temp : count) {
            ret += temp;
        }
        return ret;
    }

    // 错误
    public int findSubstringInWraproundString2(String p) {
        boolean[] mark = new boolean[52];
        int st = 0, ed = 0;
        char[] chars = p.toCharArray();
        int n = chars.length;

        int result = 0;
        while (st < n){
            ed = getEd(chars, n, st);
            result += validRange(mark, chars[st] - 'a', ed - st + 1);
            st = ed+1;
        }

        return result;
    }

    // 更新记录值
    private int validRange(boolean[] mark, int begin, int length){
        int le = 0, re = 0;
        int last = begin + length;
        for (int i = begin;i < last;i++){
            if (!mark[i]){
                le++;
                mark[i] = true;
                if (i > 25){
                    mark[i-26] = true;
                }
            } else {
                if (le > 0){
                    re += (1+le)*le/2;
                }
                le = 0;
            }
        }
        // 这里不对，例如ab已经占了，新来个c，增加的数量并不是1
        // 而且母串无限循环，这个解法根本不对
        if (le > 0){
            re += (1+le)*le/2;
        }
        return re;
    }

    // 获取连续的尾部
    private int getEd(char[] chars, int n,int st){
        int max = st+26;
        while (st < n-1 && st < max){
            if (chars[st+1] - chars[st] == 1 || (chars[st+1] == 'a' && chars[st] == 'z')){
                st++;
            } else {
                break;
            }
        }
        return st;
    }

    public static void main(String[] args){
        int i = new Unique_Substrings_in_Wraparound_String().findSubstringInWraproundString(
                "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz");
        System.out.println(i);
    }
}
