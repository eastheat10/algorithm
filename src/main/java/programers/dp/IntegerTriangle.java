package programers.dp;

// 정수 삼각형
public class IntegerTriangle {

    public static int solution(int[][] triangle) {
        int answer = Integer.MIN_VALUE;
        int len = triangle.length;
        int[][] dp = new int[len][len];

        dp[0][0] = triangle[0][0];
        for (int i = 1; i < len; i++) {
            dp[i][0] = dp[i - 1][0] + triangle[i][0];
            dp[i][i] = dp[i - 1][i - 1] + triangle[i][i];
        }

        for (int i = 2; i < len; i++)
            for (int j = 1; j < i; j++)
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]) + triangle[i][j];

        for (int i : dp[len - 1])
            answer = Math.max(answer, i);

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}));
    }

    /**
     * triangle	                                                result
     * [[7], [3, 8], [8, 1, 0], [2, 7, 4, 4], [4, 5, 2, 6, 5]]	30
     */
}
