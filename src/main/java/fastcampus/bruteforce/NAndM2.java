package fastcampus.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NAndM2 {

    static int N, M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    static void function(int depth) {
        if (depth == M + 1) {
            for (int i = 1; i <= M; i++)
                sb.append(arr[i]).append(" ");
            sb.append("\n");
        } else {
            for (int i = arr[depth - 1] + 1; i <= N; i++) {
                arr[depth] = i;
                function(depth + 1);
            }
        }
    }

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            arr = new int[M + 1];
            function(1);
            System.out.println(sb.toString());
        } catch (IOException e) {
            System.out.println("error");
        }

    }
}
