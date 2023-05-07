package beakjoon.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 트리와 쿼리
public class A15681 {

    static int n, r, q;
    static int[] query, dp;
    static ArrayList<Integer>[] tree;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        query = new int[q];

        tree = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++)
            tree[i] = new ArrayList<>();

        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            tree[x].add(y);
            tree[y].add(x);
        }

        for (int i = 0; i < q; i++)
            query[i] = Integer.parseInt(br.readLine());

    }

    static void search(int k, int parent) {
        dp[k] = 1;
        for (Integer i : tree[k]) {
            if (i == parent) continue;
            search(i, k);
            dp[k] += dp[i];
        }
    }

    static void process() {
        StringBuilder sb = new StringBuilder();
        dp = new int[n + 1];
        search(r, -1);
        for (int Q = 0; Q < q; Q++) {
            sb.append(dp[query[Q]]).append('\n');
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
