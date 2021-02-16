package algo.stage18;

import java.io.*;
import java.util.*;

/*
큐2
    push X: 정수 X를 큐에 넣는 연산이다.
    pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    size: 큐에 들어있는 정수의 개수를 출력한다.
    empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
    front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.

*/
public class A18258 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> q = new LinkedList<Integer>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            switch (st.nextToken()){
                case "push":
                    q.add(Integer.parseInt(st.nextToken())); break;
                case "pop":
                    Integer tmp1 = q.poll();
                    if(tmp1 == null){
                        tmp1 = -1;
                    }
                    sb.append(tmp1 + "\n");
                    break;
                case "size":
                    sb.append(q.size() + "\n"); break;
                case "empty":
                    boolean b = q.isEmpty();
                    if (b)
                        sb.append(1 + "\n");
                    else
                        sb.append(0 + "\n");
                    break;
                case "front":
                    Integer tmp2 = q.peek();
                    if(tmp2 == null){
                        tmp2 = -1;
                    }
                    sb.append(tmp2 + "\n");
                    break;
                case "back":
                    Integer tmp3 = q.peekLast();
                    if(tmp3 == null){
                        tmp3 = -1;
                    }
                    sb.append(tmp3 + "\n");
                    break;
            }
        }
        bw.write(sb.toString());
        bw. flush(); bw.close(); br.close();
    }
}
