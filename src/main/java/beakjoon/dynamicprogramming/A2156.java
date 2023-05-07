package beakjoon.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 포도주 시식
public class A2156 {

    static int n;
    static Integer[] arr, dp;

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new Integer[n + 1];
        dp = new Integer[n + 1];

        for (int i = 1; i <= n; i++)
            arr[i] = Integer.parseInt(br.readLine());

        dp[0] = 0;
        dp[1] = arr[1];
        if (n >= 2)
            dp[2] = arr[2] + arr[1];

    }

    static void dp1() {
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2], dp[i - 3] + arr[i - 1]) + arr[i]);
        }

        System.out.println(dp[n]);
    }

    static int dp2(int k) {

        if (dp[k] == null)
            dp[k] = Math.max(dp2(k - 1), Math.max(dp2(k - 2), dp2(k - 3) + arr[k - 1]) + arr[k]);

        return dp[k];
    }

    public static void main(String[] args) throws IOException {
        input();
        dp1();
//        System.out.println(dp2(n));
    }
}
