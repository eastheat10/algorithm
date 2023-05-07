package beakjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 스도쿠
public class A2580 {

    static int[][] arr = new int[9][9];

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        sudoku(0, 0);
    }

    static void sudoku(int row, int col) {

        if (col == 9) {
            sudoku(row + 1, 0);
            return;
        }

        if (row == 9) {
            StringBuilder sb = new StringBuilder();
            for (int[] ints : arr) {
                for (int anInt : ints) {
                    sb.append(anInt).append(' ');
                }
                sb.append('\n');
            }

            System.out.println(sb);

            // 여러 경우의 수 중 하나만 출력해햐 함.
            System.exit(0);

        }

        if (arr[row][col] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (isPossible(row, col, i)) {
                    arr[row][col] = i;
                    sudoku(row, col + 1);
                }
            }
            arr[row][col] = 0;
            return;
        }

        sudoku(row, col + 1);

    } // sudoku()

    static boolean isPossible(int row, int col, int value) {
        // 같은 행
        for (int i = 0; i < 9; i++) {
            if (arr[row][i] == value) {
                return false;
            }
        }
        // 같은 열
        for (int i = 0; i < 9; i++) {
            if (arr[i][col] == value) {
                return false;
            }
        }

        // 3 * 3 정사각형 칸 체크
        int rec_row = (row / 3) * 3;
        int rec_col = (col / 3) * 3;

        for (int i = rec_row; i < rec_row + 3; i++) {
            for (int j = rec_col; j < rec_col + 3; j++) {
                if (arr[i][j] == value) {
                    return false;
                }
            }
        }

        return true;
    }
}
