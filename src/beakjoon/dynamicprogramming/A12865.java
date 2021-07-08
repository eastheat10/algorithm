package beakjoon.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 평범한 배낭
public class A12865 {

    static int n, k;
    static int[][] bag, dp;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        bag = new int[n + 1][2];
        dp = new int[n + 1][k + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            bag[i][0] = w;
            bag[i][1] = v;
        }
    }

    static void dp() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {

                if (bag[i][0] > j)
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], bag[i][1] + dp[i - 1][j - bag[i][0]]);

            }
        }

        System.out.println(dp[n][k]);
    }

    public static void main(String[] args) throws IOException {
        input();
        dp();
    }

}
