package beakjoon.shortestpath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class A16988_Baaaaaaaaaduk2 {

    static int n, m;
    static int[][] map, dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static boolean[][] visit;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        input();
        process();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

    }

    static void process() {
        dfs(0, 1, 1);
        System.out.println(result);
    }

    static void dfs(int depth, int r, int c) {
        if (depth == 2) {
            visit = new boolean[n + 1][m + 1];
            int sum = 0;

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (!visit[i][j] && map[i][j] == 2) {
                        sum += bfs(i, j);
                    }
                }
            }
            result = Math.max(result, sum);
            return;
        }

        for (int i = r; i <= n; i++) {
            int k = (i == r) ? c + 1 : 1;
            for (int j = k; j <= m; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(depth + 1, i, j);
                    map[i][j] = 0;
                }
            }
        }
    }

    static int bfs(int x, int y) {
        int count = 1;
        Queue<int[]> q = new LinkedList<>();
        visit[x][y] = true;
        q.offer(new int[]{x, y});
        boolean flag = false;

        while (!q.isEmpty()) {
            int[] p = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = p[0] + dir[i][0];
                int ny = p[1] + dir[i][1];

                if (nx < 1 || ny < 1 || nx > n || ny > m) continue;
                if (visit[nx][ny]) continue;
                if (map[nx][ny] == 1) continue;
                if (map[nx][ny] == 0)
                    flag = true;
                if (map[nx][ny] == 2) {
                    q.offer(new int[]{nx, ny});
                    visit[nx][ny] = true;
                    count++;
                }
            }
        }
        if (flag)
            return 0;

        return count;
    }

}