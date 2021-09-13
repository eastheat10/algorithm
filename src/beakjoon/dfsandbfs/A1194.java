package beakjoon.dfsandbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 달이 차오른다, 가자.
public class A1194 {

    static class Node {
        int x;
        int y;
        int cnt;
        int key;

        public Node(int x, int y, int cnt, int key) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.key = key;
        }
    }

    static int n, m;
    static String[] maze;
    static boolean[][][] visit;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static Node start;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        maze = new String[n];
        visit = new boolean[n][m][1 << 6];  // 1 << 6 = 64 1000000

        for (int i = 0; i < n; i++) {
            maze[i] = br.readLine();
            for (int j = 0; j < maze[i].length(); j++) {
                if (maze[i].charAt(j) == '0')
                    start = new Node(i, j, 0, 0);
            }
        }
    }

    static void bfs() {
        Queue<Node> q = new LinkedList<>();

        q.offer(new Node(start.x, start.y, 0, 0));

        while (!q.isEmpty()) {
            Node node = q.poll();
            int x = node.x;
            int y = node.y;
            int cnt = node.cnt;
            int key = node.key;

            if (maze[x].charAt(y) == '1') {
                System.out.println(cnt);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

                int point = (int) maze[nx].charAt(ny);
                if (visit[nx][ny][key]) continue;
                if (point == '#') continue;

                if (point >= 'A' && point <= 'F') {
                    // 문일 때
                    // 해당 문에 맞는 키가 있나 조회
                    int door = (1 << (maze[nx].charAt(ny) - 'A')) & key;

                    if (door > 0) {
                        visit[nx][ny][key] = true;
                        q.offer(new Node(nx, ny, cnt + 1, key));
                    }
                } else if (point >= 'a' && point <= 'f') {
                    // 열쇠일 때
                    // 열쇠 추가
                    int newKey = (1 << (maze[nx].charAt(ny) - 'a')) | key;

                    if (!visit[nx][ny][newKey]) {
                        visit[nx][ny][newKey] = true;
                        visit[nx][ny][key] = true;
                        q.offer(new Node(nx, ny, cnt + 1, newKey));
                    }
                } else {
                    // 그냥 통로
                    visit[nx][ny][key] = true;
                    q.offer(new Node(nx, ny, cnt + 1, key));
                }
            }
        }
        System.out.println(-1);

    }

    public static void main(String[] args) throws IOException {
        input();
        bfs();
    }
}
