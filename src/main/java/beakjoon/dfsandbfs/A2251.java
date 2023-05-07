package beakjoon.dfsandbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 물통
class State{
    int[] x;

    State(int[] x) {
        this.x = new int[3];
        for (int i = 0; i < x.length; i++)
            this.x[i] = x[i];
    }

    State move(int from, int to, int[] limit) {
        int[] nx = {x[0], x[1], x[2]};
        if (x[from] + x[to] > limit[to]) {
            nx[from] -= limit[to] - x[to];
            nx[to] = limit[to];
        } else {
            nx[to] += nx[from];
            nx[from] = 0;
        }
        return new State(nx);
    }
}

public class A2251 {

    static int[] limit;
    static boolean[] possible;
    static boolean[][][] visit;
    static StringBuilder sb = new StringBuilder();

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        limit = new int[3];
        for (int i = 0; i < 3; i++) {
            limit[i] = Integer.parseInt(st.nextToken());
        }
        possible = new boolean[201];
        visit = new boolean[201][201][201];
    }

    public static void dfs(int x, int y, int z) {
        visit[x][y][z] = true;
        State st = new State(new int[]{x, y, z});
        if(st.x[0] == 0) possible[st.x[2]] = true;

        for (int from = 0; from < 3; from++) {
            for (int to = 0; to < 3; to++) {
                State nst = st.move(from, to, limit);
                if(from == to) continue;
                if (!visit[nst.x[0]][nst.x[1]][nst.x[2]]) {
                    dfs(nst.x[0], nst.x[1], nst.x[2]);
                }
            }
        }
    }

    public static void bfs(int x, int y, int z) {
        Queue<State> q = new LinkedList<>();
        visit[x][y][z] = true;
        q.offer(new State(new int[]{x, y, z}));

        while (!q.isEmpty()) {
            State st = q.poll();
            if(st.x[0] == 0) possible[st.x[2]] = true;
            for (int from = 0; from < 3; from++) {
                for (int to = 0; to < 3; to++) {
                    if(from == to) continue;
                    State nst = st.move(from, to, limit);
                    if(!visit[nst.x[0]][nst.x[1]][nst.x[2]]) {
                        visit[nst.x[0]][nst.x[1]][nst.x[2]] = true;
                        q.offer(nst);
                    }
                }
            }
        }
    }

    public static void process() {
        dfs(0, 0, limit[2]);
        for (int i = 0; i <= limit[2]; i++) {
            if(possible[i]) sb.append(i).append(" ");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
