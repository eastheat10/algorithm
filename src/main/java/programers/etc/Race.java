package programers.etc;

import java.util.Queue;
import java.util.LinkedList;

public class Race {
    public int solution(int[][] board) {
        int n = board.length;
        boolean[][] visit = new boolean[n][n];
        int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int cost = Integer.MAX_VALUE;

        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0, 0, -1, 0));
        visit[0][0] = true;

        while (!q.isEmpty()) {
            Point point = q.poll();

            if (point.x == n - 1 && point.y == n - 1) {
                cost = Math.min(cost, point.cost);
            }

            for (int i = 0; i < 4; i++) {
                int nx = point.x + dir[i][0];
                int ny = point.y + dir[i][1];
                int nDir = i;
                int nCost = point.cost;

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if (board[nx][ny] == 1) continue;
                if (point.dir == -1 || point.dir == nDir) {
                    nCost += 100;
                } else {
                    nCost += 600;
                }

                if (visit[nx][ny] && board[nx][ny] < nCost) continue;

                visit[nx][ny] = true;
                board[nx][ny] = nCost;
                q.offer(new Point(nx, ny, nDir, nCost));

            }
        }

        return cost;
    }

    static class Point {
        int x, y, dir, cost;

        public Point(int x, int y, int dir, int cost) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cost = cost;
        }
    }
}
