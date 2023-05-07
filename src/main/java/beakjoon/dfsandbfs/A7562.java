package beakjoon.dfsandbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 나이트의 이동
public class A7562 {

    static int i;
    static int x, y;
    static int dx, dy;
    static boolean[][] visit;
    static int[][] dir = {{1, 2}, {2, 1}, {1, -2}, {2, -1}, {-1, -2}, {-2, -1}, {-1, 2}, {-2, 1}};

    static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y, 0});
        visit[x][y] = true;

        while (!q.isEmpty()) {
            int[] tmp = q.poll();

            if (tmp[0] == dx && tmp[1] == dy)
                return tmp[2];

            for (int k = 0; k < 8; k++) {
                int nx = tmp[0] + dir[k][0];
                int ny = tmp[1] + dir[k][1];

                if (nx < 0 || nx >= i || ny < 0 || ny >= i) continue;
                if (visit[nx][ny]) continue;

                visit[nx][ny] = true;
                q.offer(new int[]{nx, ny, tmp[2] + 1});
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int j = 0; j < t; j++) {
            i = Integer.parseInt(br.readLine());
            visit = new boolean[i][i];

            StringTokenizer st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            dx = Integer.parseInt(st.nextToken());
            dy = Integer.parseInt(st.nextToken());

            int count = bfs();
            sb.append(count).append('\n');
        }

        System.out.println(sb);
    }
}