package beakjoon.dfsandbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 토마토
public class A7576 {

    static int n, m, max = -1;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int[][] arr, dist;
    static boolean[][] visit;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        arr = new int[n + 1][m + 1];
        dist = new int[n + 1][m + 1];
        visit = new boolean[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

    }

    static void bfs() {
        Queue<int[]> q = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                visit[i][j] = false;
                dist[i][j] = -1;
                if (arr[i][j] == 1) {
                    q.offer(new int[]{i, j});
                    visit[i][j] = true;
                }
            }
        }

        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            int x = tmp[0];
            int y = tmp[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];

                if (nx < 1 && nx > n && ny < 1 && ny > m) continue;
                if (visit[nx][ny]) continue;
                if (arr[nx][ny] == -1) continue;
                q.offer(new int[]{nx, ny});
                visit[nx][ny] = true;
                arr[nx][ny] = 1;
                dist[nx][ny] = dist[x][y] + 1;
                max = Math.max(dist[nx][ny], max);
            }
        }
    }

    static void process() {
        bfs();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (arr[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(max);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
