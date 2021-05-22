package beakjoon.stage9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class A1002 {

	public static int location(int x1, int y1, int r1, int x2, int y2, int r2) {
		int count = 0;
		double l = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
		int r = 0, R = 0;
		if(r1 > r2) {
			R = r1;
			r = r2;
		} else{
			R = r2;
			r = r1;
		}

		if(l > R) {
			if(l > R + r)
				count = 0;
			else if(l == R + r)
				count = 1;
			else
				count = 2;
		}
		else if(l <= R && l != 0) {
			if(l < R - r)
				count = 0;
			else if(l == R - r)
				count = 1;
			else
				count = 2;
		}
		else {
			if(R != r)
				count = 0;
			else
				count = -1;
		}

		return count;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine().trim());

		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int x1 = Integer.parseInt(st.nextToken().trim());
			int y1 = Integer.parseInt(st.nextToken().trim());
			int r1 = Integer.parseInt(st.nextToken().trim());

			int x2 = Integer.parseInt(st.nextToken().trim());
			int y2 = Integer.parseInt(st.nextToken().trim());
			int r2 = Integer.parseInt(st.nextToken().trim());

			sb.append(location(x1, y1, r1, x2, y2, r2)).append("\n");
		}
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}

}
