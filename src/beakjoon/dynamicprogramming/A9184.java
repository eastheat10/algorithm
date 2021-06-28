package beakjoon.dynamicprogramming;

import java.io.*;
import java.util.StringTokenizer;

// 신나는 함수 실행
public class A9184 {

    static int[][][] arr = new int[21][21][21];
    // arr[a][b][c]

    public static int w(int a, int b, int c) {
        boolean check = true;
        if (a > 20 || a < 0 || b > 20 || b < 0 || c > 20 || c < 0) {
            check = false;
        }

        if(check && arr[a][b][c] != 0)
            return arr[a][b][c];
        else if(a <= 0 || b <= 0 || c <= 0)
            return 1;
        else if (a > 20 || b > 20 || c > 20) {
            arr[20][20][20] = w(20, 20, 20);
            return arr[20][20][20];
        } else if (a < b && b < c) {
            arr[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
            return arr[a][b][c];
        } else {
            arr[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c)
                    + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
            return arr[a][b][c];
        }

    }

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(a == -1 && b == -1 && c == -1)
                break;

            int result = w(a, b, c);

            String s = String.format("w(%d, %d, %d) = %d\n", a, b, c, result);
            sb.append(s);
        }
        bw.write(sb.toString());
        bw.flush(); bw.close(); br.close();
    }
}
