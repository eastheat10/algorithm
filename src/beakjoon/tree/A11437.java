package beakjoon.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// LCA
public class A11437 {

    static int n, m;
    static ArrayList<Integer>[] list;
    static int[] parent, depth;
    static int[][] arr;
    static StringBuilder sb = new StringBuilder();

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        parent = new int[n + 1];
        depth = new int[n + 1];
        list = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list[x].add(y);
            list[y].add(x);
        }

        m = Integer.parseInt(br.readLine());
        arr = new int[m + 1][2];

        for (int i = 1; i <= m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[i][0] = x;
            arr[i][1] = y;
        }
    }

    static void dfs(int cur, int d, int p) {
        depth[cur] = d;
        parent[cur] = p;

        for (Integer i : list[cur]) {
            if (i != p) {
                dfs(i, d + 1, cur);
            }
        }
    }

    static void lca() {
        for (int i = 1; i <= m; i++) {
            int x = arr[i][0];
            int y = arr[i][1];

            int dx = depth[x];
            int dy = depth[y];

            while (dx > dy) {
                x = parent[x];
                dx--;
            }

            while (dx < dy) {
                y = parent[y];
                dy--;
            }

            while (x != y) {
                x = parent[x];
                y = parent[y];
            }

            sb.append(x).append('\n');
        }

    }

    static void process() {
        dfs(1, 0, -1);
        lca();
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
