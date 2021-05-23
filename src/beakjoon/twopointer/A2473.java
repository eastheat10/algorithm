package beakjoon.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 세 용액
public class A2473 {

    static int n;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
    }

    public static void find() {
        Arrays.sort(arr, 1, n + 1);
        int v1 = 0, v2 = 0, v3 = 0;
        long bestSum = Long.MAX_VALUE;

        for (int i = 1; i <= n - 2; i++) {
            int l = i + 1;
            int r = n;

            while (l < r) {
                long sum = arr[i] + arr[l] + arr[r];
                if (Math.abs(sum) < bestSum) {
                    v1 = arr[i];
                    v2 = arr[l];
                    v3 = arr[r];
                    bestSum = Math.abs(sum);
                }
                if (sum < 0) {
                    l++;
                } else {
                    r--;
                }
            } // while

        }
        sb.append(v1).append(" ").append(v2).append(" ").append(v3);
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        input();
        find();
    }
}
