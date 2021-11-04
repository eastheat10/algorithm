import java.io.*;
import java.util.*;

// 인구 이동
@SuppressWarnings("unchecked")
class Main {

    static class Nation {
        int x;
        int y;
        Nation(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int n, l, r, day = 0;
    static int[][] map, dir = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    static boolean[][] visit;
    static ArrayList<Nation> union = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        input();
        process();
        System.out.println(day);
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        map = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

    }

    static void process() {
        while (true) {
            int cnt = 0;
            visit = new boolean[n + 1][n + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (visit[i][j]) continue;
                    bfs(i, j);
                    if (union.size() > 1) {
                        migrate();
                        cnt++;
                    }
                }
            }
            if (cnt > 0) {
                day++;
                cnt = 0;
            }
            if (check())
                return;
        }
    }

    static void bfs(int row, int col) {
        Queue<Nation> q = new LinkedList<>();
        Nation na = new Nation(row, col);
        union.add(na);
        q.offer(na);
        visit[row][col] = true;

        while (!q.isEmpty()) {
            Nation nation = q.poll();
            int x = nation.x;
            int y = nation.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];

                if (nx < 1 || ny < 1 || nx > n || ny > n) continue;
                if (visit[nx][ny]) continue;
                int m = Math.abs(map[x][y] - map[nx][ny]);
                if (l <= m && m <= r) {
                    Nation nation1 = new Nation(nx, ny);
                    union.add(nation1);
                    q.offer(nation1);
                    visit[nx][ny] = true;
                }
            }
        }

        if (union.size() == 1)
            union.clear();
        
    }

    static void migrate() {
        int sum = 0;
        int size = union.size();
        for (Nation nation : union) {
            sum += map[nation.x][nation.y];
        }
        int avg = sum / size;
        for (Nation nation : union) {
            map[nation.x][nation.y] = avg;
        }
        union.clear();

    }

    static boolean check() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int x = i;
                int y = j;
                for (int k = 0; k < 4; k++) {
                    int nx = x + dir[k][0];
                    int ny = y + dir[k][1];
                    if (nx < 1 || ny < 1 || nx > n || ny > n) continue;
                    int m = Math.abs(map[x][y] - map[nx][ny]);
                    if (l <= m && m <= r) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

}