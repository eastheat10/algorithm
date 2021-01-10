package algo.stage8;

import java.util.Scanner;

public class A2292 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if(n == 1) {
			System.out.println(1);
			return;
		}
		int l = 1;
		int tmp = 1;

		while(true) {
			if(tmp >= n)
				break;
			tmp += (6 * l);
			l++;
		}

		System.out.println(l);
	}

}
