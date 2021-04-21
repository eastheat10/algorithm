package beakjoon.stage10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
// 하노이 탑
public class A11729 {

	static StringBuffer sb = new StringBuffer();
	static int count = 0;

	public static int hanoi(int n, int from, int tmp, int to) {

		if(n == 1) {
			count++;
			sb.append(from + " " + to + "\n");
		}
		else {
			hanoi(n-1, from, to, tmp);
			sb.append(from + " " + to + "\n");
			count++;
			hanoi(n-1, tmp, from, to);
		}

		return count;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());

		int count = hanoi(n, 1, 2, 3);

		bw.write(Integer.toString(count));
		bw.newLine();
		bw.write(sb.toString());
		br.close(); bw.flush(); bw.close();
	}

}
