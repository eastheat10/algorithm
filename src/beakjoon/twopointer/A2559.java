package beakjoon.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 수열
public class A2559 {

    static int n, k;
    static int[] arr;

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
    }

    static void find() {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int j = 1; j <= k; j++) {
            sum += arr[j];
        }
        max = Math.max(max, sum);
        int l = 1;
        int r = k;
        for (int i = 2; i <= n - k + 1; i++) {
            sum -= arr[l++];
            sum += arr[++r];
            max = Math.max(sum, max);
        }
        System.out.println(max);

    }

    public static void main(String[] args) throws IOException {
        input();
        find();
    }
}
