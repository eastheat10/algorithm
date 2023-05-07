package beakjoon.dfsandbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 유기농 배추
public class A1012 {

    static int t, m, n, k;
    static int result;
    static int[][] arr;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int[][] where;
    static boolean[][] visit;
    static StringBuilder sb = new StringBuilder();

    static void dfs(int x, int y){
        visit[x][y] = true;
        result++;

        for (int k = 0; k < 4; k++) {
            int nx = x + dir[k][0];
            int ny = y + dir[k][1];

            if(nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
            if(visit[nx][ny]) continue;
            if(arr[nx][ny] == 0) continue;
            dfs(nx, ny);
        }

    }

    static void process(){
        int answer = 0;
        for (int i = 0; i < k; i++) {
            result = 0;
            if(!visit[where[i][0]][where[i][1]])
                dfs(where[i][0], where[i][1]);

            if (result > 0) {
                answer++;
            }
        }
        sb.append(answer).append("\n");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            where = new int[k][2];
            arr = new int[m][n];
            visit = new boolean[m][n];
            for (int l = 0; l < k; l++) {

                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                arr[a][b] = 1;
                where[l] = new int[]{a, b};
            }

            process();
        }

        System.out.println(sb);
    }
}
