package beakjoon.dfsandbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 벽 부수고 이동하기
public class A2206 {

    static int n, m;
    static int[][] arr, visit;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    static class C {
        int x, y, dis;
        int wall;

        public C(int x, int y, int dis, int wall) {
            this.x = x;
            this.y = y;
            this.dis = dis;
            this.wall = wall;
        }
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n + 1][m + 1];
        visit = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            String s = br.readLine();
            for (int j = 1; j <= m; j++) {
                arr[i][j] = Character.getNumericValue(s.charAt(j - 1));
                visit[i][j] = Integer.MAX_VALUE;
            }
        }
    }

    static int bfs() {
        Queue<C> q = new LinkedList<>();
        q.offer(new C(1, 1, 1, 0));
        visit[1][1] = 0;

        while (!q.isEmpty()) {
            C c = q.poll();

            if (c.x == n && c.y == m)
                return c.dis;

            for (int i = 0; i < 4; i++) {
                int nx = c.x + dir[i][0];
                int ny = c.y + dir[i][1];

                if (nx < 1 || ny < 1 || nx > n || ny > m) continue;
                // 벽을 안 부수고 온 방향에서 이미 탐색 했으면 continue
                // visit[nx][ny]가 벽을 부수고 온 쪽에서 탐색 해야하면 현재 값보다 커짐
                if (visit[nx][ny] <= c.wall) continue;

                if (arr[nx][ny] == 0) {  // 벽이 아닐 때
                    q.offer(new C(nx, ny, c.dis + 1, c.wall));
                    visit[nx][ny] = c.wall;
                } else {
                    if (c.wall == 0) {
                        q.offer(new C(nx, ny, c.dis + 1, c.wall + 1));
                        visit[nx][ny] = c.wall + 1;
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(bfs());
    }
/*
8 8
01000100
01010100
01010100
01010100
01010100
01010100
01010100
00010100
29

5 10
0000011000
1101011010
0000000010
1111111110
1111000000
14

5 5
01100
01000
01110
01000
00010
9
*/
}

