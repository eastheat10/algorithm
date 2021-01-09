package algo.stage10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class A4948 {

	static boolean[] b = new boolean[246913];		// 소수면 false

	public static void prime() {
		b[0] = b[1] = true;
		for(int i = 2; i * i <= b.length; i++) {
			if(b[i]) continue;
			for(int j = i * i; j < b.length; j += i) {
				b[j] = true;
			}
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		prime();

		while (true) {
			int n = Integer.parseInt(br.readLine().trim());
			if(n == 0)
				break;
			int count = 0;

			for(int i = (n + 1); i <= (n * 2); i++) {
				if(!b[i])
					count++;
			}
			sb.append(count).append("\n");

		}

		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();

	}

}
