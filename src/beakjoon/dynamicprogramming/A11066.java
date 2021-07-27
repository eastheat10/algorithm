package beakjoon.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 파일 합치기
public class A11066 {

    static int n;
    static int[] arr;
    static int[][] dp, sum;
    static StringBuilder sb = new StringBuilder();

    static void input(BufferedReader br) throws IOException {
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        sum = new int[n + 1][n + 1];
        dp = new int[n + 1][n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                sum[i][j] = sum[i][j - 1] + arr[j];
            }
        }
    }

    static void process() {
        for (int len = 2; len <= n; len++) {
            for (int i = 1; i <= n - len + 1; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + sum[i][j]);
                }
            }
        }

        sb.append(dp[1][n]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            input(br);
            process();
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
