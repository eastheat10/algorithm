package beakjoon.dfsandbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 미로 탐색
public class A2178 {

    static int n, m ,count;
    static String[] s;
    static boolean visit[][];
    static int[][] dist;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        s = new String[n + 1];
        for (int i = 0; i < n; i++) {
            s[i] = br.readLine();
        }
        dist = new int[n][m];
        visit = new boolean[n][m];
        count = 0;
    }

    static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        dist[x][y] = 1;
        visit[x][y] = true;

        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            x = tmp[0];
            y = tmp[1];
            for (int k = 0; k < 4; k++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (visit[nx][ny]) continue;
                if (s[nx].charAt(ny) == '0') continue;
                q.add(new int[]{nx, ny});
                visit[nx][ny] = true;
                dist[nx][ny] = dist[x][y] + 1;
            }
        }

    }

    static void process() {
        bfs(0, 0);
        System.out.println(dist[n - 1][m - 1]);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
