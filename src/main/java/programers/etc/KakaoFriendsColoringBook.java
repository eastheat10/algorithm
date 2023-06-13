package programers.etc;

import java.util.LinkedList;
import java.util.Queue;

public class KakaoFriendsColoringBook {

    private static final int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    public int[] solution(int m, int n, int[][] picture) {
        int area = 0;
        int max = Integer.MIN_VALUE;
        boolean[][] visit = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] == 0 || visit[i][j]) {
                    continue;
                }

                int result = bfs(i, j, picture, visit);
                max = Math.max(max, result);
                area++;
            }
        }

        return new int[] { area, max };
    }

    public int bfs(int a, int b, int[][] picture, boolean[][] visit) {
        int area = 1;
        int color = picture[a][b];
        Queue<int[]> q = new LinkedList<>();
        visit[a][b] = true;
        q.offer(new int[] { a, b });

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for (int[] d : dir) {
                int nx = x + d[0];
                int ny = y + d[1];

                if (nx < 0 || ny < 0 || nx >= picture.length || ny >= picture[0].length) {
                    continue;
                }
                if (visit[nx][ny]) {
                    continue;
                }
                if (picture[nx][ny] == 0 || picture[nx][ny] != color) {
                    continue;
                }

                visit[nx][ny] = true;
                q.offer(new int[] { nx, ny });
                area++;
            }
        }

        return area;
    }

}
