package algo.stage11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// 블랙잭
public class A2798 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] black = new int[n];
		int sum = 0, tmp = 0;

		StringTokenizer st2 = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < n; i++) {
			black[i] = Integer.parseInt(st2.nextToken());
		}

		Arrays.sort(black);

		for (int a = black.length - 1; a > 1; a--) {
			for (int b = a - 1; b > 0; b--) {
				for (int c = b - 1; c >= 0; c--) {
					tmp = black[a] + black[b] + black[c];
					if (m >= tmp)
						if(tmp > sum)
							sum = tmp;
				}
			}
		}

		bw.write(Integer.toString(sum));
		br.close();
		bw.flush();
		bw.close();
	}
}
