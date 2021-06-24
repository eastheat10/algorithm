package programers.dp;

// 등굣길
public class SchoolRoad {
    public static int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[m + 1][n + 1];

        map[1][1] = 1;
        for (int[] puddle : puddles)
            map[puddle[0]][puddle[1]] = -1;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 && j == 1) continue;
                int up = map[i - 1][j];
                int left = map[i][j - 1];

                if (map[i][j] == -1) continue;

                if (up == -1)
                    up = 0;
                if (left == -1)
                    left = 0;

                map[i][j] = (up + left) % 1000000007;

            }
        }

        return map[m][n];
    }

    public static void main(String[] args) {
        System.out.println(solution(4, 3, new int[][]{{2, 2}}));
    }

    /**
     * m	n	puddles	    return
     * 4	3	[[2, 2]]	4
     */
}
