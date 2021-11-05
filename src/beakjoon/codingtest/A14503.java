import java.io.*;
import java.util.*;

// 로봇 청소기
@SuppressWarnings("unchecked")
class Main {

    static int n, m, r, c, d, cleaning = 0;
    static int[][] map , dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};  // 북동남서

    public static void main(String[] args) throws IOException {
        input();
        process();
        System.out.println(cleaning);
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void process() {
            
        boolean canCleaning = true;
        // 회전 횟수
        int count = 0;

        int x = r;
        int y = c;

        while (true) {
            // 1번
            if (canCleaning) {
                map[x][y] = 2;
                cleaning++;
            }

            // 2번
            int direction = (d + 3) % 4;    // 현재 기준 왼쪽
            // 왼쪽 칸
            x = r + dir[direction][0];
            y = c + dir[direction][1];
            if (x < 0 || y < 0 || x >= n || y >= m) break;
            // a
            if(map[x][y] == 0) {
                // 왼쪽 청소 가능
                canCleaning = true;
                d = direction;
                r = x;
                c = y;
                count = 0;
            } else {
                // 청소 불가
                canCleaning = false;
                if (count == 4) { 
                    // 4방향 모두 확인
                    // 뒤쪽 방향
                    int bx = r + dir[(d + 2) % 4][0];
                    int by = c + dir[(d + 2) % 4][1];
                    if (map[bx][by] == 1) { // d
                        // 모두 벽
                        return;
                    } else {    // c
                        // 후진
                        r = bx;
                        c = by;
                        count = 0;
                    }
                } else {    // b
                    /// 왼쪽으로 회전
                    d = direction;
                    count++;
                }
            }

        }
    }

}