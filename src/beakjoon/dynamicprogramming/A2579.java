package beakjoon.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A2579 {

    static int n;
    static int[] stair, dp;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        stair = new int[n + 1];
        dp = new int[n + 1];

        for (int i = 1; i <= n; i++)
            stair[i] = Integer.parseInt(br.readLine());
    }

    static int dp(int k) {
        if(k == 0) return 0;

        if(dp[k] == 0)
            return dp[k] = Math.max(dp(k - 2), stair[k - 1] + dp(k - 3)) + stair[k];

        return dp[k];
    }

    static void dp_top_down() {
        dp[1] = stair[1];
        if (n >= 2)
            dp[2] = stair[1] + stair[2];

        System.out.println(dp(n));
    }

    static void dp_bottom_up() {
        dp[1] = stair[1];
        if (n >= 2)
            dp[2] = stair[1] + stair[2];

        for (int i = 3; i <= n; i++)
            dp[i] = Math.max(dp[i - 2], stair[i - 1] + dp[i - 3]) + stair[i];

        System.out.println(dp[n]);
    }

    public static void main(String[] args) throws IOException {
        input();
        dp_top_down();
//        dp_bottom_up();
    }
}
