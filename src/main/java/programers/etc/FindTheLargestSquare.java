package programers.etc;

/**
 * 가장 큰 정사각형 찾기
 * <p>
 * https://school.programmers.co.kr/learn/courses/30/lessons/12905
 */
public class FindTheLargestSquare {

    public int solution(int[][] board) {

        int[][] dp = new int[board.length + 1][board[0].length + 1];
        int max = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dp[i + 1][j + 1] = board[i][j];
            }
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (dp[i][j] != 1) {
                    continue;
                }

                int left = dp[i][j - 1];
                int up = dp[i - 1][j];
                int leftUp = dp[i - 1][j - 1];

                int min = Math.min(left, Math.min(up, leftUp));
                dp[i][j] = min + 1;

                max = Math.max(dp[i][j], max);
            }
        }

        return max * max;
    }

}
