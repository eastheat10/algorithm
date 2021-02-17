package algo.stage18;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
정수를 저장하는 덱(Deque)를 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.

    명령은 총 여덟 가지이다.

    push_front X: 정수 X를 덱의 앞에 넣는다.
    push_back X: 정수 X를 덱의 뒤에 넣는다.
    pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    size: 덱에 들어있는 정수의 개수를 출력한다.
    empty: 덱이 비어있으면 1을, 아니면 0을 출력한다.
    front: 덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    back: 덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
*/
public class A10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> q = new LinkedList<Integer>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "push_front":
                    q.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    q.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    Integer tmp1 = q.pollFirst();
                    if (tmp1 == null) {
                        tmp1 = -1;
                    }
                    sb.append(tmp1 + "\n");
                    break;
                case "pop_back":
                    Integer tmp2 = q.pollLast();
                    if (tmp2 == null) {
                        tmp2 = -1;
                    }
                    sb.append(tmp2 + "\n");
                    break;
                case "size":
                    sb.append(q.size() + "\n");
                    break;
                case "empty":
                    boolean isEmpty = q.isEmpty();
                    if (isEmpty)
                        sb.append(1 + "\n");
                    else
                        sb.append(0 + "\n");
                    break;
                case "front":
                    Integer tmp3 = q.peekFirst();
                    if (tmp3 == null) {
                        tmp3 = -1;
                    }
                    sb.append(tmp3 + "\n");
                    break;
                case "back":
                    Integer tmp4 = q.peekLast();
                    if (tmp4 == null) {
                        tmp4 = -1;
                    }
                    sb.append(tmp4 + "\n");
                    break;
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}

