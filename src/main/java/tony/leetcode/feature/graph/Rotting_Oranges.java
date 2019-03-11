package tony.leetcode.feature.graph;

import java.util.Deque;
import java.util.LinkedList;

// 994. 腐烂的橘子
// 在给定的网格中，每个单元格可以有以下三个值之一：
// 值 0 代表空单元格；
// 值 1 代表新鲜橘子；
// 值 2 代表腐烂的橘子。

// 每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。
// 返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1。

public class Rotting_Oranges {

    public int orangesRotting(int[][] grid) {
        Deque<Integer> ique = new LinkedList<>();
        Deque<Integer> jque = new LinkedList<>();
        int news = 0;
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2){
                    ique.addLast(i);
                    jque.addLast(j);
                    ++news;
                }
            }
        }
        while (true){
            if (news == 0){
                break;
            }
            int tmp = 0;
            for (int k = 0; k < news; k++ ){
                int x = ique.pollFirst();
                int y = jque.pollFirst();
                if (x > 0){
                    if (grid[x - 1][y] == 1){
                        grid[x - 1][y] = 2;
                        ique.addLast(x-1);
                        jque.addLast(y);
                        ++tmp;
                    }
                }
                if (x < grid.length - 1){
                    if (grid[x + 1][y] == 1){
                        grid[x + 1][y] = 2;
                        ique.addLast(x+1);
                        jque.addLast(y);
                        ++tmp;
                    }
                }
                if (y > 0){
                    if (grid[x][y - 1] == 1){
                        grid[x][y - 1] = 2;
                        ique.addLast(x);
                        jque.addLast(y-1);
                        ++tmp;
                    }
                }
                if (y < grid[0].length - 1){
                    if (grid[x][y + 1] == 1){
                        grid[x][y + 1] = 2;
                        ique.addLast(x);
                        jque.addLast(y+1);
                        ++tmp;
                    }
                }
            }
            ++count;
            news = tmp;
        }

        boolean hasGood = false;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == 1){
                    hasGood = true;
                    break;
                }
            }
        }

        if (hasGood){
            return -1;
        } else {
            // 如果是0则表示没有本就没有任何新鲜的，否则需要减1，因为一定会多循环一次来检验跳出
            return count == 0 ? 0 : count-1;
        }

    }

    public static void main(String[] args){
        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        int i = new Rotting_Oranges().orangesRotting(grid);
        System.out.println(i);
    }

}
