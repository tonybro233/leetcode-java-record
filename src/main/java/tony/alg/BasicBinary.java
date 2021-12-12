package tony.alg;

import java.util.Arrays;

public class BasicBinary {

    public static void search(int[] array, int target) {
        Arrays.sort(array);

        // while循环的表达式表达了二分搜索的区间
        // 如果采用 <=
        //   终止条件为 low = high + 1
        //   所以终止之前的计算会出现 low = high 的情况，此时 mid = low = high
        //   所以 high 的初始值要取为 len - 1
        //   所以搜索区间(mid所在区间)为 [low, high]
        //   所以进行下一轮时的操作是 low = mid + 1 和 high = mid - 1

        // 如果采用 <
        //   终止条件为 low = high
        //   终止之前的计算至多只会出现 low = high - 1，此时 mid = low = high - 1
        //   所以 high 的初始值要取为 len
        //   所以搜索区间(mid所在区间)为 [low, high)
        //   所以进行下一轮时的操作是 low = mid + 1 和 high = mid


        int l1 = 0;
        int h1 = array.length - 1;

        // 因为两端是闭区间，所以在执行下一轮时，要 +- 1
        // [low, high] => [low, mid - 1] || [mid + 1, high]
        while (l1 <= h1) {
            // 为防止越界统一这么写
            int mid = l1 + (h1 - l1) / 2;
            // 把所有if分支列出
            if (array[mid] < target) { // 小于x的最大值
                // 这样理解，low一直在递增，直到array[mid]大于等于target，
                // 即找出的是大于等于target中的最小值
                l1 = mid + 1;
            } else if (array[mid] == target) {
                h1 = mid - 1;
            } else if (array[mid] > target) {
                h1 = mid - 1;
            }
        }

        System.out.printf("大于等于目标最小:%d 小于目标最大:%d%n", l1, h1);

        int l2 = 0;
        int h2 = array.length - 1;

        while (l2 <= h2) {
            int mid = (l2 + h2) / 2;
            if (array[mid] < target) {
                l2 = mid + 1;
            } else if (array[mid] == target) {
                // 关键就在于等号的处理
                // 如果是搜索准确值，直接在这里break
                // 如果是要获取 <= 目标值 则取 l = mid + 1
                // 如果是要获取 >= 目标值 则取 h = mid - 1
                l2 = mid + 1;
            } else if (array[mid] > target) {
                h2 = mid - 1;
            }
        }

        System.out.printf("大于目标最小:%d 小于等于目标最大:%d%n", l2, h2);

        int l3 = 0;
        int h3 = array.length - 1; // 注意这里取的是 len

        // 使用小于，则退出条件为 l3 = h3
        // 搜索区间为[l3, h3)，所以下一轮被分为[l3, mid), [l3 + 1, h3)
        while (l3 < h3) { // 注意
            int mid = (l3 + h3) / 2;
            if (array[mid] < target) {
                l3 = mid + 1;
            } else if (array[mid] == target) {
                h3 = mid; // 相等的时候缩小上界
            } else if (array[mid] > target) {
                h3 = mid; // 注意没有 -1
            }
        }

        // l3 == h3
        // 找不到元素的时候取的是 大于目标最小
        System.out.printf("左边界1:%d low=%d high=%d%n", l3, l3, h3);

        int l4 = 0;
        int h4 = array.length - 1;
        while (l4 < h4) {
            int mid = (l4 + h4) / 2;
            if (array[mid] < target) {
                l4 = mid + 1;
            } else if (array[mid] == target) {
                l4 = mid + 1; // 相等的时候增加下界
            } else if (array[mid] > target) {
                h4 = mid;
            }
        }

        // l4 == h4
        // 注意 -1
        // 找不到元素时取的是 小于目标最大
        System.out.printf("右边界:%d low=%d high=%d%n", l4 - 1, l4, h4);



        // 搜索边界时并不一定必须使用 <
        int l5 = 0;
        int h5 = array.length - 1;
        while (l5 <= h5) {
            int mid = (l5 + h5) / 2;
            if (array[mid] < target) {
                l5 = mid + 1;
            } else if (array[mid] == target) {
                h5 = mid - 1;
            } else if (array[mid] > target) {
                h5 = mid - 1;
            }
        }
        // l5 = h5 + 1
        // 这里其实就写的和第一个例子一模一样了
        System.out.printf("左边界:%d low=%d high=%d%n", l5, l5, h5);
    }

    public static void searchTest(int[] nums, int target) {
        int low = 0;
        int high = nums.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < target) {
                low = mid + 1;
            } else if (nums[mid] == target) {
                System.out.println("res is " + mid);
                break;
            } else if (nums[mid] > target) {
                high = mid;
            }
        }

        System.out.println("low=" + low + " high=" + high);
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 6, 6, 8, 9};
        int target = 6;
        // System.out.println("数组=" + Arrays.toString(array) + " 目标=" + target);
        // search(array, target);

        target = 4;
        System.out.println("数组=" + Arrays.toString(array) + " 目标=" + target);
        search(array, target);

        // searchTest(array, 9);
    }
}
