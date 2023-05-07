package beakjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

// 좌표 압축
public class A18870 {

    static int n;
    static int[] arr, arr2;
    static HashMap<Integer, Integer> hm = new HashMap<>();

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        arr2 = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(st.nextToken());;
            arr[i] = tmp;
            arr2[i] = tmp;
        }
    }

    static void sort() {
        StringBuilder sb = new StringBuilder();
        Arrays.sort(arr2);

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!hm.containsKey(arr2[i]))
                hm.put(arr2[i], count++);
        }

        for (int i = 0; i < n; i++) {
            sb.append(hm.get(arr[i])).append(" ");
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        input();
        sort();
    }
}
