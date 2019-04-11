package tony.leetcode.feature.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 406. 根据身高重建队列
// 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，
// 其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。
// 编写一个算法来重建这个队列。
//
// 注意：
// 总人数少于1100人。
//
// 示例
// 输入:
// [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
//
// 输出:
// [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]

public class Queue_Reconstruction_by_Height {

    public int[][] reconstructQueue2(int[][] people) {
        int n = people.length;
        Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);
        List<int[]> list = new ArrayList<>();
        // K值定义为 排在h前面且身高大于或等于h的人数
        // 因为从身高降序开始插入，此时所有人身高都大于等于h
        // 因此K值即为需要插入的位置
        for (int[] i : people) {
            list.add(i[1], i);
        }
        return list.toArray(new int[list.size()][]);
    }

    public int[][] reconstructQueue(int[][] people) {
        int n = people.length;
        Arrays.sort(people, (o1, o2) -> {
            if (o1[0] != o2[0]){
                return o1[0] - o2[0];
            } else {
                return o1[1] - o2[1];
            }
        });
        int[][] result = new int[n][2];
        for (int[] ea : result){
            ea[0] = -1;
        }
        for (int[] one : people){
            int pos = one[1];
            int cursor = 0;
            while (pos != 0 || result[cursor][0] != -1){
                if (pos > 0 && (result[cursor][0] == -1 || result[cursor][0] == one[0])){
                    pos--;
                }
                cursor++;
            }
            result[cursor][0] = one[0];
            result[cursor][1] = one[1];
        }

        return result;
    }

    public static void main(String[] args){
        int[][] ints = new Queue_Reconstruction_by_Height().reconstructQueue2(
                new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}}
        );
        for (int[] ea : ints){
            System.out.print("{"+ea[0]+","+ea[1]+"} ");
        }
    }
}
