package beakjoon.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 1로 만들기
public class A1463 {

    static int n;
    static int[] dp;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];
    }

    static void dp() {

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            if (i % 6 == 0)
                dp[i] = Math.min(dp[i], Math.min(dp[i / 2], dp[i / 3]) + 1);
            else if (i % 2 == 0)
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            else if (i % 3 == 0)
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
        }

        System.out.println(dp[n]);
    }

    public static void main(String[] args) throws IOException {
        input();
        dp();
    }
}
