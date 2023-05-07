package beakjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 모든 순열
public class A10974 {

    static int n;
    static int[] arr;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        visit = new boolean[n + 1];
    }

    static void permutation(int k) {
        if (k == n + 1) {
            for (int i = 1; i <= n; i++)
                sb.append(arr[i]).append(" ");
            sb.append('\n');
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arr[k] = i;
                permutation(k + 1);
                visit[i] = false;
            }
        }

    }

    public static void main(String[] args) throws IOException {
        input();
        permutation(1);
        System.out.println(sb);
    }
}
