package beakjoon.dfsandbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 연구소
public class A14502 {

    static int n, m, wall, answer;
    static int[][] a;   // 연구실 구조 입력
    static int[][] blank;   // 벽을 세울 수 있는 곳 (0)
    static boolean[][] visit;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        a = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        wall = 0;
        answer = 0;
        visit = new boolean[n + 1][m + 1];
        blank = new int[n * m + 1][2];
    }

    static void bfs() {
        Queue<int[]> q = new LinkedList<>();

        // 모든 바이러스 위치를 큐에 입력
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                visit[i][j] = false;
                if (a[i][j] == 2) {
                    q.add(new int[]{i, j});
                    visit[i][j] = true;
                }
            }
        }
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            int x = tmp[0];
            int y = tmp[1];
            for (int k = 0; k < 4; k++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];
                if(nx < 1 || ny < 1 || nx > n || ny > m) continue;
                if(a[nx][ny] != 0) continue;
                if(visit[nx][ny]) continue;
                visit[nx][ny] = true;
                q.add(new int[]{nx, ny});
            }
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (a[i][j] == 0 && !visit[i][j]) {
                    count++;
                }
            }
        }
        answer = Math.max(count, answer);
    }

    // idx번째 빈칸에 벽을 세워야 하고 cnt개의 벽을 세워놓음
    static void dfs(int idx, int cnt) {
        if(cnt == 3) {
            bfs();
            return;
        }

        if(idx > wall)
            return;

        a[blank[idx][0]][blank[idx][1]] = 1;
        dfs(idx + 1, cnt + 1);

        a[blank[idx][0]][blank[idx][1]] = 0;
        dfs(idx + 1, cnt);

    }

    static void process() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (a[i][j] == 0) {
                    wall++; // 벽을 세울 수 있는 총 개수
                    blank[wall][0] = i;
                    blank[wall][1] = j;
                }
            }
        }
        dfs(1, 0);
        System.out.println(answer);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
