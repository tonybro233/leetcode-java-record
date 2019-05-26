package tony.leetcode.feature.graph;

import java.util.*;

// 399. 除法求值
// 给出方程式 A / B = k, 其中 A 和 B 均为代表字符串的变量， k 是一个浮点型数字。
// 根据已知方程式求解问题，并返回计算结果。如果结果不存在，则返回 -1.0。
//
// 示例 :
// 给定 a / b = 2.0, b / c = 3.0
// 问题: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
// 返回 [6.0, 0.5, -1.0, 1.0, -1.0 ]
//
// 输入为: vector<pair<string, string>> equations,
//         vector<double>& values,
//         vector<pair<string, string>> queries
//         (方程式，方程式结果，问题方程式)，
// 其中 equations.size() == values.size()，即方程式的长度与方程式结果长度相等（程式与结果一一对应），
// 并且结果值均为正数。以上为方程式的描述。 返回vector<double>类型。
//
// 基于上述例子，输入如下：
// equations(方程式) = [ ["a", "b"], ["b", "c"] ],
// values(方程式结果) = [2.0, 3.0],
// queries(问题方程式) = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].

// 输入总是有效的。你可以假设除法运算中不会出现除数为0的情况，且不存在任何矛盾的结果。

public class Evaluate_Division {

    // 父子级记录
    Map<String, String> parents = new HashMap<>();
    // 子级是父级的几倍
    Map<String, Double> vals = new HashMap<>();

    // 常规解法是建立图，使用dfs
    // 这种解法相当于压缩整个图为单根形式
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int n = values.length;
        for (int i = 0; i < n;i++){
            List<String> equation = equations.get(i);
            String x = equation.get(0), y = equation.get(1);
            add(x); // 如果无父级，则添加自身为父级，val为1
            add(y); // 如果有父级，不做处理

            String px = find(x); // 递归获取根父级
            String py = find(y); // 递归过程中会把链路上的节点的父级都置为根父级并更新val值
            parents.put(px, py); // 添加两个节点的父子级关联，这个关联将在后续执行find函数时更新处理

            // x = vals.get(x) * px , y = vals.get(y) * py
            // px / py = x / y * vals.get(y) / vals.get(x)
            vals.put(px, values[i] * vals.get(y) / vals.get(x)); // 更新val值
        }

        int m = queries.size();
        double[] result = new double[m];
        for (int i = 0;i < m;i++){
            List<String> equation = queries.get(i);

            String x = equation.get(0);
            String y = equation.get(1);

            result[i] = (
                    parents.containsKey(x)
                    && parents.containsKey(y)
                    && find(x).equals(find(y))
            ) ? vals.get(x) / vals.get(y) : -1.0;
        }


        return result;
    }

    // 添加值，初始值父级为自身，取值为1
    private void add(String s) {
        if (parents.containsKey(s)) {
            return;
        }
        parents.put(s, s);
        vals.put(s, 1.0);
    }

    // 递归取父级
    private String find(String s) {
        String p = parents.getOrDefault(s, s);
        if (!s.equals(p)) {
            String pp = find(p);
            vals.put(s, vals.get(s) * vals.get(p));
            parents.put(s, pp);
        }
        return parents.getOrDefault(s, s);
    }

    public static void main(String[] args){
        List<List<String>> equations = new ArrayList<>();
        equations.add(new ArrayList<String>(){{add("a");add("b");}});
        equations.add(new ArrayList<String>(){{add("b");add("c");}});
        equations.add(new ArrayList<String>(){{add("d");add("e");}});
        equations.add(new ArrayList<String>(){{add("e");add("f");}});
        equations.add(new ArrayList<String>(){{add("b");add("f");}});
        double[] values = new double[]{2,2,3,3,4};

        List<List<String>> query = new ArrayList<>();
        query.add(new ArrayList<String>(){{add("a");add("e");}});
        query.add(new ArrayList<String>(){{add("b");add("d");}});
        double[] doubles = new Evaluate_Division().calcEquation(equations, values, query);
        System.out.println(Arrays.toString(doubles));
    }
}
