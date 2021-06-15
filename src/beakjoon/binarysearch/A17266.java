package beakjoon.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 어두운 굴다리
public class A17266 {

    static int n, m;
    static int[] arr;
    static int[] street;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        street = new int[n + 1];
        arr = new int[m + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= m; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr, 1, m + 1);
    }

    static boolean check(long l) {
        long last = 0;

        for (int i = 1; i <= m; i++) {
            if(arr[i] - last <= l)
                last = arr[i] + l;
            else
                return false;
        }

        return last >= n;
    }

    static void process() {
        long l = arr[1];
        long r = n;
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

