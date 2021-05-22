package beakjoon.stage17;

import java.io.*;
import java.util.Stack;

public class A4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();

        Stack<Character> stack = new Stack<>();

        while(true) {
            String s = br.readLine();
            if(s.equals("."))
                break;

            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);

                if (c == '(' || c == '[') {
                    stack.push(c);
                }
                else if (c == ')') {
                    if (stack.empty() || (stack.peek() != '(')) {
                        stack.push(c);
                        break;
                    } else {
                        stack.pop();
                    }
                }
                else if(c == ']'){
                    if (stack.empty() || (stack.peek() != '[')) {
                        stack.push(c);
                        break;
                    } else {
                        stack.pop();
                    }
                }

            }

            if (stack.empty()) {
                sb.append("yes" + "\n");
            } else {
                sb.append("no" + "\n");
                stack.clear();
            }

        }

        bw.write(sb.toString());
        bw.flush(); bw.close();
        br.close();
    }
}
