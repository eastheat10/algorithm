package beakjoon.priorityqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

// 최소 힙
public class A1927 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> q = new PriorityQueue<>();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int t = Integer.parseInt(br.readLine());

            if (t == 0) {
                if (q.isEmpty())
                    sb.append(0).append('\n');
                else
                    sb.append(q.poll()).append('\n');
            } else {
                q.offer(t);
            }

        }

        System.out.println(sb);
    }
}
