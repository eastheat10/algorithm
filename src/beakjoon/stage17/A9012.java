package beakjoon.stage17;

import java.io.*;
import java.util.Stack;

// 괄호
public class A9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();
        int n = Integer.parseInt(br.readLine());
        String yes = "YES";
        String no = "NO";
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            String s = br.readLine();

            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);

                if(c == '('){ // '('이면 push
                    stack.push(c);
                } else if (stack.empty()) {   // ')'인데 비어있으면 no
                    stack.push(c);
                    break;
                } else {    // ')' 입력받고 비어있지 않으면 pop
                    stack.pop();
                }
            } // for j

            if(stack.empty()) // 검사 종료 후 스택 비어있으면 yes
                sb.append(yes + "\n");
            else    // 스택이 비어있지 않으면 no
                sb.append(no + "\n");

            stack.clear();
        } // for i

        bw.write(sb.toString());
        bw.flush(); bw.close();
        br.close();
    }
}
