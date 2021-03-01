package algo.stage18;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 프린터 큐
public class A1966 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int n = Integer.parseInt(br.readLine());

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st1.nextToken());
            int where = Integer.parseInt(st1.nextToken());
            int max = 0;
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++) {
                int imp = Integer.parseInt(st2.nextToken());
                if(max < imp) max = imp;
                q.add(imp);
            }
        }

        bw.write(sb.toString());
        br.close(); bw.flush(); bw.close();
    }
}
