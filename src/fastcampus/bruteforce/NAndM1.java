package fastcampus.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NAndM1 {

    static int N, M;
    static int[] arr, used;
    static StringBuilder sb = new StringBuilder();

    static void func(int depth) {
        if (depth == M + 1) {
            for (int i = 1; i <= M; i++) {
                sb.append(arr[i]).append(" ");
            }sb.append("\n");
        } else {
            for (int i = 1; i <= N; i++) {
                if(used[i] == 1) continue;
                arr[depth] = i;
                used[i] = 1;
                func(depth + 1);
                used[i] = 0;
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M + 1];
        used = new int[N + 1];
        func(1);
        System.out.println(sb.toString());
    }
}
