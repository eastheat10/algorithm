package beakjoon;

import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = 0;
		for (int i = 0; i < 8; i++) {
			String s = br.readLine();
			for (int j = 0; j < 8; j++) {
				if (i % 2 == 0 && j % 2 == 0) {
					if (s.charAt(j) == 'F') {
						count++;
					}
				}
				if (i % 2 == 1 && j % 2 == 1) {
					if (s.charAt(j) == 'F')
						count++;
				}
			}
		}
		System.out.println(count);
	}
}
