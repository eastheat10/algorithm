package beakjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

// 회의실 배정
public class A1931 {

    static int n;
    static int[][] times;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        times = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            times[i][0] = Integer.parseInt(st.nextToken());
            times[i][1] = Integer.parseInt(st.nextToken());
        }
    }

    static void greedy() {
        Arrays.sort(times, (o1, o2) -> {
            if (o1[1] == o2[1])
                return o1[0] - o2[0];
            return o1[1] - o2[1];
        });

        int count = 0;
        int endTime = -1;
        for (int i = 0; i < n; i++) {
            if (endTime <= times[i][0]) {
                count++;
                endTime = times[i][1];
            }
        }

        System.out.println(count);
    }

    public static void main(String[] args) throws IOException {
        input();
        greedy();
    }
}
