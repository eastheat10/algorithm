package programers.etc;

/**
 * N Queen
 * <p>
 * https://school.programmers.co.kr/learn/courses/30/lessons/12952
 */
public class NQueen {

    private boolean[][] map;
    private int n, cnt;

    public int solution(int n) {
        init(n);

        find(0);

        return cnt;
    }

    private void init(int n) {
        this.n = n;
        cnt = 0;
        map = new boolean[n][n];
    }

    private void find(int depth) {
        if (depth == n) {
            cnt++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!canLocate(depth, i)) {
                continue;
            }
            map[depth][i] = true;
            find(depth + 1);
            map[depth][i] = false;
        }
    }

    private boolean canLocate(int x, int y) {
        // 상 하
        for (int i = 0; i < n; i++) {
            if (map[i][y]) {
                return false;
            }
        }

        // /
        int tx = x;
        int ty = y;
        for (; 0 <= tx && ty < n; tx--, ty++) {
            if (map[tx][ty]) {
                return false;
            }
        }

        for (tx = x, ty = y; tx < n && 0 <= ty; tx++, ty--) {
            if (map[tx][ty]) {
                return false;
            }
        }

        // \
        for (tx = x, ty = y; tx < n && ty < n; tx++, ty++) {
            if (map[tx][ty]) {
                return false;
            }
        }

        for (tx = x, ty = y; 0 <= tx && 0 <= ty; tx--, ty--) {
            if (map[tx][ty]) {
                return false;
            }
        }

        return true;
    }

}
