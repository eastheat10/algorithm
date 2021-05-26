package fastcampus.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Graph_matrix {

    static int n, m, v;
    static int[][] adj;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        adj = new int[n + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            adj[x][y] = 1;
            adj[y][x] = 1;
        }
    }

    static void dfs(int x) {
        visit[x] = true;
        sb.append(x).append(" ");
        for (int y = 1; y <= n; y++) {
            if(adj[x][y] == 0) continue;
            if(visit[y] == true) continue;
            dfs(y);
        }
    }

    static void bfs(int x) {
        Queue<Integer> q = new LinkedList<>();

        q.offer(x);
        visit[x] = true;

        while (!q.isEmpty()) {
            x = q.poll();
            sb.append(x).append(" ");
            for (int y = 1; y <= n; y++) {
                if(adj[x][y] == 0) continue;
                if(visit[y]) continue;
                q.add(y);
                visit[y] = true;
            }
        }
    }

    static void process() {
        visit = new boolean[n + 1];
        dfs(v);
        sb.append("\n");
        visit = new boolean[n + 1];
        bfs(v);
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
