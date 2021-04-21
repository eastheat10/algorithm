package beakjoon.stage18;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 요세푸스 문제0
public class A11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        sb.append("<");

        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= n; i++)
            q.add(i);

        while(q.size() > 1){
            for (int i = 1; i < k; i++)
                q.offer(q.poll());
            sb.append(q.poll().toString() + ", ");
        }
        sb.append(q.poll().toString() + ">");

        bw.write(sb.toString());
        bw.flush(); bw.close(); br.close();
    }
}
