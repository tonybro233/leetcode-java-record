package tony.leetcode.feature.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


// 17. Letter Combinations of a Phone Number
// 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
// 1       2(abc) 3(def)
// 4(ghi)  5(jkl) 6(mno)
// 7(pqrs) 8(tuv) 9(wxyz)

// 示例:
// 输入："23"
// 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// 说明: 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。

public class LetterCombinationsOfAPhoneNumber {

    private static Map<Character, char[]> map;
    static {
        map = new HashMap<>();
        map.put('2', new char[]{'a','b','c'});
        map.put('3', new char[]{'d','e','f'});
        map.put('4', new char[]{'g','h','i'});
        map.put('5', new char[]{'j','k','l'});
        map.put('6', new char[]{'m','n','o'});
        map.put('7', new char[]{'p','q','r','s'});
        map.put('8', new char[]{'t','u','v'});
        map.put('9', new char[]{'w','x','y','z'});
    }

    public List<String> letterCombinations(String digits) {
        char[] chars = digits.toCharArray();
        List<String> result = new ArrayList<>();
        if (chars.length == 0){
            return result;
        }
        go(chars, 0, new StringBuilder(), result);
        return result;
    }

    private void go(char[] chars, int pos, StringBuilder sb, List<String> result){
        if (pos == chars.length){
            result.add(sb.toString());
            return;
        }
        char[] member = map.get(chars[pos]);
        for (char ea : member){
            sb.append(ea);
            go(chars, pos+1, sb, result);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public List<String> letterCombinations2(String digits){
        List<String> sbList = new ArrayList<>();
        for(int i =0;i < digits.length();i++){
            char[] tmp = map.get(digits.charAt(i));
            List<String> tmpList = new ArrayList<>();
            for(char c : tmp){
                if(sbList.isEmpty()){
                    tmpList.add(String.valueOf(c));
                }else{
                    for(String s : sbList){
                        tmpList.add(s+c);
                    }
                }

            }
            sbList = tmpList;
        }
        return sbList;
    }
}
