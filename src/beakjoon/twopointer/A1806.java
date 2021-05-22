package beakjoon.stage26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class A1806 {

    static int n, s;
    static int[] arr;

    static void sum() {
        int sum = 0;
        int r = 0;
        int answer = n + 1;
        for (int l = 1; l <= n; l++) {
            // l - 1 구간 제외
            sum -= arr[l - 1];

            // r 최대로 이동
            while (r < n && sum < s) {
                r++;
                sum += arr[r];
            }

            if (sum >= s) {
                answer = Math.min(answer, r - l + 1);
            }
        }
        if (answer == n + 1) {
            answer = 0;
        }
        System.out.println(answer);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        arr = new int[n + 1];
        s = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] >= s) {
                System.out.println(1);
                return;
            }
        }

        sum();

    }
}
