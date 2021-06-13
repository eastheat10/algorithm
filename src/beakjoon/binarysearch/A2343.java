package beakjoon.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 기타레슨
public class A2343 {

    static int n, m;
    static int[] arr;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, 1, n + 1);
    }

    static boolean check(int size) {
        int count = 1;
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += arr[i];
            if (sum > size) {
                count++;
                sum = arr[i];
            }
        }
        return count <= m;
    }

    static void process() {
        int l = arr[n];
        int r = 1000000000;
        int answer = 0;
        while (l <= r) {
            int mid = (l + r) / 2;
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
