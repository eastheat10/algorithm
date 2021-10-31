import java.util.*;
import java.io.*;

// 최소 스패닝 트리
@SuppressWarnings("unchecked")
class Main {

    static int v, e;
    static ArrayList<Node> list[];
    static class Node {
        int to, weight;
        public Node (int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(process());
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        list = new ArrayList[v + 1];
        for (int i = 0; i <= v; i++) 
            list[i] = new ArrayList<>();

        
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }
    }
 
    static long prim() {
        boolean[] visit = new boolean[v + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>((i, j) -> i.weight - j.weight);
        pq.add(new Node(1, 0));

        long result = 0;
        int count = 0;

        while(!pq.isEmpty()) {
            Node edge = pq.poll();

            if(visit[edge.to]) continue;

            result += edge.weight;
            visit[edge.to] = true;

            if (count + 1 == v) 
                return result;

            for (Node node : list[edge.to]) {
                if (visit[node.to]) continue;
                pq.add(node);
            }
        }

        return result;
    }

}
