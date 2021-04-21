package beakjoon.stage9;

import java.util.Scanner;

public class A11653{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int i = 2;

		if(n == 1) {
			System.out.println("");
			return;
		}

		while(true) {
			if(n % i == 0) {
				System.out.println(i);
				n /= i;
				i =2;
			}
			else
				i++;

			if(n == 1)
				break;
		}

	}
}
