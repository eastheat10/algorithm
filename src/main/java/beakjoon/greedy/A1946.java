package beakjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 신입사원
public class A1946 {

    public static void main(String[] args) throws IOException {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());

            int count1 = greedy1(br, n);
            int count2 = greedy2(br, n);

            sb1.append(count1).append('\n');
            sb2.append(count2).append('\n');
        }

        System.out.println(sb1);
        System.out.println(sb2);
    }

    static int greedy1(BufferedReader br, int n) throws IOException {
        int[][] em = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            em[i][0] = Integer.parseInt(st.nextToken());
            em[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(em, (i, j) -> i[0] - j[0]);

        int count = 1;
        int k = em[0][1];
        for (int i = 1; i < n; i++) {
            if (k > em[i][1]) {
                count++;
                k = em[i][1];
            }
        }
        return count;
    }

    static int greedy2(BufferedReader br, int n) throws IOException {
        int[] em = new int[n + 1];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            em[a] = b;
        }

        int count = 1;
        int k = em[1];
        for (int i = 2; i <= n; i++) {
            if (em[i] < k) {
                count++;
                k = em[i];
            }
        }
        return count;
    }
}
