package programers.etc;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 리코쳇 로봇
 * <p>
 * https://school.programmers.co.kr/learn/courses/30/lessons/169199
 */
public class RicochetRobot {

    private static final int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
    private static final char START = 'R';
    private static final char GOAL = 'G';
    private static final char WALL = 'D';

    private int dx, dy, gx, gy;

    private String[] board;
    private int[][] dist;
    private boolean[][] visit;

    public int solution(String[] board) {

        init(board);

        bfs();

        return dist[gx][gy];
    }

    private void bfs() {

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { dx, dy });
        visit[dx][dy] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for (int[] d : dir) {

                int nx = x;
                int ny = y;

                while (true) {
                    nx += d[0];
                    ny += d[1];

                    if (isWall(nx, ny)) {
                        nx -= d[0];
                        ny -= d[1];
                        break;
                    }
                }

                if (visit[nx][ny]) {
                    continue;
                }


                visit[nx][ny] = true;
                dist[nx][ny] = dist[x][y] + 1;

                if (board[nx].charAt(ny) == GOAL) {
                    return;
                }
                q.offer(new int[] { nx, ny });
            }
        }

    }

    private boolean isWall(int x, int y) {
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length()) {
            return true;
        }
        return board[x].charAt(y) == WALL;
    }

    private void init(String[] board) {
        this.board = board;
        this.dist = new int[board.length][board[0].length()];
        this.visit = new boolean[board.length][board[0].length()];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length(); j++) {
                if (board[i].charAt(j) == START) {
                    dx = i;
                    dy = j;
                }

                if (board[i].charAt(j) == GOAL) {
                    dist[i][j] = -1;
                    gx = i;
                    gy = j;
                }
            }
        }

    }

}
