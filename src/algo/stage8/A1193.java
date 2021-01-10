package algo.stage8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class A1193 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int num = Integer.parseInt(br.readLine().trim());
		int l = 1;		// 대각선
		int n = 1;		// 분자
		int d = 1;		// 분모

		for(int i = num; i > 1; i--) {
			if((l % 2) != 0) {		// 대각선이 홀수
				if(n == 1) {
					d++; l++;
					continue;
				}
				n--; d++;
			}
			else {					// 대각선이 짝수
				if(d == 1) {
					n++; l++;
					continue;
				}
				n++; d--;
			}
		}

		bw.write(n + "/" + d);
		br.close();
		bw.flush(); bw.close();
	}

}