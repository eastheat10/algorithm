import java.io.*;
import java.util.*;

// 감시
@SuppressWarnings("unchecked")
class Main {

    static int n, m, size = Integer.MAX_VALUE, cctvCount;
    static int[][] area, copyMap, dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static ArrayList<CCTV> cctvList = new ArrayList<>();
    static class CCTV {
        int x;
        int y;
        int num;
        CCTV(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }
    

    public static void main(String[] args) throws IOException {
        input();
        process();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        area = new int[n + 1][m + 1];
<<<<<<< HEAD
=======
        visit = new boolean[n + 1][m + 1];
>>>>>>> 57addc685384abfa906347cb997e66717ea20fbf

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
                if (area[i][j] > 0 && area[i][j] < 6) {
                    cctvList.add(new CCTV(i, j, area[i][j]));
                }
            }
        }

        cctvCount = cctvList.size();
    }

    static void process() {
        func(0, 0, area);
        System.out.println(size);
    }

    static void func(int depth, int start, int[][] map) {
        if (cctvCount == 0) {
            copy(area);
            size = checkArea();
            return;
        }
        if (cctvCount == depth) {
            int width = checkArea();
            size = Math.min(size, width);
            return;
        }

        for (int i = 0; i < 4; i++) {
            copy(map);
            CCTV cctv = cctvList.get(start);
            if (cctv.num == 2 || cctv.num == 5) {
                if (i == 2)
                    break;
                if (cctv.num == 5 && i == 1)
                    break;
            }
            changeView(cctv, i);
            func(depth + 1, start + 1, copyMap);
        }
    }

    static void copy(int[][] map) {
        copyMap = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                copyMap[i][j] = map[i][j];
            }
        }
    }

    static void changeView(CCTV cctv, int direction) {
        switch(cctv.num) {
            case 1:
                bfs(direction, cctv);
                break;
            case 2:
                bfs(direction, cctv);
                bfs((direction + 2) % 4, cctv);
                break;
            case 3:
                bfs(direction, cctv);
                bfs((direction + 1) % 4, cctv);
                break;
            case 4:
                bfs(direction, cctv);
                bfs((direction + 1) % 4, cctv);
                bfs((direction + 2) % 4, cctv);
                break;
            case 5:
                bfs(direction, cctv);
                bfs((direction+1) % 4, cctv);
                bfs((direction+2) % 4, cctv);
                bfs((direction+3) % 4, cctv);
                break;
        }
    }

    static void bfs(int direction, CCTV cctv) {
        int x = cctv.x;
        int y = cctv.y;
        while(true) {
            x += dir[direction][0];
            y += dir[direction][1];

            if (x < 1 || y < 1 || x > n || y > m) break;
            if (copyMap[x][y] == 6) break;
            if (copyMap[x][y] > 1 && copyMap[x][y] < 6) continue;
            
            copyMap[x][y] = 7;
        }
    }

    static int checkArea() {
        int width = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (copyMap[i][j] == 0) {
                    width++;
                }
            }
        }
        return width;
    }
}