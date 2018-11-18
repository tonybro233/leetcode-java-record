package tony.leetcode.feature.hash;

import java.util.HashMap;
import java.util.Map;

public class Sort_Characters_By_Frequency {


    /**
     * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
     *
     * stream性能一般，不过1.8提供的map value比较器值得一看
     * @param s
     * @return
     */
    public String frequencySort(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char ea : chars){
            map.put(ea, map.getOrDefault(ea, 0)+1);
        }
        StringBuilder sb = new StringBuilder();
        map.entrySet().stream()
                .sorted(Map.Entry.<Character,Integer>comparingByValue().reversed())
                .forEachOrdered(e -> {
                    for (int i = 0; i < e.getValue();i++){
                        sb.append(e.getKey());
                    }
                });

        return sb.toString();

    }
}
