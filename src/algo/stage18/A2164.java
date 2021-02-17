package algo.stage18;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

// 카드2
public class A2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int tmp = 0;
        Deque<Integer> q = new LinkedList<Integer>();

        for (int i = 1; i <= n; i++)
            q.add(i);

        while(q.size() > 1){
            q.poll();
            q.addLast(q.poll());
        }
        bw.write(q.peek().toString());
        bw.flush(); bw.close();
        br.close();
    }
}
