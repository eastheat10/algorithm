package beakjoon.stage13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 부분 수열의 합
public class A1182 {

    static int n, s, sum, count;
    static int[] arr;

    static void func(int k, int sum) {
        if (k == n + 1) {
            if (sum == s) {
                count++;
            }
        } else {
            func(k + 1, sum);
            func(k + 1, sum + arr[k]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        arr = new int[n + 1];

        sum = 0; count = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        func(1, sum);
        if(s == 0) count--;
        System.out.println(count);
    }
}
