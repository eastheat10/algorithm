package beakjoon.dfsandbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 섬의 개수
public class A4963 {

    static int w, h;
    static int[][] arr;  // 1 땅, 0 바다
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
    static boolean[][] visit;
    static StringBuilder sb = new StringBuilder();

    static void dfs(int x, int y) {
        visit[x][y] = true;
        for (int k = 0; k < 8; k++) {
            int nx = x + dir[k][0];
            int ny = y + dir[k][1];

            if(nx < 0 || ny < 0 || nx >= w || ny >= h) continue;
            if(visit[nx][ny]) continue;
            if(arr[nx][ny] == 0) continue;
            dfs(nx, ny);
        }
    }

    static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visit[x][y] = true;
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            x = tmp[0];
            y = tmp[1];
            for (int k = 0; k < 8; k++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];
                if(nx < 0 || ny < 0 || nx >= w || ny >= h) continue;
                if(visit[nx][ny]) continue;
                if(arr[nx][ny] == 0) continue;
                q.offer(new int[]{nx, ny});
                visit[nx][ny] = true;
            }
        }
    }

    static void process() {
        int answer = 0;
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                if(!visit[i][j] && arr[i][j] == 1) {
                    bfs(i, j);
                    answer++;
                }
            }
        }
        sb.append(answer).append("\n");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if (w == 0 && h == 0) break;

            arr = new int[w][h];
            visit = new boolean[w][h];

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    arr[j][i] = Integer.parseInt(st.nextToken());
                }
            }
            process();
        }

        System.out.println(sb);
    }
}
