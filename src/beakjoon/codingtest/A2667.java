import java.io.*;
import java.util.*;

// 단지 번호 붙이기
@SuppressWarnings("unchecked")
class Main {

    static int n;
    static int[][] apt, dir = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        input();
        process();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        apt = new int[n + 1][n + 1];
        visit = new boolean[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            String s = br.readLine();
            for (int j = 1; j <= n; j++) {
                int t = 0;
                if (s.charAt(j - 1) == '1')
                    t = 1;
                apt[i][j] = t;
            }
        }
    }

    static void process() {
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> count = new ArrayList<>();
        int result = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (apt[i][j] == 1 && !visit[i][j]) {
                    Integer cnt = bfs(i, j);
                    count.add(cnt);
                    result++;
                }
            }
        }

        count.sort((o1, o2) -> o1 - o2);

        sb.append(result).append('\n');
        for (Integer i : count) 
            sb.append(i).append('\n');

        System.out.println(sb);
        
    }

    static Integer bfs(int i, int j) {
        Integer cnt = 1;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j});
        visit[i][j] = true;

        while(!q.isEmpty()) {
            int[] tmp = q.poll();
            int x = tmp[0];
            int y = tmp[1];
            for (int t = 0; t < 4; t++) {
                int nx = x + dir[t][0];
                int ny = y + dir[t][1];

                if (nx < 1 || ny < 1 || nx > n || ny > n) continue;
                if (visit[nx][ny]) continue;
                if (apt[nx][ny] == 0) continue;

                q.offer(new int[]{nx, ny});
                visit[nx][ny] = true;
                cnt++;
            }
        }

        return cnt;

    }

}