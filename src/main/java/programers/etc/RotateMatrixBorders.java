package programers.etc;

/**
 * 배열 회전시키기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/120844
 */
public class RotateMatrixBorders {

    private int[][] arr;

    public int[] solution(int rows, int cols, int[][] queries) {

        int[] answer = new int[queries.length];
        arr = new int[rows + 1][cols + 1];

        int val = 1;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                arr[i][j] = val++;
            }
        }

        for (int i = 0; i < queries.length; i++) {
            answer[i] = rotate(queries[i][0], queries[i][1], queries[i][2], queries[i][3]);
        }

        return answer;
    }

    private int rotate(int x1, int y1, int x2, int y2) {
        int start = arr[x1][y2];
        int min = start;

        for (int y = y2 - 1; y >= y1; y--) {
            min = Math.min(arr[x1][y], min);
            arr[x1][y + 1] = arr[x1][y];
        }

        for (int x = x1 + 1; x <= x2; x++) {
            min = Math.min(arr[x][y1], min);
            arr[x - 1][y1] = arr[x][y1];
        }

        for (int y = y1 + 1; y <= y2; y++) {
            min = Math.min(arr[x2][y], min);
            arr[x2][y - 1] = arr[x2][y];
        }

        for (int x = x2 - 1; x >= x1; x--) {
            min = Math.min(arr[x][y2], min);
            arr[x + 1][y2] = arr[x][y2];
        }

        arr[x1 + 1][y2] = start;

        return min;
    }

}
