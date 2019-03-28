package tony.codewar.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ObservedPin {

    private static Map<Character, char[]> map;

    static {
        map = new HashMap<>();
        map.put('0',new char[]{'0','8'});
        map.put('1',new char[]{'1','2','4'});
        map.put('2',new char[]{'1','2','3','5'});
        map.put('3',new char[]{'2','3','6'});
        map.put('4',new char[]{'1','4','5','7'});
        map.put('5',new char[]{'2','4','5','6','8'});
        map.put('6',new char[]{'3','5','6','9'});
        map.put('7',new char[]{'4','7','8'});
        map.put('8',new char[]{'5','7','8','9','0'});
        map.put('9',new char[]{'6','8','9'});
    }

    public static List<String> getPINs(String observed) {
        List<String> result = new ArrayList<>();
        go(observed.toCharArray(), 0, new StringBuilder(),result);
        return result;
    }

    private static void go(char[] chars, int pos, StringBuilder sb, List<String> result){
        if (pos == chars.length){
            result.add(sb.toString());
        } else {
            char[] cs = map.get(chars[pos]);
            for (int i = 0; i < cs.length; i++){
                sb.append(cs[i]);
                go(chars, pos+1, sb, result);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
}
