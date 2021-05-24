package beakjoon.bruteforce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 분해합
public class A2231 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine().trim());
		int tmp = 0;

		for(int i = 1; i < n; i++) {
			String s = Integer.toString(i);
			int[] num = new int[s.length()];
			int sum = 0;
			for(int j = 0; j < s.length(); j++) {
				num[j] = Integer.parseInt(Character.toString(s.charAt(j)));
				sum += num[j];
			} sum += i;
			if(sum == n) {
				tmp = i;
				break;
			}
		}

		bw.write(Integer.toString(tmp));
		br.close(); bw.flush(); bw.close();
	}

}
