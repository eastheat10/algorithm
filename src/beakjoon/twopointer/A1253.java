package beakjoon.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 좋다
public class A1253 {

    static int n;
    static int[] arr;

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[(n + 1)];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
    }

    static boolean check(int idx) {
        int l = 1;
        int r = n;
        int target = arr[idx];

        while (l < r) {
            if(l == idx)
                l++;
            else if (r == idx)
                r--;
            else {
                int sum = arr[l] + arr[r];
                if(sum == target)
                    return true;
                else if (sum > target)
                    r--;
                else
                    l++;
            }
        }

        return false;
    }

    public static void find() {
        Arrays.sort(arr, 1, n+1);
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (check(i)) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    public static void main(String[] args) throws IOException {
        input();
        find();
    }
}
