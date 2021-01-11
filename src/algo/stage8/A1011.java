package algo.stage8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class A1011 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for(int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int l = y - x;

			int max = (int)Math.sqrt(l);
			int count = 0;

			if(max == Math.sqrt(l))
				count = (max * 2) - 1;
			else if(Math.pow(max, 2) + max >= l)
				count = max * 2;
			else
				count = (max * 2) + 1;
			sb.append(count + "\n");
		}
		bw.write(sb.toString());
		br.close();
		bw.flush(); bw.close();
	}

}
