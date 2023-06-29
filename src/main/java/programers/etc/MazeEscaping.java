package programers.etc;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 미로 탈출
 * <p>
 * https://school.programmers.co.kr/learn/courses/30/lessons/159993
 */
public class MazeEscaping {

    private static final int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
    private int sx, sy, lx, ly, ex, ey;
    private int[][] dist;
    private boolean[][] visit;
    private String[] maps;

    public int solution(String[] maps) {
        init(maps);

        int toLever = bfs(sx, sy, lx, ly);
        int toExit = bfs(lx, ly, ex, ey);

        if (toLever == 0 || toExit == 0) {
            return -1;
        }

        return toLever + toExit;
    }

    private void init(String[] maps) {
        this.maps = maps;
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length(); j++) {
                char c = maps[i].charAt(j);
                if (c == 'S') {
                    sx = i;
                    sy = j;
                } else if (c == 'E') {
                    ex = i;
                    ey = j;
                } else if (c == 'L') {
                    lx = i;
                    ly = j;
                }
            }
        }
    }

    private int bfs(int startX, int startY, int endX, int endY) {
        Queue<int[]> q = new LinkedList<>();
        visit = new boolean[maps.length][maps[0].length()];
        dist = new int[maps.length][maps[0].length()];

        visit[startX][startY] = true;
        q.offer(new int[] { startX, startY });

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            if (x == endX && y == endY) {
                return dist[x][y];
            }

            for (int[] d : dir) {
                int nx = x + d[0];
                int ny = y + d[1];

                if (nx < 0 || ny < 0 || nx >= maps.length || ny >= maps[0].length()) {
                    continue;
                }
                if (visit[nx][ny]) {
                    continue;
                }
                if (maps[nx].charAt(ny) == 'X') {
                    continue;
                }

                q.offer(new int[] { nx, ny });
                visit[nx][ny] = true;
                dist[nx][ny] = dist[x][y] + 1;
            }
        }

        return 0;
    }

}