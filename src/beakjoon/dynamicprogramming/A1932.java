package beakjoon.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 정수 삼각형
public class A1932 {

    static int n;
    static int[][] dp;
    static int[][] triangle;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        dp = new int[n + 1][n + 1];

        triangle = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= i; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

    }

    static void dp() {
        int max = Integer.MIN_VALUE;

        dp[1][1] = triangle[1][1];
        for (int i = 2; i <= n; i++) {
            dp[i][1] = dp[i - 1][1] + triangle[i][1];
            dp[i][i] = dp[i - 1][i - 1] + triangle[i][i];
        }

        for (int i = 3; i <= n; i++)
            for (int j = 2; j < i; j++)
                dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];

        for (int i = 1; i <= n; i++)
            max = Math.max(dp[n][i], max);

        System.out.println(max);
    }

    public static void main(String[] args) throws IOException {
        input();
        dp();
    }
}
