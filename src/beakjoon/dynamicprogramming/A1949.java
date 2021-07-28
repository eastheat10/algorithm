package beakjoon.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 우수 마을
public class A1949 {

    static int n;
    static int[] population;
    static int[][] dp;
    static ArrayList<Integer>[] village;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        population = new int[n + 1];
        village = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++)
            village[i] = new ArrayList();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++)
            population[i] = Integer.parseInt(st.nextToken());

        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            village[x].add(y);
            village[y].add(x);
        }
    }

    static void dfs(int k, int parent) {
        dp[k][0] = 0;
        dp[k][1] = population[k];

        for (Integer i : village[k]) {
            if (i == parent) continue;
            dfs(i, k);
            dp[k][0] += Math.max(dp[i][0], dp[i][1]);
            dp[k][1] += dp[i][0];
        }
    }

    static void process() {
        dp = new int[n + 1][2];

        dfs(1, -1);

        System.out.println(Math.max(dp[1][0], dp[1][1]));

    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
