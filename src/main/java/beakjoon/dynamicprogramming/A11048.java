package beakjoon.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 11048  이동하기
 *
 * https://www.acmicpc.net/problem/11048
 */
public class A11048 {

    private static int n, m;
    private static int[][] room, dp;

    public static void main(String[] args) throws IOException {
        input();
        process();
        System.out.println(dp[n - 1][m - 1]);
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        room = new int[n][m];
        dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void process() {
        dp[0][0] = room[0][0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + room[i][0];
        }
        for (int j = 1; j < m; j++) {
            dp[0][j] = dp[0][j - 1] + room[0][j];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + room[i][j];
            }
        }
    }

}
