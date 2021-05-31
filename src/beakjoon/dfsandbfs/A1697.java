package beakjoon.dfsandbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 숨바꼭질
public class A1697 {

    static int n, k;
    static boolean visit[];
    static int[] dist;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        visit = new boolean[100001];
        dist = new int[100001];
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        visit[n] = true;

        while (!q.isEmpty()) {
            int x = q.poll();
            if (x - 1 < 100001 && x - 1 >= 0 && !visit[x - 1]) {
                visit[x - 1] = true;
                dist[x - 1] = dist[x] + 1;
                q.offer(x - 1);
            }
            if (x + 1 < 100001 && x + 1 >= 0 && !visit[x + 1]) {
                visit[x + 1] = true;
                dist[x + 1] = dist[x] + 1;
                q.offer(x + 1);
            }
            if (x * 2 < 100001 && x * 2 >= 0 && !visit[x * 2]) {
                visit[x * 2] = true;
                dist[x * 2] = dist[x] + 1;
                q.offer(x * 2);
            }

        }
    }

    static void process() {
        bfs();
        System.out.println(dist[k]);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
