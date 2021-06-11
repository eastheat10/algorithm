package beakjoon.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 공유기 설치
public class A2110 {

    static int n, c;
    static int[] arr;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new int[n + 1];
        for (int i = 1; i <= n; i++)
            arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr, 1, n + 1);
    }

    static boolean check(int l) {
        int count = 1;
        int last = arr[1];

        for (int i = 2; i <= n; i++) {
            if(arr[i] - last < l) continue;
            last = arr[i];
            count++;
        }

        return count >= c;
    }

    static void process() {
        int l = 1;
        int r = 10000000;
        int answer = 0;

        while (l <= r) {
            int mid = (l + r) / 2;
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
