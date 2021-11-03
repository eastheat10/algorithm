import java.io.*;
import java.util.*;

// 아기 상어
@SuppressWarnings("unchecked")
class Main {
    static class Fish {
        int x;
        int y;
        int time;
        public Fish(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
    
    static int n;
    static int[][] map, dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static boolean[][] visit;

    static Fish shark;
    static int size = 2;
    static int eaten = 0;
    static int result = 0;

    static PriorityQueue<Fish> feed = new PriorityQueue<>((f1, f2) -> {
            if (f1.time == f2.time) {
                // 거리가 같으면
                if (f1.x == f2.x) {
                    // 가장 위에 
                    return f1.y - f2.y;
                } else {
                    // 가장 왼쪽
                    return f1.x - f2.x;
                }
            } else {
                // 거리가 작은 순서
                return f1.time - f2.time;
            }
    });

    public static void main(String[] args) throws IOException {
        input();
        process();
        System.out.println(result);
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    shark = new Fish(i, j, 0);
                    map[i][j] = 0;
                }
            }
        }
    }

    static void process() {
        while (true) {
            // 먹을 수 있는 물고기를 다 먹을 때 까지 반복
            bfs();
            if (feed.isEmpty()) break;
            eat();
        }
    }

    // bfs를 통해서 먹을 수 있는 물고기를 찾는다.
    static void bfs() {    
        Queue<Fish> q = new LinkedList<>();
        q.offer(shark);
        visit = new boolean[n + 1][n + 1];
        visit[shark.x][shark.y] = true;

        while(!q.isEmpty()) {
            Fish fish = q.poll();
            int time = fish.time;

            for (int i = 0; i < 4; i++) {
                int nx = fish.x + dir[i][0];
                int ny = fish.y + dir[i][1];

                // 범위 안에 있고 사이즈가 작은 물고기만 먹을 수 있음
                if (nx < 1 || ny < 1 || nx > n || ny > n) continue;
                if (visit[nx][ny]) continue;
                if (size < map[nx][ny]) continue;

                if (map[nx][ny] < size && map[nx][ny] > 0) {
                    // 크기가 작은 물고기가 있으면 먹이목록에 넣는다.
                    feed.add(new Fish(nx, ny, time + 1));
                }

                q.offer(new Fish(nx, ny, time + 1));
                visit[nx][ny] = true;
            }
        }

    }

    static void eat() {
        Fish fish = feed.poll();

        shark.x = fish.x;
        shark.y = fish.y;
        eaten++;

        if (eaten == size) {
            size++;
            eaten = 0;
        }

        result += fish.time;
        // 물고기를 먹었으면 해당 위치를 0으로 바꿔준다.
        map[fish.x][fish.y] = 0;
        feed.clear();
    }

}