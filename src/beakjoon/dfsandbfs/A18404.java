
package beakjoon.dfsandbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 현명한 나이트
public class A18404 {

    static int n, m, x, y;
    static int[][] dist;
    static boolean[][] visit;
    static int[][] dir = {{1, 2}, {2, 1}, {1, -2}, {2, -1}, {-1, -2}, {-2, -1}, {-1, 2}, {-2, 1}};
    static ArrayList<int[]> e = new ArrayList<>();

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dist = new int[n + 1][n + 1];
        visit = new boolean[n + 1][n + 1];

        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            e.add(new int[]{x1, y1});
        }
    }

    static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visit[x][y] = true;

        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            int x = tmp[0];
            int y = tmp[1];

            for (int i = 0; i < 8; i++) {
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];

                if (nx < 1 || ny < 1 || nx > n || ny > n) continue;
                if (visit[nx][ny]) continue;

                q.offer(new int[]{nx, ny});
                visit[nx][ny] = true;
                dist[nx][ny] = dist[x][y] + 1;
            }
        }

    }

    static void print() {
        StringBuilder sb = new StringBuilder();
        for (int[] ints : e) {
            int x1 = ints[0];
            int y1 = ints[1];
            sb.append(dist[x1][y1]).append(" ");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        input();
        bfs();
        print();
    }
}
