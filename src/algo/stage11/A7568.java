package algo.stage11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class A7568 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		int n = Integer.parseInt(br.readLine().trim());

		int[][] info = new int[n][2];
		int[] rank = new int[n];

		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			info[i][0] = Integer.parseInt(st.nextToken());
			info[i][1] = Integer.parseInt(st.nextToken());
			rank[i] = 1;
		}

		for(int j = 0; j < n; j++) {
			for(int k = 0; k < n; k++) {
				if(j == k)
					continue;

				if(info[j][0] > info[k][0] && info[j][1] > info[k][1])
					rank[k]++;
			}
		}

		for(int tmp : rank)
			sb.append(tmp + " ");

		bw.write(sb.toString().trim());
		br.close(); bw.flush(); bw.close();
	}

}
