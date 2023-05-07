package beakjoon.dfsandbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 벽 부수고 이동하기
public class AA2206 {

    static int n, m, wall = 0, answer = Integer.MAX_VALUE;
    static int[][] arr, dist, b;
    static boolean[][] visit;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            String s = br.readLine();
            for (int j = 1; j <= m; j++) {
                arr[i][j] = Character.getNumericValue(s.charAt(j - 1));
            }
        }
        b = new int[n * m + 1][2];
    }

    static void bfs() {
        Queue<int[]> q = new LinkedList<>();

        dist = new int[n + 1][m + 1];
        visit = new boolean[n + 1][m + 1];

        q.offer(new int[]{1, 1});
        visit[1][1] = true;
        dist[1][1] = 1;
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            int x = tmp[0];
            int y = tmp[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];

                if (nx < 1 || ny < 1 || nx > n || ny > m) continue;
                if (visit[nx][ny]) continue;
                if (arr[nx][ny] == 1) continue;

                q.offer(new int[]{nx, ny});
                visit[nx][ny] = true;
                dist[nx][ny] = dist[x][y] + 1;

            }
        }

        if (dist[n][m] > 0)
            answer = Math.min(answer, dist[n][m]);
    }

    static void dfs(int idx, int cnt) {
        if (cnt == 1) {
            bfs();
            return;
        }

        if (idx > wall) return;

        arr[b[idx][0]][b[idx][1]] = 0;
        dfs(idx + 1, cnt + 1);

        arr[b[idx][0]][b[idx][1]] = 1;
        dfs(idx + 1, cnt);

    }

    static void graph() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (arr[i][j] == 1) {
                    wall++;
                    b[wall][0] = i;
                    b[wall][1] = j;
                }
            }
        }
        dfs(1, 0);

        if (answer == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(answer);
    }

    public static void main(String[] args) throws IOException {
        input();
        graph();
    }

}