package beakjoon.stage9;

import java.util.Scanner;

public class A2581 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		int min = 0;
		int sum = 0;

		for(int i = n; i <= m; i++) {
			int t = 0;
			for(int j = 1; j <= i; j++) {
				if(i % j == 0)
					t++;
			}
			if(t == 2) {
				sum += i;
				if(min == 0)
					min = i;
			}
		}
		if(sum == 0)
			System.out.println(-1);
		else
			System.out.printf("%d\n%d", sum, min);

	}

}
