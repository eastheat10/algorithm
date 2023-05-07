package beakjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// N-Queen

/**
 * 같은 행에 퀸을 놓지 않는다고 가정
 * 열마다 체크
 * 맨 아래 열에 내려오면 성공!
 */

/**
 * dfs 와 백트래킹의 차이
 * dfs 는 완전탐색 (끝날 때 까지 재귀호출)
 * 백트래킹은 조건에 맞지 않으면 호출 중
 */
public class A9663 {

    static int[] col;
    static int count = 0;
    static int n;

    public static void nQueen(int depth) {
        // 맨 아래 열 까지 내려왔으면 성공
        if (depth == n) {
            count++;
            return;
        }

        for (int i = 0; i < n; i++) {
            // 몇번째 행에 있는지 입력
            col[depth] = i;
            // 다른 퀸에 공격을 받는지 검사
            if(promising(depth))    // true 이면 재귀함수 호출
                nQueen(depth + 1);
        }
    }

    public static boolean promising(int row) {
        for (int j = 0; j < row; j++) {
            // 같은 열에 있는지 체크
            if (col[row] == col[j]) {
                return false;
            }
            // 대각선에 있는지 체크
            else if (Math.abs(row - j) == Math.abs(col[row] - col[j])) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        col = new int[n];

        nQueen(0);

        System.out.println(count);
    }
}
