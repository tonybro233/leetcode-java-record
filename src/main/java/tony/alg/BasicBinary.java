package tony.alg;

import java.util.Arrays;

public class BasicBinary {

    public static void search(int[] array, int target){
        Arrays.sort(array);
        int l1 = 0,h1 = array.length - 1, m1;
        int l2 = 0,h2 = array.length - 1, m2;

        while(l1 <= h1) {
            m1 = (l1 + h1)/2;
            if(array[m1] < target){//小于x的最大值
                //这样理解，l一直在向右移动，直到array[mid]大于等于target，即找出的是大于等于target中的最小值
                l1 = m1 + 1;
            } else {
                h1 = m1 - 1;
            }
        }

        System.out.println("大于等于目标最小:"+array[l1] + " 小于目标最大:"+array[h1]);

        while(l2 <= h2) {
            m2 = (l2 + h2)/2;
            if(array[m2] > target) { //大于x的最小值
                h2 = m2 - 1;
            } else {
                l2 = m2 + 1;
            }
        }

        System.out.println("大于目标最小:"+array[l2] + " 小于等于目标最大:"+array[h2]);
    }

    public static void main(String[] args){
        search(new int[]{1,5,6,9}, 6);
    }
}
