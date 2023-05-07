package beakjoon.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 두 수의 합
public class A3273 {

    static int n, x;
    static int[] arr;

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(br.readLine());

    }

    public static void find() {
        Arrays.sort(arr, 1, n + 1);
        int count = 0;
        int l = 1;
        int r = n;

        while (l < r) {
            int sum = arr[l] + arr[r];
            if (sum < x) {
                l++;
            } else if (sum > x) {
                r--;
            } else {
                count++;
                l++;
                r--;
            }
        }

        System.out.println(count);
    }

    public static void main(String[] args) throws IOException {
        input();
        find();
    }
}
