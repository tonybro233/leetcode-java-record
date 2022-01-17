package tony.leetcode.feature.binary_search;

import java.util.*;

// 881. 救生艇
// 救生艇第 i 个人的体重为 people[i]，每艘船可以承载的最大重量为 limit。
// 每艘船最多可同时载两人，但条件是这些人的重量之和最多为 limit。
// 返回载到每一个人所需的最小船数。(保证每个人都能被船载)。

public class Life_Boat {

    public static void main(String[] args) {
        Life_Boat go = new Life_Boat();
        int[] people = {3, 2, 2, 1};
        int i = go.numRescueBoats(people, 3);
        System.out.println(i);
    }

    public int numRescueBoats3(int[] people, int limit) {
        // 这题应该算作贪心
        int len = people.length;
        if (len <= 1) {
            return len;
        }

        Arrays.sort(people);
        int left = 0, right = len - 1;
        int res = 0;
        while (left <= right) {
            if (left == right) {
                res++;
                break;
            }
            // 缩小问题规模，体重最小的人一定是和体重最大的人配对
            // 如果不行则体重最大的人只能自己走
            if (people[left] + people[right] <= limit) {
                left++;
                right--;
            } else {
                right--;
            }
            res++;
        }

        return res;
    }

    public int numRescueBoats(int[] people, int limit) {
        int n = people.length;
        if (n == 1) {
            return 1;
        }
        Arrays.sort(people);

        // List<int[]> list1 = Arrays.asList(people); 这个方法不适用于基础类型数组
        List<Integer> list = new ArrayList<>();
        for (int ea : people) {
            list.add(ea);
        }

        int count = 0;
        while (list.size() > 0) {
            int w = list.remove(list.size() - 1);
            int other = Collections.binarySearch(list, limit - w);
            if (other >= 0) {
                list.remove(other);
            } else {
                other = -other - 2;
                if (other >= 0) {
                    list.remove(other);
                }
            }
            count++;
        }

        return count;
    }


    // 方法超时
    public int numRescueBoats2(int[] people, int limit) {
        // 想复杂了，最多两个人
        int n = people.length;
        if (n == 1) {
            return 1;
        }
        Arrays.sort(people);

        int[] record = new int[n];
        Arrays.fill(record, 0);

        int count = 0;
        int cur = 0;
        for (int i = n - 1; i >= 0; i--) {
            cur = i - 1;
            if (record[i] != 0) {
                continue;
            }

            record[i] = 1;
            count++;
        }

        return count;
    }
}
