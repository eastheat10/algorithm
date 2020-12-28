package algo.stage8;

import java.util.Scanner;

public class A10250 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int[] result = new int[t];

		int height = 0;
		int width = 0;
		int guest = 0;

		for(int t1 = 0; t1 < t; t1++) {
			height = sc.nextInt();
			width = sc.nextInt();
			guest = sc.nextInt();

			int floor = ((guest % height) == 0) ? height : (guest % height);
			int number = ((guest % height) == 0) ? (guest / height) : (guest / height) + 1;

			result[t1] = floor * 100 + number;

		}

		for(int n : result)
			System.out.println(n);

	}
}
