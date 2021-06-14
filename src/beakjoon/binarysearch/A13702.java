package beakjoon.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 이상한 술집
public class A13702 {
    static int n, k;
    static int arr[];

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n + 1];

        for (int i = 1; i <= n; i++)
            arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr, 1, n + 1);
    }

    static boolean check(long l) {
        int count = 0;

        for (int i = 1; i <= n; i++)
            count += (arr[i] / l);

        return k <= count;
    }

    static void process() {
        long answer = 0;
        long l = 0;
        long r = Integer.MAX_VALUE;

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
