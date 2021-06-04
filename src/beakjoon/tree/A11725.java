package beakjoon.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 트리의 부모 찾기
public class A11725 {

    static int n;

    static ArrayList<Integer>[] list;
    static int[] parent;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        list = new ArrayList[n + 1];
        parent = new int[n + 1];

        for (int i = 1; i <= n; i++)
            list[i] = new ArrayList<>();

        for (int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list[x].add(y);
            list[y].add(x);

        }
    }

    // p가 x의 부모이다.
    static void dfs(int x, int p) {
        for (Integer i : list[x]) {
            if(i == p) continue;
            parent[i] = x;
            dfs(i, x);
        }
    }

    static void process() {
        dfs(1, -1); // 1은 루트이기 떄문에 부모가 없음(-1)

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= n; i++)
            sb.append(parent[i]).append("\n");

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException{
        input();
        process();
    }

}
