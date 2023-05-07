package beakjoon.bruteforce;

/**
 * 색종이 붙이기
 * https://www.acmicpc.net/problem/17136
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A17136 {

    static int[][] arr = new int[10][10];
    static int[] paper = {0, 5, 5, 5, 5, 5};
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        input();
        process();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void process() {
        dfs(0, 0);
        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }

    static void dfs(int idx, int cnt) {
        if (idx == 100) {
            result = Math.min(cnt, result);
            return;
        }

        if (result <= cnt) return;

        int r = idx / 10;
        int c = idx % 10;

        if (arr[r][c] == 1) {
            for (int i = 5; i > 0; i--) {
                if (paper[i] <= 0) continue;
                if (check(r, c, i)) {
                    fill(r, c, i, 0);
                    paper[i]--;
                    dfs(idx + 1, cnt + 1);
                    fill(r, c, i, 1);
                    paper[i]++;
                }
            }
        } else {
            dfs(idx + 1, cnt);
        }
    }
    static boolean check(int r, int c, int idx) {
        if (r + idx > 10 || c + idx > 10)
            return false;

        for (int i = 0; i < idx; i++) {
            for (int j = 0; j < idx; j++) {
                if (arr[r + i][c + j] != 1)
                    return false;
            }
        }

        return true;
    }

    static void fill (int r, int c, int size, int state) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                arr[r + i][c + j] = state;
            }
        }
    }

}
