import java.io.*;
import java.util.*;

// 줄 세우기
@SuppressWarnings("unchecked")
class Main {

    static int n, m;
    static ArrayList<Integer>[] adj;
    static int[] indeg;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        process();
        System.out.println(sb);
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        adj = new ArrayList[n + 1];
        indeg = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            adj[x].add(y);
            indeg[y]++;
        }
    }

    static void process() {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (indeg[i] == 0)
                q.offer(i);
        }

        while(!q.isEmpty()) {
            int x = q.poll();
            sb.append(x).append(" ");
            for (Integer y : adj[x]) {
                indeg[y]--;
                if (indeg[y] == 0) 
                    q.offer(y);
            }
        }
    }
}