package beakjoon.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// K번째 수
public class A1300 {

    static long n, k;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
    }

    static boolean check(long l) {
        long count = 0;

        for (int i = 1; i <= n; i++) {
            count += Math.min(l / i, n);
        }

        return count >= k;
    }

    static void process() {
        long l = 1;
        long r = n * n;
        long answer = 0;
        while (l <= r) {
            long mid = (l + r) / 2;
            if (check(mid)) {
                answer = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        System.out.println(answer);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
