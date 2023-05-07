package beakjoon.dfsandbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 안전영역
public class A2468 {

    static int n, maxHeight = Integer.MIN_VALUE, result = Integer.MIN_VALUE;
    static int[][] arr, dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static boolean visit[][];

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, arr[i][j]);
            }
        }
    }

    static void bfs(int h, int x1, int y1) {
        Queue<int[]> q = new LinkedList<>();
        visit[x1][y1] = true;
        q.offer(new int[]{x1, y1});

        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            int x = tmp[0];
            int y = tmp[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];

                if (nx < 1 || ny < 1 || nx > n || ny > n) continue;
                if (visit[nx][ny]) continue;
                if (arr[nx][ny] <= h) continue;

                visit[nx][ny] = true;
                q.offer(new int[]{nx, ny});
            }
        }
    }

    static void process() {

        for (int h = 0; h < maxHeight; h++) {
            int count = 0;
            visit = new boolean[n + 1][n + 1];
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    if (arr[j][k] > h && !visit[j][k]) {
                        bfs(h, j, k);
                        count++;
                    }
                }
            }
            result = Math.max(result, count);
        }
        System.out.println(result);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
