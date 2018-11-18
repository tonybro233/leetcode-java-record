package tony.leetcode.feature.math;

public class Reverse_Integer {

    // 7
    // 给定一个 32 位有符号整数，将整数中的数字进行反转。


    public static void main(String[] args){
        Reverse_Integer go = new Reverse_Integer();
        int re = go.reverse(-2147483648);
        System.out.println(re);
    }

    public int reverse(int x) {
        boolean b = x < 0 ;
        long maxb = (long)Integer.MAX_VALUE + 1;
        long lx = x;
        lx = Math.abs(lx);
        long val = 0;
        int count = 0;
        long xx = lx;
        long xxx = lx;
        while (xx != 0){
            count++;
            xx = xx / 10;
        }

        for (int i = 1; i <= count; i++){
            val = val + (xxx % 10)*(long)Math.pow( 10,(count - i));
            xxx = xxx / 10;
            if (b && val > maxb){
                return 0;
            }
            if (!b && val > Integer.MAX_VALUE){
                return 0;
            }
        }
        if (b)
            val = -val;

        return (int)val;

    }

    public int reverse2(int x) {
        double res = 0;
        int sign = 1;

        if (x == 0) {
            return 0;
        }
        if (x < 0) {
            sign = -1;
            x = -1 * x;
        }

        // 同时进行处理
        while (x > 0) {
            res = res * 10 + x % 10;
            x /= 10;
        }
        res = sign * res ;
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
            return 0;
        }

        return (int)res;
    }
}
