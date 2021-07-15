package beakjoon.dfsandbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 적록색약
public class A10026 {

    static int n;
    static String[] wall;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static boolean[][] visit;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        wall = new String[n];

        for (int i = 0; i < n; i++)
            wall[i] = br.readLine();

    }

    static void bfs(char c, int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visit[x][y] = true;

        while (!q.isEmpty()) {
            int[] tmp = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = tmp[0] + dir[i][0];
                int ny = tmp[1] + dir[i][1];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if (visit[nx][ny]) continue;
                if (wall[nx].charAt(ny) == c) {
                    q.offer(new int[]{nx, ny});
                    visit[nx][ny] = true;
                }
            }
        }

    }

    static void colorBfs(char c, int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visit[x][y] = true;

        while (!q.isEmpty()) {
            int[] tmp = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = tmp[0] + dir[i][0];
                int ny = tmp[1] + dir[i][1];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if (visit[nx][ny]) continue;
                if (c == 'B') {
                    if (wall[nx].charAt(ny) == 'B') {
                        q.offer(new int[]{nx, ny});
                        visit[nx][ny] = true;
                    }
                } else {
                    if (wall[nx].charAt(ny) != 'B') {
                        q.offer(new int[]{nx, ny});
                        visit[nx][ny] = true;
                    }
                }
            }
        }
    }

    static void dfs(char c, int x, int y) {
        visit[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];

            if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
            if (visit[nx][ny]) continue;
            if (wall[nx].charAt(ny) == c)
                dfs(c, nx, ny);
        }
    }

    static void colorDfs(char c, int x, int y) {
        visit[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];

            if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
            if (visit[nx][ny]) continue;
            if (c == 'B') {
                if (wall[nx].charAt(ny) == 'B')
                    colorDfs(c, nx, ny);
            } else {
                if (wall[nx].charAt(ny) != 'B')
                    colorDfs(c, nx, ny);
            }
        }
    }

    static void find() {
        StringBuilder sb = new StringBuilder();
        int count1 = 0;
        int count2 = 0;

        visit = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j]) {
//                    bfs(wall[i].charAt(j), i, j);
                    dfs(wall[i].charAt(j), i, j);
                    count1++;
                }
            }
        }

        visit = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j]) {
//                    colorBfs(wall[i].charAt(j), i, j);
                    colorDfs(wall[i].charAt(j), i, j);
                    count2++;
                }
            }
        }

        sb.append(count1).append(" ").append(count2);
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        input();
        find();
    }
}
