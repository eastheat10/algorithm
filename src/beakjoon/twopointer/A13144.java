package beakjoon.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// List of unique number
public class A13144 {

    static int n;
    static int[] arr, count;

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        count = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
    }

    public static void find() {
        int r = n;
        int result = 0;
        for (int l = 1; l <= n; l++) {

        }
    }

    public static void main(String[] args) throws IOException {
        input();
        find();
    }
}
