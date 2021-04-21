package beakjoon.stage17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 스택 수열
public class A1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        int tmp = 0;    // 스택 맨 위에 있는 애
        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            if (tmp <= num) {
                while (tmp < num) {
                    stack.push(++tmp);
                    sb.append("+\n");
                    if (tmp == num) {
                        stack.pop();
                        sb.append("-\n");
                        continue;
                    }
                }
            } else {
                if(stack.peek() != num) {
                    System.out.println("NO");
                    return;
                }
                stack.pop();
                sb.append("-\n");
            }
        }

        System.out.println(sb);
    }
}
