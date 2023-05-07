package beakjoon.bruteforce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class A1436 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int num = 666;

		while(n > 0) {
			String s = Integer.toString(num);

			if(s.contains("666"))
				n--;
			if(n == 0)
				break;
			num++;
		}
		bw.write(Integer.toString(num));
		br.close(); bw.flush(); bw.close();
	}
}
