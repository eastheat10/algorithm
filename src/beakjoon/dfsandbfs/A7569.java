package beakjoon.dfsandbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 토마토 2
public class A7569 {

    static int m, n, h;
    static int max = 0;
    static int[][][] tomatoes, dist;
    static int[][] dir = {{1, 0, 0}, {-1, 0, 0}, {0, 1, 0}, {0, -1, 0}, {0, 0, 1}, {0, 0, -1}};
    static boolean[][][] visit;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        tomatoes = new int[h][n][m];
        dist = new int[h][n][m];
        visit = new boolean[h][n][m];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    tomatoes[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }
    }

    static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    visit[i][j][k] = false;
                    dist[i][j][k] = -1;
                    if (tomatoes[i][j][k] == 1) {
                        q.offer(new int[]{i, j, k});
                        visit[i][j][k] = true;
                        dist[i][j][k] = 0;
                    }
                }
            }
        }

        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            int h1 = tmp[0];
            int n1 = tmp[1];
            int m1 = tmp[2];

            for (int i = 0; i < 6; i++) {
                int nh = h1 + dir[i][0];
                int nn = n1 + dir[i][1];
                int nm = m1 + dir[i][2];

                if (nh < 0 || nn < 0 || nm < 0 || nh >= h || nn >= n || nm >= m) continue;
                if (visit[nh][nn][nm]) continue;
                if (tomatoes[nh][nn][nm] == -1) continue;

                q.offer(new int[]{nh, nn, nm});
                tomatoes[nh][nn][nm] = 1;
                visit[nh][nn][nm] = true;
                dist[nh][nn][nm] = dist[h1][n1][m1] + 1;
                max = Math.max(max, dist[nh][nn][nm]);
            }
        }
    }

    static void graph() {
        bfs();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (tomatoes[i][j][k] == 0) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }
        System.out.println(max);
    }

    public static void main(String[] args) throws IOException {
        input();
        graph();
    }
}
