package beakjoon.dfsandbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 바이러스
public class A2606 {

    static int v, e;
    static int count;
    static ArrayList<Integer>[] list;
    static boolean[] visit;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        v = Integer.parseInt(br.readLine());
        e = Integer.parseInt(br.readLine());
        list = new ArrayList[v + 1];
        for (int i = 1; i <= v; i++)
            list[i] = new ArrayList<>();

        for (int i = 0; i < e; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);

        }

        visit = new boolean[v + 1];
    }

    static void dfs(int x) {
        visit[x] = true;
        if(x != 1) count++;
        for (Integer i : list[x]) {
            if(!visit[i])
                dfs(i);
        }
    }

    static void bfs(int x) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(x);
        visit[x] = true;

        while (!q.isEmpty()) {
            x = q.poll();
            for (Integer i : list[x]) {
                if (!visit[i]) {
                    q.offer(i);
                    visit[i] = true;
                    count++;
                }
            }
        }

    }

    static void process() {
        count = 0;
//        dfs(1);
        bfs(1);
        System.out.println(count);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
