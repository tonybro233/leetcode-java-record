package tony.leetcode.feature.dynamic_program;

import java.util.*;

// 403. 青蛙过河
// 一只青蛙想要过河。 假定河流被等分为 x 个单元格，并且在每一个单元格内都有可能放有一石子（也有可能没有）。
// 青蛙可以跳上石头，但是不可以跳入水中。
// 给定石子的位置列表（用单元格序号升序表示）， 请判定青蛙能否成功过河（即能否在最后一步跳至最后一个石子上）。
// 开始时， 青蛙默认已站在第一个石子上，并可以假定它第一步只能跳跃一个单位（即只能从单元格1跳至单元格2）。
//
// 如果青蛙上一步跳跃了 k 个单位，那么它接下来的跳跃距离只能选择为 k - 1、k 或 k + 1个单位。
// 另请注意，青蛙只能向前方（终点的方向）跳跃。
//
// 请注意：
//
// 石子的数量 ≥ 2 且 < 1100；
// 每一个石子的位置序号都是一个非负整数，且其 < 231；
// 第一个石子的位置永远是0。

// 示例 1:
// [0,1,3,5,6,8,12,17]
//
// 总共有8个石子。
// 第一个石子处于序号为0的单元格的位置, 第二个石子处于序号为1的单元格的位置,
// 第三个石子在序号为3的单元格的位置， 以此定义整个数组...
// 最后一个石子处于序号为17的单元格的位置。
//
// 返回 true。即青蛙可以成功过河，按照如下方案跳跃：
// 跳1个单位到第2块石子, 然后跳2个单位到第3块石子, 接着
// 跳2个单位到第4块石子, 然后跳3个单位到第6块石子,
// 跳4个单位到第7块石子, 最后，跳5个单位到第8个石子（即最后一块石子）。

// 示例 2:
// [0,1,2,3,4,8,9,11]
//
// 返回 false。青蛙没有办法过河。
// 这是因为第5和第6个石子之间的间距太大，没有可选的方案供青蛙跳跃过去。

public class Frog_Jump {

    public boolean canCross4(int[] stones) {
        for (int i = 3; i < stones.length; i++) {
            if (stones[i] > 2 * stones[i - 1]) {
                return false;
            }
        }
        return stones[1] == 1 && dfs(1, 1, stones);
    }

    /**
     * @param i      石头下标
     * @param k      步数
     * @param stones 石头数组
     */
    private boolean dfs(int i, int k, int[] stones) {
        if (i < 0 || k <= 0) {
            return false;
        }
        if (i == stones.length - 1) {
            return true;
        }
        int plusOne = Arrays.binarySearch(stones, stones[i] + k + 1);
        int equalOne = Arrays.binarySearch(stones, stones[i] + k);
        int minusOne;
        if (k == 1) {
            minusOne = -1;
        } else {
            minusOne = Arrays.binarySearch(stones, stones[i] + k - 1);
        }
        return dfs(plusOne, k + 1, stones) || dfs(equalOne, k, stones) || dfs(minusOne, k - 1, stones);
    }

    // 石头的值是不重复的
    // 使用石头值和到达石头的步数集合作为map进行操作
    public boolean canCross3(int[] stones) {
        if (stones[1] != 1) {
            return false;
        }
        int n = stones.length;
        Map<Integer, Set<Integer>> D = new HashMap<>();
        for (int i = 0; i < n; i++) {
            D.put(stones[i], new HashSet<>());
        }
        D.get(0).add(0);
        for (int i = 0; i < n - 1; i++) {
            for (int k : D.get(stones[i])) {
                for (int j = k - 1; j <= k + 1; j++) {
                    if (j > 0 && D.containsKey(stones[i] + j)) {
                        D.get(stones[i] + j).add(j);
                    }
                }
            }
        }
        return D.get(stones[n - 1]).size() > 0;
    }

    // 同样超时
    public boolean canCross2(int[] stones) {
        if (stones[1] != 1) {
            return false;
        }
        int n = stones.length;
        List<Integer>[] D = new List[n];
        // List数组，第一个值作为石头本身的值，后续为达到这个石头的步数值
        for (int i = 0; i < n; i++) {
            D[i] = new ArrayList<>();
            D[i].add(stones[i]);
        }
        D[1].add(1);
        for (int i = 1; i < n; i++) {
            if (1 == D[i].size()) {
                continue;
            }
            for (int j = 1; j < D[i].size(); j++) {
                int val = D[i].get(j);
                for (int k = i + 1; k < n; k++) {
                    if (D[k].get(0) == D[i].get(0) + val) {
                        D[k].add(val);
                    } else if (D[k].get(0) == D[i].get(0) + val + 1) {
                        D[k].add(val + 1);
                    } else if (val > 1 && D[k].get(0) == D[i].get(0) + val - 1) {
                        D[k].add(val - 1);
                    }
                }
            }
        }
        return D[n - 1].size() > 1;
    }

    // 使用bfs进行搜索，超时
    public boolean canCross(int[] stones) {
        if (stones[1] != 1) {
            return false;
        }
        int n = stones.length;
        Deque<Integer> cursor = new ArrayDeque<>(); // 石头下标
        Deque<Integer> steps = new ArrayDeque<>(); // 达到这个石头的步数
        cursor.addLast(1);
        steps.addLast(1);
        while (true) {
            Integer pos = cursor.pollLast();
            Integer step = steps.pollLast();
            if (pos == null) {
                return false;
            }
            if (pos == n - 1) {
                return true;
            }
            for (int i = pos + 1; i < n; i++) {
                if (stones[i] == stones[pos] + step) {
                    cursor.addFirst(i);
                    steps.addFirst(step);
                } else if (stones[i] == stones[pos] + step + 1) {
                    cursor.addFirst(i);
                    steps.addFirst(step + 1);
                } else if (step > 1 && stones[i] == stones[pos] + step - 1) {
                    cursor.addFirst(i);
                    steps.addFirst(step - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        boolean b = new Frog_Jump().canCross2(new int[]{0, 1, 2, 3, 4, 8, 9, 11});
        System.out.println(b);
    }
}
