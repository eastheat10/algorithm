package beakjoon.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 전깃줄
public class A2565 {

    static int n, maxIdx = Integer.MIN_VALUE;
    static int[] arr, dp;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[501];
        dp = new int[501];


        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x] = y;

            maxIdx = Math.max(maxIdx, x);
        }

    }

    static void process() {
        int max = Integer.MIN_VALUE;

        for (int i = 1; i <= maxIdx; i++) {
            if (arr[i] == 0) continue;
            dp[i] = 1;

            for (int j = 1; j < i; j++) {
                if (arr[j] == 0) continue;
                if (arr[i] > arr[j] && dp[i] <= dp[j]) {
                    dp[i] = dp[j] + 1;
                }
            }
            max = Math.max(max, dp[i]);
        }

        System.out.println(n - max);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
