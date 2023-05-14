package programers.etc;

public class TriangleSnail {

    public static void main(String[] args) {

    }

    public int[] solution(int n) {
        int[] answer = new int[n * (n + 1) / 2];
        int[][] arr = new int[n][n];

        int row = -1;
        int col = 0;
        int num = 1;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i % 3 == 0) {
                    row++;
                } else if (i % 3 == 1) {
                    col++;
                } else if (i % 3 == 2) {
                    row--;
                    col--;
                }
                arr[row][col] = num++;
            }
        }

        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 0) {
                    break;
                }
                answer[idx++] = arr[i][j];
            }
        }

        return answer;
    }

}
