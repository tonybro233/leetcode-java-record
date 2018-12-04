package tony.leetcode.feature.bit_operation;

// 338. 比特位计数
// 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
//
// 示例 1:
// 输入: 2
// 输出: [0,1,1]

// 示例 2:
// 输入: 5
// 输出: [0,1,1,2,1,2]

// 进阶:
// 给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？
// 要求算法的空间复杂度为O(n)。
// 你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount）来执行此操作。

import java.util.Arrays;

public class Counting_Bits {

    public int[] countBits(int num) {
        int[] result = new int[num+1];
        result[0] = 0;
        for (int i = 1; i <= num; i++){
            int val = (int) (Math.log(i)/Math.log(2));
            val = (int) (i - Math.pow(2, val));
            result[i] = result[val] + 1;
        }
        return result;
    }

    // 利用奇偶性，奇数直接是前一项+1，偶数能被2整除说明第一位是0，因此可以做右移，也就是除以2
    // 可以进一步简化为 result[i] = result[i>>1] + (i & 1);
    public int[] countBits2(int num) {
        int[] index = new int[num+1];
        index[0] = 0;
        for(int i = 1; i<index.length; i++){
            if (i % 2 == 0){
                index[i]=index[i/2]; // 被2整除
            } else {
                index[i]=index[i-1]+1;
            }
        }
        return index;
    }

    public static void main(String[] args){
        int[] ints = new Counting_Bits().countBits(10);
        System.out.println(Arrays.toString(ints));
    }
}
