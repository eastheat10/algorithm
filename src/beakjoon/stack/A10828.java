package beakjoon.stage17;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class A10828 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine().trim());
		Stack<Integer> stack = new Stack<>();

		for(int i =0; i < n; i++) {
			String stack_controll = br.readLine();
			StringTokenizer st = new StringTokenizer(stack_controll);
			String s = st.nextToken();

			if(s.equals("push")) {
				stack.push(Integer.parseInt(st.nextToken()));
			}
			else if(s.equals("pop")) {
				if(!stack.empty())
					sb.append(stack.pop()).append("\n");
				else
					sb.append(-1).append("\n");
			}
			else if(s.equals("empty")) {
				if(stack.empty())
					sb.append(1).append("\n");
				else
					sb.append(0).append("\n");
			}
			else if(s.equals("size")) {
				sb.append(stack.size()).append("\n");
			}
			else {
				if(!stack.empty())
					sb.append(stack.peek()).append("\n");
				else
					sb.append(-1).append("\n");
			}
		}
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}
}

// push, pop, empty, top, size