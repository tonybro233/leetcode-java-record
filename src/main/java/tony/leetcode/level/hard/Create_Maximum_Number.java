package tony.leetcode.level.hard;

// 321. 拼接最大数
// 给定长度分别为 m 和 n 的两个数组，其元素由 0-9 构成，表示两个自然数各位上的数字。
// 现在从这两个数组中选出 k (k <= m + n) 个数字拼接成一个新的数，要求从同一个数组中
// 取出的数字保持其在原数组中的相对顺序。
//
// 求满足该条件的最大数。结果返回一个表示该最大数的长度为 k 的数组。
//
// 说明: 请尽可能地优化你算法的时间和空间复杂度。
//
// 示例 1:
// 输入:
// nums1 = [3, 4, 6, 5]
// nums2 = [9, 1, 2, 5, 8, 3]
// k = 5
// 输出:
// [9, 8, 6, 5, 3]

// 示例 2:
// 输入:
// nums1 = [6, 7]
// nums2 = [6, 0, 4]
// k = 5
// 输出:
// [6, 7, 6, 0, 4]

// 示例 3:
// 输入:
// nums1 = [3, 9]
// nums2 = [8, 9]
// k = 3
// 输出:
// [9, 8, 9]

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Create_Maximum_Number {

    /**
     * 按照各种分配结果求取两个最大子数组然后合并
     */
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length, len2 = nums2.length;
        int[] maxSubsequence = new int[k];
        int start = Math.max(0, k - len2), end = Math.min(k, len1);

        for (int i = start; i <= end; i++) {
            int[] subsequence1 = maxSubsequence(nums1, i);
            int[] subsequence2 = maxSubsequence(nums2, k - i);
            int[] curMaxSubsequence = merge(subsequence1, subsequence2);
            if (compare(curMaxSubsequence, 0, maxSubsequence, 0) > 0) {
                // System.arraycopy(curMaxSubsequence, 0, maxSubsequence, 0, k);
                maxSubsequence = curMaxSubsequence;
            }
        }
        return maxSubsequence;
    }

    public int[] maxSubsequence(int[] nums, int k) {
        int len = nums.length;
        int[] stack = new int[k];
        int cur = -1, remain = len - k;
        for (int i = 0; i < len; i++) {
            int num = nums[i];
            while (cur >= 0 && stack[cur] < num && remain > 0) {
                cur--;
                remain--;
            }
            if (cur < k - 1) {
                stack[++cur] = num;
            } else {
                remain--;
            }
        }
        return stack;
    }

    public int[] merge(int[] subsequence1, int[] subsequence2) {
        int x = subsequence1.length, y = subsequence2.length;
        if (x == 0) {
            return subsequence2;
        }
        if (y == 0) {
            return subsequence1;
        }
        int mergeLength = x + y;
        int[] merged = new int[mergeLength];
        int index1 = 0, index2 = 0;
        for (int i = 0; i < mergeLength; i++) {
            if (compare(subsequence1, index1, subsequence2, index2) > 0) {
                merged[i] = subsequence1[index1++];
            } else {
                merged[i] = subsequence2[index2++];
            }
        }
        return merged;
    }

    public int compare(int[] subsequence1, int index1, int[] subsequence2, int index2) {
        int x = subsequence1.length, y = subsequence2.length;
        while (index1 < x && index2 < y) {
            int difference = subsequence1[index1] - subsequence2[index2];
            if (difference != 0) {
                return difference;
            }
            index1++;
            index2++;
        }
        return (x - index1) - (y - index2);
    }


    /**
     * 想法是依次取出最大值，数字最大一定先选，前提是后面的数字要足够
     * 写不动了
     */
    public int[] maxNumber2(int[] nums1, int[] nums2, int k) {
        int[] res = new int[k];
        if (k == 0) {
            return res;
        }

        int len1 = nums1.length;
        List<Pair> list1 = new ArrayList<>(len1);
        for (int i = 0; i < len1; i++) {
            list1.add(new Pair(nums1[i], i));
        }
        int len2 = nums2.length;
        List<Pair> list2 = new ArrayList<>(len2);
        for (int i = 0; i < len2; i++) {
            list2.add(new Pair(nums2[i], i));
        }

        list1.sort(Comparator.<Pair>comparingInt(p -> p.val).reversed());
        list2.sort(Comparator.<Pair>comparingInt(p -> p.val).reversed());

        List<Pair>[] lists1 = new List[len1];
        for (int i = 0; i < len1; i++) {
            lists1[i] = new LinkedList<>();
            for (Pair pair : list1) {
                if (pair.pos <= i) {
                    lists1[i].add(pair);
                }
            }
        }
        List<Pair>[] lists2 = new List[len2];
        for (int i = 0; i < len2; i++) {
            lists2[i] = new LinkedList<>();
            for (Pair pair : list2) {
                if (pair.pos <= i) {
                    lists2[i].add(pair);
                }
            }
        }

        int nums1Begin = 0, nums2Begin = 0;

        for (int i = 0; i < k; i++) {
            int nums1Ava = len1 - nums1Begin;
            int nums2Ava = len2 - nums2Begin;
            int need = k - i;

            int maxIdx1 = nums2Ava >= need ? len1 - 1 : len1 - (need - nums2Ava);
            Pair max1 = null;
            for (Pair pair : lists1[maxIdx1]) {
                if (pair.pos >= nums1Begin) {
                    max1 = pair;
                    break;
                }
            }

            int maxIdx2 = nums1Ava >= need ? len2 - 1 : len2 - (need - nums1Ava);
            Pair max2 = null;
            for (Pair pair : lists2[maxIdx2]) {
                if (pair.pos >= nums1Begin) {
                    max2 = pair;
                    break;
                }
            }


            if (max2 == null) {
                res[i] = max1.val;
                nums1Begin = max1.pos + 1;
            } else if (max1 == null) {
                res[i] = max2.val;
                nums2Begin = max2.pos + 1;
            } else if (max1.val > max2.val) {
                res[i] = max1.val;
                nums1Begin = max1.pos + 1;
            } else if (max1 == null || max2.val > max1.val) {
                res[i] = max2.val;
                nums2Begin = max2.pos + 1;
            } else {



            }

        }



        return null;
    }

    static class Pair {
        int val;
        int pos;

        public Pair(int val, int pos) {
            this.val = val;
            this.pos = pos;
        }
    }

}
