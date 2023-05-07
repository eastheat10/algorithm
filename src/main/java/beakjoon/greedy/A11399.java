package beakjoon.stage15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// ATM
public class A11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int time = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] people = new int[n];

        for (int i = 0; i < n; i++)
            people[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(people);
        for (int i = 0; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                time += people[j];
            }
        }

        System.out.println(time);
    }
}
