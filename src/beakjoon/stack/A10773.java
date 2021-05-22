package beakjoon.stage17;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

// 제로
public class A10773 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine().trim());
		Stack<Integer> stack = new Stack<>();
		int sum = 0;

		for(int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num != 0)
				stack.push(num);

			else
				stack.pop();

		}

		while(!stack.empty()) {
			sum += stack.pop();
		}

		bw.write(Integer.toString(sum));
		bw.flush(); bw.close(); br.close();

	}
}
