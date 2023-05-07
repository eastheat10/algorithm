package beakjoon.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 나무 자르기
public class A2805 {

    static int n, m;
    static int[] arr;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    static boolean check(long h) {
        if(h >= arr[n]) return false;
        long sum = 0;
        for (int i = 1; i <= n; i++) {
            int t = arr[i];
            if (t > h)
                sum += (t - h);
        }

        return sum >= m;
    }

    static void process() {
        Arrays.sort(arr, 1, n + 1);
        long l = 1;
        long r = Integer.MAX_VALUE;
        long height = 0;
        while (l <= r) {
            long mid = (l + r) / 2;
            if (check(mid)) {
                height = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        System.out.println(height);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }

}
