package beakjoon.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 배열 합치기
public class A11728 {
    static int n, m;
    static int[] arr1, arr2;

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st1.nextToken());
        m = Integer.parseInt(st1.nextToken());
        arr1 = new int[n + 1];
        arr2 = new int[m + 1];
        st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int tmp = Math.max(n, m);
        for (int i = 1; i <= tmp; i++) {
            if (st1.hasMoreTokens())
                arr1[i] = Integer.parseInt(st1.nextToken());
            if (st2.hasMoreTokens())
                arr2[i] = Integer.parseInt(st2.nextToken());
        }
    }

    static void find() {
        StringBuilder sb = new StringBuilder();
        int first = 1;
        int second = 1;

        for (int i = 0; i < n + m; i++) {
            if(first <= n && second <= m) {
                sb.append(arr1[first] < arr2[second] ? arr1[first++] : arr2[second++]).append(" ");
            }
            else if (second <= m && first > n) {
                sb.append(arr2[second++]).append(" ");
            }
            else if (first <= n && second > m) {
                sb.append(arr1[first++]).append(" ");
            }

        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        input();
        find();
    }
}
