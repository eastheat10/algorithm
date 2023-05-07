package fastcampus.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Graph_list {

    static int n, m, v;
    static ArrayList<Integer>[] adj;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++)
            adj[i] = new ArrayList<>();

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            adj[x].add(y);
            adj[y].add(x);
        }
        for (int i = 1; i <= n; i++) {
            Collections.sort(adj[i]);
        }
    }

    // x를 갈 수 있다는걸 알고 방문
    static void dfs(int x) {
        // x를 방문했다.
        visit[x] = true;
        sb.append(x).append(" ");

        // x에서 갈 수 있는 곳들을 방문한다.
        for (int y : adj[x]) {
            // 방문한 곳은 방문하지 않는다.
            if(visit[y] == true) continue;

            // y에서 갈 수 있는 곳도 확인
            dfs(y);
        }
    }

    // x에서 시작해서 갈 수 있는 정점들을 모두 탐색하기
    static void bfs(int x) {
        Queue<Integer> q = new LinkedList<>();

        // x는 방문 가능한 점이므로 queue에 넣어준다.
        q.offer(x);
        visit[x] = true;    // x를 방문

        while (!q.isEmpty()) {  // 더 확인할 점이 없다면 정지
            x = q.poll();
            sb.append(x).append(" ");
            for (int y : adj[x]) {  // x에서 갈 수 있는 점들
                if(visit[y]) continue;  // 탐색한 점이면 무시

                q.add(y);   // y를 갈 수 있으니까 queue에 추가하고 방문처리
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

