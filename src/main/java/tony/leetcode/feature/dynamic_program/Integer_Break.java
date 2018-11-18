package tony.leetcode.feature.dynamic_program;

public class Integer_Break {

    // 343
    // 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。

    public int integerBreak(int n) {
        // 所有的都拆为2,3即为最大值
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        int two = 2,three = 0;
        for (int i = 5 ; i <= n;i++){
            if (two > 0){
                two--;
                three++;
            } else {
                three--;
                two += 2;
            }
        }
        return (int)(Math.pow(2,two)*Math.pow(3,three));
    }

    public int dp(int n){
        // D[i] = max{j*D[i-j],j*(i-j)}
        // 也就是说拆分成两个数字的所有组合取最大值，另外还要考虑2这个特殊值因此加上了j*(i-j)
        // D[4] = (1*D[3])(2*D[2])(3*D[1])以及2*2的max值
        int[] dp = new int[n+1];
        dp[0]=0;
        dp[1]=1;
        dp[2]=1;
        for(int i=3;i<=n;i++){
            dp[i]=-1;
            for(int j=1;j<i;j++){
                dp[i]=Math.max(j*dp[i-j],Math.max(dp[i],j*(i-j)));
            }
        }
        return dp[n];
    }
}
