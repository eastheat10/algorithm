package beakjoon.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 오르막 수
public class A11057 {

    static int n;
    static int[][] dp;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1][10];
    }

    static void dp() {
        for (int i = 0; i < 10; i++)
            dp[1][i] = i + 1;
        for (int i = 0; i <= n; i++)
            dp[i][0] = 1;


        for (int i = 2; i <= n; i++)
            for (int j = 1; j < 10; j++)
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 10007;

        System.out.println(dp[n][9]);
    }

    public static void main(String[] args) throws IOException {
        input();
        dp();
    }
}
