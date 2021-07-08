package beakjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 체스판 다시 칠하기
public class A1018 {

    static int n, m, min = Integer.MAX_VALUE;
    static char[][] chess;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        chess = new char[n][m];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                chess[i][j] = s.charAt(j);
            }
        }

    }

    static char colorChange(char c) {
        if (c == 'W') {
            return 'B';
        } else {
            return 'W';
        }
    }

    static void find(int x, int y) {
        int endX = x + 8;
        int endY = y + 8;
        int count = 0;

        char color = chess[x][y];

        for (int i = x; i < endX; i++) {
            for (int j = y; j < endY; j++) {
                if (chess[i][j] != color)
                    count++;
                color = colorChange(color);
            }
            color = colorChange(color);
        }
        // 첫번째 색을 기준으로 바꿔야할지 첫번째 색과 반대색을 기준으로 할지 결정
        count = Math.min(count, 64 - count);

        min = Math.min(count, min);
    }

    static void bf() {
        int row = n - 7;
        int col = m - 7;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                find(i, j);
            }
        }

        System.out.println(min);
    }

    public static void main(String[] args) throws IOException {
        input();
        bf();
    }
}
