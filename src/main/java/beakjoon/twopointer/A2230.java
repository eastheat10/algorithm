package beakjoon.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 수 들의 합
public class A2230 {
    static int n, m;
    static int[] arr;

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st1.nextToken());
        m = Integer.parseInt(st1.nextToken());
        arr = new int[n + 1];
        for (int i = 1; i <= n; i++)
            arr[i] = Integer.parseInt(br.readLine());

    }

    static void find() {
        Arrays.sort(arr, 1, n + 1);
        int answer = Integer.MAX_VALUE;

        int r = 1;
        for (int l = 1; l <= n; l++) {

            while (arr[r] - arr[l] < m && r < n)
                r++;

            int result = arr[r] - arr[l];
            if(result >= m)
                answer = Math.min(answer, result);
        }

        System.out.println(answer);
    }

    public static void main(String[] args) throws IOException {
        input();
        find();
    }
}
