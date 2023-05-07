package beakjoon.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 사촌
public class A9489 {

    static int n, k;
    static int[] arr, parent;
    static StringBuilder sb = new StringBuilder();

    static void input(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        if (n == 0 && k == 0) return;

        parent = new int[n + 1];
        arr = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

    }

    static void findParent() {
        parent[0] = -1;
        parent[1] = 0;

        // 부모 인덱스
        int p = 1;
        // 자식 인덱스
        for (int c = 2; c <= n; c++) {
            for (; c <= n; c++) {
                parent[c] = p;
                if (c < n && arr[c] + 1 != arr[c + 1]) {
                    break;
                }
            }
            p++;
        }
    }

    static void findCousin() {
        int kIdx = 0;
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            if (k == arr[i]) {
                kIdx = i;
                break;
            }
        }

        int kParent = parent[kIdx];
        int kGrandParent = parent[kParent];

        for (int i = 1; i <= n; i++) {
            int iParent = parent[i];
            if (kGrandParent == parent[iParent] && parent[kIdx] != iParent) {
                answer++;
            }
        }
        sb.append(answer).append('\n');

    }

    static void process() {
        findParent();
        findCousin();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            input(br);
            if (n == 0 && k == 0)
                break;
            process();
        }

        System.out.println(sb);
    }
}
