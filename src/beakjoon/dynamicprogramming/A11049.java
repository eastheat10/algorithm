import java.util.*;
import java.io.*;

class Main {

    static int n;
    static int[][] matrix, dp;

    public static void main(String[] args) throws IOException {
        input();
        process();
        System.out.println(dp[0][n - 1]);
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        matrix = new int[n][2];
        dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            matrix[i][0] = Integer.parseInt(st.nextToken());
            matrix[i][1] = Integer.parseInt(st.nextToken());
        }
    }

    static void process() {
        for (int i = 1; i < n; i++) {   // 구간의 범위 (x 번째 부터 x + i 번째 까지의 행렬)
            for (int j = 0; i + j < n; j++) {  // 구간의 시작
                dp[j][j + i] = Integer.MAX_VALUE;   // j번째 행렬과 j+i번째 행렬 까지의 비용 계산
                for (int k = j; k < i; k++) {
                    int cost = dp[j][j + k] + dp[j + k + 1][j + i] + (matrix[j][0] * matrix[j + i][0] * matrix[j + i][1]);
                    dp[j][j + i] = Math.min(dp[j][j + i], cost);
                }
            }
        }
    }

}