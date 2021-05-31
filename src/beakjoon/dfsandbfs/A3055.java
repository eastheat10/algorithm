package beakjoon.dfsandbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class A3055 {

    static int r, c;
    static String[] s;
    static boolean[][] visit;
    static int[][] dist;
    static int[][] distWater;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int endX, endY;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        s = new String[r];
        for (int i = 0; i < r; i++) {
            s[i] = br.readLine();
        }
        dist = new int[r][c];
        distWater = new int[r][c];
        visit = new boolean[r][c];
    }

    static void setDistWater(){
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                distWater[i][j] = -1;
                if (s[i].charAt(j) == '*') {
                    q.offer(new int[]{i, j});
                    visit[i][j] = true;
                }
            }
        }

        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            int x = tmp[0];
            int y = tmp[1];
            for (int k = 0; k < 4; k++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];

                if(nx < 0 || ny < 0 || nx >= r || ny >= c) continue;
                if(s[nx].charAt(ny) != '.') continue;
                if(visit[nx][ny]) continue;
                q.offer(new int[]{nx, ny});
                visit[nx][ny] = true;
                distWater[nx][ny] = dist[x][y] + 1;
            }
        }

    }

    static void bfs(){
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                visit[i][j] = false;
                dist[i][j] = -1;
                if (s[i].charAt(j) == 'S') {
                    q.offer(new int[]{i, j});
                    visit[i][j] = true;
                    dist[i][j] = 0;
                }
                if (s[i].charAt(j) == 'D') {
                    endX = i;
                    endY = j;
                }
            }
        }

        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            int x = tmp[0];
            int y = tmp[1];
            for (int k = 0; k < 4; k++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];
                if(nx < 0 || ny < 0 || nx >= r || ny >= c) continue;
                if(s[nx].charAt(ny) != '.' && s[nx].charAt(ny) != 'D') continue;
                if(visit[nx][ny]) continue;
                if(distWater[nx][ny] != -1 && dist[nx][ny] >= distWater[nx][ny]) continue;
                q.offer(new int[]{nx, ny});
                visit[nx][ny] = true;
                dist[nx][ny] = dist[x][y] + 1;
            }
        }

    }

    static void process(){
        setDistWater();
        bfs();

        if(dist[endX][endY] == -1)
            System.out.println("KAKTUS");
        else
            System.out.println(dist[endX][endY]);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
