package beakjoon.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// RGB 거리
public class A1149 {

    static int n;
    static int[][] arr;
    static int[][] dp;
    static final int red = 0;
    static final int green = 1;
    static final int blue = 2;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n][3];
        dp = new int[n][3];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

    }

    static void dp() {
        dp[0][red] = arr[0][red];
        dp[0][green] = arr[0][green];
        dp[0][blue] = arr[0][blue];

        dp[n - 1][red] = Integer.MAX_VALUE;
        dp[n - 1][green] = Integer.MAX_VALUE;
        dp[n - 1][blue] = Integer.MAX_VALUE;

        for (int i = 1; i < n; i++) {
            dp[i][red] = Math.min(dp[i - 1][green], dp[i - 1][blue]) + arr[i][red];
            dp[i][green] = Math.min(dp[i - 1][red], dp[i - 1][blue]) + arr[i][green];
            dp[i][blue] = Math.min(dp[i - 1][red], dp[i - 1][green]) + arr[i][blue];
        }

        int result = Integer.MAX_VALUE;
        for (int i : dp[n - 1])
            result = Math.min(i, result);

        System.out.println(result);
    }

    public static void main(String[] args) throws IOException {
        input();
        dp();
    }
}
