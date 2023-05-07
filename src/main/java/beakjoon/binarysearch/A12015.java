package beakjoon.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// 가장 긴 증가하는 부분 수열2
public class A12015 {

    static int n;
    static int[] arr;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void binarySearch() {
        List<Integer> list = new ArrayList<>();
        list.add(0);

        for (int i = 1; i <= n; i++) {
            int value = arr[i];
            if (value > list.get(list.size() - 1)) {
                list.add(value);
            } else {
                int l = 0;
                int r = list.size() - 1;
                while (l < r) {
                    int mid = (l + r) / 2;
                    if (value <= list.get(mid)) {
                        r = mid;
                    } else {
                        l = mid + 1;
                    }
                }
                list.set(r, value);
            }
        }

        System.out.println(list.size() - 1);
    }

    public static void main(String[] args) throws IOException {
        input();
        binarySearch();
    }
}
