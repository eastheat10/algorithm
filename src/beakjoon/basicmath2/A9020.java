package beakjoon.stage9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class A9020 {

	public static boolean[] prime = new boolean[10000];

	public static void getPrime() {
		prime[0] = prime[1] = true;
		for(int i = 2; i * i <= prime.length; i++) {
			if(prime[i])
				continue;
			for(int j = i * i; j < prime.length; j += i)
				prime[j] = true;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int test = Integer.parseInt(br.readLine().trim());
		getPrime();

		for(int i = 0; i < test; i++) {
			int num = Integer.parseInt(br.readLine().trim());

			for(int k = 0; k < (num / 2); k++) {
				if(!prime[(num / 2) - k] && !prime[(num / 2) + k]) {
					sb.append(((num / 2) - k) + " " + ((num / 2) + k)  + "\n");
					break;
				}
			}
		}

		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}

}
