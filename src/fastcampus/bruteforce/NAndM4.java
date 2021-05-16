package fastcampus.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NAndM4 {

    static int N, M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    static void func(int depth) {
        if (depth == M + 1) {
            for (int i = 1; i <= M; i++)
                sb.append(arr[i]).append(" ");
            sb.append("\n");
        } else {
            int start = arr[depth - 1] == 0 ? 1 : arr[depth - 1];

            for (int i = start; i <= N; i++) {
                arr[depth] = i;
                func(depth + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M + 1];
        func(1);
        System.out.println(sb.toString());
    }
}
