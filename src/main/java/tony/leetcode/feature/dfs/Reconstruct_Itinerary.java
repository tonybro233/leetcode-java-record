package tony.leetcode.feature.dfs;

import java.util.*;

// 332. 重新安排行程
//
// 给定一个机票的字符串二维数组 [from, to]，子数组中的两个成员分别表示飞机出发和降落的机场地点，对该行程进行重新规划排序。
// 所有这些机票都属于一个从JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 出发。
//
// 说明:
//
// 如果存在多种有效的行程，你可以按字符自然排序返回最小的行程组合。
// 例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前
// 所有的机场都用三个大写字母表示（机场代码）。
// 假定所有机票至少存在一种合理的行程。

// 示例 1:
// 输入: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
// 输出: ["JFK", "MUC", "LHR", "SFO", "SJC"]

// 示例 2:
// 输入: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
// 输出: ["JFK","ATL","JFK","SFO","ATL","SFO"]
// 解释: 另一种有效的行程是 ["JFK","SFO","ATL","JFK","ATL","SFO"]。但是它自然排序更大更靠后。

public class Reconstruct_Itinerary {


    public List<String> findItinerary(String[][] tickets) {
        List<String> result = new ArrayList<>();
        // 使用map构建图结构，value类型使用PriorityQueue保证顺序
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for (String[] ticket : tickets){
            PriorityQueue<String> queue = map.getOrDefault(ticket[0], new PriorityQueue<>());
            queue.add(ticket[1]);
            map.put(ticket[0], queue);
        }

        // 使用dfs得到结果的反向值
        dfs(map, "JFK", result);
        Collections.reverse(result);
        return result;
    }

    private void dfs(Map<String, PriorityQueue<String>> que, String dest, List<String> result){
        PriorityQueue<String> set = que.get(dest);
        while (set != null && set.size() > 0){
            Iterator<String> it = set.iterator();
            String next = it.next();
            it.remove();
            dfs(que, next, result);
        }
        // 后置加入所以结果是反的
        result.add(dest);
    }

    public static void main(String[] args){
        String[] t1 = new String[]{"MUC","LHR"};
        String[] t2 = new String[]{"JFK","MUC"};
        String[] t3 = new String[]{"SFO","SJC"};
        String[] t4 = new String[]{"LHR","SFO"};
        String[][] tickets = new String[][]{t1,t2,t3,t4};
        List<String> itinerary = new Reconstruct_Itinerary().findItinerary(tickets);
        System.out.println(itinerary);

    }
}
