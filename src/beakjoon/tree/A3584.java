package beakjoon.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 공통 조상
public class A3584 {

    static int n, root, n1, n2;
    static ArrayList<Integer>[] list;
    static int[] parent, depth;
    static boolean[] findRoot;

    static void input(BufferedReader br) throws IOException {
        n = Integer.parseInt(br.readLine());

        parent = new int[n + 1];
        depth = new int[n + 1];
        findRoot = new boolean[n + 1];
        list = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            findRoot[y] = true;

            list[x].add(y);
            list[y].add(x);
        }

        st = new StringTokenizer(br.readLine());
        n1 = Integer.parseInt(st.nextToken());
        n2 = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            if (!findRoot[i])
                root = i;
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

    static int lca() {
        int x = n1;
        int y = n2;

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

        return x;
    }

    static int process() {
        StringBuilder sb = new StringBuilder();

        dfs(root, 0, -1);
        return lca();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            input(br);
            sb.append(process()).append('\n');
        }
        System.out.println(sb);
    }

}
