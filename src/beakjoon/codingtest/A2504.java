import java.util.*;
import java.io.*;

// 괄호의 값
@SuppressWarnings("unchecked")
class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        System.out.println(process(s));
    }

    static int process(String s) {
        Stack<Character> stack = new Stack<>();
        int result = 0;
        int m = 1;

        for (int i = 0; i < s.length(); i++) {
            switch(s.charAt(i)) {
                case '(':
                    stack.push('(');
                    m *= 2;
                    break;

                case '[':
                    stack.push('[');
                    m *= 3;
                    break;

                case ')':
                    if (stack.isEmpty() || stack.peek() != '(') {
                        return 0;
                    }
                    if (s.charAt(i - 1) == '(')
                        result += m;
                    stack.pop();
                    m /= 2;
                    break;

                case ']':
                    if (stack.isEmpty() || stack.peek() != '[') {
                        return 0;
                    }
                    if (s.charAt(i - 1) == '[')
                        result += m;
                    stack.pop();
                    m /= 3;
                    break;
            }
        }

        if (!stack.isEmpty())
            result = 0;

        return result;
    }

}