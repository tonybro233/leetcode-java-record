package tony.codewar.math;

import java.util.Arrays;

// You have to create a function that takes a positive integer number
// and returns the next bigger number formed by the same digits:
// 12 ==> 21
// 513 ==> 531
// 2017 ==> 2071

// If no bigger number can be composed using those digits, return -1:
// 9 ==> -1
// 111 ==> -1
// 531 ==> -1

public class Next_bigger_number_with_the_same_digits {

    public static long nextBiggerNumber(long n) {
        char[] chars = Long.toString(n).toCharArray();
        int le = chars.length;
        for (int i = le-2; i >=0 ;i--){
            int val = chars[i] - '0';
            if (val < chars[i+1] - '0'){
                // 二分取第一个比val大的值
                int i1 = searchFirstLarger(chars, i+1, val);
                // 交换后将后面的从小到大排序
                exch(chars, i, i1);
                Arrays.sort(chars, i+1, chars.length);
                return Long.parseLong(new String(chars));
            }
        }

        return -1;
    }

    public static int searchFirstLarger(char[] chars, int begin, int val){
        int left = begin, right = chars.length-1;
        while (left <= right){
            int mid = (left+right)/2;
            if (chars[mid] - '0' > val){
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        while (right > 0 && chars[right] == chars[right-1]){
            right--;
        }
        return right;
    }

    public static void exch(char[] chars, int a, int b){
        char ac = chars[a];
        chars[a] = chars[b];
        chars[b] = ac;
    }

    public static void main(String[] args){
        // long l = nextBiggerNumber(7988611L);
        // long l = nextBiggerNumber(1234567890);
        long l = nextBiggerNumber(1180869172);
        // long l = nextBiggerNumber(144L);
        System.out.print(l);
    }
}
