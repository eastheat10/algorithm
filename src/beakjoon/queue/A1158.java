package beakjoon.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 요세푸스 문제
public class A1158 {

    static int n, k;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
    }

    static void queue() {
        StringBuilder sb = new StringBuilder();
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++)
            q.offer(i);

        int cnt = 0;

        while (!q.isEmpty()) {
            if (cnt == k - 1) {
                list.add(q.poll());
                cnt = 0;
            } else {
                q.offer(q.poll());
                cnt++;
            }
        }

        sb.append("<").append(list.remove(0));
        for (Integer integer : list)
            sb.append(", ").append(integer);
        sb.append(">");

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        input();
        queue();
    }
}
