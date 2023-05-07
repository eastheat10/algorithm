package beakjoon.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 랜선 자르기
public class A1654 {

    static int k, n;
    static int arr[];

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new int[k + 1];

        for (int i = 1; i <= k; i++)
            arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr, 1, k + 1);
    }

    static boolean check(long l) {
        long sum = 0;

        for (int i = 1; i <= k; i++) {
            sum += (arr[i] / l);
        }

        return sum >= n;
    }

    static void process() {
        long l = 1;
        long r = Integer.MAX_VALUE;
        long answer = 0;
        while (l <= r) {
            long mid = (l + r) / 2;
            if (check(mid)) {
                answer = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        System.out.println(answer);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
