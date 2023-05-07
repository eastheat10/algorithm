package beakjoon.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 귀여운 라이언
public class A15565 {

    static int n, k;
    static int[] arr;

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
    }

    static void find() {
        // 라이언 1 || 어피치 2
        int answer = -1;
        int sum = 0;
        int right = 0;

        for (int left = 1; left <= n - k + 1; left++) {
            while (right < n && sum < k) {
                right++;
                if(arr[right] == 1)
                    sum++;
            }
            if (sum >= k) {
                int tmp = right - left + 1;
                answer = answer == -1 ? tmp : Math.min(answer, tmp);
            }
            if(arr[left] == 1)
                sum--;
        }

        System.out.println(answer);
    }

    public static void main(String[] args) throws IOException {
        input();
        find();
    }
}
