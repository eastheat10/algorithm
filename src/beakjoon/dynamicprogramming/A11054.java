package beakjoon.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 가장 긴 바이토닉 부분 수열
public class A11054 {

    static int n;
    static int[] arr, dp1, dp2;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        dp1 = new int[n + 1];
        dp2 = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
    }

    static void dp() {

        for (int i = 1; i <= n; i++) {
            dp1[i] = 1;

            for (int j = 1; j < i; j++) {
                if (arr[i] > arr[j] && dp1[i] <= dp1[j]) {
                    dp1[i] = dp1[j] + 1;
                }
            }
        }

        for (int i = n; i > 0; i--) {
            dp2[i] = 1;

            for (int j = n; j > i; j--) {
                if (arr[i] > arr[j] && dp2[i] <= dp2[j]) {
                    dp2[i] = dp2[j] + 1;
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, dp1[i] + dp2[i]);
        }

        System.out.println(max - 1);
    }

    public static void main(String[] args) throws IOException {
        input();
        dp();
    }
}
