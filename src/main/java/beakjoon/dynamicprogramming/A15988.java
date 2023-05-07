package beakjoon.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 1, 2, 3 더하기 3
public class A15988 {

//    static long process(int t) {
//        if (t == 1)
//            return arr[1] = 1;
//        if (t == 2)
//            return arr[2] = 2;
//        if (t == 3)
//            return arr[3] = 4;
//        if(arr[t] != 0)
//            return arr[t];
//        else
//            return arr[t] = (process(t - 1) + process(t - 2) + process(t - 3)) % 1000000009;
//    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] test = new int[n];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            test[i] = Integer.parseInt(br.readLine());
            max = Math.max(test[i], max);
        }
        int[] arr = new int[max + 1];

        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;
        for (int i = 4; i <= max; i++)
            arr[i] = (arr[i - 1] + arr[i - 2] + arr[i - 3]) % 1000000009;

        for (int i = 0; i < n; i++)
            sb.append(arr[test[i]]).append('\n');

        System.out.println(sb);
    }

}
