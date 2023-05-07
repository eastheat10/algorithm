package beakjoon.dfsandbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

// 단지 번호 붙이기
public class A2667 {

    static int n, groupCount;
    static String[] s;
    static boolean[][] visit;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static ArrayList<Integer> countList = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        s = new String[n];
        for (int i = 0; i < n; i++)
            s[i] = br.readLine();
        visit = new boolean[n][n];
    }

    static void dfs(int x, int y) {
        groupCount++;
        visit[x][y] = true;
        for (int k = 0; k < 4; k++) {
            int nx = x + dir[k][0];
            int ny = y + dir[k][1];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
            if (visit[nx][ny]) continue;
            if (s[nx].charAt(ny) == '0') continue;
            dfs(nx, ny);
        }
    }

    static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        groupCount++;
        visit[x][y] = true;

        while (!q.isEmpty()){
            int[] poll = q.poll();
            int cx = poll[0];
            int cy = poll[1];

            for (int k = 0; k < 4; k++) {
                int nx = cx + dir[k][0];
                int ny = cy + dir[k][1];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (visit[nx][ny]) continue;
                if (s[nx].charAt(ny) == '0') continue;
                q.offer(new int[]{nx, ny});
                visit[nx][ny] = true;
                groupCount++;
            }

        }
    }

    static void process() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j] && s[i].charAt(j) == '1') {
                    groupCount = 0;
                    bfs(i, j);
                    countList.add(groupCount);
                }
            }
        }
        Collections.sort(countList);
        sb.append(countList.size()).append("\n");
        for (Integer integer : countList)
            sb.append(integer).append("\n");

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }

}
