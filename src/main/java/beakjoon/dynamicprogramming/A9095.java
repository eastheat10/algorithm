package beakjoon.dynamicprogramming;

import java.io.*;

// 1, 2, 3 더하기
public class A9095 {

    static Integer[] dp = new Integer[12];

    static int dp(int k) {
        if(k < 0)
            return 0;

        if (dp[k] == null) {
            return dp[k] = dp(k - 1) + dp(k - 2) + dp(k - 3);
        } else {
            return dp[k];
        }
    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 0; i < T; i++) {
            int t = Integer.parseInt(br.readLine());
            int result = dp(t);

            sb.append(result).append('\n');
        }

        System.out.println(sb);
    }
}