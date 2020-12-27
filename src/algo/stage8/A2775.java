package algo.stage8;

import java.util.Scanner;

public class A2775 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("숫자를 입력하세요: ");
		int t = sc.nextInt();
		int[] result = new int[t];
		int floor = 0;
		int number = 0;
		int people = 0;

		for(int t1 = 0; t1 < t; t1++) {
			floor = sc.nextInt();
			number = sc.nextInt();

			int[][] apt = new int[floor + 1][number];

			for(int i = 0; i < number; i++)
				apt[0][i] = i + 1;

			for(int i = 1; i <= floor; i++) {
				for(int j = 0; j < number; j++) {
					for(int k = 0; k <= j; k++) {
						people += apt[i - 1][k];
					}
					apt[i][j] = people;
					people = 0;
				}
			}

			result[t1] = apt[floor][number - 1];
		}

		for(int n : result)
			System.out.println(n);

	}

}
