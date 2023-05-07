package fastcampus.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NQueen {

    static int n;
    static int answer;
    static int[] col;

    static boolean attackable(int r1, int c1, int r2, int c2) {
        if (c1 == c2 || r1 - c1 == r2 - c2 || r1 + c1 == r2 + c2) {
            return true;
        } else return false;
    }

    static void nQueen(int row) {
        if (row == n + 1) {
            answer++;
        } else {
            for (int c = 1; c <= n; c++) {
                boolean isPossible = true;
                for (int i = 1; i < row; i++) {
                    if (attackable(row, c, i, col[i])) {
                        isPossible = false;
                        break;
                    }
                }
                if (isPossible) {
                    col[row] = c;
                    nQueen(row + 1);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        answer = 0;
        col = new int[n + 1];

        nQueen(1);
        System.out.println(answer);
    }
}
