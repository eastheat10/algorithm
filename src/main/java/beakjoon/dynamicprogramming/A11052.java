package beakjoon.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 카드 구매하기
public class A11052 {

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

    static void dp() {
        dp[1] = arr[1];

        for (int i = 2; i <= n; i++) {
            dp[i] = arr[i];
            for (int j = 1; j <= (i / 2); j++) {
                dp[i] = Math.max((dp[i - j] + dp[j]), dp[i]);
            }
        }

        System.out.println(dp[n]);
    }

    public static void main(String[] args) throws IOException {
        input();
        dp();
    }
}
