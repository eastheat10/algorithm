package beakjoon.dfsandbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 양
public class A3184 {

    static int r, c;
    static String[] s;
    static boolean[][] visit;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int sheep;  // o
    static int wolf; // v

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        s = new String[r];
        for (int i = 0; i < r; i++)
            s[i] = br.readLine();
        visit = new boolean[r][c];
    }

    static void dfs(int x, int y) {
        visit[x][y] = true;
        char cc = s[x].charAt(y);
        if(cc == 'v') wolf++;
        if(cc == 'o') sheep++;

        for (int k = 0; k < 4; k++) {
            int nx = x + dir[k][0];
            int ny = y + dir[k][1];

            if(nx < 0 || ny < 0 || nx >= r || ny >= c) continue;
            if(visit[nx][ny]) continue;
            char c = s[nx].charAt(ny);
            if(c == '#') continue;

            dfs(nx, ny);

        }

    }

    static void process() {
        int wo = 0;
        int sh = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                char c = s[i].charAt(j);
                if (!visit[i][j] && (c != '#')) {
                    sheep = 0;
                    wolf = 0;
                    dfs(i, j);
                    if(sheep > wolf) wolf = 0;
                    else sheep = 0;
                    wo += wolf;
                    sh += sheep;
                }
            }
        }
        System.out.println(sh + " " + wo);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }

}
