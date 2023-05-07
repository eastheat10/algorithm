package beakjoon.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 가장 긴 증가하는 수열 1
public class A11053 {

    static int n;
    static int[] arr, dp;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        dp = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
    }

    static void dp_bottom_up() {

        for (int i = 1; i <= n; i++) {
            dp[i] = 1;

            for (int j = 1; j < i; j++) {
                if (arr[i] > arr[j] && dp[i] <= dp[j]) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        System.out.println(Arrays.stream(dp).max().getAsInt());

    }

    static int dp(int k) {
        if (k == 0) return 0;

        if (dp[k] == 0) {
            dp[k] = 1;

            for (int i = 1; i <= k; i++) {
                if (arr[k] > arr[i]) {
                    dp[k] = Math.max(dp[k], dp(i) + 1);
                }
            }
        }

        return dp[k];
    }

    static void dp_top_down() {
        int result = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++)
            dp(i);


        System.out.println(Arrays.stream(dp).max().getAsInt());
    }

    public static void main(String[] args) throws IOException {
        input();
//        dp_top_down();
        dp_bottom_up();
    }
}
