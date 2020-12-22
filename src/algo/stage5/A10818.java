package algo.stage5;

// N개의 정수가 주어진다. 이때, 최솟값과 최댓값을 구하는 프로그램을 작성하시오.

import java.util.Scanner;

public class A10818 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("숫자를 입력하세요: ");
		int n = sc.nextInt();

		int [] a = new int[n];

		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}

		int max = a[0];
		int min = a[0];

		for(int i = 1; i < n; i ++) {
			if(max < a[i])
				max = a[i];
		}

		for(int i = 1; i < n; i ++) {
			if(min > a[i])
				min = a[i];
		}

		System.out.printf("%d %d", min, max);
	}


}
