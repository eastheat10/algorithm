package algo.stage9;

import java.util.Scanner;

public class A1978 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int num[] = new int[n];

		for(int i = 0; i < n; i++) {
			num[i] = sc.nextInt();
		}

		int count = 0;

		for(int i = 0; i < n; i++) {
			int t = 0;

			for(int j = 1; j <= num[i]; j++) {
				if(num[i] % j == 0)
					t++;
			}

			if(t == 2)
				count++;
		}

		System.out.println(count);
	}

}
