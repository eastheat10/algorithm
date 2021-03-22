package algo.stage17;

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

        while (true) {
            int num = Integer.parseInt(br.readLine());
            int tmp = 1;    // 스택 맨 위에 있는 애
            while (tmp <= num) {
                stack.push(tmp++);
                sb.append("+\n");
            }
            if (stack.peek() == num) {

            }

        }

        //System.out.println(sb);
    }
}
