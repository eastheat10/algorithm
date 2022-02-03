package beakjoon.dfsandbfs;

import java.util.*;
import java.io.*;

// 영역 구하기 햐
public class A2583 {

    static int m, n, k;
    static int[][] arr;
    static boolean[][] visit;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static ArrayList<Integer> widthList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        input();
        process();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

       arr = new int[n + 1][m + 1];
       visit = new boolean[n + 1][m + 1];
       for (int i = 0; i < k; i++) {
        st = new StringTokenizer(br.readLine());

        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());

        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());

        for (int f = x1; f < x2; f++) {
            for (int g = y1; g < y2; g++) {
                arr[f][g] = 1;
            }
        }
       }
    }

    static void process() {
        StringBuilder sb = new StringBuilder();
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visit[i][j] && arr[i][j] == 0) {
                    widthList.add(bfs(i, j));
                    cnt++;
                }
            }
        }

        widthList.sort((o1, o2) -> o1 - o2);
        
        sb.append(cnt).append('\n');
        for (Integer i : widthList) 
            sb.append(i).append(" ");
        
        System.out.println(sb);
        
    }

    static int bfs(int x, int y) {
        int width = 1;
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{x, y});
        visit[x][y] = true;
        
        while(!q.isEmpty()) {
            int[] tmp = q.poll();
            int x1 = tmp[0];
            int y1 = tmp[1];

            for (int i = 0; i < 4; i++) {
                int nx = x1 + dir[i][0];
                int ny = y1 + dir[i][1];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (visit[nx][ny]) continue;
                if (arr[nx][ny] == 1) continue;
                
                q.offer(new int[]{nx, ny});
                visit[nx][ny] = true;

                width++;
            }
        }

        return width;
    }
    
}