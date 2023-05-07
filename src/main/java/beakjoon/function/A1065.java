package beakjoon.stage6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A1065 {

	public static int hansu(boolean[] X) {
		int count = 0;
		if(X.length > 99) {
			for(int i = 100; i < X.length; i++) {
				int tmp = i;
				String s = Integer.toString(tmp);
				int m1 = Integer.parseInt(Character.toString(s.charAt(1)))
						- Integer.parseInt(Character.toString(s.charAt(0)));

				for(int t = 2; t < s.length(); t++) {
					if(Integer.parseInt(Character.toString(s.charAt(t - 1))) + m1
							!= Integer.parseInt(Character.toString(s.charAt(t)))) {
						X[i] = true;
						break;
					}
				}

			}
		}

		for(int j = 1; j < X.length; j++) {
			if(!X[j])
				count++;
		}
		return count;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		boolean[] X = new boolean[n + 1];

		System.out.println(hansu(X));
	}

}
