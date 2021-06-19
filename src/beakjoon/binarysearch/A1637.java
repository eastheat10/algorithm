package beakjoon.binarysearch;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 날카로운 눈
public class A1637 {

    static int n;
    static int arr[][];
    static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1][3];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, arr[i][1]);
                min = Math.min(min, arr[i][0]);
            }
        }
    }

    static long count(long l) {
        long sum = 0;

        for (int i = 1; i <= n; i++) {
            if (l >= arr[i][0]) {
                sum += (Math.min(l, arr[i][1]) - arr[i][0]) / arr[i][2] + 1;
            }
        }

        return sum;
    }

    static boolean check(long l) {
        long sum = count(l);
        return sum %  2 == 1;
    }

    static void process() {
        long l = min;
        long r = max;
        long answer = 0;
        long count;
        while (l <= r) {
            long mid = (l + r) / 2;
            if (check(mid)) {
                answer = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        if (answer == 0) {
            System.out.println("NOTHING");
        } else {
            count = count(answer) - count(answer - 1);
            System.out.println(answer + " " + count);
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }

}
