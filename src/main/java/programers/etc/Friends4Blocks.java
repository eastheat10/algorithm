package programers.etc;

import java.util.HashSet;
import java.util.Set;

/**
 * 프렌즈 4 블록
 * <p>
 * https://school.programmers.co.kr/learn/courses/30/lessons/17679
 */
public class Friends4Blocks {

    private static final int[][] dir = { { 0, 0 }, { 0, 1 }, { 1, 1 }, { 1, 0 } };
    private int m, n, result;
    private char[][] charBoard;
    private Set<int[]> haveToChange;

    public int solution(int m, int n, String[] board) {
        this.m = m;
        this.n = n;
        result = 0;
        haveToChange = new HashSet<>();
        charBoard = new char[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                this.charBoard[i][j] = board[i].charAt(j);
            }
        }

        while (true) {
            find();
            if (haveToChange.isEmpty()) {
                break;
            }
            remove();
            rearrange();
        }

        return result;
    }

    private void find() {
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (canRemove(i, j)) {
                    haveToChange.add(new int[] { i, j });
                }
            }
        }
    }

    private boolean canRemove(int x, int y) {
        char c = charBoard[x][y];
        if (c == '#') {
            return false;
        }

        for (int[] d : dir) {
            int nx = x + d[0];
            int ny = y + d[1];

            if (charBoard[nx][ny] != c) {
                return false;
            }
        }
        return true;
    }

    private void remove() {
        for (int[] p : haveToChange) {
            for (int[] d : dir) {
                int x = p[0] + d[0];
                int y = p[1] + d[1];

                if (charBoard[x][y] != '#') {
                    charBoard[x][y] = '#';
                    result++;
                }
            }
        }
        haveToChange.clear();
    }

    private void rearrange() {
        for (int i = m - 2; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                char cur = charBoard[i][j];
                for (int k = m - 1; k > i; k--) {
                    if (charBoard[k][j] == '#') {
                        charBoard[k][j] = cur;
                        charBoard[i][j] = '#';
                        break;
                    }
                }
            }
        }
    }

}
