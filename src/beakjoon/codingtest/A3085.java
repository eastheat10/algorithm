import java.io.*;
import java.util.*;

// 사탕 게임
@SuppressWarnings("unchecked")
class Main {

    static int n;
    static char[][] candy;
    static int[][] dir = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        input();
        process();
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        candy = new char[n][n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            candy[i] = s.toCharArray();
        }
    }

    static void process() {
        int answer = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j + 1 < n && candy[i][j] != candy[i][j + 1]) {
                    char tmp = candy[i][j];
                    candy[i][j] = candy[i][j + 1];
                    candy[i][j + 1] = tmp;

                    int result = check();
                    answer = Math.max(result, answer);

                    tmp = candy[i][j];
                    candy[i][j] = candy[i][j + 1];
                    candy[i][j + 1] = tmp;
                }

                if (i + 1 < n && candy[i][j] != candy[i + 1][j]) {
                    char tmp = candy[i][j];
                    candy[i][j] = candy[i + 1][j];
                    candy[i + 1][j] = tmp;

                    int result = check();
                    answer = Math.max(result, answer);

                    tmp = candy[i][j];
                    candy[i][j] = candy[i + 1][j];
                    candy[i + 1][j] = tmp;
                }
            }
        }

        System.out.println(answer);
    }

    static int check() {
        int n = candy.length;
        int answer = 1;
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            cnt = 1;
            for (int j = 1; j < n; j++) {
                if (candy[i][j] == candy[i][j - 1]) {
                    cnt++;
                } else {
                    cnt = 1;
                }
                answer = Math.max(answer, cnt);
            }
            
            cnt = 1;
            for (int j = 1; j < n; j++) {
                if (candy[j][i] == candy[j - 1][i]) {
                    cnt++;
                } else {
                    cnt = 1;
                }
                answer = Math.max(answer, cnt);
            }
            
        }

        return answer;

    }

}