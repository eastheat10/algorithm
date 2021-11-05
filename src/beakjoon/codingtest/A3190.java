import java.io.*;
import java.util.*;

// 뱀
@SuppressWarnings("unchecked")
class Main {

    static class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static Queue<Point> direction = new LinkedList<>();
    static Deque<Point> snake = new ArrayDeque<>();
    static int n, k, l, time = 0;
    static int[][] map, dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};  // 오른쪽부터 시계방향
    static int snakeDirection = 0;  // {1, 0}이 오른쪽을 향한다.

    public static void main(String[] args) throws IOException {
        input();
        dummy();
        System.out.println(time);
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        map = new int[n + 1][n + 1];
        map[1][1] = -1;
        snake.offer(new Point(1, 1));

        
        for (int i = 0; i < k; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // 사과
            map[x][y] = 1;
        }
        
        l = Integer.parseInt(br.readLine());
        for (int i = 0; i < l; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            char ch = st.nextToken().charAt(0);
            int c = 1;
            if (ch == 'L')
                c = 0;
            direction.add(new Point(x, c));
        }

    }

    static void dummy() {
        Point d = direction.poll();
        int X = d.x;
        int C = d.y;

        while(true) {
            time++;

            Point head = snake.peek();
            int nx = head.x + dir[snakeDirection][0];
            int ny = head.y + dir[snakeDirection][1];

            if (nx < 1 || ny < 1 || nx > n || ny > n || map[nx][ny] == -1) {
                // 벽이나 몸에 부딪히면 끝
                break;
            }
             
            
            if (map[nx][ny] != 1) {
                //  사과가 없다면 꼬리칸 비우기
                Point tail = snake.pollLast();
                map[tail.x][tail.y] = 0;
            }

            snake.offerFirst(new Point(nx, ny));
            map[nx][ny] = -1;

            if (time == X) {
                if (C == 0) {
                    //  0이면 왼쪽으로 90도 
                    snakeDirection = (snakeDirection + 3) % 4;
                } else {
                    // 1이면 오른쪽으로 90도
                    snakeDirection = (snakeDirection + 1) % 4;
                }

                if (!direction.isEmpty()) {
                    d = direction.poll();
                    X = d.x;
                    C = d.y;
                }
            }
        }

    }

}