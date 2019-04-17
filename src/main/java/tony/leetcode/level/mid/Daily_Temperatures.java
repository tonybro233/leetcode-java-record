package tony.leetcode.level.mid;

// 739. 每日温度
// 根据每日 气温 列表，请重新生成一个列表，对应位置的输入是你需要再等待多久温度才会升高的天数。
// 如果之后都不会升高，请输入 0 来代替。
//
// 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，
// 你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
//
// 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的都是 [30, 100] 范围内的整数。

public class Daily_Temperatures {

    public int[] dailyTemperatures(int[] T) {
        int n = T.length;
        int[] result = new int[n];
        // 倒序处理
        for (int i = n-2; i >=0;i--){
            // T[j += result[j]]表现为递增
            for (int j = i+1; j < n; j += result[j]){
                if (T[i] < T[j]){
                    result[i] = j-i;
                    break;
                } else if (result[j] == 0) {
                    result[i] = 0;
                    break;
                }
            }
        }

        return result;
    }
}
