package beakjoon.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 수들의 합2
public class A2003 {

    static int n, m;
    static int[] arr;

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[(n + 1)];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
    }

    public static void find() {
        int answer = 0;

        for (int l = 1; l <= n; l++) {
            int sum = arr[l];
            if (sum == m) {
                answer++;
                continue;
            }
            int r = l + 1;
            while (r <= n && sum <= m) {
                sum += arr[r++];
                if(sum == m) {
                    answer++;
                    break;
                }
            }
        }

        System.out.println(answer);
    }

    public static void main(String[] args) throws IOException {
        input();
        find();
    }
}
