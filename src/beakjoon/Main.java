package beakjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// 통계학
public class Main {

	static int n, m;
	static int[] selected;
	static boolean[] used;
	static StringBuffer sb = new StringBuffer();

	public static void main(String[] args)  throws IOException, NumberFormatException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		selected = new int[m + 1];
		used = new boolean[n + 1];

		func(1);

		System.out.println(sb);
	}

	static void func(int k) {
		if (k == m + 1) {
			for (int i = 1; i <= m; i++)
				sb.append(selected[i]).append(" ");
			sb.append("\n");
			return;
		}

		int s = selected[k - 1] == 0 ? 1 : selected[k - 1];
		for (int i = s; i <= n; i++) {
			selected[k] = i;
			func(k + 1);
		}
	}

}
