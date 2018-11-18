package tony.leetcode.feature.array;

import java.util.Arrays;

public class Task_Scheduler {

    // 621
    // 给定一个用字符数组表示的 CPU 需要执行的任务列表。其中包含使用大写的 A - Z 字母表示的26 种不同种类的任务。
    // 任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。
    // CPU 在任何一个单位时间内都可以执行一个任务，或者在待命状态。

    // 然而，两个相同种类的任务之间必须有长度为 n 的冷却时间，
    // 因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。

    // 你需要计算完成所有任务所需要的最短时间。

    public static void main(String[] args){
        int i = new Task_Scheduler().leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 50);
        System.out.println(i);
    }

    /**
     * 获取最多个数(count)的字母‘x’，则问题可描述为 x 0 0 0 .. x 0 0 0 .. x ...、
     * 如果有多个(m)最多个数的字母，则问题可描述为 x y 0 0 .. x y 0 0 .. x y ...
     *
     * 1.如果n小于等于m，则没有0位，但是其他字母都可以插到xy的间隙中
     * 2.如果n > m 但是 (n-m)*(count-1) < 剩余的其他字母数量，其它字母也是可以在0位塞满后插入到各组的间隙中
     * 上述两种情况下需要的时间都是task.length
     * 3.如果n > m 而且 (n-m)*(count-1) > 剩余的其他字母数量，那么在count-1组后只剩下m个字母
     *   即为(count-1)*(n+1) + m，这个值是一定比task.length大，因为有空闲
     *
     * @param tasks
     * @param n
     * @return
     */
    public int leastInterval(char[] tasks, int n) {
        if (n == 0){
            return tasks.length;
        }
        int[] record = new int[26];
        for (char ea : tasks){
            record[ea - 'A']++;
        }

        Arrays.sort(record);
        int temp = 0; // 最高频率字母的数量
        while ( temp >= 0 && record[25] == record[temp]){
            temp++;
        }

        return Math.max((record[25] - 1)*(n+1) + temp, tasks.length);

    }


    /**
     * 这么写得出的结果并不是最短时间
     * @param tasks
     * @param n
     * @return
     */
    public int leastInterval2(char[] tasks, int n) {
        if (n == 0){
            return tasks.length;
        }

        int total = tasks.length;
        int[] record = new int[26];
        int[] cooldown = new int[26];
        for (char ea : tasks){
            record[ea - 'A']++;
        }

        int seconds = 0;
        while (total > 0){
            seconds++;
            if (doTask(record,cooldown,n)){
                total--;
            }
        }
        return seconds;
    }

    private boolean doTask(int[] record, int[] cooldown, int n){
        boolean get =false;
        for (int i = 0; i < record.length;i++){
            if (cooldown[i] > 0){
                cooldown[i]--;
                continue;
            }
            if (!get && record[i] > 0){
                record[i]--;
                cooldown[i] += n;
                get = true;
            }
        }
        return get;
    }
}
