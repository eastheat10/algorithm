package beakjoon.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 트리
public class A1068 {

    static int n, k, root;
    static ArrayList<Integer>[] list;
    static int[] leaf;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        list = new ArrayList[n];
        for (int i = 0; i < n; i++)
            list[i] = new ArrayList<>();
        leaf = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int p = Integer.parseInt(st.nextToken());
            if(p == -1) {
                root = i;
                continue;
            }
            list[p].add(i);

        }

        k = Integer.parseInt(br.readLine());

    }

    static void dfs() {

    }

    static void process() {
        dfs();

    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
