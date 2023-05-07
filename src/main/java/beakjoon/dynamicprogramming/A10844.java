package beakjoon.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 쉬운 계단 수
public class A10844 {

    static int n;
    final static long mod = 1000000000;
    static long[][] dp;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new long[n + 1][10];
        for (int i = 1; i <= 9; i++)
            dp[1][i] = 1;
    }

    static void dp() {

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j + 1];
                } else if (j == 9) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j + 1];
                }
                dp[i][j] %= mod;
            }
        }

        long sum = 0;
        for (int i = 0; i <= 9; i++)
            sum += dp[n][i];
        sum %= mod;
        System.out.println(sum);
    }

    public static void main(String[] args) throws IOException {
        input();
        dp();
    }
}
